package com.aarav.medcare.profile

import com.aarav.medcare.R
import com.aarav.medcare.navigation.NavRoute

data class ProfileSettings(
    val icon: Int,
    val label: String,
    val description: String? = null,
    val path: String? = null
)

data class Prescription(
    val doctorName: String,
    val medicineInfo: List<Pair<String, String>>,
    val date: String
)

data class Notification(
    val icon: Int,
    val title: String,
    val description: String
)

data class HealthHistory(
    val tag: String,
    val prescription: String,
    val title: String,
    val description: String? = null
)

data class Transaction(
    val date: String,
    val month: String,
    val paidTo: String,
    val isPaid: Boolean,
    val amount: Double
)

object ProfileData {
    val menuGroup = listOf(
        ProfileSettings(
            R.drawable.book,
            "Prescription History",
            "Check out the full prescription history here",
            NavRoute.PrescriptionHistory.path
        ),
        ProfileSettings(
            R.drawable.heart_profile,
            "Health History",
            "Check details regarding your medical history",
            NavRoute.HealthHistory.path
        ),
        ProfileSettings(
            R.drawable.transaction,
            "Transactions",
            "Look back at your previous transactions",
            NavRoute.Transactions.path
        )
    )

    val generalInfoGroup = listOf(
        ProfileSettings(
            R.drawable.settings,
            "Account Settings",
            path = NavRoute.AccountSettings.path
        ),
        ProfileSettings(
            R.drawable.notification,
            "Notifications",
            path = NavRoute.Notifications.path
        ),
        ProfileSettings(
            R.drawable.reference,
            "Reference Settings"
        )
    )

    val medicineInfo = listOf(
        Pair(
            "Paracetamol 500 mg",
            "Take 1 tablet every 6 hours as needed to reduce fever or pain."
        ),
        Pair(
            "Amoxicillin 500 mg",
            "Take 1 tablet every 8 hours for 7 days to treat bacterial infection."
        ),
        Pair(
            "Omeprazole 20 mg",
            "Take 1 tablet every morning before eating to reduce stomach acid production."
        ),
    )

    val prescriptions = listOf(
        Prescription(
            "Dr. Emily Smith, MD",
            medicineInfo,
            "12 June 2024 - 20 June 2024"
        ),
        Prescription(
            "Dr. Emily Smith, MD",
            medicineInfo,
            "12 June 2024 - 20 June 2024"
        ),
    )

    val healthHistoryList = listOf(
        HealthHistory(
            "Disease History",
            "Type 2 Diabetes",
            "Diagnosis : January 10, 2022"
        ),
        HealthHistory(
            "Disease History",
            "Hypertension",
            "Diagnosis : January 10, 2022"
        ),
        HealthHistory(
            "Allergy History",
            "Allergy to Legumes",
            "Severity : Severe, Precautions",
            "Avoid foods containing nuts"
        ),
    )

    val transactionList = listOf(
        Transaction(
            "13",
            "May",
            "GP Consultation with Dr. Emily Smith",
            true,
            20.00
        ),
        Transaction(
            "28",
            "Mar",
            "GP Consultation with Dr. Emily Smith",
            true,
            50.00
        ),
        Transaction(
            "05",
            "May",
            "GP Consultation with Dr. Emily Smith",
            true,
            20.00
        )
    )

    val notificationList = listOf(
        Notification(
            R.drawable.alert,
            "Doctor Appointment Reminder",
            "Hi [User's Name], this is a reminder for your consultation appointment with Dr. [Doctor's Name] tomorrow at 10:00 AM. Please make sure you arrive on time"
        ),
        Notification(
            R.drawable.alert,
            "New Medical Record Notification",
            "Hello [User's Name], you have a new medical record added to your profile. Please check for the latest information about your health condition."
        ),
        Notification(
            R.drawable.hand,
            "Medication Pickup Reminder",
        "Good morning [User's Name], don't forget to pick up your daily dose of medication, Paracetamol 500mg, today. Make sure you take it as directed by your doctor."
        )
    )
}