package com.example.bovink.dagger2example.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * com.example.bovink.dagger2example.scope
 *
 * @author bovink
 * @since 2016/12/10
 */

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface GithubScope {
}
