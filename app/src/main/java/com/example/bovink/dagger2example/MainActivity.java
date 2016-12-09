package com.example.bovink.dagger2example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.bovink.dagger2example.api.API;
import com.example.bovink.dagger2example.component.NetComponent;
import com.example.bovink.dagger2example.dependent_component.GithubCompnent;
import com.example.bovink.dagger2example.dependent_component.GithubModule;
import com.example.bovink.dagger2example.model.Repo;
import com.example.bovink.dagger2example.module.ApplicationModule;
import com.example.bovink.dagger2example.module.NetModule;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private List<Repo> repos;

    //    @Inject
//    @Named("cache")
    Retrofit retrofit;

    @Inject
    GithubModule.GithubInterface githubInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daggerDependentInstance();
//        daggerInstance();
//        normalInstance();

//        request();
    }

    private void daggerInstance() {
//        NetComponent netComponent = DaggerNetComponent.builder()
//                .applicationModule(new ApplicationModule(getApplication()))
//                .netModule(new NetModule("https://api.github.com"))
//                .build();
//
//        netComponent.inject(this);
    }


    private void daggerDependentInstance() {
        NetComponent netComponent = DaggerNetComponent.builder()
                .applicationModule(new ApplicationModule(getApplication()))
                .netModule(new NetModule("https://api.github.com"))
                .build();

        GithubCompnent githubCompnent = DaggerGithubCompnent.builder()
                .netComponent(netComponent)
                .githubModule(new GithubModule())
                .build();

        githubCompnent.inject(this);

        HashMap<String, String> options = new HashMap<>();
        options.put("page", "1");
        options.put("per_page", "3");

        Call<List<Repo>> call = githubInterface.getRepoList("bovink", options);
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {

                repos = response.body();
                for (Repo repo : repos) {
                    System.out.println("repo.getName() = " + repo.getName());
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }

    private void normalInstance() {

        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(getApplication().getCacheDir(), cacheSize);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    private void request() {
        API api = retrofit.create(API.class);

        Call<List<Repo>> call = api.getRepoList("bovink", "1", "6");
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {

                repos = response.body();
                for (Repo repo : repos) {
                    System.out.println("repo.getName() = " + repo.getName());
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }
}
