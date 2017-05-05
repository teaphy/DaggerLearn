package advanced.todo.com.daggerlearn.di.module;

import advanced.todo.com.daggerlearn.bean.AppleBean;
import dagger.Module;
import dagger.Provides;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/5
 */
@Module
public class AppleModule {

	@Provides
	public AppleBean privdeApple() {
		return new AppleBean("这是一个苹果");
	}
}
