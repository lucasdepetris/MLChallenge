package com.depetris.lucas.mercadolibrechallenge.Activity;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.depetris.lucas.mercadolibrechallenge.Modelo.Product;
import com.depetris.lucas.mercadolibrechallenge.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetail extends AppCompatActivity {

    @BindView(R.id.imgProducto)
    ImageView imgProducto;

    @BindView(R.id.textStateAndQuantitySold)
    TextView textStateQuantity;
    @BindView(R.id.TitleProduct)
    TextView title;
    @BindView(R.id.Price)
    TextView price;

    @BindView(R.id.rating)
    RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Product producto = (Product) getIntent().getExtras().getParcelable("producto");
        Resources res = getApplication().getResources();
        if(producto != null && producto.getThumbnail() != null){
            Picasso.with(getApplicationContext()).load(producto.getThumbnail()).into(this.imgProducto);
        }

        this.textStateQuantity.setText(String.format(res.getString(R.string.state_quantity_sold), producto.getCondition(),producto.getSold_quantity()));
        this.title.setText(producto.getTitle());
        this.rating.setRating(producto.getInstallments().getRate());
        this.price.setText(String.format(res.getString(R.string.price), producto.getPrice()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
