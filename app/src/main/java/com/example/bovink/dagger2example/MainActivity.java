package com.example.bovink.dagger2example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.bovink.dagger2example.component.DaggerGithubComponent;
import com.example.bovink.dagger2example.component.DaggerNetComponent;
import com.example.bovink.dagger2example.component.GithubComponent;
import com.example.bovink.dagger2example.component.NetComponent;
import com.example.bovink.dagger2example.model.Repo;
import com.example.bovink.dagger2example.module.ApplicationModule;
import com.example.bovink.dagger2example.module.GithubModule;
import com.example.bovink.dagger2example.module.NetModule;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<Repo> repos;

    @Inject
    GithubModule.GithubInterface githubInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daggerDependentInstance();
    }

    private void daggerDependentInstance() {
        NetComponent netComponent = DaggerNetComponent.builder()
                .applicationModule(new ApplicationModule(getApplication()))
                .netModule(new NetModule("https://api.github.com"))
                .build();

        GithubComponent githubComponent = DaggerGithubComponent.builder()
                .netComponent(netComponent)
                .githubModule(new GithubModule())
                .build();

        githubComponent.inject(this);

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
}
