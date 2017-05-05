package advanced.todo.com.daggerlearn.di.module;

import advanced.todo.com.daggerlearn.bean.Fruits;
import advanced.todo.com.daggerlearn.di.component.AppleSubcomponent;
import dagger.Module;
import dagger.Provides;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
// 注明本类属于Module
@Module(subcomponents = AppleSubcomponent.class)
public class FruitModule {

	@Provides
	public Fruits provideFruit() {
		return  new Fruits("这是一个水果");
	}
}
