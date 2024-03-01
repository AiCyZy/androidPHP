package com.example.phptest.dto;

import java.util.List;

//api get all
public class ListProductsReponseDTO {
    private boolean status;
    private List<ProductReponseDTO> products;
    public class ProductReponseDTO{
        private int id;
        private String name;
        private float price;
        private int quantity;
        private String image;
        private String description;
        private int category_id;
        private String category_name;

        public ProductReponseDTO() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public ProductReponseDTO(int id, String name, float price, int quantity, String image, String description, int category_id, String category_name) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.image = image;
            this.description = description;
            this.category_id = category_id;
            this.category_name = category_name;
        }
    }

    public ListProductsReponseDTO() {
    }

    public ListProductsReponseDTO(boolean status, List<ProductReponseDTO> products) {
        this.status = status;
        this.products = products;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<ProductReponseDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductReponseDTO> products) {
        this.products = products;
    }
}
