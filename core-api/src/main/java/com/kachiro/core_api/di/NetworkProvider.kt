package com.kachiro.core_api.di

import retrofit2.Retrofit

interface NetworkProvider {

    fun provideRetrofit(): Retrofit
}