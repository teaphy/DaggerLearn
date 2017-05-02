package advanced.todo.com.daggerlearn.bean;

import android.util.Log;

import javax.inject.Inject;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/2
 */
public class BananaBean {

	@Inject
	public BananaBean() {
		Log.d("test", "BananaBean()");
	}
}
