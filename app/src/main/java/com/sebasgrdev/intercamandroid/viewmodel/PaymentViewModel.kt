package com.sebasgrdev.intercamandroid.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.sebasgrdev.intercamandroid.model.data.Payment
import kotlinx.coroutines.launch
import java.io.IOException
import kotlin.collections.addAll

class PaymentViewModel(application: Application) : AndroidViewModel(application) {
    private val _paymentList = mutableStateListOf<Payment>()
    val paymentList: List<Payment> = _paymentList

    init {
        viewModelScope.launch {
            loadOperationTypes()
        }
    }

    private suspend fun loadOperationTypes() {
        val jsonString = readJsonFromAssets(getApplication(), "operation_type.json")
        if (jsonString != null) {
            try {
                val payment = Gson().fromJson(jsonString, Array<Payment>::class.java)
                _paymentList.addAll(payment)
            } catch (e: JsonSyntaxException) {
                Log.e("Json", "Error al parsear los datos")
            }
        } else {
            Log.e("Json", "Error al leer los archivos")
        }
    }

    private fun readJsonFromAssets(context: Context, fileName: String): String? {
        return try {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            Log.e("Error", "Error reading JSON file", e)
            null
        }
    }
}