package com.example.myapplication.customadpaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class CustomAdpater extends RecyclerView.Adapter<CustomAdpater.MyviewHolder> {
    private Context context;
    private  String name[];
    private Integer img[];

    public CustomAdpater(Context context, String[] name, Integer[] img) {
        this.context = context;
        this.name = name;

        this.img = img;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,null,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.imageView.setImageResource(img[position]);
        holder.textView.setText(name[position]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,textView2,textView3;




        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView11);
            textView2 = itemView.findViewById(R.id.textView12);
            textView3 = itemView.findViewById(R.id.textView13);

        }
    }
}
