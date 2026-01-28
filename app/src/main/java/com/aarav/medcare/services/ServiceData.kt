package com.aarav.medcare.services

import com.aarav.medcare.R
import com.aarav.medcare.home.Doctor

data class Review(
    val name: String,
    val image: Int,
    val relativeTime: String,
    val rating: Float,
    val review: String
)

data class RoomType(
    val type: String,
    val supporting: String? = null,
    val beds: Int,
    val remaining: Int,
    val price: String
)

data class Appointment(
    val doctorImage: Int,
    val doctorName: String,
    val speciality: String,
    val dateAndTime: String,
    val location: String,
    val isCompleted: Boolean
)

data class Product(
    val productImage: Int,
    val productName: String,
    val supporting: String,
    val price: Double
)


data class HospitalInfo(
    val image: Int,
    val name: String,
    val address: String,
    val telephone: String
)


data class BrandDetails(
    val logo: Int
)

object ServiceData {
    val doctorList = listOf(
        Doctor(
            "Dr. Luca Rossi",
            R.drawable.doctor1,
            "Cardiology Specialist",
            "3 Years",
            "Available on Wed - Sat"
        ),
        Doctor(
            "Dr. Marco Ferrari",
            R.drawable.doctor2,
            "Orthopedics Specialist",
            "3 Years",
            "Available on Wed - Sat"
        ),
        Doctor(
            "Dr. Sofia Müller",
            R.drawable.doctor3,
            "Dermatology Specialist",
            "6 Years",
            "Available on Wed - Sat"
        ),
        Doctor(
            "Dr. Rajesh Patel",
            R.drawable.doctor4,
            "General Surgery",
            "2 Years",
            "Available on Wed - Sat"
        ),
        Doctor(
            "Dr. Leonard Campbell",
            R.drawable.image71,
            "Heart Specialist",
            "4 Years",
            "Available on Wed - Sat"
        ),
        Doctor(
            "Dr. Gabriel Smith",
            R.drawable.image72,
            "Dentist",
            "3 Years",
            "Available on Wed - Sat"
        ),
        Doctor(
            "Dr. Leonard Campbell",
            R.drawable.image71,
            "Heart Specialist",
            "4 Years",
            "Available on Wed - Sat"
        ),
    )

    val timings = listOf(
        "9:00 AM",
        "10:00 AM",
        "1:00 PM",
        "2:00 PM",
        "3:00 PM",
        "4:00 PM",
    )

    val schedule = listOf(
        Pair("Wed", "22"),
        Pair("Thu", "23"),
        Pair("Fri", "24"),
        Pair("Sat", "25"),
        Pair("Sun", "26"),
        Pair("Mon", "27"),
        Pair("Tue", "28"),
    )

    val reviewList = listOf(
        Review(
            "Emily Johnson",
            R.drawable.review1,
            "1 day ago",
            4F,
            "My consultation with Dr. Luca Rossi was excellent. He's knowledgeable, attentive, and provided great advice. The consultation helped me a lot and I would definitely recommend this doctor to others."
        ),
        Review(
            "Daniel Anderson",
            R.drawable.review2,
            "8 day ago",
            4F,
            "My consultation with Dr. Luca Rossi was excellent. He's knowledgeable, attentive, and provided great advice. The consultation helped me a lot and I would definitely recommend this doctor to others."
        )
    )

    val appointmentList = listOf(
        Appointment(
            R.drawable.doctor6,
            "Dr. Giovanni Bianchi",
            "General Surgery",
            "Wednesday, 29 Feb 04.00 pm",
            "Bella Vista Surgery Clinic, Via Garibaldi 10, Milan, Italy",
            true
        ),
        Appointment(
            R.drawable.doctor7,
            "Dr. Luca Rossi",
            "Cardiology Specialist",
            "Wednesday, 29 Feb 04.00 pm",
            "Bella Vista Surgery Clinic, Via Garibaldi 10, Milan, Italy",
            true
        ),

        Appointment(
            R.drawable.doctor6,
            "Dr. Giovanni Bianchi",
            "General Surgery",
            "Wednesday, 29 Feb 04.00 pm",
            "Bella Vista Surgery Clinic, Via Garibaldi 10, Milan, Italy",
            false
        ),
        Appointment(
            R.drawable.doctor7,
            "Dr. Luca Rossi",
            "Cardiology Specialist",
            "Wednesday, 22 Feb 1.00 pm",
            "Rossi Cardiology Clinic" +
                    "Via Garibaldi 15, Milan, Italy",
            false
        )
    )

    val brandStore = listOf(
        BrandDetails(R.drawable.brand1),
        BrandDetails(R.drawable.brand2),
        BrandDetails(R.drawable.brand3),
    )

    val productList = listOf(
        Product(
            R.drawable.product_image1,
            "Promag 10 Tablets",
            "Per strip",
            2.00
        ),
        Product(
            R.drawable.product_image2,
            "STRIP NEURODEX 10 TABLET",
            "Per strip",
            2.00
        ),
        Product(
            R.drawable.product_image2,
            "STRIP NEURODEX 10 TABLET",
            "Per strip",
            2.00
        ),
        Product(
            R.drawable.product_image4,
            "Bufect Strip of 4 Tablets -Heat and Pain Relief Medicine",
            "Per strip",
            2.00
        )
    )

    val hospitalInfoList = listOf(
        HospitalInfo(
            R.drawable.hospital1,
            "Ospedale San Raffaele",
            "Via Olgettina, 60, 20132 Milano MI, Italy",
            "(+22) 2361 6257 1726"
        ),
        HospitalInfo(
            R.drawable.hospital2,
            "Ospedale San Raffaele",
            "Via Olgettina, 60, 20132 Milano MI, Italy",
            "(+22) 2361 6257 1726"
        ),
        HospitalInfo(
            R.drawable.hospital3,
            "IRCCS Istituto Ortopedico Galeazzi",
            "Via Riccardo Galeazzi, 4, 20161 Milano MI, Italy",
            "(+22) 2361 6257 1726"
        ),
        HospitalInfo(
            R.drawable.hospital1,
            "Ospedale San Raffaele",
            "Via Olgettina, 60, 20132 Milano MI, Italy",
            "(+22) 2361 6257 1726"
        ),
    )

    val roomType = listOf(
        RoomType(
            "General Ward",
            supporting = "(4 persons per room)",
            beds = 120,
            remaining = 10,
            price = "$100-$150"
        ),
        RoomType(
            "Semi-Private Rooms",
            supporting = "(2 persons per room)",
            beds = 80,
            remaining = 30,
            price = "$170-$210  "
        ),
        RoomType(
            "Private Rooms",
            beds = 40,
            remaining = 20,
            price = "$350-$450"
        ),
        RoomType(
            "Deluxe Suites",
            beds = 12,
            remaining = 0,
            price = "$600-$1000"
        )
    )
}