package com.example.soccernews.ui.Autors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.soccernews.data.remote.AutoresApi;
import com.example.soccernews.domain.Autors;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    public class AutorsViewModel extends ViewModel {
        private final MutableLiveData<List<Autors>> autors = new MutableLiveData<>();
        private final AutoresApi api;
        public AutorsViewModel() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://alanandcode.github.io/AutoresAPI/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            api = retrofit.create(AutoresApi.class);


            this.findAutors();
        }
        private void findAutors() {
            api.getAutors().enqueue(new Callback<List<Autors>>() {
                @Override
                public void onResponse(Call<List<Autors>> call, Response<List<Autors>> response) {
                    if (response.isSuccessful()) {
                        autors.setValue(response.body());
                    } else {
                        //tratamento de erros
                    }
                }

                @Override
                public void onFailure(Call<List<Autors>> call, Throwable t) {

                }
            });
        }


        public LiveData<List<Autors>> getAutors() {
            return this.autors;
        }
    }

