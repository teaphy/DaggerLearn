package advanced.todo.com.daggerlearn.bean;

import javax.inject.Inject;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
public class AreaBean {
	private String provice;
	private String city;

	@Inject
	public AreaBean() {
		this.provice = "四川";
		this.city = "成都";
	}

	@Override
	public String toString() {
		return "AreaBean{" +
				"provice='" + provice + '\'' +
				", city='" + city + '\'' +
				'}';
	}
}
