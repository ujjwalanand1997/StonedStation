package com.oraganisation.stonedstation.utilities

import android.util.Patterns
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Matcher
import java.util.regex.Pattern


object Validations {

    /*
    one small case, one capital case, one digit and no spaces
    6 digit length
     */
       fun isPasswordValid(str: String = ""): Boolean {
        if (str.isBlank() || str.length < 6)
            return false;
        val regex =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$"
        val patternMatcher = (Pattern.compile(regex)).matcher(str)
        return patternMatcher.matches()
    }

    fun isValidEmail(str: String): Boolean {
        val regex = "^[\\w+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$"
        val pattern: Pattern = Pattern.compile(regex)
        val matcher: Matcher = pattern.matcher(str)
        return str != "" && matcher.matches()
    }

}