package com.pkdigitalsolution.typesafenav.navigation

import kotlinx.serialization.Serializable

// Define a home destination that doesn't take any arguments
@Serializable
object Students

// Define a profile destination that takes an ID
@Serializable
data class StudentProfile(val studentId: String)