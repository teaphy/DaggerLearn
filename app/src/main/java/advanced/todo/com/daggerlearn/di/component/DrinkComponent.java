package advanced.todo.com.daggerlearn.di.component;

import java.util.Map;


import advanced.todo.com.daggerlearn.activity.DrinkActivity;
import advanced.todo.com.daggerlearn.di.module.DrinkModule;
import advanced.todo.com.daggerlearn.di.qualifier.ProvinceType;
import dagger.Component;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
@Component(modules = {DrinkModule.class})
public interface DrinkComponent {
	void inject(DrinkActivity activity);
}
