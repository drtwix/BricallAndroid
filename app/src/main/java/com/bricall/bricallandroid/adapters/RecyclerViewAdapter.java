package com.bricall.bricallandroid.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bricall.bricallandroid.R;
import com.bricall.bricallandroid.model.Service;

import java.util.List;

/**
 * Created by yassine on 11/03/2019.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Service> mData ;
    RequestOptions option;


    public RecyclerViewAdapter(Context mContext, List<Service> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.anime_row_item,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        /*viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, AnimeActivity.class);
                i.putExtra("servicename",mData.get(viewHolder.getAdapterPosition()).getService_name());
                i.putExtra("thumbnail",mData.get(viewHolder.getAdapterPosition()).getService_img_url());


                mContext.startActivity(i);

            }
        });*/




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.service_name.setText(mData.get(position).getService_name());


        // Load Image from the internet and set it into Imageview using Glide

        Glide.with(mContext).load(mData.get(position).getService_img_url()).apply(option).into(holder.img_thumbnail);



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView service_name ;

        ImageView img_thumbnail;
        LinearLayout view_container;





        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            service_name = itemView.findViewById(R.id.servicename);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }

}


