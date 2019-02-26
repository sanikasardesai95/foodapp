package com.example.mohit.foodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b;
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://foodappsanika.herokuapp.com").addConverterFactory(GsonConverterFactory.create()).build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.button);
        e1 = findViewById(R.id.username);
        e2 = findViewById(R.id.email);
        e3 = findViewById(R.id.mobile);
        e4 = findViewById(R.id.password);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }
    void registerUser(){

        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<String> call = api.insertUser(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString());
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_LONG);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error while adding the user",Toast.LENGTH_LONG);
            }
        });
    }
}
