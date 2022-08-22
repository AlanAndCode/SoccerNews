package com.example.soccernews.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.soccernews.domain.News;
import com.example.soccernews.domain.Autors;

@Database(entities = {News.class , Autors.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public NewsDAO newsDao;

    public abstract NewsDAO newsDAO();
    public abstract AutorDAO AutorDAO();
}