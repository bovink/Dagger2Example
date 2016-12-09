package com.example.bovink.dagger2example.api;

import com.example.bovink.dagger2example.model.Repo;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * com.example.bovink.dagger2example.api
 *
 * @author bovink
 * @since 2016/12/6
 */

public interface API {

    @GET("/users/{user}/repos")
    Call<List<Repo>> getRepoList(@Path("user") String username, @Query("page") String page, @Query("per_page") String per_page);

    @GET("/users/{user}/repos")
    Call<List<Repo>> getRepoList(@Path("user") String username, @QueryMap Map<String, String> options);
}
