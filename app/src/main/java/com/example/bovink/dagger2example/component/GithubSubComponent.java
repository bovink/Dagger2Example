package com.example.bovink.dagger2example.component;

import com.example.bovink.dagger2example.MainActivity;
import com.example.bovink.dagger2example.module.GithubModule;
import com.example.bovink.dagger2example.scope.GithubScope;

import dagger.Subcomponent;

/**
 * com.example.bovink.dagger2example.component
 *
 * @author bovink
 * @since 2016/12/10
 */

@GithubScope
@Subcomponent(modules = GithubModule.class)
public interface GithubSubcomponent {

    void inject(MainActivity mainActivity);

    @Subcomponent.Builder
    interface Builder extends SubcomponentBuilder<GithubSubcomponent> {
        Builder githubModule(GithubModule module);
    }

    interface SubcomponentBuilder<V> {
        V build();
    }
}
