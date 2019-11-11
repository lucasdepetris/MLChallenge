package com.depetris.lucas.mercadolibrechallenge.Service;

import com.depetris.lucas.mercadolibrechallenge.Modelo.BusquedaResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiMercadolibre {
    @Headers("Content-Type: application/json")
    //API DE ELLO
    @GET("search")
    Call<BusquedaResponse> searchProduct(@Query("q") String query);
    //@GET("productos")
   // Call<ProductosApi> BuscarProductosC(@Query ("string") String buscar , @Query("lat") double latitud, @Query("lng") double longitud, @Query("limit") int limit);
}

