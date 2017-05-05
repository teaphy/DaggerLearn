package advanced.todo.com.daggerlearn.di.component;

import advanced.todo.com.daggerlearn.activity.FruitActivity;
import advanced.todo.com.daggerlearn.bean.Fruits;
import advanced.todo.com.daggerlearn.di.module.AppleModule;
import advanced.todo.com.daggerlearn.di.module.FruitModule;
import dagger.Component;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
@Component(modules = {FruitModule.class})
public interface FruitComponent {

	void inject(FruitActivity activity);

	// 将FruitModule中的Fruits暴露出来，以便于其他依赖于FruitComponent的Component调用
	// 若不将Fruits暴露出来，依赖于FruitComponent的Component无法获取该实例,此时编译会报错，提示为该实例提供@Inject注解或者@Provides方法
	Fruits supplyFruits();


	//需要将SubComponent 追加到 被依赖的Component中
	AppleSubcomponent addAppleSubcomponent(AppleModule module);
}
