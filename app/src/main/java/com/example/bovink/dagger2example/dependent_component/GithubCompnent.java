package com.example.bovink.dagger2example.dependent_component;

import com.example.bovink.dagger2example.MainActivity;
import com.example.bovink.dagger2example.component.NetComponent;

import dagger.Component;

/**
 * com.example.bovink.dagger2example.dependent_component
 *
 * @author bovink
 * @since 2016/12/9
 */

@UserScope
@Component(dependencies = NetComponent.class, modules = GithubModule.class)
public interface GithubCompnent {
    void inject(MainActivity mainActivity);
}
