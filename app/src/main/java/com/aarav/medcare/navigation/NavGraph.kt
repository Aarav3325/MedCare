package com.aarav.medcare.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aarav.medcare.SplashScreen
import com.aarav.medcare.TempScreen
import com.aarav.medcare.auth.AuthSplash
import com.aarav.medcare.auth.LoginScreen
import com.aarav.medcare.auth.OPTScreen
import com.aarav.medcare.auth.RegisterScreen
import com.aarav.medcare.auth.VerificationScreen
import com.aarav.medcare.history.HistoryScreen
import com.aarav.medcare.home.HomeScreen
import com.aarav.medcare.onboard.OnBoardScreen
import com.aarav.medcare.profile.AccountSettings
import com.aarav.medcare.profile.HealthHistory
import com.aarav.medcare.profile.NotificationScreen
import com.aarav.medcare.profile.PrescriptionHistory
import com.aarav.medcare.profile.ProfileScreen
import com.aarav.medcare.profile.TransactionScreen
import com.aarav.medcare.services.ServicesScreen
import com.aarav.medcare.services.article.ArticleDetailScreen
import com.aarav.medcare.services.article.ArticleScreen
import com.aarav.medcare.services.chatdoctor.AppointmentSuccessScreen
import com.aarav.medcare.services.chatdoctor.CallScreen
import com.aarav.medcare.services.chatdoctor.ChatDoctorScreen
import com.aarav.medcare.services.chatdoctor.ChatScreen
import com.aarav.medcare.services.chatdoctor.ConfirmationScreen
import com.aarav.medcare.services.chatdoctor.DoctorDetailScreen
import com.aarav.medcare.services.chatdoctor.VideoCallScreen
import com.aarav.medcare.services.hospital.HospitalDetailScreen
import com.aarav.medcare.services.hospital.HospitalListScreen
import com.aarav.medcare.services.hospital.HospitalMapScreen
import com.aarav.medcare.services.reminder.AddMedicine
import com.aarav.medcare.services.reminder.MedicationReminder
import com.aarav.medcare.services.reminder.MedicationReminderEmpty
import com.aarav.medcare.services.shopping.CartScreen
import com.aarav.medcare.services.shopping.FindingPharmacy
import com.aarav.medcare.services.shopping.ProductDetailScreen
import com.aarav.medcare.services.shopping.ShoppingScreen

@Composable
fun NavGraph(navHostController: NavHostController, modifier: Modifier) {
    NavHost(
        navHostController, startDestination = NavRoute.Splash.path
    ) {
        addSplashScreen(navHostController, this)
        addTempScreen(navHostController, this)
        addOnBoard(navHostController, this)
        addAuthSplash(navHostController, this)
        addRegisterScreen(navHostController, this)
        addLoginScreen(navHostController, this)
        addOTPScreen(navHostController, this)
        addVerificationScreen(navHostController, this)
        addHomeScreen(navHostController, this)
        addServiceScreen(navHostController, this)
        addChatDoctorScreen(navHostController, this)
        addDoctorDetailScreen(navHostController, this)
        addConfirmationScreen(navHostController, this)
        addAppointmentSuccessScreen(navHostController, this)
        addHistoryScreen(navHostController, this)
        addShoppingScreen(navHostController, this)
        addProductDetailScreen(navHostController, this)
        addCartScreen(navHostController, this)
        addFindingPharmacyScreen(navHostController, this)
        addHospitalListScreen(navHostController, this)
        addHospitalDetailScreen(navHostController, this)
        addHospitalMapScreen(navHostController, this)
        addMedicationReminderScreen(navHostController, this)
        addAllReminderScreen(navHostController, this)
        addAddMedicineScreen(navHostController, this)
        addArticlesScreen(navHostController, this)
        addArticleDetailScreen(navHostController, this)
        AddProfileScreen(navHostController, this)
        AddPrescriptionHistoryScreen(navHostController, this)
        AddHealthHistoryScreen(navHostController, this)
        AddTransactionsScreen(navHostController, this)
        AddAccountSettingsScreen(navHostController, this)
        AddNotificationsScreen(navHostController, this)
        addChatDoctorScreen(navHostController, this)
        AddChatScreen(navHostController, this)
        AddVideoCallScreen(navHostController, this)
        AddCallScreen(navHostController, this)
    }
}

