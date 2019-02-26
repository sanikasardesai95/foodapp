package com.example.mohit.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Button b;
    Intent i;
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://foodappsanika.herokuapp.com").addConverterFactory(GsonConverterFactory.create()).build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b= findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginuser();
            }
        });

    }
    public void loginuser(){
        LoginAPI api = retrofit.create(LoginAPI.class);
        Call<String> call = api.loginUser(e1.getText().toString(),e2.getText().toString());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.body()!=null){

                    i = new Intent(Login.this,Dashboard.class);
                    startActivity(i);
                }
                else
                {
                    i = new Intent(Login.this,MainActivity.class);
                    startActivity(i);
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(Login.this,"Unable to login invalid credentials",Toast.LENGTH_LONG);
            }
        });
    }
}
