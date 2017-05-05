package advanced.todo.com.daggerlearn.bean;

import android.util.Log;

import javax.inject.Inject;

import advanced.todo.com.daggerlearn.di.scope.TodoScope;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
public class OrangeBean {

	String desc;

	public OrangeBean(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "OrangeBean{" +
				"desc='" + desc + '\'' +
				'}';
	}
}
