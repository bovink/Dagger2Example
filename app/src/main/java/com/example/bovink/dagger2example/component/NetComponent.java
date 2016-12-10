package com.example.bovink.dagger2example.component;

import com.example.bovink.dagger2example.module.ApplicationModule;
import com.example.bovink.dagger2example.module.GithubModule;
import com.example.bovink.dagger2example.module.NetModule;

import dagger.Component;

/**
 * com.example.bovink.dagger2example.component
 *
 * @author bovink
 * @since 2016/12/6
 */

@Component(modules = {NetModule.class, ApplicationModule.class})
public interface NetComponent {
    GithubSubComponent newGithubSubComponent(GithubModule githubModule);
}
