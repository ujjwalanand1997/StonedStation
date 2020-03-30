package com.oraganisation.stonedstation.utilities

import android.app.Activity
import android.provider.SyncStateContract
import org.json.JSONException
import org.json.JSONObject
import java.math.BigDecimal

class PaymentUtility {
    private val MICROS: BigDecimal = BigDecimal(1000000.0)

    @Throws(JSONException::class)
    private fun getBaseRequest(): JSONObject? {
        return JSONObject().put("apiVersion", 2).put("apiVersionMinor", 0)
    }

//    fun createPaymentsClient(activity: Activity?): PaymentsClient? {
//        val walletOptions: Wallet.WalletOptions =
//            Builder().setEnvironment(SyncStateContract.Constants.PAYMENTS_ENVIRONMENT).build()
//        return Wallet.getPaymentsClient(activity, walletOptions)
//    }

}