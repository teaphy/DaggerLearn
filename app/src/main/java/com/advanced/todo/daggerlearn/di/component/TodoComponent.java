package com.advanced.todo.daggerlearn.di.component;

import com.advanced.todo.daggerlearn.application.TodoApplication;
import com.advanced.todo.daggerlearn.di.module.CoffeeModule;
import com.advanced.todo.daggerlearn.di.module.DrinkModule;
import com.advanced.todo.daggerlearn.di.module.MainModule;
import com.advanced.todo.daggerlearn.di.module.BookModule;
import com.advanced.todo.daggerlearn.di.module.FruitModule;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * @author Tiany
 * @desc
 * @date 2017/4/28
 */
@Component(modules = {AndroidInjectionModule.class, AndroidSupportInjectionModule.class, MainModule.class, FruitModule.class,
		DrinkModule.class, CoffeeModule.class, BookModule.class})
public interface TodoComponent extends AndroidInjector<TodoApplication> {
	@Component.Builder
	abstract class Builder extends AndroidInjector.Builder<TodoApplication> {
	}
}
