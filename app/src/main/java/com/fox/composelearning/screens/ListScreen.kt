package com.fox.composelearning.screens

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.os.Parcelable
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.core.os.postDelayed
import androidx.navigation.NavController
import com.fox.composelearning.navigation.navigate
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Word(val value: String): Parcelable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavController, context: Context) {
    val testList = listOf(
        Word("Hello"),
        Word("AVR programming on C"),
        Word("Compose is amazing!"),
        Word("Subscribe on my social groups!"),
        Word("Interesting"),
        Word("Как жить то дальше"),
        Word("Хеллоу мазафака :D"),
        Word("Hello"),
        Word("AVR programming on C"),
        Word("Compose is amazing!"),
        Word("Subscribe on my social groups!"),
        Word("Interesting"),
        Word("Интрестинг хе хе"),
        Word("Я анимешник :D")
    )

    Scaffold {
        LazyColumn {
            testList.map {item {
                Text(
                    text = it.value,
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("details", bundleOf("WORD_KEY" to it))
                        }
                )
            }}
        }
    }
}