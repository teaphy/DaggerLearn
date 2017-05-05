package advanced.todo.com.daggerlearn.di.component;

import advanced.todo.com.daggerlearn.di.module.AppleModule;
import advanced.todo.com.daggerlearn.di.module.OrangeModule;
import advanced.todo.com.daggerlearn.fragment.AppleFragment;
import advanced.todo.com.daggerlearn.fragment.OrangeFragment;
import dagger.Component;
import dagger.Subcomponent;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/5
 */
@Component(modules = OrangeModule.class, dependencies = FruitComponent.class)
public interface OrangeComponent {
	void inject(OrangeFragment fragment);
}
