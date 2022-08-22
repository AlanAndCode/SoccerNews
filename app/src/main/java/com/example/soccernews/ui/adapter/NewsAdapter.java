package com.example.soccernews.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccernews.R;
import com.example.soccernews.databinding.NewsItemBinding;
import com.example.soccernews.domain.News;
import com.squareup.picasso.Picasso;

import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    @NonNull

    private List<News> news;
    private FavoriteListener favoriteListener;

    public NewsAdapter(List<News> news, FavoriteListener favoriteListener){
        this.news = news;
        this.favoriteListener = favoriteListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        News news = this.news.get(position);
        //passando titulo
        holder.binding.tvTitle.setText(news.title);
        //passando descriçao
        holder.binding.tvDescription.setText(news.description);
        //impleentando imagem
        Picasso.get().load(news.image).into(holder.binding.imView);
        //abrir link
        holder.binding.btOpenLink.setOnClickListener(view -> {
Intent i = new Intent(Intent.ACTION_VIEW);
i.setData(Uri.parse(news.link));
holder.itemView.getContext().startActivity(i);
    });
        //compartilhar
        holder.binding.ivShare.setOnClickListener(view -> {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, (news.link));
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, "Compartilhar via");
            holder.itemView.getContext().startActivity(shareIntent);

        });
//favoritar(influencia do fragment)
        holder.binding.ivLike.setOnClickListener( view -> {
            news.favorite = !news.favorite;
this.favoriteListener.onFavorite(news);
notifyItemChanged(position);
    });
        int favoriteColor = news.favorite ? R.color.Like_color : R.color.Nolike_color;
            holder.binding.ivLike.setColorFilter(context.getResources().getColor(favoriteColor));

    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final NewsItemBinding binding;

        public ViewHolder(NewsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    public interface FavoriteListener{
        void onFavorite(News news);
    }

}
