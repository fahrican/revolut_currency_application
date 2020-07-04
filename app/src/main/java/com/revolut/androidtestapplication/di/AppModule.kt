package com.revolut.androidtestapplication.di

import com.revolut.androidtestapplication.data.network.RevolutCurrencyApi
import com.revolut.androidtestapplication.data.network.RevolutCurrencyService
import com.revolut.androidtestapplication.model.Currency
import com.revolut.androidtestapplication.repository.CurrencyRepository
import com.revolut.androidtestapplication.ui.adapter.CurrencyAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object AppModule {

    @Singleton
    @Provides
    fun provideApi(): RevolutCurrencyApi = RevolutCurrencyService.getClient()

    @Provides
    fun provideRepository() = CurrencyRepository()

    @Provides
    fun provideCurrencies() = ArrayList<Currency>()

    @Provides
    fun provideAdapter(currencies: ArrayList<Currency>) = CurrencyAdapter(currencies)

}