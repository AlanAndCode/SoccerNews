package com.example.soccernews.data.remote;

import com.example.soccernews.domain.Autors;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AutoresApi {

    @GET("Autor.json")
    Call<List<Autors>> getAutors();

}