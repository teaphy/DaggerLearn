package advanced.todo.com.daggerlearn.di.component;

import advanced.todo.com.daggerlearn.activity.MainActivity;
import advanced.todo.com.daggerlearn.activity.StudentActivity;
import advanced.todo.com.daggerlearn.di.scope.TodoScope;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author Tiany
 * @desc
 * @date 2017/4/28
 */
@TodoScope
@Subcomponent
public interface MainSubcomponent extends AndroidInjector<MainActivity> {
	@Subcomponent.Builder
	public abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
}
