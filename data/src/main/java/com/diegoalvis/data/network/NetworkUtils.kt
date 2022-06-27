package com.diegoalvis.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRetrofit(
    baseUrl: String,
    converterFactory: Converter.Factory = GsonConverterFactory.create(GsonBuilder().serializeNulls().create())
): Retrofit {
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    return Retrofit.Builder()
        .addConverterFactory(converterFactory)
        .client(OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        )
        .baseUrl(baseUrl)
        .build()
}


//
//https://api.foursquare.com/v2/venues/search?ll=41.385040,2.176724&client_id=SFTEX4E45MNUAZXMABQOF4NVEBEIOYKE53ZNMIP40RX2S4CK&client_secret=5AGNN0IDYHURCDITIZX1PAGMFHEO4O0I4VEBLPKMJEPTQPH4&v=20190717

//https://api.foursquare.com/v2/venues/search?ll=SFTEX4E45MNUAZXMABQOF4NVEBEIOYKE53ZNMIP40RX2S4CK&client_id=5AGNN0IDYHURCDITIZX1PAGMFHEO4O0I4VEBLPKMJEPTQPH4&client_secret=41.3850371%2C2.1767156&v=20190717