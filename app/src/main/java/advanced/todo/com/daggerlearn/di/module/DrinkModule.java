package advanced.todo.com.daggerlearn.di.module;

import javax.inject.Singleton;

import advanced.todo.com.daggerlearn.bean.AppleBean;
import advanced.todo.com.daggerlearn.bean.GreenTeaBean;
import advanced.todo.com.daggerlearn.di.scope.TodoScope;
import dagger.Module;
import dagger.Provides;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
// 注明本类属于Module
@Module()
public class DrinkModule {

	@TodoScope
	@Provides
	public AppleBean providerApple() {
		return new AppleBean();
	}

	@Singleton
	@Provides
	public GreenTeaBean providerDrink() {
		return new GreenTeaBean();
	}
}
