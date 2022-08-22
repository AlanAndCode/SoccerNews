package com.example.soccernews.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.soccernews.domain.Autors;

import java.util.List;

@Dao
public interface AutorDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(Autors autors);


}
