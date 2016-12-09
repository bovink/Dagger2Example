package com.example.bovink.dagger2example.component;

import com.example.bovink.dagger2example.module.ApplicationModule;
import com.example.bovink.dagger2example.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * com.example.bovink.dagger2example.component
 *
 * @author bovink
 * @since 2016/12/6
 */

@Singleton
@Component(modules = {NetModule.class, ApplicationModule.class})
public interface NetComponent {
    Retrofit retrofit();
}
