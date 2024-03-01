package com.example.phptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.phptest.dto.ListProductsReponseDTO;
import com.example.phptest.dto.ProductDetailResponseDTO;
import com.example.phptest.helper.Iretrofic;
import com.example.phptest.helper.RetroficHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailProductActivity extends AppCompatActivity {

    int product_id = -1;

    Iretrofic iretrofic;
    List<ListProductsReponseDTO.ProductReponseDTO> list;

    TextView tvname, tvprice, tvdescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        tvname = findViewById(R.id.tvname);
        tvprice = findViewById(R.id.tvprice);
        tvdescription = findViewById(R.id.tvdescription);

        iretrofic = RetroficHelper.createService(Iretrofic.class);

        Intent intent = getIntent();
        product_id = intent.getIntExtra("productId", -1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //goi api laays product theo id
        iretrofic.getProductById(product_id).enqueue(getCallback);
    }

    Callback<ProductDetailResponseDTO> getCallback = new Callback<ProductDetailResponseDTO>() {
        @Override
        public void onResponse(Call<ProductDetailResponseDTO> call, Response<ProductDetailResponseDTO> response) {
            if (response.isSuccessful()){
                ProductDetailResponseDTO productResponse = response.body();

                if (productResponse.isStatus() == true){
                    ListProductsReponseDTO.ProductReponseDTO product = productResponse.getProducts();
                    Log.d(">>>>>>>>>>>>>", "onResponse: "+product);
                    tvname.setText(product.getName());
                    tvprice.setText(product.getPrice() + "");
                    tvdescription.setText(product.getDescription());
                }




            }
        }

        @Override
        public void onFailure(Call<ProductDetailResponseDTO> call, Throwable t) {
            Log.d(">>> login", "onFailure: " + t.getMessage());
        }
    };
}