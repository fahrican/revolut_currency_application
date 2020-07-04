package com.revolut.androidtestapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.revolut.androidtestapplication.R
import com.revolut.androidtestapplication.databinding.ItemCurrencyBinding
import com.revolut.androidtestapplication.model.Currency
import kotlin.collections.ArrayList


class CurrencyAdapter(
    val currencies: ArrayList<Currency>
) : RecyclerView.Adapter<CurrencyViewHolder>() {


    lateinit var adapterContext: Context

    override fun getItemCount() = currencies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        adapterContext = parent.context
        val itemCurrencyBinding: ItemCurrencyBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_currency,
            parent,
            false
        )
        return CurrencyViewHolder(itemCurrencyBinding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.itemCurrencyBinding.currency = currencies[position]
        holder.itemCurrencyBinding.currencyCard.setOnClickListener {
            Toast.makeText(adapterContext, "Taped on currency", Toast.LENGTH_SHORT).show()
        }
    }

    fun setUpCurrencies(newCurrencies: List<Currency>) {
        currencies.clear()
        currencies.addAll(newCurrencies)
        notifyDataSetChanged()
    }
}


class CurrencyViewHolder(val itemCurrencyBinding: ItemCurrencyBinding) :
    RecyclerView.ViewHolder(itemCurrencyBinding.root)