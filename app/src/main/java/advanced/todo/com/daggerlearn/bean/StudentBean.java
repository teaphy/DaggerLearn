package advanced.todo.com.daggerlearn.bean;

import javax.inject.Inject;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
public class StudentBean {
	private int no;
	private String name;

	@Inject
	AreaBean areaBean;
	@Inject
	ScoreBean scoreBean;

	@Inject
	public StudentBean() {
		this.no = 1;
		this.name = "赵四";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StudentBean{" +
				"no=" + no +
				", name='" + name + '\'' +
				", areaBean=" + areaBean +
				", scoreBean=" + scoreBean +
				'}';
	}
}
