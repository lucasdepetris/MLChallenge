package com.depetris.lucas.mercadolibrechallenge.Service;

import android.util.Log;

import com.depetris.lucas.mercadolibrechallenge.Modelo.BusquedaResponse;

import retrofit2.Call;
import retrofit2.Callback;

public class HttpService {
    private static HttpService instance = null;
    private String TAG = "HttpServPice";
    private String GENERIC_ERROR_MSG = "No se pudo conectar con el servidor";
    private String PARSE_JSON_ERROR = "No se pudo procesar la respuesta del servidor";


    private HttpService() {
    }

    public static HttpService getInstance() {
        if (instance == null) {
            instance = new HttpService();
        }
        return instance;
    }

    public interface CustomCallListener<T> {
        public void getResult(T object);
    }

    public void BuscarProducto(String query, final CustomCallListener<BusquedaResponse> listener) {
        Call<BusquedaResponse> requestProductos;

        requestProductos = Api.getInstance().getApiService().searchProduct(query);
        requestProductos.enqueue(new Callback<BusquedaResponse>() {
            @Override
            public void onResponse(Call<BusquedaResponse> call, retrofit2.Response<BusquedaResponse> response) {
                if (response.body() != null) {
                    listener.getResult(response.body());
                }else{
                    listener.getResult(null);
                }
            }

            @Override
            public void onFailure(Call<BusquedaResponse> call, Throwable t) {
                String TAG = null;
                Log.e(TAG, "Error:" + t.getCause());
                listener.getResult(null);
            }

        });
    }


}
