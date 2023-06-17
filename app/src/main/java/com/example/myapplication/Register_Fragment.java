package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class Register_Fragment extends Fragment {
    Button btn2;
    TextView text;
    EditText ed1,ed2,ed3,ed4,ed5;
    RequestQueue queue;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_, container, false);
        text=view.findViewById(R.id.textView3);
        btn2 = view.findViewById(R.id.button2);
        ed1=view.findViewById(R.id.personname_);
        ed2=view.findViewById(R.id.email_);
        ed3=view.findViewById(R.id.number_);
        ed4=view.findViewById(R.id.address_);
        ed5=view.findViewById(R.id.password_);
        queue = Volley.newRequestQueue(getContext());
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =ed1.getText().toString();
                String email =ed2.getText().toString();
                String num =ed3.getText().toString();
                String add =ed4.getText().toString();
                String pass =ed5.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://www.digitechy.in.net/WebService1.asmx/RegisterApi?nn="+name+"&ee="+email+"&mm="+num+"&aa="+add+"&pp="+pass,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                Toast.makeText(getContext(), ""+response, Toast.LENGTH_SHORT).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

// Add the request to the RequestQueue.
                queue.add(stringRequest);
            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contatiner, new LoginFragment()).addToBackStack(null).commit();
            }
        });
        return view;
    }
}