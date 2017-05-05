package advanced.todo.com.daggerlearn.di.component;

import advanced.todo.com.daggerlearn.bean.AppleBean;
import advanced.todo.com.daggerlearn.di.module.AppleModule;
import advanced.todo.com.daggerlearn.fragment.AppleFragment;
import dagger.Subcomponent;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/5
 */
@Subcomponent(modules = AppleModule.class)
public interface AppleSubcomponent {
	void inject(AppleFragment fragment);


	@Subcomponent.Builder
	interface Builder{
		Builder appleModule(AppleModule module);
		AppleSubcomponent build();
	}
}
