package com.oraganisation.stonedstation.ui.activity.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.oraganisation.stonedstation.R
import com.oraganisation.stonedstation.databinding.ActivityHomeBinding
import java.util.stream.Stream


class HomeActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityHomeBinding
    private lateinit var mViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        mViewModel = HomeViewModel(application)
        mBinding.homeViewModel = mViewModel

        mViewModel.mText.set("Hello bhai")

        val GOOGLE_PAY_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user"
        val GOOGLE_PAY_REQUEST_CODE = 123

        val uri: Uri = Uri.Builder()
            .scheme("upi")
            .authority("pay")
            .appendQueryParameter("pa", "ujjwalanand1997@okicici")
            .appendQueryParameter("pn", "Ujjwal Anand")
            .appendQueryParameter("mc", "1234")
            .appendQueryParameter("tr", "123456789")
            .appendQueryParameter("tn", "your-transaction-note")
            .appendQueryParameter("am", "20")
            .appendQueryParameter("cu", "INR")
            .appendQueryParameter("url", "your-transaction-url")
            .build()
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = uri
        intent.setPackage(GOOGLE_PAY_PACKAGE_NAME)
        startActivityForResult(intent, GOOGLE_PAY_REQUEST_CODE)

    }
}
