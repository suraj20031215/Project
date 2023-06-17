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

public class CustomAdpterView extends RecyclerView.Adapter<CustomAdpterView.MyviewHolder> {
private Context context;
private  String name_1[];
private Integer img_1[];


public CustomAdpterView(Context context, String[] name, Integer[] img) {
        this.context = context;
        this.name_1 = name;
        this.img_1 = img;
        }

@NonNull
@Override
public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_1,null,false);
        return new MyviewHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.imageView.setImageResource(img_1[position]);
        holder.textView.setText(name_1[position]);
    }



    @Override
public int getItemCount() {
        return name_1.length;
        }

public class MyviewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;
    RelativeLayout relativeLayout;
    public MyviewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView4);
        textView = itemView.findViewById(R.id.textView18);
        relativeLayout= itemView.findViewById(R.id.recyclerview_1);
    }
}
}
