package com.java.core.util

import androidx.fragment.app.Fragment

fun Fragment.stringListFrom(id: Int): List<String> = requireContext().resources.getStringArray(id).toList()