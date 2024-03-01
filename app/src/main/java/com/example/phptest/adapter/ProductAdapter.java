package com.example.phptest.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.phptest.R;
import com.example.phptest.dto.ListProductsReponseDTO;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private List<ListProductsReponseDTO.ProductReponseDTO> products;


    public ProductAdapter(List<ListProductsReponseDTO.ProductReponseDTO> products) {
        this.products = products;
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public Object getItem(int position) {
        return this.products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View _view, ViewGroup _viewgrp) {
        View view = _view;
        if (view == null){
            view = View.inflate(_viewgrp.getContext(), R.layout.lvproduct_item, null);
            ImageView img = view.findViewById(R.id.img);
            TextView productName = view.findViewById(R.id.tvname);
            TextView productPrice = view.findViewById(R.id.tvprice);

            ViewHolder holder = new ViewHolder(img, productName, productPrice);
            view.setTag(holder);
        }

        ListProductsReponseDTO.ProductReponseDTO product = this.products.get(position);
        ViewHolder holder = (ViewHolder) view.getTag();

        Glide.with(_viewgrp.getContext())
                .load(product.getImage())
                .centerCrop()
                .into(holder.img);

        holder.productName.setText(product.getName());
        holder.productPrice.setText(product.getPrice()+"");



        return view;
    }

    private  static class ViewHolder {
        final ImageView img;
        final TextView productName, productPrice;

        public ViewHolder(ImageView img, TextView productName, TextView productPrice) {
            this.img = img;
            this.productName = productName;
            this.productPrice = productPrice;
        }
    }
}
