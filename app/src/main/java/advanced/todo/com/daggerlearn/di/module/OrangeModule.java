package advanced.todo.com.daggerlearn.di.module;

import advanced.todo.com.daggerlearn.bean.AppleBean;
import advanced.todo.com.daggerlearn.bean.Fruits;
import advanced.todo.com.daggerlearn.bean.OrangeBean;
import dagger.Module;
import dagger.Provides;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/5
 */
@Module
public class OrangeModule {

	@Provides
	public OrangeBean provideOrange() {
		return new OrangeBean("这是一个橘子");
	}
}
