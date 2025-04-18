package etf.ri.rma.newsfeedapp.screen

import androidx.compose.foundation.background
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

@Composable
fun NewsFeedScreen() {
    val newsItems = remember { NewsData.getAllNews() }
    var selectedCategory by remember { mutableStateOf("All") }

    var selectedSource by remember { mutableStateOf("") }

    val categoryFilteredItems = when (selectedCategory) {
        "Politika" -> newsItems.filter { it.category == "Politika" }
        "Sport" -> newsItems.filter { it.category == "Sport" }
        "Nauka/tehnologija" -> newsItems.filter { it.category == "Nauka/tehnologija" }
        else -> newsItems
    }

    val finalItems = when (selectedSource) {
        "Izvor A-Z" -> categoryFilteredItems.sortedBy { it.source }
        "Izvor Z-A" -> categoryFilteredItems.sortedByDescending { it.source }
        else -> categoryFilteredItems
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        FilterSection(selectedCategory) { selectedCategory = it }
        Spacer(modifier = Modifier.height(8.dp))
        FilterSectionSource(selectedSource) { selectedSource = it }
        Spacer(modifier = Modifier.height(8.dp))

        if (finalItems.isEmpty()) {
            MessageCard("Nema vijesti za ovu kategoriju.")
        } else {
            NewsList(finalItems)
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

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        categories.forEach { category ->
            FilterChip(
                selected = selected == category,
                onClick = { if (selected != category) onCategorySelected(category) },
                label = { Text(category) },
                modifier = Modifier.testTag(tags[category] ?: "")
            )
        }
    }
}

@Composable
fun FilterSectionSource(selected: String, onCategorySelected: (String) -> Unit) {
    val categories = listOf("Izvor A-Z", "Izvor Z-A")
    val tags = mapOf(
        "Izvor A-Z" to "sort_chip_source_asc",
        "Izvor Z-A" to "sort_chip_source_desc"
    )

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        categories.forEach { category ->
            val isSelected = selected == category
            FilterChip(
                selected = isSelected,
                onClick = {
                    if (isSelected) {
                        onCategorySelected("") // klik na isti chip -> deaktivacija
                    } else {
                        onCategorySelected(category)
                    }
                },
                label = { Text(category) },
                modifier = Modifier.testTag(tags[category] ?: "")
            )
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
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
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
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
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
