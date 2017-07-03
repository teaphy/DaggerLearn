package com.advanced.todo.daggerlearn.bean;

import java.util.Set;

import javax.inject.Inject;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/2
 */
public class SetBananaBean {

	Set<BananaBean> set;

	@Inject
	public SetBananaBean(Set<BananaBean> set) {
		this.set = set;
	}

	@Override
	public String toString() {
		return "SetBananaBean{" +
				"set=" + set +
				'}';
	}
}
