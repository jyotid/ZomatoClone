package com.jetpackcompose.core.di


import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@dagger.Module
class NetworkModule {

    @Singleton
    @dagger.Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://developers.zomato.com/api/v2.1/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Singleton
    @dagger.Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor {
                val request: Request = it.request()
                    .newBuilder()
                    .addHeader("user-key", "")
                    .build()
                it.proceed(request)
            }
            .build()
    }
}
