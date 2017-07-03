package com.advanced.todo.daggerlearn.bean;

import javax.inject.Inject;

/**
 * @author todo
 * @desc
 * @date 2017/4/29
 */
public class ScoreBean {
	private double chinese;
	private double math;
	@Inject
	public ScoreBean() {
		this.chinese = 90.5;
		this.math = 78.0;
	}

	@Override
	public String toString() {
		return "ScoreBean{" +
				"chinese=" + chinese +
				", math=" + math +
				'}';
	}
}
