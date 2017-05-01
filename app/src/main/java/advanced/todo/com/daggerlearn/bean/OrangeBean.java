package advanced.todo.com.daggerlearn.bean;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
public class OrangeBean {
	private String name;
	private double price;
	private String area;

	public OrangeBean(String name, double price, String area) {
		this.name = name;
		this.price = price;
		this.area = area;
	}

	@Override
	public String toString() {
		return "OrangeBean{" +
				"name='" + name + '\'' +
				", price=" + price +
				", area='" + area + '\'' +
				'}';
	}
}
