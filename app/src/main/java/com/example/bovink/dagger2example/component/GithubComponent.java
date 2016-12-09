package com.example.bovink.dagger2example.component;

import com.example.bovink.dagger2example.MainActivity;
import com.example.bovink.dagger2example.module.GithubModule;
import com.example.bovink.dagger2example.scope.UserScope;

import dagger.Component;

/**
 * com.example.bovink.dagger2example.dependent_component
 *
 * @author bovink
 * @since 2016/12/9
 */

@UserScope
@Component(dependencies = NetComponent.class, modules = GithubModule.class)
public interface GithubComponent {
    void inject(MainActivity mainActivity);
}
