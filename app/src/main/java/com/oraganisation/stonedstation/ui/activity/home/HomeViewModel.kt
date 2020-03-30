package com.oraganisation.stonedstation.ui.activity.home

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    public val mText:ObservableField<String> = ObservableField()

}