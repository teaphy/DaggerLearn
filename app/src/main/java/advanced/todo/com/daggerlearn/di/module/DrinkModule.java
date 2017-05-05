package advanced.todo.com.daggerlearn.di.module;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import advanced.todo.com.daggerlearn.activity.DrinkActivity;
import advanced.todo.com.daggerlearn.activity.FruitActivity;
import advanced.todo.com.daggerlearn.bean.AppleBean;
import advanced.todo.com.daggerlearn.bean.BananaBean;
import advanced.todo.com.daggerlearn.bean.GreenTeaBean;
import advanced.todo.com.daggerlearn.di.qualifier.ProvinceType;
import advanced.todo.com.daggerlearn.di.scope.TodoScope;
import dagger.MapKey;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
// 注明本类属于Module
@Module()
public class DrinkModule {

}
