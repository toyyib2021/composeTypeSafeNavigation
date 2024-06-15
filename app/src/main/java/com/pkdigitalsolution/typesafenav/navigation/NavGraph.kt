package com.pkdigitalsolution.typesafenav.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.pkdigitalsolution.typesafenav.presenation.StudentProfile
import com.pkdigitalsolution.typesafenav.presenation.Students


@Composable
fun NavHost (navController:NavHostController) {

    NavHost(navController = navController, startDestination = Students){
        composable<Students> {
            Students(
                navToStudentProfileScreen = { studentId ->
                    navController.navigate(StudentProfile(studentId))
                }
            )
        }

        composable<StudentProfile> {

            val student = it.toRoute<StudentProfile>()

            StudentProfile(
                studentId = student.studentId,
                onCloseClick = { navController.navigateUp() }
            )

        }
    }

}

