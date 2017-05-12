package advanced.todo.com.daggerlearn.bean;

import android.util.Log;

import javax.inject.Inject;

import advanced.todo.com.daggerlearn.di.qualifier.Type;
import advanced.todo.com.daggerlearn.di.scope.TodoScope;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
public class AppleBean {

	private String name;

	@Inject
	public AppleBean(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AppleBean{" +
				"name='" + name + '\'' +
				'}';
	}
}
