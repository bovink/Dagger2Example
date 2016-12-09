package com.example.bovink.dagger2example.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * com.example.bovink.dagger2example.module
 *
 * @author bovink
 * @since 2016/12/6
 */

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    Application providesApplication() {
        return application;
    }
}
