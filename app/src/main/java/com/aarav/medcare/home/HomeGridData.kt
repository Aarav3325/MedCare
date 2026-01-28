package com.aarav.medcare.home

import androidx.navigation.compose.NavHost
import com.aarav.medcare.R
import com.aarav.medcare.navigation.NavRoute

data class ServiceItem(
    val name: String,
    val icon: Int,
    val route: String? = null
)

data class Doctor(
    val name: String,
    val image: Int,
    val type: String,
    val experience: String? = "",
    val available: String? = ""
)

data class Hospital(
    val name: String,
    val image: Int
)

data class Article(
    val title: String,
    val image: Int,
    val tag: String,
    val date: String
)
object HomeGridData {
    val serviceList = listOf(
        ServiceItem("All", R.drawable.all),
        ServiceItem("General Practitioner", R.drawable.general),
        ServiceItem("Dentistry", R.drawable.dentistry),
        ServiceItem("Gynecology", R.drawable.gynecology),
        ServiceItem("Ophthalmology", R.drawable.ophthalmology),
        ServiceItem("Neurology", R.drawable.neurology),
        ServiceItem("Otorhinolaryngology", R.drawable.ear),
        ServiceItem("Pulmonologist", R.drawable.lungs),
    )

    val serviceList2 = listOf(
        ServiceItem("Chat Doctor", R.drawable.chat_docter, NavRoute.ChatDoctor.path),
        ServiceItem("Hospitals", R.drawable.hospitals, NavRoute.HospitalList.path),
        ServiceItem("Emergency Services", R.drawable.emergency),
        ServiceItem("Article", R.drawable.article),
        ServiceItem("Medication Reminder", R.drawable.medication, NavRoute.MedicationReminder.path),
        ServiceItem("Specialization", R.drawable.specialization),
        ServiceItem("Health Shop", R.drawable.solar_cart_3_outline, NavRoute.Shopping.path)
    )

    val DoctorList = listOf(
        Doctor("Dr. Leonard Campbell", R.drawable.image71, "Heart Specialist"),
        Doctor("Dr. Gabriel Smith", R.drawable.image72, "Dentist"),
        Doctor("Dr. Leonard Campbell", R.drawable.image71, "Heart Specialist"),
    )

    val hospitalList = listOf(
        Hospital("Cipto Mangunkusumo Hospital (RSCM)", R.drawable.image75),
        Hospital("Mitra Keluarga Hospital", R.drawable.image76),
        Hospital("Mayapada", R.drawable.image77)
    )

    val articleList = listOf(
        Article("Understanding Vaccination, The Importance of Preventative Medicine", R.drawable.article1,
            "Disease Prevention",
            "14 - Jun - 2023"),
        Article("Turning Bad Habits into Healthy Habits: Tips for Living Better", R.drawable.article2,
            "Healthy Lifestyle",
            "14 - Jun - 2023"),
        Article("Turning Bad Habits into Healthy Habits: Tips for Living Better", R.drawable.article2,
            "Healthy Lifestyle",
            "14 - Jun - 2023")
    )


}

