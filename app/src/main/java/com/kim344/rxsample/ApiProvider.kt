package com.kim344.rxsample

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun provideMyApi() : MyApi
        = Retrofit.Builder()
    .baseUrl("https://api.stackexchange.com/2.2/")
    .client(provideOkHttpClient(provideLoggingInterceptor()))
    .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(MyApi::class.java)


// 네트워크 통신에 사용할 클라이언트 객체를 생성합니다.
private fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
    val builder = OkHttpClient.Builder()
    return builder.build()
}

// 네트워크 요청/응답을 로그에 표시하는 Interceptor 객체를 생성합니다
private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
        Log.e("Retrofit : ", message)
    })
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    return interceptor
}