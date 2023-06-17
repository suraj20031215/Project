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

public class CustomAdpterView2 extends RecyclerView.Adapter<CustomAdpterView2.MyviewHolder> {
    private Context context;
    private  String name_2[];
    private Integer img_2[];



    public CustomAdpterView2(Context context, String[] name, Integer[] img) {
        this.context = context;
        this.name_2 = name;

        this.img_2 = img;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_2,null,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.imageView.setImageResource(img_2[position]);
        holder.textView.setText(name_2[position]);
    }




    @Override
    public int getItemCount() {
        return name_2.length;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        RelativeLayout relativeLayout2;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView3);
            textView = itemView.findViewById(R.id.textView17);
            relativeLayout2= itemView.findViewById(R.id.recyclerview_2);

        }
    }
}
