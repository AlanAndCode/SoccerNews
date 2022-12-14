package com.example.soccernews.data.local;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Dao;

import com.example.soccernews.domain.News;

import java.util.List;
@Dao
public interface NewsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(News news);

    @Query("SELECT * FROM news WHERE favorite = 1")
    List<News> loadFavoriteNews();


}
