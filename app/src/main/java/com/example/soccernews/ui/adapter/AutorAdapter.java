package com.example.soccernews.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccernews.databinding.AutorsItemBinding;
import com.example.soccernews.domain.Autors;
import com.squareup.picasso.Picasso;

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
        Context context = holder.itemView.getContext();
     Autors autors  = this.autors.get(position);
        holder.binding.auTitle.setText(autors.title);
        holder.binding.auDescription.setText(autors.description);
        Picasso.get().load(autors.image).into(holder.binding.auImage);
        holder.binding.ivShare.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(autors.link));
            holder.itemView.getContext().startActivity(i);
        });
        holder.binding.btOpenLink.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(autors.etc));
            holder.itemView.getContext().startActivity(i);
        });


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
