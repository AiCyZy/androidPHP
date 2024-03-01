package com.example.phptest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.phptest.adapter.ProductAdapter;
import com.example.phptest.dto.ListProductsReponseDTO;
import com.example.phptest.dto.LoginResponseDTO;
import com.example.phptest.helper.Iretrofic;
import com.example.phptest.helper.RetroficHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {

    ListView lv;
    ProductAdapter adapter;
    List<ListProductsReponseDTO.ProductReponseDTO> list;
    Iretrofic iretrofic;

    AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        iretrofic = RetroficHelper.createService(Iretrofic.class);
        lv = findViewById(R.id.lvProduct);
        list = new ArrayList<>();
        adapter = new ProductAdapter(list);
        lv.setAdapter(adapter);

        alert = new AlertDialog.Builder(this);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListProductsReponseDTO.ProductReponseDTO product =
                        (ListProductsReponseDTO.ProductReponseDTO)
                        parent.getItemAtPosition(position);

                int product_id = product.getId();

                Intent intent = new Intent(ProductsActivity.this, DetailProductActivity.class);
                intent.putExtra("productId", product_id);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        iretrofic.getAllProducts().enqueue(getCallback);
    }

    Callback<ListProductsReponseDTO> getCallback = new Callback<ListProductsReponseDTO>() {
        @Override
        public void onResponse(Call<ListProductsReponseDTO> call, Response<ListProductsReponseDTO> response) {
            if (response.isSuccessful()){
                ListProductsReponseDTO lvResponse = response.body();
                list.clear();
                list.addAll(lvResponse.getProducts());
                adapter.notifyDataSetChanged();

            }
        }

        @Override
        public void onFailure(Call<ListProductsReponseDTO> call, Throwable t) {
            Log.d(">>> login", "onFailure: " + t.getMessage());
        }
    };
}