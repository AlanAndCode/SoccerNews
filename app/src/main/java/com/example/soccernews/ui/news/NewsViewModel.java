package com.example.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.soccernews.domain.News;

import java.util.ArrayList;
import java.util.List;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        List<News> news = new ArrayList<>();
        news.add(new News("Ferroviaria tem desfalque importante","Com contrato até junho de 2023, português está insatisfeito e procura na Europa outra equipe que aceite contratá-lo"));
        news.add(new News("FeRRINHA JOGA SABADO","Com contrato até junho de 2023, português está insatisfeito e procura na Europa outra equipe que aceite contratá-lo"));
        news.add(new News("Copa do mundo feminina","Com contrato até junho de 2023, português está insatisfeito e procura na Europa outra equipe que aceite contratá-lo"));

        this.news.setValue((news));
    }

    public LiveData<List<News>> getNews() {
        return this.news;
    }
}