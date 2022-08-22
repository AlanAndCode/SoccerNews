package com.example.soccernews.ui.Autors;

import android.graphics.drawable.GradientDrawable;
import android.icu.lang.UCharacter;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.soccernews.MainActivity;
import com.example.soccernews.data.local.AppDatabase;
import com.example.soccernews.databinding.FragmentAutorsBinding;
import com.example.soccernews.domain.News;
import com.example.soccernews.ui.adapter.AutorAdapter;
import com.example.soccernews.ui.adapter.NewsAdapter;
;


public class AutorsFragment extends Fragment {


    private FragmentAutorsBinding binding;
    private AppDatabase db;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AutorsViewModel AutorsViewModel =
                new ViewModelProvider(this).get(AutorsViewModel.class);

        binding = FragmentAutorsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.rvAutors.setLayoutManager( layoutManager );
        AutorsViewModel.getAutors().observe(getViewLifecycleOwner(), autors -> {
            binding.rvAutors.setAdapter(new AutorAdapter(autors));

        });
        return root;
    }

    


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}