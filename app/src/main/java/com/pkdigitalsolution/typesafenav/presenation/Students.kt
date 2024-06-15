package com.pkdigitalsolution.typesafenav.presenation

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pkdigitalsolution.typesafenav.data.model.StudentData
import com.pkdigitalsolution.typesafenav.data.repositoryImp.studentList

@Composable
fun Students(
    navToStudentProfileScreen:(String)->Unit
){
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(studentList, key = {it.studentId}){ student ->
            StudentUI(student, navToStudentProfileScreen)

        }
    }
}




@Composable
fun StudentUI(
    student: StudentData,
    onStudentClick: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxSize()
            .padding(5.dp)
        .border(2.dp, Color.Black,RoundedCornerShape(10.dp),)) {
        Column(
            modifier = Modifier.weight(3f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(vertical = 5.dp),
                text = student.studentId,
                style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold
            )
        }
        Column(modifier = Modifier
            .weight(7f)
            .padding(5.dp)
            .clickable {
                onStudentClick(student.studentId)
            }
        ) {
            Text(
                text = student.studentName,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )
            Text(
                text = student.studentClass,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


