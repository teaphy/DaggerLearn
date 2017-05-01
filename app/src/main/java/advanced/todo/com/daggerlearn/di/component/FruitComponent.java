package advanced.todo.com.daggerlearn.di.component;

import advanced.todo.com.daggerlearn.activity.FruitActivity;
import advanced.todo.com.daggerlearn.bean.AppleBean;
import advanced.todo.com.daggerlearn.di.module.FruitModule;
import advanced.todo.com.daggerlearn.di.qualifier.Type;
import dagger.Component;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
@Component(modules = {FruitModule.class})
public interface FruitComponent {

	void inject(FruitActivity activity);

	@Type("color")
	AppleBean makeApple();
}
