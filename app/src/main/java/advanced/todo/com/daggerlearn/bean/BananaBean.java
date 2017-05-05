package advanced.todo.com.daggerlearn.bean;

import android.util.Log;

import javax.inject.Inject;

import advanced.todo.com.daggerlearn.di.scope.TodoScope;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/2
 */
public class BananaBean {

	String name;

	public BananaBean(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BananaBean{" +
				"name='" + name + '\'' +
				'}';
	}
}
