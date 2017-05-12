package advanced.todo.com.daggerlearn.di.module;

import android.app.Activity;

import advanced.todo.com.daggerlearn.activity.FruitActivity;
import advanced.todo.com.daggerlearn.bean.AppleBean;
import advanced.todo.com.daggerlearn.bean.OrangeBean;
import advanced.todo.com.daggerlearn.di.component.FruitSubcomponent;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * @author todo
 * @desc
 * @date 2017/5/7
 */
@Module(subcomponents = FruitSubcomponent.class)
public abstract class FruitModule {
	@Binds
	@IntoMap
	@ActivityKey(FruitActivity.class)
	abstract AndroidInjector.Factory<? extends Activity> bindFruit(FruitSubcomponent.Builder builder);

	@Provides
	static AppleBean provideApple() {
		return new AppleBean("苹果");
	}
}