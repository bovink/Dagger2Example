package com.example.bovink.dagger2example;

import android.app.Application;

import com.example.bovink.dagger2example.component.DaggerNetComponent;
import com.example.bovink.dagger2example.component.NetComponent;
import com.example.bovink.dagger2example.module.ApplicationModule;
import com.example.bovink.dagger2example.module.NetModule;

/**
 * com.example.bovink.dagger2example
 *
 * @author bovink
 * @since 2016/12/10
 */

public class MyApplication extends Application {

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule("https://api.github.com"))
                .build();
    }


    public NetComponent getNetComponent() {
        return netComponent;
    }
}
