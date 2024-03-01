package com.example.phptest.helper;

import com.example.phptest.dto.ListProductsReponseDTO;
import com.example.phptest.dto.LoginRequestDTO;
import com.example.phptest.dto.LoginResponseDTO;
import com.example.phptest.dto.ProductDetailResponseDTO;
import com.example.phptest.dto.RegisterRequestDTO;
import com.example.phptest.dto.RegisterResponseDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Iretrofic {
    @POST("/api/register.php")
    Call<RegisterResponseDTO> register(@Body RegisterRequestDTO body);

    @POST("/api/login.php")
    Call<LoginResponseDTO> login(@Body LoginRequestDTO body);

    @GET("/api/get_all_products.php")
    Call<ListProductsReponseDTO> getAllProducts();

    @GET("/api/get_by_id.php")
    Call<ProductDetailResponseDTO> getProductById(@Query("id") int id);
}
