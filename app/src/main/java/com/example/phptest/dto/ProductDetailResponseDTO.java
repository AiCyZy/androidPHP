package com.example.phptest.dto;

public class ProductDetailResponseDTO {
    private boolean status;

    private ListProductsReponseDTO.ProductReponseDTO products;

    public ProductDetailResponseDTO() {
    }

    public ProductDetailResponseDTO(boolean status, ListProductsReponseDTO.ProductReponseDTO products) {
        this.status = status;
        this.products = products;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ListProductsReponseDTO.ProductReponseDTO getProducts() {
        return products;
    }

    public void setProducts(ListProductsReponseDTO.ProductReponseDTO products) {
        this.products = products;
    }
}
