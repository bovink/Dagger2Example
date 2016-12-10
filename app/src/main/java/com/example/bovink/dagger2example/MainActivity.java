package com.example.bovink.dagger2example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.bovink.dagger2example.api.GithubInterface;
import com.example.bovink.dagger2example.component.DaggerNetComponent;
import com.example.bovink.dagger2example.component.NetComponent;
import com.example.bovink.dagger2example.model.Repo;
import com.example.bovink.dagger2example.module.ApplicationModule;
import com.example.bovink.dagger2example.module.NetModule;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private List<Repo> repos;

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daggerInstance();

        request();
    }

    private void daggerInstance() {
        NetComponent netComponent = DaggerNetComponent.builder()
                .applicationModule(new ApplicationModule(getApplication()))
                .netModule(new NetModule("https://api.github.com"))
                .build();

        netComponent.inject(this);
    }

    private void request() {
        GithubInterface githubInterface = retrofit.create(GithubInterface.class);

        HashMap<String, String> options = new HashMap<>();
        options.put("page", "1");
        options.put("per_page", "5");
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
}