fun addSplashScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Splash.path
    ) {
        SplashScreen(
            navigateToHome = {
                navController.navigate(NavRoute.Home.path) {
                    popUpTo(NavRoute.Splash.path) {
                        inclusive = true
                    }
                }
            },
            navigateToOnBoard = {
                navController.navigate(NavRoute.AuthSplash.path) {
                    popUpTo(NavRoute.Splash.path) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

fun addTempScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Main.path
    ) {
        TempScreen()
    }
}


fun addOnBoard(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.OnBoard.path
    ) {
        OnBoardScreen(
            navigateToRegister = {
                navController.navigate(NavRoute.Register.path) {
                    popUpTo(NavRoute.OnBoard.path) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

fun addAuthSplash(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.AuthSplash.path
    ) {
        AuthSplash(
            navigateToOnBoard = {
                navController.navigate(NavRoute.OnBoard.path) {
                    popUpTo(NavRoute.Splash.path) {
                        inclusive = true
                    }
                }
            },
            navigateToRegister = {
                navController.navigate(NavRoute.Register.path) {
                    popUpTo(NavRoute.Splash.path) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

fun addRegisterScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Register.path
    ) {
        RegisterScreen(
            onRegisterClick = {
                navController.navigate(NavRoute.OTP.path)
            },
            navigateToLogin = {
                navController.navigate(NavRoute.Login.path)
            },
            back = {
                navController.navigateUp()
            }
        )
    }
}

fun addLoginScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Login.path
    ) {
        LoginScreen(
            onLoginClick = {
                navController.navigate(NavRoute.OTP.path)
            },
            navigateToRegister = {
                navController.navigate(NavRoute.Login.path)
            },
            back = {
                navController.navigateUp()
            }
        )
    }
}


fun addOTPScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.OTP.path
    ) {
        OPTScreen(
            onContinueClick = {
                navController.navigate(NavRoute.Verification.path)
            },
            back = {
                navController.navigateUp()
            }
        )
    }
}


fun addVerificationScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Verification.path
    ) {
        VerificationScreen(
            navigateToHome = {
                navController.navigate(NavRoute.Home.path) {
                    popUpTo(NavRoute.AuthSplash.path) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

fun addHomeScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Home.path
    ) {
        HomeScreen(navController)
    }
}

fun addServiceScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Services.path
    ) {
        ServicesScreen(navController)
    }
}

fun addChatDoctorScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.ChatDoctor.path
    ) {
        ChatDoctorScreen(
            back = {
                navController.popBackStack()
            },
            navController
        )
    }
}

fun addDoctorDetailScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.DoctorDetail.path
    ) {
        DoctorDetailScreen(
            back = {
                navController.popBackStack()
            },
            navigateToConfirmation = {
                navController.navigate(NavRoute.Confirmation.path)
            },
            navigateToChat = {
                navController.navigate(NavRoute.Chat.path)
            }
        )
    }
}


fun addConfirmationScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Confirmation.path
    ) {
        ConfirmationScreen(
            back = {
                navController.popBackStack()
            },
            navigateToSuccess = {
                navController.navigate(NavRoute.AppointmentSuccess.path) {
                    popUpTo(NavRoute.Services.path) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

fun addAppointmentSuccessScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.AppointmentSuccess.path
    ) {
        AppointmentSuccessScreen(
            back = {
                navController.popBackStack()
            }
        )
    }
}

fun addHistoryScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.History.path
    ) {
        HistoryScreen(
            back = {
                navController.popBackStack()
            }
        )
    }
}


fun addShoppingScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Shopping.path
    ) {
        ShoppingScreen(
            navigateToCart = {
                navController.navigate(NavRoute.Cart.path)
            },
            navigateToDetail = {
                navController.navigate(NavRoute.ProductDetail.path)
            },
            back = {
                navController.popBackStack()
            }
        )
    }
}

