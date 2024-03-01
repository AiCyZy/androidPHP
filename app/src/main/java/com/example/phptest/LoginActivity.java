package com.example.phptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.phptest.dto.LoginRequestDTO;
import com.example.phptest.dto.LoginResponseDTO;
import com.example.phptest.dto.RegisterRequestDTO;
import com.example.phptest.dto.RegisterResponseDTO;
import com.example.phptest.helper.Iretrofic;
import com.example.phptest.helper.RetroficHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText edtemail1, edtpass;
    Button btnlogin, btnregis;

    Iretrofic iretrofic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtemail1 = findViewById(R.id.edtemail1);
        edtpass = findViewById(R.id.edtpass);

        btnlogin = findViewById(R.id.btnlogin);
        btnregis = findViewById(R.id.btnregis);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtemail1.getText().toString();
                String pass = edtpass.getText().toString();

                iretrofic = RetroficHelper.createService(Iretrofic.class);
                LoginRequestDTO requestDTO = new LoginRequestDTO(email, pass);
                iretrofic.login(requestDTO).enqueue(login);
            }
        });

        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Register.class);
                startActivity(intent);
                finish();
            }
        });

    }

    Callback<LoginResponseDTO> login = new Callback<LoginResponseDTO>() {
        @Override
        public void onResponse(Call<LoginResponseDTO> call, Response<LoginResponseDTO> response) {
            if (response.isSuccessful()){
                LoginResponseDTO loginResponse = response.body();
                if (loginResponse.isStatus()){
                    Intent intent = new Intent(LoginActivity.this, ProductsActivity.class);
                    startActivity(intent);
                    finish();
                    //thành công, sang home
                    Toast.makeText(LoginActivity.this, "Thành công sang home", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Không thành công sang home", Toast.LENGTH_SHORT).show();
                }

            }
        }

        @Override
        public void onFailure(Call<LoginResponseDTO> call, Throwable t) {
            Log.d(">>> login", "onFailure: " + t.getMessage());
        }
    };

}