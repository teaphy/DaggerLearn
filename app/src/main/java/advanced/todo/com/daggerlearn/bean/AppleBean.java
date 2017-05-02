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
@TodoScope
public class AppleBean {
	@Inject
	public AppleBean() {
	}
}
