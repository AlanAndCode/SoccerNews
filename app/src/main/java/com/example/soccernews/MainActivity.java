package com.example.soccernews;

import static java.security.AccessController.getContext;

import android.os.Bundle;

import com.example.soccernews.data.local.AppDatabase;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;

import com.example.soccernews.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_news, R.id.navigation_favorites, R.id.navigation_autors)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        db = Room.databaseBuilder(this, AppDatabase.class, "soccer-news")
                .allowMainThreadQueries()
                .build();

        this.setupDb();
    }
    private void setupDb() {
        db = Room.databaseBuilder(this, AppDatabase.class, "soccer-news")
                .allowMainThreadQueries()
                .build();
    }

    public AppDatabase getDb() {
        return db;
    }
}