package advanced.todo.com.daggerlearn.di.module;

import advanced.todo.com.daggerlearn.bean.AppleBean;
import advanced.todo.com.daggerlearn.bean.Fruits;
import advanced.todo.com.daggerlearn.bean.OrangeBean;
import advanced.todo.com.daggerlearn.di.qualifier.Type;
import dagger.Module;
import dagger.Provides;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
// 注明本类属于Module
@Module()
public class FruitModule {

	//使用限定符来区别使用哪个构造函数返回对象
	@Type("color")
	@Provides
	public AppleBean provideColorApple() {
		return new AppleBean("red");
	}

	@Type("name")
	@Provides
	public AppleBean provideNameApple() {
		return new AppleBean("红富士", 6.88);
	}
}
