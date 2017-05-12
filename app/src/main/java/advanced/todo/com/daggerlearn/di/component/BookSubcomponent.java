package advanced.todo.com.daggerlearn.di.component;

import advanced.todo.com.daggerlearn.activity.BookActivity;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/11
 */
@Subcomponent
public interface BookSubcomponent extends AndroidInjector<BookActivity> {

	@Subcomponent.Builder
	public abstract class Builder extends AndroidInjector.Builder<BookActivity> {

	}
}