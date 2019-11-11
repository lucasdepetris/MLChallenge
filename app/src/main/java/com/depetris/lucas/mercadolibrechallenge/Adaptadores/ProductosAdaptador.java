package com.depetris.lucas.mercadolibrechallenge.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.depetris.lucas.mercadolibrechallenge.Activity.ProductDetail;
import com.depetris.lucas.mercadolibrechallenge.Modelo.Product;
import com.depetris.lucas.mercadolibrechallenge.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductosAdaptador extends RecyclerView.Adapter<ProductosAdaptador.ViewHolder> {
    private List<Product> productos;
    private Context context;
    public ProductosAdaptador(List<Product> productos) {
        this.productos = productos;
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_producto, null);
        return new ProductosAdaptador.ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(ProductosAdaptador.ViewHolder holder, final int position) {
        final Product producto = this.productos.get(position);

        Resources res = context.getResources();
        Picasso.with(holder.imgProducto.getContext()).load(producto.getThumbnail()).into(holder.imgProducto);
        holder.precioProducto.setText(String.format(res.getString(R.string.price), producto.getPrice()));
        holder.title.setText(producto.getTitle());
        holder.condition.setText(String.format(res.getString(R.string.state_product), producto.getCondition()));
        holder.MP.setText(String.format(res.getString(R.string.accept_mp), producto.isAccepts_mercadopago() ? "si" : "no"));
        holder.seller_status.setText(String.format(res.getString(R.string.seller_status), producto.getSeller().getPower_seller_status() != null ? producto.getSeller().getPower_seller_status() : ""));
        holder.contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetail.class);
                intent.setFlags(intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("producto",producto);
                context.startActivity(intent);

            }
        });
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private final View item;

        @BindView(R.id.imgProducto)
        ImageView imgProducto;
        @BindView(R.id.precioProducto)
        TextView precioProducto;
        @BindView(R.id.TitleProduct)
        TextView title;
        @BindView(R.id.condition)
        TextView condition;
        @BindView(R.id.acceptMP)
        TextView MP;
        @BindView(R.id.seller_status)
        TextView seller_status;

        @BindView(R.id.cont_buscarProductos)RelativeLayout contenedor;
        public ViewHolder(View itemView) {
            super(itemView);
            this.item = itemView;
            context = itemView.getContext();
            ButterKnife.bind(this, itemView);
        }
    }
}
