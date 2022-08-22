package com.example.soccernews.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccernews.R;
import com.example.soccernews.databinding.AutorsItemBinding;
import com.example.soccernews.domain.Autors;
import com.example.soccernews.domain.News;
import com.squareup.picasso.Picasso;
import com.example.soccernews.domain.Autors;
import java.util.List;


public class AutorAdapter extends RecyclerView.Adapter<AutorAdapter.ViewHolder> {

    @NonNull

    private List<Autors> autors;

    public AutorAdapter(List<Autors> autors){
        this.autors = autors;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        AutorsItemBinding binding = AutorsItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     Autors autors  = this.autors.get(position);
        holder.binding.auTitle.setText(autors.title);
        holder.binding.auDescription.setText(autors.description);
    }

    @Override
    public int getItemCount() {
        return this.autors.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final AutorsItemBinding binding;

        public ViewHolder(AutorsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}
