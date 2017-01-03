package com.example.bovink.dagger2example.binder;

import com.example.bovink.dagger2example.component.GithubSubComponent;
import com.example.bovink.dagger2example.scope.SubcomponentKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * com.example.bovink.dagger2example.binder
 *
 * @author bovink
 * @since 2016/12/10
 */

@Module(subcomponents = GithubSubComponent.class)
public abstract class ApplicationBinders {
    @Binds
    @IntoMap
    @SubcomponentKey(GithubSubComponent.Builder.class)
    public abstract GithubSubComponent.SubcomponentBuilder mainActivity(GithubSubComponent.Builder impl);
}
