package com.depetris.lucas.mercadolibrechallenge;

import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.depetris.lucas.mercadolibrechallenge.Adaptadores.ProductosAdaptador;
import com.depetris.lucas.mercadolibrechallenge.Modelo.BusquedaResponse;
import com.depetris.lucas.mercadolibrechallenge.Service.HttpService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.searchViewProduct)
    SearchView buscador;

    @BindView(R.id.msgError)
    TextView msgError;

    @BindView(R.id.ReciclerProductos)
    RecyclerView recyclerView;

    private BusquedaResponse resp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if(savedInstanceState != null){
            this.resp = savedInstanceState.getParcelable("response");
            if(this.resp != null && !resp.getResults().isEmpty()){
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                ProductosAdaptador adapter = new ProductosAdaptador(resp.getResults());
                recyclerView.setAdapter(adapter);
            }
        }
        buscador.setIconifiedByDefault(false);
        buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                buscarProd(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable("response",resp);
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }

    public void buscarProd(String nombre) {
        findViewById(R.id.msgError).setVisibility(View.GONE);
        findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
        HttpService.getInstance().BuscarProducto(nombre, new HttpService.CustomCallListener<BusquedaResponse>() {
            @Override
            public void getResult(BusquedaResponse response) {
                resp = response;
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);

                if(response != null &&!response.getResults().isEmpty()){
                    ProductosAdaptador adapter = new ProductosAdaptador(response.getResults());
                    recyclerView.setAdapter(adapter);
                    findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                }else{
                    Resources res = getApplicationContext().getResources();
                    msgError.setText(response != null && response.getResults().isEmpty() ? res.getString(R.string.msg_error) : res.getString(R.string.msg_error_server));
                    findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                    findViewById(R.id.msgError).setVisibility(View.VISIBLE);
                }
            }
            });
        };
}

