package com.example.bovink.dagger2example.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * com.example.bovink.dagger2example.dependent_component
 *
 * @author bovink
 * @since 2016/12/9
 */

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {
}
