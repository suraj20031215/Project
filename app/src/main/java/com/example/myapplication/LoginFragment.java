package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class LoginFragment extends Fragment {
    Button btn;
    TextView text1;
    EditText ed6,ed7;
    RequestQueue queue;
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        text1=view.findViewById(R.id.textView8);
        ed6=view.findViewById(R.id.email2_);
        ed7=view.findViewById(R.id.password2_);
        btn=view.findViewById(R.id.button3);
        queue = Volley.newRequestQueue(getContext());
        sharedPreferences=getContext().getSharedPreferences("Session", Context.MODE_PRIVATE);

        String name=sharedPreferences.getString("key","0");
        if (name!="0")
        {
            Intent in=new Intent(getContext(), MainActivity2.class);
            startActivity(in);

        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=ed6.getText().toString();
                String pass=ed7.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://www.digitechy.in.net/WebService1.asmx/LoginApi?ee="+email+"&pp="+pass,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONArray jsonArray =new JSONArray(response);
                                    JSONObject jsonObject=jsonArray.getJSONObject(0);
                                    String msg =jsonObject.getString("Logg");
                                    if(msg.equals("1")){

                                        SharedPreferences.Editor sh=sharedPreferences.edit();
                                        sh.putString("key",email);
                                        sh.commit();

                                      Intent in=new Intent(getContext(), MainActivity2.class);
                                      startActivity(in);
                                    }
                                    else {
                                        Toast.makeText(getContext(),"invalid input", Toast.LENGTH_SHORT).show();
                                    }

                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }
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

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contatiner,new Register_Fragment()).addToBackStack(null).commit();
            }
        });


        return  view;
    }
}
