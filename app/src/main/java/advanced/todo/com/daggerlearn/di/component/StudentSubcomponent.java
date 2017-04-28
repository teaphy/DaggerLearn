package advanced.todo.com.daggerlearn.di.component;

import advanced.todo.com.daggerlearn.activity.StudentActivity;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author Tiany
 * @desc
 * @date 2017/4/28
 */
@Subcomponent
public interface StudentSubcomponent extends AndroidInjector<StudentActivity> {
	@Subcomponent.Builder
	public abstract class Builder extends AndroidInjector.Builder<StudentActivity> {}
}
