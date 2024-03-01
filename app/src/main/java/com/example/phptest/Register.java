package com.example.phptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.phptest.dto.RegisterRequestDTO;
import com.example.phptest.dto.RegisterResponseDTO;
import com.example.phptest.helper.Iretrofic;
import com.example.phptest.helper.RetroficHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    EditText edtname, edtpass1, edtemail;
    Button btn, btnlogin;

    Iretrofic iretrofic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtemail = findViewById(R.id.edtemail);
        edtpass1 = findViewById(R.id.edtpass1);
        edtname = findViewById(R.id.edtname);

        btn = findViewById(R.id.btnlogin);
        btnlogin = findViewById(R.id.btnl);

        iretrofic = RetroficHelper.createService(Iretrofic.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtemail.getText().toString();
                String pass = edtpass1.getText().toString();
                String name = edtname.getText().toString();
                //bắt lỗi

                iretrofic = RetroficHelper.createService(Iretrofic.class);
                RegisterRequestDTO requestDTO = new RegisterRequestDTO(email, pass, name);
                iretrofic.register(requestDTO).enqueue(register);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    Callback<RegisterResponseDTO> register = new Callback<RegisterResponseDTO>() {
        @Override
        public void onResponse(Call<RegisterResponseDTO> call, Response<RegisterResponseDTO> response) {
            if (response.isSuccessful()){
                RegisterResponseDTO registerResponse = response.body();
                if (registerResponse != null && registerResponse.isStatus()){
                    //thành công, sang login
                    Toast.makeText(Register.this, "Thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(Register.this, "Không thành công", Toast.LENGTH_SHORT).show();
                }

            }
        }

        @Override
        public void onFailure(Call<RegisterResponseDTO> call, Throwable t) {
            Log.d(">>> login", "onFailure: " + t.getMessage());
        }
    };

}