fun addProductDetailScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.ProductDetail.path
    ) {
        ProductDetailScreen(
            back = {
                navController.popBackStack()
            }
        )
    }
}

fun addCartScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Cart.path
    ) {
        CartScreen(
            back = {
                navController.popBackStack()
            },
            onContinueClick = {
                navController.navigate(NavRoute.FindingPharmacy.path) {
                    popUpTo(NavRoute.Cart.path) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

fun addFindingPharmacyScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.FindingPharmacy.path
    ) {
        FindingPharmacy()
    }
}

fun addHospitalListScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.HospitalList.path
    ) {
        HospitalListScreen(
            back = {
                navController.popBackStack()
            },
            navigateToDetail = {
                navController.navigate(NavRoute.HospitalDetail.path)
            },
            navigateToMap = {
                navController.navigate(NavRoute.HospitalMap.path)
            }
        )
    }
}


fun addHospitalDetailScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.HospitalDetail.path
    ) {
        HospitalDetailScreen(
            back = {
                navController.popBackStack()
            },
            navigateToMap = {
                navController.navigate(NavRoute.HospitalMap.path)
            }
        )
    }
}


fun addHospitalMapScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.HospitalMap.path
    ) {
        HospitalMapScreen()
    }
}

fun addMedicationReminderScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.MedicationReminder.path
    ) {
        MedicationReminder(
            back = {
                navController.popBackStack()
            },
            navigateToAll = {
                navController.navigate(NavRoute.AllReminders.path)
            },
            navigateToAddMedicine = {
                navController.navigate(NavRoute.AddMedicine.path)
            }
        )
    }
}

fun addAllReminderScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.AllReminders.path
    ) {
        MedicationReminderEmpty(
            back = {
                navController.popBackStack()
            },
            navigateToAddMedicine = {
                navController.navigate(NavRoute.AddMedicine.path)
            }
        )
    }
}

fun addAddMedicineScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.AddMedicine.path
    ) {
        AddMedicine(
            back = {
                navController.popBackStack()
            },
            navigateToAllReminders = {
                navController.navigate(NavRoute.AllReminders.path) {
                    popUpTo(NavRoute.AddMedicine.path) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

fun addArticlesScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Articles.path
    ) {
        ArticleScreen(
            back = {
                navController.popBackStack()
            },
            navigateToDetail = {
                navController.navigate(NavRoute.ArticleDetail.path)
            }
        )
    }
}


fun addArticleDetailScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.ArticleDetail.path
    ) {
        ArticleDetailScreen(
            back = {
                navController.popBackStack()
            }
        )
    }
}

fun AddProfileScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Profile.path
    ) {
        ProfileScreen(
            back = {
                navController.popBackStack()
            },
            navController
        )
    }
}

fun AddPrescriptionHistoryScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.PrescriptionHistory.path
    ) {
        PrescriptionHistory(
            back = {
                navController.popBackStack()
            }
        )
    }
}

fun AddHealthHistoryScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.HealthHistory.path
    ) {
        HealthHistory(
            back = {
                navController.popBackStack()
            }
        )
    }
}

fun AddTransactionsScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Transactions.path
    ) {
        TransactionScreen(
            back = {
                navController.popBackStack()
            }
        )
    }
}

fun AddAccountSettingsScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.AccountSettings.path
    ) {
        AccountSettings(
            back = {
                navController.popBackStack()
            }
        )
    }
}

fun AddNotificationsScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Notifications.path
    ) {
        NotificationScreen(
            back = {
                navController.popBackStack()
            }
        )
    }
}

fun AddChatScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Chat.path
    ) {
        ChatScreen(
            back = {
                navController.popBackStack()
            },
            navigateToVideoCall = {
                navController.navigate(NavRoute.VideoCall.path)
            },
            navigateToCall = {
                navController.navigate(NavRoute.Call.path)
            }
        )
    }
}

fun AddVideoCallScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.VideoCall.path
    ) {
        VideoCallScreen()
    }
}

fun AddCallScreen(navController: NavController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Call.path
    ) {
        CallScreen(
            back = {
                navController.popBackStack()
            }
        )
    }
}