package com.example.bovink.dagger2example.module;

import com.example.bovink.dagger2example.model.Repo;
import com.example.bovink.dagger2example.scope.UserScope;

import java.util.List;
import java.util.Map;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * com.example.bovink.dagger2example.dependent_component
 *
 * @author bovink
 * @since 2016/12/9
 */

@Module
public class GithubModule {

    public interface GithubInterface{
        @GET("/users/{user}/repos")
        Call<List<Repo>> getRepoList(@Path("user") String username, @QueryMap Map<String, String> options);
    }

    @UserScope
    @Provides
    public GithubInterface providesGithubInterface(Retrofit retrofit) {
        return retrofit.create(GithubInterface.class);
    }

}
