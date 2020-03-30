package com.oraganisation.stonedstation.utilities

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object FragmentHelper {

    fun addFragmentToActivity(manager: FragmentManager, fragment: Fragment, frameId: Int) {
        val transaction = manager.beginTransaction()
        transaction.add(frameId, fragment)
        transaction.commit()
    }

    fun replaceFragmentToActivity(manager: FragmentManager, fragment: Fragment, frameId: Int) {
        val transaction = manager.beginTransaction()
        transaction.replace(frameId, fragment)
        transaction.addToBackStack(fragment::class.java.simpleName)
        transaction.commit()

    }
}