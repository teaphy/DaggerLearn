package advanced.todo.com.daggerlearn.di.module;

import advanced.todo.com.daggerlearn.bean.AppleBean;
import dagger.Module;
import dagger.Provides;

/**
 * @author todo
 * @desc
 * @date 2017/5/7
 */
@Module
public abstract class AppleModule {
	@Provides
	public static AppleBean provideApple() {
		return new AppleBean("这是一个苹果");
	}
}
