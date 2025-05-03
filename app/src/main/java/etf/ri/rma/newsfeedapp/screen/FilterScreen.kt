package etf.ri.rma.newsfeedapp.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import etf.ri.rma.newsfeedapp.navigation.LocalNavController
import java.text.SimpleDateFormat
import java.util.*
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.rememberDateRangePickerState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterScreen(
    initialCategory: String = "All",
    onApplyFilters: (String, String?, String?, String?) -> Unit = { _, _, _, _ -> }
) {
    val navController = LocalNavController.current
    val context = LocalContext.current

    var selectedCategory by remember { mutableStateOf(initialCategory) }

    LaunchedEffect(Unit) {
        val savedCategory = navController
            .previousBackStackEntry
            ?.savedStateHandle
            ?.get<String>("selected_category")
        if (savedCategory != null) {
            selectedCategory = savedCategory
        }
    }
    var selectedSource by remember { mutableStateOf("") }

    var dateRange by remember { mutableStateOf<Pair<String?, String?>?>(null) }
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDateRangePickerState()

    var inputWord by remember { mutableStateOf("") }
    var unwantedWords by remember { mutableStateOf(listOf<String>()) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        // Kategorije Chipovi
        val categories = listOf("All", "Politika", "Sport", "Nauka/tehnologija")
        val tags = mapOf(
            "All" to "filter_chip_all",
            "Politika" to "filter_chip_pol",
            "Sport" to "filter_chip_spo",
            "Nauka/tehnologija" to "filter_chip_sci"
        )
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            categories.forEach { category ->
                FilterChip(
                    selected = selectedCategory == category,
                    onClick = { selectedCategory = category },
                    label = { Text(category) },
                    modifier = Modifier.testTag(tags[category] ?: "")
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = dateRange?.let { "${it.first};${it.second}" } ?: "Odaberite datum...",
            modifier = Modifier.testTag("filter_daterange_display")
        )
        Button(
            onClick = { showDatePicker = true },
            modifier = Modifier.testTag("filter_daterange_button")
        ) {
            Text("Odaberi datum")
        }

        if (showDatePicker) {
            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(onClick = {
                        val startDateMillis = datePickerState.selectedStartDateMillis
                        val endDateMillis = datePickerState.selectedEndDateMillis

                        if (startDateMillis != null && endDateMillis != null) {
                            val format = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                            val start = format.format(Date(startDateMillis))
                            val end = format.format(Date(endDateMillis))
                            dateRange = Pair(start, end)
                        }

                        showDatePicker = false
                    }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDatePicker = false }) {
                        Text("Otkaži")
                    }
                }
            ) {
                DateRangePicker(state = datePickerState)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Sortiraj po izvoru", style = MaterialTheme.typography.titleMedium)

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(top = 8.dp)
        ) {
            FilterChip(
                selected = selectedSource == "Izvor A-Z",
                onClick = { selectedSource = "Izvor A-Z" },
                label = { Text("Izvor A-Z") },
                modifier = Modifier.testTag("sort_chip_source_asc")
            )

            FilterChip(
                selected = selectedSource == "Izvor Z-A",
                onClick = { selectedSource = "Izvor Z-A" },
                label = { Text("Izvor Z-A") },
                modifier = Modifier.testTag("sort_chip_source_desc")
            )
        }


        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            TextField(
                value = inputWord,
                onValueChange = { inputWord = it },
                label = { Text("Neželjena riječ") },
                modifier = Modifier
                    .weight(1f)
                    .testTag("filter_unwanted_input")
            )
            Button(
                onClick = {
                    val wordLower = inputWord.lowercase()
                    if (wordLower.isNotBlank() &&
                        wordLower !in unwantedWords.map { it.lowercase() }) {
                        unwantedWords = unwantedWords + inputWord
                        inputWord = ""
                    } else {
                        Toast.makeText(context, "Riječ je već dodana ili prazna.", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.testTag("filter_unwanted_add_button")
            ) {
                Text("Dodaj")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(modifier = Modifier.testTag("filter_unwanted_list")) {
            items(unwantedWords) {
                Text(text = it)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                onApplyFilters(
                    selectedCategory,
                    dateRange?.let { "${it.first};${it.second}" },
                    unwantedWords.joinToString(";"),
                    selectedSource
                )

                navController.previousBackStackEntry?.savedStateHandle?.apply {
                    set("filters_applied", "true")
                    set("filter_category", selectedCategory)
                    set("filter_daterange", dateRange?.let { "${it.first};${it.second}" })
                    set("filter_unwanted", unwantedWords.joinToString(";"))
                    set("filter_source", selectedSource)
                }
                navController.popBackStack()

            },
            modifier = Modifier
                .fillMaxWidth()
                .testTag("filter_apply_button")
        ) {
            Text("Primijeni filtere")
        }
    }
}

