package advanced.todo.com.daggerlearn.di.component;

import advanced.todo.com.daggerlearn.activity.OrangeFragment;
import advanced.todo.com.daggerlearn.di.scope.ActivityScope;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/10
 */
@Subcomponent
public interface OrangeSubcomponent extends AndroidInjector<OrangeFragment> {

	@Subcomponent.Builder
	public abstract class Builder extends AndroidInjector.Builder<OrangeFragment> {

	}
}
