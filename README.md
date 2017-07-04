Dagger系列：

1. [Dagger 2从浅到深(一)](http://blog.csdn.net/io_field/article/details/70947365)
2. [Dagger 2从浅到深(二)](http://blog.csdn.net/io_field/article/details/70988569)
3. [Dagger 2从浅到深(三)](http://blog.csdn.net/io_field/article/details/71055031)
4. [Dagger 2从浅到深(四)](http://blog.csdn.net/io_field/article/details/71083516)
5. [Dagger 2从浅到深(五)](http://blog.csdn.net/io_field/article/details/71122979)
6. [Dagger 2从浅到深(六)](http://blog.csdn.net/io_field/article/details/71170727)
7. [Dagger 2从浅到深(七)](http://blog.csdn.net/io_field/article/details/71319138)
8. [Dagger 2应用于Android的完美扩展库-dagger.android](http://blog.csdn.net/IO_Field/article/details/71730248)

<font color="blue" size=5>
Demo地址： [https://github.com/teaphy/DaggerLearn](https://github.com/teaphy/DaggerLearn)
</font>



# 概述 #
在使用Dagger开发Android时，不可避免的一个问题是，许多Android的类都是由系统实例化的，比如Activity、Fragment等，如果使用Dagger依赖注入实例，我们不由得这么写：

	public class FrombulationActivity extends Activity {
	  @Inject Frombulator frombulator;
	
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    // DO THIS FIRST. Otherwise frombulator might be null!
	    ((SomeApplicationBaseType) getContext().getApplicationContext())
	        .getApplicationComponent()
	        .newActivityComponentBuilder()
	        .activity(this)
	        .build()
	        .inject(this);
	    // ... now you can write the exciting code
	  }
	}

从而引发了，不可避免的问题：

- 复制代码使得以后很难重构。 随着越来越多的开发人员复制粘贴该块，更少的知道它实际上做了什么。
- 更重要的是，它要求注射类型（FrombulationActivity）知道其注射器。 即使这是通过接口而不是具体类型完成的，它打破了依赖注入的核心原则：一个类不应该知道如何注入它。

自从Googgle接手Dagger维护以来，大神们脑洞全开，如何能让Dagger完美的与Android系统兼容?确实是个头疼的问题。dagger.android也就这时候应运而生了。Dagger.Android库是Dagger库的补充，dagger.android中的类提供了一种简化此模式的方法，从而在一定程度上避免了上述问题的发生。

# 核心类 #

- AndroidInjection：注入Android核心库的基本类型的实例
- AndroidInjector&lt;T>:注入Android库的类型的接口, T为Android库的基本类型T,比如Activity、Fragment、BroadcastReceive等；
- AndroidInjector.Factory&lt;T>：AndroidInjector&lt;T>的工厂类接口
- DispatchingAndroidInjector&lt;T>:其为AndroidInjector&lt;T>接口的实现类，将Android核心库的的基本类型T的实例注入Dagger，该操作是由Android核心库的类的实例本身执行，而不是Dagger。


# 注入实例 #

由于DispatchingAndroidInjector在运行时由类查找相应的AndroidInjector.Factory，那么，在基类中，实现HasActivityInjector/HasFragmentInjector接口，在相应的声明周期(onCreate()或者onAttach())内调用AndroidInjection.inject()方法，注入相应的实例。所有每个子类都需要做的是绑定相应的@Subcomponent，从而没有必要在每个实例类中调用AndroidInjection.inject()方法。

在dagger.android库中，Dagger提供了一些基本类型，比如DaggerActivity和DaggerFragment。对于Appliaction,还提供了DaggerApplication，继承其后，只需重写applicationInjectoer()方法来返回AndroidInjector&lxtXxApplication>.

Dagger提供的基本类型：

1. DaggerActivity
2. DaggerFragment
3. DaggerService
4. DaggerIntentService
5. DaggerBroadcastReceiver
5. DaggerContentProvider

下面，我们来了解Dagger所提供的基本类型的用法：

## 注入Activity实例 ##

1.注入AndroidInjectionModule：在应用程序的ApplicationComponent中，注入AndroidInjectionModule，以确保Android的类(Activity、Fragment、Service、BroadcastReceiver及ContentProvider等)可以绑定。 一般把AndroidInjectionModule放在ApplicationCoponent中，其他的Component依赖Application即可。

		@Component(modules = AndroidInjectionModule.class)
		public interface TodoComponent {
			void inject(TodoApplication application);
		}
2. 创建子组件 - MainSubcomponent：其继承自AndroidInjector<MainActivity>，在该子组件中含有一个抽象类Builder，
 该Builder继承自AndroidInjector.Builder<MainActivity>，并由@Subcomponent.Builder注解

		@Subcomponent(modules = AndroidInjectionModule.class)
		public interface MainSubcomponent extends AndroidInjector<MainActivity> {
		
			@Subcomponent.Builder
			public abstract class Builder extends AndroidInjector.Builder<MainActivity>{
			}
		}
3. 创建Module - MainModule：定义子组件MainActivitySubcomponent后，定义该子组件的Module - MainctivityModule,通过将该Module注入到AppComponentd的modules列表中，以便将MainActivitySubcomponent.Builder添加到组件层次机构中。

		@Module(subcomponents = MainSubcomponent.class)
		public abstract class MainModule {
			@Binds
			@IntoMap
			@ActivityKey(MainActivity.class)
			abstract AndroidInjector.Factory<? extends Activity>
			bindYourActivityInjectorFactory(MainSubcomponent.Builder builder);
		}
	
		@Component(modules = {..., YourActivityModule.class})
		interface YourApplicationComponent {}
<font color="red">
注意：
	- 如果在Module中提供依赖实例，@Provides方法必须为静态方法，否则编译不通过。
</font>
4. 自定义Application，并实现HasActivityInjector接口，同时注入(@Inject)DispatchingAndroidInjector&lt;Activity>实例，该实例在activityInjector()方法中返回：

		public class TodoApplication extends Application  implements HasActivityInjector {
			@Inject
			DispatchingAndroidInjector<Activity> dispatchingActivityInjector;
		
			@Override
			public void onCreate() {
				super.onCreate();
				DaggerTodoComponent.create()
						.inject(this);
			}
			/**
			 * Returns an {@link AndroidInjector} of {@link Activity}s.
			 */
			@Override
			public AndroidInjector<Activity> activityInjector() {
				return dispatchingActivityInjector;
			}
		}
5. 在MainActivity.onCreat()方法中，在调用super.onCreate()之前调用AndroidInjection.inject(this)

		public class MaiActivity extends Activity {
		  public void onCreate(Bundle savedInstanceState) {
		    AndroidInjection.inject(this);
		    super.onCreate(savedInstanceState);
		  }
		}

## 注入Fragment实例 ##

注入Fragment实例， 与注入Activity实例一样，以相同的方式定义子组件。不同的是：

1. 需使用Fragment替换Activity类型参数；
2. 将@ActivityKey替换为@FragmentKey；
3. 将HasActivityInjector替换为HasFragmentInjector；
4. AndroidInjection.inject(Fragment)方法,在Fragment的onAttach()中调用，而不是在onCreate()中；
5. Fragment的Module的添加位置，与Activity定义的Module添加不同，其取决于Fragment内部所需要的其他绑定的依赖注入；

与为Activity定义的模块不同，您可以选择为Fragment添加模块的位置。 您可以使您的Fragment组件成为另一个Fragment组件，一个Activity组件或Application组件的子组件，这一切都取决于片段需要哪个其他绑定。确定组件位置后，使相应的类型实现HasFragmentInjector。

比如，FragmentA中，绑定了Apple实例，而在Fragment所在的ActivityA的Module中，提供了该实例的，那么只需要将FragmenA的Module添加至ActivityA的Component即可：

	@Subcomponent(modules = { FragmentAModule.class, ... }
	public interface ActivityAComponent { ... }

下面，以FruitActivity中添加OrangeFragment为例，其中OrangeFragment中绑定AppleBean实例，该实例由FruitModule提供，而FruitModule为FruitActivity的Module，示例代码如下：

1. 创建Fragment - OrangeFragment,在onAttach()方法中，super.onAttach(context)方法前调用AndroidSupportInjection.inject(this)。

		public class OrangeFragment extends Fragment{
		
			***
		
			@Inject
			AppleBean mAppleBean;
		
			@Override
			public void onAttach(Context context) {
				AndroidSupportInjection.inject(this);
				super.onAttach(context);
			}
		
			@Override
			public View onCreateView(LayoutInflater inflater, ViewGroup container,
			                         Bundle savedInstanceState) {
				View rootView = inflater.inflate(R.layout.fragment_orange, container, false);
		
				ButterKnife.bind(this, rootView);
				
				// AppleBean{name='这是一个苹果'}
				Log.d("testTodo", mAppleBean.toString());
	
				***
	
				return rootView;
			}
		
		}
<font color="red">
注意:
	- 如果使用v4包中的Fragment，在onAttach()方法中，应调用AndroidSupportInjection.inject(this);
	- 如果使用普通的Fragment(即android.app.Fragment)，在onAttach()方法中，应调用AndroidInjection.inject(this);
</font>
2. 创建子组件 - OrangeSubcomponent,其继承自AndroidInjector<OrangeFragment>，在该子组件中含有一个抽象类Builder，
 该Builder继承自AndroidInjector.Builder<OrangeFragment>，并由@Subcomponent.Builder注解

		@Subcomponent
		public interface OrangeSubcomponent extends AndroidInjector<OrangeFragment> {
		
			@Subcomponent.Builder
			public abstract class Builder extends AndroidInjector.Builder<OrangeFragment> {
		
			}
		}
3. 创建Module - OrangeModule：定义该Fragment的Module，通过将该Module注入到相应的Fragment、Activity、AppComponent的Module中，具体注入到哪个Module中，依据绑定的实例的依赖关系

		@Module(subcomponents = OrangeSubcomponent.class)
		public abstract class OrangeModule {
		
			@Binds
			@IntoMap
			@FragmentKey(OrangeFragment.class)
			abstract AndroidInjector.Factory<? extends Fragment> bind(FruitSubcomponent.Builder builder);
		}
<font color="red">
注意:
	- 如果使用v4包中的Fragment，必须绑定AndroidInjector.Factory<？ extends android.support.v4.app.Fragment>;
</font>
3. 将OrangeModule注入到FruitComponent中，即将OrangeModule添加至FruiltCoponent的modules属性中

		@Subcomponent(modules = OrangeModule.class)
		public interface FruitSubcomponent extends AndroidInjector<FruitActivity> {
		
			@Subcomponent.Builder
			abstract class Builder extends AndroidInjector.Builder<FruitActivity> {
		
			}
		}
## 注入BroadcastReceiver实例 ##

这里我们先看看如何动态注册一个广播。动态注册需要在代码中动态的指定广播地址并注册，通常我们是在Activity或Service注册一个广播，下面我们就来看一下注册的代码：

	CoffeeReceiver receiver = new CoffeeReceiver();  
	          
	IntentFilter filter = new IntentFilter();  
	filter.addAction("android.intent.action.MY_BROADCAST");  
	          
	registerReceiver(receiver, filter); 

registerReceiver是android.content.ContextWrapper类中的方法，Activity和Service都继承了ContextWrapper，所以可以直接调用。在实际应用中，我们在Activity或Service中注册了一个BroadcastReceiver，当这个Activity或Service被销毁时如果没有解除注册，系统会报一个异常，提示我们是否忘记解除注册了。所以，记得在特定的地方执行解除注册操作：

	@Override  
	protected void onDestroy() {  
	    super.onDestroy();  
	    unregisterReceiver(receiver);  
	} 

执行这样行代码就可以解决问题了。注意，这种注册方式与静态注册相反，不是常驻型的，也就是说广播会跟随程序的生命周期。
我们可以根据以上任意一种方法完成注册，当注册完成之后，这个接收者就可以正常工作了。我们可以用以下方式向其发送一条广播：

	@OnClick(R.id.acb_coffee)
	public void onViewClicked() {
		Intent intent = new Intent();
		intent.setAction(CoffeeReceiver.ACTION_COFFEE);
		sendBroadcast(intent);
	} 

这样，就完成了一次简单的广播的简单注册，看起来也不算太复杂。接下来，让我们来看看使用Dager2依赖注入广播实例：

1. 创建BroadcastReceiver - CoffeeReceiver,其继承自DaggerBroadcastReceiver。在CoffeeReceiver中，依赖注入AppleBean实例。

		public class CoffeeReceiver extends DaggerBroadcastReceiver {
		
			public static final String ACTION_COFFEE = "com.todo.daggerlearn.coffee";
		
			@Inject
			AppleBean mAppleBean;
		
			@Override
			public void onReceive(Context context, Intent intent) {
				super.onReceive(context, intent);
		
				if (TextUtils.equals(intent.getAction(), ACTION_COFFEE)) {
					Toast.makeText(context, "这是一杯" + mAppleBean.getName() + "味咖啡", Toast.LENGTH_SHORT).show();
				}
			}
		}
2. 在AndroidManifest.xml中声明CoffeeReceiver
		
		<receiver android:name=".broadcast.CoffeeReceiver">
			<intent-filter>
				<action android:name="com.todo.daggerlearn.coffee" />
			</intent-filter>
		</receiver>

3. 创建子组件 - CoffeeReceiverSubcomponent

		@Subcomponent
		public interface CoffeeReceiverSubcomponent extends AndroidInjector<CoffeeReceiver> {
			@Subcomponent.Builder
			public abstract class Builder extends AndroidInjector.Builder<CoffeeReceiver> {
		
			}
		}
4. 创建Module - CoffeeModule

		@Module(subcomponents = CoffeeReceiverSubcomponent.class)
		public abstract class CoffeeModule {
		
			@Binds
			@IntoMap
			@BroadcastReceiverKey(CoffeeReceiver.class)
			abstract AndroidInjector.Factory<? extends BroadcastReceiver> bind(CoffeeReceiverSubcomponent.Builder builder);
		}
5. 将CoffeeModule添加至ApplicationComponent的modules属性中

		@Component(modules = {AndroidInjectionModule.class, CoffeeModule.class，...})
		public interface TodoComponent extends AndroidInjector<TodoApplication> {
			@Component.Builder
			abstract class Builder extends AndroidInjector.Builder<TodoApplication> {}
		}
6. 在DringkActivity中发送广播

		public class DrinkActivity extends AppCompatActivity {
		
			@BindView(R.id.toolBar)
			Toolbar mToolbar;
			@BindView(R.id.acb_coffee)
			AppCompatButton mAcbCoffee;
			
			***
		
			@OnClick(R.id.acb_coffee)
			public void onViewClicked() {
				Intent intent = new Intent();
				intent.setAction(CoffeeReceiver.ACTION_COFFEE);
				sendBroadcast(intent);
			}
		}

<img src="http://img.blog.csdn.net/20170511155300104?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvSU9fRmllbGQ=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast" width=240 height=360/>

<font color="red">
注意：

- 只有当BroadcastReceiver在AndroidManifest.xml中注册时，才能使用DaggerBroadcastReceiver。 当在动态注册BroadcastReceiver时，推荐使用构造函数注入。
</font>

一看前面的代码，使用Dagger2注入广播时，步骤显得复杂了。而，原生动态注册广播也没有几行代码。不过，值得注意的是，使用原生动态注册广播时，每次都得重复的new和注册等操作，而Dagger只要提供依赖关系即可。
# 关于Dagger的使用流程 #
对于其他的基本类型，不再举例子，创建模式基本是一样的，比较呆瓜式流程如下：

1. 在ApplicationComponent中注入AndroidInjectionModule,如果项目中用到v4包的Fragment，还需注入AndroidSupportInjectionModule.建议把两个Module都注入XxComponent中，说不定哪位同仁和你想法一样呢...

		@Component(modules = {AndroidInjectionModule.class, AndroidSupportInjectionModule,...})
		public interface XxComponent {
			void inject(XxApplication application);
		}	
2. 创建Android库的核心类(Activity、Fragment、Service、IntentService、BroadcasReceiver)，需要注意的就是：AndroidInjection.inject(T)方法的调用位置

	- 在Activity、Service及IntentService的onCreate()中，super.onCreate()方法以前。
	- 在Fragment中onAttach()中，super.onAttach()方法以前。如果是v4包的Fragment，应调用AndroidInjection.inject()方法。
	- 在BroadcastReceiver的onReceive()中，super.onReceive之前调用。

			public class CoffeeReceiver extends DaggerBroadcastReceiver {
		
				public static final String ACTION_COFFEE = "com.todo.daggerlearn.coffee";
			
				@Inject
				AppleBean mAppleBean;
			
				@Override
				public void onReceive(Context context, Intent intent) {
					super.onReceive(context, intent);
			
					if (TextUtils.equals(intent.getAction(), ACTION_COFFEE)) {
						Toast.makeText(context, "这是一杯" + mAppleBean.getName() + "味咖啡", Toast.LENGTH_SHORT).show();
					}
				}
			}
3. 创建子组件 - @Subcomponent，其继承自AndroidInjector&lt;T>,而T就是step2创建的Android库的类型

		@Subcomponent
		public interface CoffeeReceiverSubcomponent extends AndroidInjector<CoffeeReceiver> {
			@Subcomponent.Builder
			public abstract class Builder extends AndroidInjector.Builder<CoffeeReceiver> {
		
			}
		}
<font color="red">
注意：
	- 如果该Activity或者Fragment中，含有子Fragment，可以其modules属性中注入其子Fragment的Module。当然这样这也限制了子Fragment的依赖关系。

			@Subcomponent(modules = OrangeModule.class)
			public interface FruitSubcomponent extends AndroidInjector<FruitActivity> {
			
				@Subcomponent.Builder
				abstract class Builder extends AndroidInjector.Builder<FruitActivity> {
			
				}
			}
</font>
4. 创建Module，其subcomponents属性值就是step3创建的子组件。在其内必须声明一个抽象方法，该抽象方法返回AndroidInjector.Factory&lt;？>实例，而其参数为step1创建的XxSubcomponent.Builder实例。

		@Module(subcomponents = CoffeeReceiverSubcomponent.class)
		public abstract class CoffeeModule {
		
			@Binds
			@IntoMap
			@BroadcastReceiverKey(CoffeeReceiver.class)
			abstract AndroidInjector.Factory<? extends BroadcastReceiver> bind(CoffeeReceiverSubcomponent.Builder builder);
		}	
5. 将创建的Module注入到ApplicationComponent中，即把其添加至ApplicationComponent的modules属性列表

		@Component(modules = {AndroidInjectionModule.class, AndroidSupportInjectionModule.class,  CoffeeModule.class, ...})
		public interface TodoComponent extends AndroidInjector<TodoApplication> {
			@Component.Builder
			abstract class Builder extends AndroidInjector.Builder<TodoApplication> {
			}
		}

6. 创建Application。在创建时，继承了DaggerApplication，因为dagger把该添加的DispatchingAndroidInjector&lt;T>添加进去了。但是，并没有实现v4包的HasSupportFragmentInjector，这里需要手动添加进去。

		public class TodoApplication extends DaggerApplication implements HasSupportFragmentInjector{
		
			@Inject
			DispatchingAndroidInjector<Fragment> fragmentSupportInjector;
		
			public void onCreate() {
				super.onCreate();
			}
		
			@Override
			protected AndroidInjector<TodoApplication> applicationInjector() {
				return DaggerTodoComponent.builder().create(this);
			}
		
			@Override
			public AndroidInjector<Fragment> supportFragmentInjector() {
				return fragmentSupportInjector;
			}
		}

值得一提的是，对于Android库的核心类注入要求比较严格，甚至在哪个生命周期内注入都有严格的要求。我们首选的应该是在构造器注入，因为因为javac将确保在设置之前没有引用字段，这样，有助于避免NullPointerExceptions。从而，当需要注入Android库的核心类时，应尽早注入。所以，DaggerActivity在调用super.onCreate()之前,调用AndroidInjection.inject()。而DaggerFragment在调用super.onAttach()之前调用。


对于DaggerFragment而言，可能觉得奇怪，为什么不再super.onCreate()之前调用呢？一是，当Fragment被重新绑定，这样也可以防止不一致；二是，如果已经绑定了Activity的Fragment，又依赖注入了一个Fragment，这时，super.onAttach(fragment)调用AndroidInjection.inject()显得尤为重要了。

# 更人性化的Dagger2 #

看了上面的流程，是不是觉得有点模板化了，每创建一个组件，都要重复着这些步骤，有没有优化的可能呢？接下来，我们先看 Dagger2中的一个注解@ContributesAndroidInjector

	@Target(METHOD)
	public @interface ContributesAndroidInjector {
	  // 要注入到生成的dagger.Subcomponent中的Module。
	  Class<?>[] modules() default {};
	}
官方文档对它是这么解释的：为其注解的方法生成相应的AndroidInjector。该注射器是 dagger.Subcomponent的实现，而且dagger.Module 的子类。
 
- 此注释必须应用于返回具体的Android框架类型(例如:FooActivity、BarFragment、MyService等）的dagger.Module中的抽象方法。
- 该方法应该没有参数。

这样，可以将前面的 Dagger的使用流程中的步骤3、4、5省略为：

	@Module
	public abstract class BookModule {
	
		@ContributesAndroidInjector
		abstract BookActivity contributesBookActivity();
	}
这样，是不是节省了很多工作，不用再机械式的创建。
