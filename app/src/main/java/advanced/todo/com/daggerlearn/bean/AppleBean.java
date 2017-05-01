package advanced.todo.com.daggerlearn.bean;

import javax.inject.Inject;

import advanced.todo.com.daggerlearn.di.qualifier.Type;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
public class AppleBean {
	private String name;
	private double price;
	private String color;

	public AppleBean() {
	}

	public AppleBean(String color) {
		this.color = color;
	}

	public AppleBean(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "AppleBean{" +
				       "name='" + name + '\'' +
				       ", price=" + price +
				       ", color='" + color + '\'' +
				       '}';
	}
}
