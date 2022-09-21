package com.example.tech_talent.model;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ProjetosRest {
    @Headers({"x-hasura-access-key:CQOsnv00PT6e7E8UY06ti0tmFgs4GGT7DZrnZvJqS649gBVFUSH1dmiRpmIJdsd4"})
    @POST("api/rest/projects")
    Call<Void> cadastraProjeto(@Body Projetos projetos);

    @GET("api/rest/projects")
    Call<List<Projetos>> getProjetos();

    @GET("api/rest/projects")
    Call<List<Projetos>> getProjetos(@QueryMap Map<String, String> parameters);

    @GET("api/rest/projects/{id}")
    Call<Projetos> getProjetosId(@Path("id") String id);

    @PUT("/api/rest/projects/{id}")
    Call<Void> editaProjeto(@Path("id") String id, @Body Projetos projetos);

    @DELETE("api/rest/projects/{id}")
    Call<Void> excluiProjeto(@Path("id") String id);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://tech-talent.hasura.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
