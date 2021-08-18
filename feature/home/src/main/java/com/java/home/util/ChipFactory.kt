package com.java.home.util

import android.view.LayoutInflater
import com.google.android.material.chip.Chip
import com.java.home.R

object ChipFactory {
    fun create(layoutInflater: LayoutInflater): Chip =
        layoutInflater.inflate(R.layout.layout_chip_choice, null, false) as Chip
}
