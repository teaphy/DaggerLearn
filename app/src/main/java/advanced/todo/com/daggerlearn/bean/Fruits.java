package advanced.todo.com.daggerlearn.bean;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
public class Fruits {
	AppleBean appleBean;
	OrangeBean orangeBean;

	public Fruits(AppleBean appleBean, OrangeBean orangeBean) {
		this.appleBean = appleBean;
		this.orangeBean = orangeBean;
	}

	@Override
	public String toString() {
		return "Fruits{" +
				"appleBean=" + appleBean +
				", orangeBean=" + orangeBean +
				'}';
	}
}
