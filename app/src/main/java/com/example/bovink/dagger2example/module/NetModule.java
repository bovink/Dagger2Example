package com.example.bovink.dagger2example.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * com.example.bovink.dagger2example.module
 *
 * @author bovink
 * @since 2016/12/6
 */

@Module
public class NetModule {

    private final String baseUrl;

    public NetModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    Cache providesCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        return new Cache(application.getCacheDir(), cacheSize);
    }

//    @Provides
//    @Named("cache")
//    OkHttpClient providesOkHttpClientWithCache(Cache cache) {
//        return new OkHttpClient.Builder()
//                .cache(cache)
//                .build();
//    }

    //    @Named("no cache")
    @Provides
    OkHttpClient providesOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

//    @Provides
//    @Named("cache")
//    Retrofit providesRetrofitWithCache(@Named("cache") OkHttpClient okHttpClient) {
//        return new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
//                .build();
//    }

    @Provides
//    @Named("no cache")
    Retrofit providesRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
}
