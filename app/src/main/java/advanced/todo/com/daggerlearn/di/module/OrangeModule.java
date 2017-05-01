package advanced.todo.com.daggerlearn.di.module;

import advanced.todo.com.daggerlearn.bean.OrangeBean;
import dagger.Module;
import dagger.Provides;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
@Module
public class OrangeModule {
	OrangeBean orangeBean;

	public OrangeModule(OrangeBean orangeBean) {
		this.orangeBean = orangeBean;
	}

	@Provides
	public OrangeBean provideOrange() {
		return this.orangeBean;
	}
}
