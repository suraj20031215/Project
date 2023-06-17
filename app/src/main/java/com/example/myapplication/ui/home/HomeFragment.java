package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.customadpaters.CustomAdpterView;
import com.example.myapplication.customadpaters.CustomAdpater;
import com.example.myapplication.R;
import com.example.myapplication.customadpaters.CustomAdpterView2;
import com.example.myapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView,recyclerView1,recyclerView2;
    CustomAdpater customAdpater;
    CustomAdpterView customAdpater1;


     CustomAdpterView2 customAdpater2;
     //Top
    String[] name = {"Apple","Laptop"};
    Integer img[] = {R.drawable.img_8,R.drawable.img};

//Categories
    String name_1[]= {"Laptop","Watch","Phone"};
    Integer img_1[]= {R.drawable.img_1,R.drawable.img_6,R.drawable.img_7};
// Trending
    String name_2[]= {"MacBook Air with M1 Chip","MacBook Pro with M1 Pro Chip","MacBook Pro M1 Chip"};
    Integer img_2[]= {R.drawable.img_1,R.drawable.img_4,R.drawable.img};


    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView1 = view.findViewById(R.id.recyclerview_1);
        recyclerView2 = view.findViewById(R.id.recyclerview_2);
        customAdpater = new CustomAdpater(getContext(), name, img);
        customAdpater1 = new CustomAdpterView(getContext(), name_1, img_1);
        customAdpater2 = new CustomAdpterView2(getContext(), name_2, img_2);
        recyclerView.setAdapter(customAdpater);
        recyclerView1.setAdapter(customAdpater1);
        recyclerView2.setAdapter(customAdpater2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        //  HomeViewModel homeViewModel =
        //     new ViewModelProvider(this).get(HomeViewModel.class);

        //   binding = FragmentHomeBinding.inflate(inflater, container, false);
        //   View root = binding.getRoot();

        // final TextView textView = binding.textHome;
        // homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        //return root;
        // return view;

        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}