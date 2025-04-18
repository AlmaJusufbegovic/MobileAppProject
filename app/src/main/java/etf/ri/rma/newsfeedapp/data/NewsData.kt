package etf.ri.rma.newsfeedapp.data

import etf.ri.rma.newsfeedapp.model.NewsItem

object NewsData {
    fun getAllNews(): List<NewsItem> {
        return listOf(
            NewsItem(
                id = "1",
                title = "Ukraine and US forge new economic partnership for reconstruction",
                snippet = "On Friday, Ukraine and the United States signed a memorandum of intent.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Obrazovanje",
                category = "Politika",
                isFeatured = true,
                source = "Daily Wrap",
                publishedDate = "2025-04-17"
            ),
            NewsItem(
                id = "2",
                title = "Lazio Star Warns Tottenham Of ‘Problems’ Against Bodo/Glimt",
                snippet = "Tottenham Hotspur have been warned that they will have ‘problems’ playing Bodo/Glimt away in the semi-final of the Europa League.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Sport",
                category = "Sport",
                isFeatured = false,
                source = "Inside Futbol",
                publishedDate = "2025-04-16"
            ),
            NewsItem(
                id = "3",
                title = "GPT-4.5 nears human mimicry, passing the Turing test at 73%",
                snippet = "Does GPT chat think in a similar way to us? ",
                imageUrl = "https://via.placeholder.com/800x400.png?text=AI+Model",
                category = "Nauka/tehnologija",
                isFeatured = true,
                source = "Daily Wrap",
                publishedDate = "2025-04-15"
            ),
            NewsItem(
                id = "4",
                title = "Cutting ties with China would be very foolish, says Reeves",
                snippet = "Rachel Reeves has said it would be “very foolish” for Britain to disengage with China, in a rejection of Donald Trump’s efforts to isolate Beijing..",
                imageUrl = null,
                category = "Politika",
                isFeatured = false,
                source = "The Telegraph",
                publishedDate = "2025-04-14"
            ),
            NewsItem(
                id = "5",
                title = "Hue new? Scientists claim to have found colour no one has seen before",
                snippet = "Their description of the colour is not too arresting – the five people who have seen it call it blue-green – but that, they say, does not fully capture the richness of the experience.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=NASA",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "The Guardian",
                publishedDate = "2025-04-13"
            ),
            NewsItem(
                id = "6",
                title = "The top 10 greatest coaches in Real Madrid's history",
                snippet = "The football community is paying tribute to Leo Beenhakker",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = true,
                source = "Sports Unlimited News",
                publishedDate = "2025-03-1"
            ),
            NewsItem(
                id = "7",
                title = "2025 Saudi Arabian Grand Prix – Free Practice 1 F1 results (Jeddah)",
                snippet = "UDrivers headed out for the first practice session of the Saudi Arabian Grand Prix weekend with Pierre Gasly topping the times in Jeddah.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = false,
                source = "Planet f1",
                publishedDate = "2025-03-12"
            ),
            NewsItem(
                id = "8",
                title = "Politics home and after haven't deterred investors from South Africa",
                snippet = "Investors have flocked to South Africa's domestic bond markets, betting the country can stay the course on reforms despite ...",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = true,
                source = "Reuters",
                publishedDate = "2025-02-16"
            ),
            NewsItem(
                id = "9",
                title = "Inside the Kremlin college",
                snippet = "Where diplomats learn to deceive the West",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "The Telegraph",
                publishedDate = "2025-04-10"
            ),
            NewsItem(
                id = "10",
                title = "Will trade war between USA and China escalate into actual war",
                snippet = "The trade war between the USA and China is unlikely to escalate into an actual war.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = true,
                source = "RBC Ukraine",
                publishedDate = "2025-04-15"
            ),
            NewsItem(
                id = "11",
                title = "Arsenal v Lyon: five key factors in the Women’s Champions League semi",
                snippet = "The former Arsenal manager Joe Montemurro, who left the club at the end of the 2020-21 season, returns to the Emirates Stadium when Arsenal... ",
                imageUrl = null,
                category = "Sport",
                isFeatured = false,
                source = "SportCC",
                publishedDate = "2025-04-05"
            ),
            NewsItem(
                id = "12",
                title = "Cricket-Jacks repays Mumbai's faith with all-round show in IPL win",
                snippet = "I knew I was going to play a role, they've got three left-handers in the top order and we knew that the wicket was going to have a little bit of assistance",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = false,
                source = "Reuters",
                publishedDate = "2025-03-28"
            ),
            NewsItem(
                id = "13",
                title = "World Politics",
                snippet = "The 17-year-old has been taken into custody more than two weeks after the alleged murder.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = false,
                source = "The Telegraph",
                publishedDate = "2025-04-17"
            ),
            NewsItem(
                id = "14",
                title = "Scientists now say MILLIONS of planets could be teeming with life",
                snippet = "Planet K2-18b is very unlikely to be a one-off in the vast universe",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "BBC",
                publishedDate = "2025-01-24"
            ),
            NewsItem(
                id = "15",
                title = "Premier League break FA Cup final fixture promise",
                snippet = "The Premier League has been forced to break a Football Association pledge to stop any top-tier matches being played on the eve of the men’s FA Cup final.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = false,
                source = "The Telegraph",
                publishedDate = "2025-04-02"
            ),
            NewsItem(
                id = "16",
                title = "Donald Trump studying if he can sack Fed chief, says White House",
                snippet = "Donald Trump is assessing whether he can sack the head of the Federal Reserve, the White House has said.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = false,
                source = "The Telegraph",
                publishedDate = "2025-02-28"
            ),
            NewsItem(
                id = "17",
                title = "Postecoglou hails Spurs’ belief after Solanke sets up Bodø/Glimt semi-final",
                snippet = "Ange Postecoglou insisted he never lost faith in his Tottenham players as they progressed to the semi-finals of the Europa League and feels there is growing belief that they can lift the trophy next month.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = true,
                source = "The Guardian",
                publishedDate = "2025-04-08"
            ),
            NewsItem(
                id = "18",
                title = "Is South Korea’s political turmoil being underwritten by Beijing?",
                snippet = "With South Korea now set to hold presidential elections within the next two months following the ousting of President Yoon Suk Yeol...",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = true,
                source = "BBC",
                publishedDate = "2025-04-06"
            ),
            NewsItem(
                id = "19",
                title = "Scientists create the world's largest lab-grown chicken nugget",
                snippet = "The piece of lab-grown meat had an artificial circulatory system of hollow fibers delivering nutrients and oxygen.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "Science Daily",
                publishedDate = "2025-03-10"
            ),
            NewsItem(
                id = "20",
                title = "Scientists stumble across rare evidence that Earth is peeling underneath the Sierra Nevada",
                snippet = "Scientists found new evidence that Earth’s crust is peeling underneath the Sierra Nevada in California.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "Independent",
                publishedDate = "2025-02-26"
            ),
            NewsItem(
                id = "21",
                title = "Myanmar's fatal quake deepens political turmoil with no path to peace",
                snippet = "Armed Conflict Location and Event Data (ACLED), which monitors global conflicts, ranked Myanmar as the world's second-most ...",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = false,
                source = "Hosted",
                publishedDate = "2025-04-01"
            ),
            NewsItem(
                id = "22",
                title = "BJP now the world's largest political party: VD Sharma",
                snippet = "...said that the tireless efforts of crores of party workers have made the BJP the largest political party in the world.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = false,
                source = "Pioneer ",
                publishedDate = "2025-04-04"
            ),
            NewsItem(
                id = "23",
                title = "Controversy around the dire wolf 'de-extinctions'",
                snippet = "...brought back dire wolves (Aenocyon dirus) from extinction after more than 10,000 years.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "Live Science on MSN",
                publishedDate = "2025-03-22"
            ),
            NewsItem(
                id = "24",
                title = "In Kerala politics, Satheesan's shoes are issue, not Trump or tariffs",
                snippet = "The politics in Kerala operate in a different universe",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = false,
                source = "Gulf News",
                publishedDate = "2025-04-02"
            ),
            NewsItem(
                id = "25",
                title = "US now 'most dysfunctional and unfree political system' in industrialized world: expert",
                snippet = "Political scientist Ian Bremmer says that President Donald Trump has quickly made the United States into...",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = true,
                source = "Raw Story",
                publishedDate = "2025-04-09"
            ),
            NewsItem(
                id = "26",
                title = "Max Verstappen 'offered biggest contract in F1 history' to leave Red Bull for rival",
                snippet = "Max Verstappen is said to be mulling over a mega-money contract offer from Aston Martin as the reigning world champion considers his future with Red Bull.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = false,
                source = "Mirror",
                publishedDate = "2025-04-16"
            ),
            NewsItem(
                id = "27",
                title = "Victor Montagliani: Travel bans nor politics will impact World Cup 2026 ... maybe",
                snippet = "Controversy has dogged the FIFA Men’s World Cup for decades.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = true,
                source = "Province on MSN",
                publishedDate = "2025-04-07"
            ),
            NewsItem(
                id = "28",
                title = "Scientists from Japan, UK race to fight drug resistance",
                snippet = "What happens if the world's antibiotics stop working?",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "NHK",
                publishedDate = "2025-01-09"
            ),
            NewsItem(
                id = "29",
                title = "Party like it’s 1999",
                snippet = "Amorim uses treble as ‘inspiration’ for crazy Lyon comeback",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = true,
                source = "The Telegraph",
                publishedDate = "2025-04-15"
            ),
            NewsItem(
                id = "30",
                title = "Trump, Putin and better world politics?",
                snippet = "During World War II, Russia (then part of the Soviet Union ... ",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = false,
                source = "Daily",
                publishedDate = "2025-02-12"
            ),
            NewsItem(
                id = "31",
                title = "The oldest football clubs in history",
                snippet = "A trip down memory lane",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = false,
                source = "SportCC",
                publishedDate = "2025-02-11"
            ),
            NewsItem(
                id = "32",
                title = "'One club men'",
                snippet = "The 20 most loyal players in football history",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = false,
                source = "SportCC",
                publishedDate = "2025-01-30"
            ),
            NewsItem(
                id = "33",
                title = "The 25 Best Strikers in World Football Right Now",
                snippet = "Ranked from Lowest to Highest",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = false,
                source = "Lente Desportiva",
                publishedDate = "2025-03-02"
            ),
            NewsItem(
                id = "34",
                title = "Environmental Science News",
                snippet = " Scientists use small peptides to enhance symbiosis between plants and fungi",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "Science Daily",
                publishedDate = "2025-01-23"
            ),
            NewsItem(
                id = "35",
                title = "Scientists reveal advance in brain research once thought impossible",
                snippet = "From a cubic millimeter of tissue, scientists constructed a precise, 3D map of the activity in a mouse’s brain, detailing ...",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "CNN",
                publishedDate = "2025-01-31"
            )
        )
    }
}
