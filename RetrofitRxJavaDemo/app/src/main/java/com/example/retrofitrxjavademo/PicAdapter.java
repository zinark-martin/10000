package com.example.retrofitrxjavademo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * @author myx
 */
public class PicAdapter extends RecyclerView.Adapter<PicAdapter.MyViewHolder> {
    private List<Photo> photos;

    public PicAdapter(List<Photo> photoList) {
        photos = photoList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pics, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Photo photo = photos.get(position);
        //把从list中获取的图片set给holder里的图片资源
        holder.pic.setImageResource(photo.getImageId());
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pic = (ImageView) itemView.findViewById(R.id.photo);
        }
    }
}