package etf.ri.rma.newsfeedapp.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import etf.ri.rma.newsfeedapp.data.NewsData
import etf.ri.rma.newsfeedapp.model.NewsItem
import coil.compose.AsyncImage
import etf.ri.rma.newsfeedapp.navigation.LocalNavController
import java.text.SimpleDateFormat
import java.util.Locale
import kotlinx.coroutines.flow.collectLatest

@Composable
fun NewsFeedScreen() {
    val navController = LocalNavController.current
    val allNewsItems = remember { NewsData.getAllNews() }

    var selectedCategory by remember { mutableStateOf("All") }
    var dateRange by remember { mutableStateOf<Pair<String?, String?>?>(null) }
    var unwantedWords by remember { mutableStateOf<List<String>>(emptyList()) }
    var selectedSource by remember { mutableStateOf("") }

    val categoryFilteredItems = when (selectedCategory) {
        "Politika" -> allNewsItems.filter { it.category == "Politika" }
        "Sport" -> allNewsItems.filter { it.category == "Sport" }
        "Nauka/tehnologija" -> allNewsItems.filter { it.category == "Nauka/tehnologija" }
        else -> allNewsItems
    }

    val dateFilteredItems = dateRange?.let { range ->
        val (startStr, endStr) = range
        if (startStr != null && endStr != null) {
            val format = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val start = format.parse(startStr)
            val end = format.parse(endStr)
            categoryFilteredItems.filter {
                val pubDate = format.parse(it.publishedDate)
                pubDate != null && pubDate >= start && pubDate <= end
            }
        } else categoryFilteredItems
    } ?: categoryFilteredItems

    val unwantedFilteredItems = if (unwantedWords.isNotEmpty()) {
        dateFilteredItems.filter { item ->
            unwantedWords.none { word ->
                item.title.contains(word, ignoreCase = true) ||
                        item.snippet.contains(word, ignoreCase = true)
            }
        }
    } else dateFilteredItems

    val finalItems = when (selectedSource) {
        "Izvor A-Z" -> unwantedFilteredItems.sortedBy { it.source }
        "Izvor Z-A" -> unwantedFilteredItems.sortedByDescending { it.source }
        else -> unwantedFilteredItems
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        FilterSection(selectedCategory) { selectedCategory = it }

        Spacer(modifier = Modifier.height(8.dp))

        if (finalItems.isEmpty()) {
            MessageCard("Nema vijesti za ovu kategoriju.")
        } else {
            NewsList(finalItems)
        }
    }

    LaunchedEffect(Unit) {
        navController.currentBackStackEntryFlow.collectLatest { entry ->
            val handle = entry.savedStateHandle

            if (handle.contains("filters_applied")) {
                selectedCategory = handle.get<String>("filter_category") ?: "All"

                val dateStr = handle.get<String>("filter_daterange")
                dateRange = dateStr?.split(";")?.let {
                    if (it.size == 2) Pair(it[0], it[1]) else null
                }

                val wordsStr = handle.get<String>("filter_unwanted")
                unwantedWords = wordsStr?.split(";")?.filter { it.isNotBlank() } ?: emptyList()

                selectedSource = handle.get<String>("filter_source") ?: ""

                handle.remove<String>("filters_applied")
            }
        }
    }
}

@Composable
fun FilterSection(selected: String, onCategorySelected: (String) -> Unit) {
    val categories = listOf("All", "Politika", "Sport", "Nauka/tehnologija")
    val tags = mapOf(
        "All" to "filter_chip_all",
        "Politika" to "filter_chip_pol",
        "Sport" to "filter_chip_spo",
        "Nauka/tehnologija" to "filter_chip_sci"
    )
    val navController = LocalNavController.current

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            categories.forEach { category ->
                FilterChip(
                    selected = selected == category,
                    onClick = { onCategorySelected(category) },
                    label = { Text(category) },
                    modifier = Modifier.testTag(tags[category] ?: "")
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { navController.currentBackStackEntry?.savedStateHandle?.set("selected_category", selected)
                navController.navigate("filters") },
            modifier = Modifier
                .testTag("filter_chip_more")
                .align(Alignment.Start)
        ) {
            Text("Više filtera...")
        }
    }
}

@Composable
fun NewsList(newsItems: List<NewsItem>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("news_list"),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(top = 8.dp)
    ) {
        items(newsItems, key = { it.id }) { item ->
            if (item.isFeatured) {
                FeaturedNewsCard(item)
            } else {
                StandardNewsCard(item)
            }
        }
    }
}

@Composable
fun StandardNewsCard(item: NewsItem) {
    val navController = LocalNavController.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp).clickable {
                navController.navigate("details/${item.id}")
            },
        elevation = CardDefaults.cardElevation(2.dp)

    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = item.imageUrl,
                contentDescription = "standard image",
                modifier = Modifier
                    .size(80.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = item.title,
                    //modifier = Modifier.testTag("news_title_${item.id}"),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = item.snippet,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = item.source,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
                Text(
                    text = item.publishedDate,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )

            }
        }
    }
}

@Composable
fun FeaturedNewsCard(item: NewsItem) {
    val navController = LocalNavController.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable {
                navController.navigate("details/${item.id}")
            },
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = item.imageUrl,
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = item.title,
                //modifier = Modifier.testTag("news_title_${item.id}"),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = item.snippet,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${item.source} • ${item.publishedDate}",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}


@Composable
fun MessageCard(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = message, style = MaterialTheme.typography.bodyLarge)
    }
}
