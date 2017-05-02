package advanced.todo.com.daggerlearn.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Tiany
 * @desc
 * @date 2017/5/2
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface TodoScope {
}
