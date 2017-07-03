package com.advanced.todo.daggerlearn.bean;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
public class Fruits {

	String desc;

	public Fruits(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Fruits{" +
				"desc='" + desc + '\'' +
				'}';
	}
}
