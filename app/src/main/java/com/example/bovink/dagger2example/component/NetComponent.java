package com.example.bovink.dagger2example.component;

import com.example.bovink.dagger2example.binder.ApplicationBinders;
import com.example.bovink.dagger2example.module.ApplicationModule;
import com.example.bovink.dagger2example.module.NetModule;

import java.util.Map;

import javax.inject.Provider;

import dagger.Component;

/**
 * com.example.bovink.dagger2example.component
 *
 * @author bovink
 * @since 2016/12/6
 */

@Component(modules = {NetModule.class, ApplicationModule.class, ApplicationBinders.class})
public interface NetComponent {
    Map<Class<?>, Provider<GithubSubcomponent.SubcomponentBuilder>> subcomponentBuilders();
}
