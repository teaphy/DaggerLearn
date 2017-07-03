package com.advanced.todo.daggerlearn.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author todo
 * @desc
 * @date 2017/5/7
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface ActivityScope {
}