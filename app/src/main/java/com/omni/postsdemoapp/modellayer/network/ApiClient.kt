package com.omni.postsdemoapp.modellayer.network


import com.omni.postsdemoapp.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory




object ServiceGenerator {

    private val httpClient = OkHttpClient.Builder()

    private val builder = Retrofit.Builder()
            .baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //NOTE: Jon Bott - Add this line for RxRetrofit

    fun <S> createService(serviceClass: Class<S>): S {
        return createService(serviceClass, null)
    }

    private fun <S> createService(serviceClass: Class<S>, authToken: String?): S {
        if (authToken != null) {
            addRequestHeaders(authToken)
        }

        val client = httpClient.build()
        val retrofit = builder.client(client).build()
        return retrofit.create(serviceClass)
    }

    private fun addRequestHeaders(authToken: String?) {
        httpClient.interceptors().add(Interceptor { chain ->
            val original = chain.request()

            // Request customization: add request headers
            val requestBuilder = original.newBuilder().header("Authorization", authToken).method(original.method(), original.body())

            val request = requestBuilder.build()
            chain.proceed(request)
        })
    }

}
