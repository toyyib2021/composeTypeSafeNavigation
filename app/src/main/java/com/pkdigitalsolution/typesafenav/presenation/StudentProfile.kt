package com.pkdigitalsolution.typesafenav.presenation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pkdigitalsolution.typesafenav.data.repositoryImp.studentList

@Composable
fun StudentProfile(
    studentId:String,
    onCloseClick:()->Unit
    ){
    // Pass the student ID here to get the student details
    val student =  studentList.find { it.studentId == studentId }

    BackHandler {onCloseClick()}
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(modifier = Modifier.fillMaxWidth()
            .clickable { onCloseClick() },
            horizontalArrangement = Arrangement.Center) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }

        // show student UI if it's null or notnull
        if (student != null){
            // A random image appears each time this composable is drawn
            Image(painter = painterResource(id = student.pics ), contentDescription = "")
            StudentUI(student = student , onStudentClick = {})
        }
        else{
            Text(
                text = "No Student Found",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
        }

    }
}