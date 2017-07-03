package com.advanced.todo.daggerlearn.bean;

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
