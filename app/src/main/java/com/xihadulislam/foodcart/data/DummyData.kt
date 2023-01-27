package com.xihadulislam.foodcart.data

import com.xihadulislam.foodcart.R
import com.xihadulislam.foodcart.models.PopularData

var popularList = listOf(
    PopularData(
        R.drawable.salad_pesto_pizza,
        title = "Salad Pesto Pizza",
        description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form.",
        price = 10.55,
        calori = 540.0,
        scheduleTime = 20.0,
        rate = 5.0,
        ingradients = listOf(
            R.drawable.ing1,
            R.drawable.ing2,
            R.drawable.ing3,
            R.drawable.ing4,
            R.drawable.ing5,
        )
    ),
    PopularData(
        R.drawable.primavera_pizza,
        title = "Primavera Pizza",
        description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form.",
        price = 12.55,
        calori = 440.0,
        scheduleTime = 30.0,
        rate = 4.5,
        ingradients = listOf(
            R.drawable.ing1,
            R.drawable.ing2,
            R.drawable.ing3,
            R.drawable.ing4,
            R.drawable.ing5,
        )
    ),
    PopularData(
        R.drawable.salad_pesto_pizza,
        title = "Margherita Pizza",
        description = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form.",
        price = 31.55,
        calori = 640.0,
        scheduleTime = 40.0,
        rate = 4.7,
        ingradients = listOf(
            R.drawable.ing1,
            R.drawable.ing2,
            R.drawable.ing3,
            R.drawable.ing4,
            R.drawable.ing5,
        )
    )
)