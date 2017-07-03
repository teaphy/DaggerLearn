package com.advanced.todo.daggerlearn.bean;

import javax.inject.Inject;

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
