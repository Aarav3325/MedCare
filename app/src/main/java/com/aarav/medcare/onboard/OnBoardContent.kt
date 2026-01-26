package com.aarav.medcare.onboard

import com.aarav.medcare.R

data class OnBoardingPage(val title: String, val description: String, val imageRes: Int)


object OnBoardContent {
    val pages = listOf(
        OnBoardingPage(
            "Online Consultation",
            "Connect with healthcare professionals virtually for convenient medical advice and support.",
            R.drawable.onboard1
        ),
        OnBoardingPage(
            "24 Hours Ready to Serve",
            "Instant access to expert medical assistance. Get the care you need, when you need it, with our app.",
            R.drawable.onboard2
        ),
        OnBoardingPage(
            "Medical Record Data Patient",
            " Easily manage and access comprehensive health records, including medical history, test results, and treatment plans, all in one secure place.",
            R.drawable.onboard3
        )
    )
}