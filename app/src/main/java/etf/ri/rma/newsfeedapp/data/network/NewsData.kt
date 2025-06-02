package etf.ri.rma.newsfeedapp.data.network

import etf.ri.rma.newsfeedapp.model.NewsItem
import java.util.UUID

object StaticNewsData {
    val predefinedNews = listOf(
        NewsItem(
            uuid = "1bb1b44a-f400-4750-99ef-6dbf3e596a3f",
            title = "Ukraine and US forge new economic partnership for reconstruction",
            snippet = "On Friday, Ukraine and the United States signed a memorandum of intent.",
            imageUrl =  "https://media-cldnry.s-nbcnews.com/image/upload/t_nbcnews-fp-1200-630,f_auto,q_auto:best/rockcms/2025-06/250602-Ukraine-defence-RS-d4fb77.jpg",
            category = "general",
            isFeatured = true,
            source = "nbcnews.com",
            publishedDate = "17-04-2025",
            imageTags = arrayListOf()
        ),
        NewsItem(
            uuid ="d060294c-f5c8-420e-8ee3-6e5916dabe23",
            title = "Trevor McEuen, accused murderer on Texas’ Top 10 most wanted list, arrested after month-long manhunt",
            snippet = "Teagan Kavan strikes out Emma Clarke to secure a berth for Texas in the championship series of the Women's College World Series. (0:27)\n\nOpen Extended Reactions...",
            imageUrl = "https://a4.espncdn.com/combiner/i?img=/photo/2025/0602/r1501573_1296x729_16-9.jpg",
            category = "sports",
            isFeatured = false,
            source = "nypost.com",
            publishedDate = "14-04-2025",
            imageTags = arrayListOf()
        ),
        NewsItem(
            uuid = "179548dc-8ebc-4ed5-b156-32fd57873940",
            title =  "Democratic Sen. Schiff again asks White House officials to disclose financial transactions",
            snippet =  "Democratic Sen. Adam Schiff in a letter to White House chief of staff Susie Wiles sent Monday, repeated his calls for the White House to issue a full disclosure...",
            imageUrl = "https://i.abcnewsfe.com/a/41c2c783-5576-4317-95cc-9fd5751b1b61/adam-schiff-rt-jef-250410_1744295330268_hpMain_16x9.jpg?w=1600",
            category = "general",
            isFeatured = true,
            source = "abcnews.go.com",
            publishedDate = "22-03-2025",
            imageTags = arrayListOf()
        ),
        NewsItem(
            uuid =  "4ea01ce4-ae2f-408c-8d56-d4f18cf2d8b5",
            title = "Rivian wants to make EV charging faster, smarter, and easier",
            snippet = "is transportation editor with 10+ years of experience who covers EVs, public transportation, and aviation. His work has appeared in The New York Daily News and ...",
            imageUrl = "https://platform.theverge.com/wp-content/uploads/sites/2/chorus/uploads/chorus_asset/file/25480112/Exterior_Hero_Shot.jpg?quality=90&strip=all&crop=0%2C19.406298631238%2C100%2C61.187402737524&w=1200",
            category = "tech",
            isFeatured = false,
            source = "theverge.com",
            publishedDate = "05-04-2025",
            imageTags = arrayListOf()
        ),
        NewsItem(
            uuid = "3c0b69c5-dfab-4fc1-b9a4-ede287bd2046",
            title = "Cannabis Stock Gainers And Losers From June 2, 2025 - Body and Mind (OTC:BMMJ), Australis Capital (OTC:AUSAF)",
            snippet =  "© 2025 Benzinga.com. Benzinga does not provide investment advice. All rights reserved.\n\nBenzinga Rankings give you vital metrics on any stock – anytime.\n\nThi...",
            imageUrl = "https://www.benzinga.com/next-assets/images/schema-image-default.png",
            category = "business",
            isFeatured = false,
            source = "benzinga.com",
            publishedDate = "12-03-2025",
            imageTags = arrayListOf()
        ),
        NewsItem(
            uuid = "df44ff81-b476-4cdf-a621-492c5948757a",
            title = "Russia banned from ice hockey in 2026 Olympics",
            snippet = "The IOC has ruled to extend sanctions imposed on Russian and Belarusian teams\n\nThe International Olympic Committee (IOC) has made the decision to ban Russian ic...",
            imageUrl = "https://mf.b37mrtl.ru/files/2025.06/article/683df93620302721600192c6.jpg",
            category = "general",
            isFeatured = true,
            source =  "rt.com",
            publishedDate = "17-02-2025",
            imageTags = arrayListOf()
        ),
        NewsItem(
            uuid = "57573f86-fec0-4bee-9138-4b0cd1f3753b",
            title = "Supreme Court allows AR-15 ban in this state",
            snippet = "The justices rejected an appeal from gun rights advocates.\n\nSupreme Court allows AR-15 ban in this state\n\nAR-15 rifles are displayed at an exhibition booth duri...",
            imageUrl = "https://i.abcnewsfe.com/a/dcfa9e57-a116-40ce-aca8-a238bb0137c6/AR-15-1-rt-gmh-250602_1748892669442_hpMain_16x9.jpg?w=1600",
            category = "general",
            isFeatured = false,
            source = "abcnews.go.com",
            publishedDate = "17-01-2025",
            imageTags = arrayListOf()
        ),
        NewsItem(
            uuid = "548d2ef9-5a6b-4b3b-bd55-596006444af6",
            title = "UFC's Tom Aspinall tired of waiting for 'retired' Jon Jones",
            snippet =  "Open Extended Reactions\n\nAs far as interim UFC heavyweight champion Tom Aspinall is concerned, Jon Jones is officially retired.\n\nAspinall (15-3), appearing on E...",
            imageUrl = "https://a3.espncdn.com/combiner/i?img=/photo/2024/0723/r1362254_1296x729_16-9.jpg",
            category = "sports",
            isFeatured = true,
            source = "espn.com",
            publishedDate = "11-04-2025",
            imageTags = arrayListOf()
        ),
        NewsItem(
            uuid = "c9a23881-12dd-4005-8982-7b6552a2eb50",
            title = "Tesla To Join S&P 500 With Full Market Cap On December 21",
            snippet = "Tesla (NASDAQ: TSLA) will be added to the S&P 500 index all ...",
            imageUrl = "https://d32r1sh890xpii.cloudfront.net/news/718x300/2020-12-01_xwjdajwctl.jpg",
            category = "business",
            isFeatured = false,
            source = "oilprice.com",
            publishedDate = "15-04-2025",
            imageTags = arrayListOf()
        ),
        NewsItem(
            uuid = "fb7d276f-0570-4fd2-809c-7de347f11a9c",
            title = "Hue new? Scientists claim to have found colour no one has seen before",
            snippet = "Total\n\nFree shipping over $200 in the U.S.\n\nInternational rates at checkout. We're proud to offer a discount to Military, Nurses, and First Responders.",
            imageUrl = "https://uncrate.com/p/2025/06/Garb-halftone.jpg",
            category = "entertainment",
            isFeatured = false,
            source = "uncrate.com",
            publishedDate = "13-04-2025",
            imageTags = arrayListOf()
        )

    )
}


//ne koristi se od spirale3
/*object NewsData {
    fun getAllNews(): List<NewsItem> {
        return listOf(
            NewsItem(
                id = "0",
                title = "Ukraine and US forge new economic partnership for reconstruction",
                snippet = "On Friday, Ukraine and the United States signed a memorandum of intent.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Obrazovanje",
                category = "Politika",
                isFeatured = true,
                source = "Daily Wrap",
                publishedDate = "17-04-2025"
            ),
            NewsItem(
                id = "1",
                title = "Lazio Star Warns Tottenham Of ‘Problems’ Against Bodo/Glimt",
                snippet = "Tottenham Hotspur have been warned that they will have ‘problems’ playing Bodo/Glimt away in the semi-final of the Europa League.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Sport",
                category = "Sport",
                isFeatured = false,
                source = "Inside Futbol",
                publishedDate = "16-04-2025"
            ),
            NewsItem(
                id = "2",
                title = "GPT-4.5 nears human mimicry, passing the Turing test at 73%",
                snippet = "Does GPT chat think in a similar way to us? ",
                imageUrl = "https://via.placeholder.com/800x400.png?text=AI+Model",
                category = tech",
                isFeatured = false,
                source = "Daily Wrap",
                publishedDate = "14-04-2025",
            ),
            NewsItem(
                id = "3",
                title = "Cutting ties with China would be very foolish, says Reeves",
                snippet = "Rachel Reeves has said it would be “very foolish” for Britain to disengage with China, in a rejection of Donald Trump’s efforts to isolate Beijing..",
                imageUrl = null,
                category = "Politika",
                isFeatured = false,
                source = "The Telegraph",
                publishedDate = "15-04-2025"
            ),
            NewsItem(
                id = "4",
                title = "Hue new? Scientists claim to have found colour no one has seen before",
                snippet = "Their description of the colour is not too arresting – the five people who have seen it call it blue-green – but that, they say, does not fully capture the richness of the experience.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=NASA",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "The Guardian",
                publishedDate = "13-04-2025"
            ),
            NewsItem(
                id = "5",
                title = "The top 10 greatest coaches in Real Madrid's history",
                snippet = "The football community is paying tribute to Leo Beenhakker",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = true,
                source = "Sports Unlimited News",
                publishedDate = "01-03-2025"
            ),
            NewsItem(
                id = "6",
                title = "2025 Saudi Arabian Grand Prix – Free Practice 1 F1 results (Jeddah)",
                snippet = "UDrivers headed out for the first practice session of the Saudi Arabian Grand Prix weekend with Pierre Gasly topping the times in Jeddah.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = false,
                source = "Planet f1",
                publishedDate = "12-03-2025"
            ),
            NewsItem(
                id = "7",
                title = "Politics home and after haven't deterred investors from South Africa",
                snippet = "Investors have flocked to South Africa's domestic bond markets, betting the country can stay the course on reforms despite ...",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = true,
                source = "Reuters",
                publishedDate = "17-02-2025"
            ),
            NewsItem(
                id = "8",
                title = "Inside the Kremlin college",
                snippet = "Where diplomats learn to deceive the West",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "The Telegraph",
                publishedDate = "10-02-2025"
            ),
            NewsItem(
                id = "9",
                title = "Will trade war between USA and China escalate into actual war",
                snippet = "The trade war between the USA and China is unlikely to escalate into an actual war.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = true,
                source = "RBC Ukraine",
                publishedDate = "11-04-2025"
            ),
            NewsItem(
                id = "10",
                title = "Arsenal v Lyon: five key factors in the Women’s Champions League semi",
                snippet = "The former Arsenal manager Joe Montemurro, who left the club at the end of the 2020-21 season, returns to the Emirates Stadium when Arsenal... ",
                imageUrl = null,
                category = "Sport",
                isFeatured = false,
                source = "SportCC",
                publishedDate = "05-04-2025"
            ),
            NewsItem(
                id = "11",
                title = "Cricket-Jacks repays Mumbai's faith with all-round show in IPL win",
                snippet = "I knew I was going to play a role, they've got three left-handers in the top order and we knew that the wicket was going to have a little bit of assistance",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = false,
                source = "Reuters",
                publishedDate = "28-03-2025"
            ),
            NewsItem(
                id = "12",
                title = "World Politics",
                snippet = "The 17-year-old has been taken into custody more than two weeks after the alleged murder.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = false,
                source = "The Telegraph",
                publishedDate = "17-01-2025"
            ),
            NewsItem(
                id = "13",
                title = "Scientists now say MILLIONS of planets could be teeming with life",
                snippet = "Planet K2-18b is very unlikely to be a one-off in the vast universe",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "BBC",
                publishedDate = "24-03-2025"
            ),
            NewsItem(
                id = "14",
                title = "Premier League break FA Cup final fixture promise",
                snippet = "The Premier League has been forced to break a Football Association pledge to stop any top-tier matches being played on the eve of the men’s FA Cup final.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = false,
                source = "The Telegraph",
                publishedDate = "10-04-2025"
            ),
            NewsItem(
                id = "15",
                title = "Donald Trump studying if he can sack Fed chief, says White House",
                snippet = "Donald Trump is assessing whether he can sack the head of the Federal Reserve, the White House has said.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = false,
                source = "The Telegraph",
                publishedDate = "28-03-2025"
            ),
            NewsItem(
                id = "16",
                title = "Postecoglou hails Spurs’ belief after Solanke sets up Bodø/Glimt semi-final",
                snippet = "Ange Postecoglou insisted he never lost faith in his Tottenham players as they progressed to the semi-finals of the Europa League and feels there is growing belief that they can lift the trophy next month.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = true,
                source = "The Guardian",
                publishedDate = "17-02-2025"
            ),
            NewsItem(
                id = "17",
                title = "Is South Korea’s political turmoil being underwritten by Beijing?",
                snippet = "With South Korea now set to hold presidential elections within the next two months following the ousting of President Yoon Suk Yeol...",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = true,
                source = "BBC",
                publishedDate = "05-02-2025"
            ),
            NewsItem(
                id = "18",
                title = "Scientists create the world's largest lab-grown chicken nugget",
                snippet = "The piece of lab-grown meat had an artificial circulatory system of hollow fibers delivering nutrients and oxygen.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "Science Daily",
                publishedDate = "07-03-2025"
            ),
            NewsItem(
                id = "19",
                title = "Scientists stumble across rare evidence that Earth is peeling underneath the Sierra Nevada",
                snippet = "Scientists found new evidence that Earth’s crust is peeling underneath the Sierra Nevada in California.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "Independent",
                publishedDate = "27-02-2025"
            ),
            NewsItem(
                id = "20",
                title = "Myanmar's fatal quake deepens political turmoil with no path to peace",
                snippet = "Armed Conflict Location and Event Data (ACLED), which monitors global conflicts, ranked Myanmar as the world's second-most ...",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = false,
                source = "Hosted",
                publishedDate = "11-02-2025"
            ),
            NewsItem(
                id = "21",
                title = "BJP now the world's largest political party: VD Sharma",
                snippet = "...said that the tireless efforts of crores of party workers have made the BJP the largest political party in the world.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = false,
                source = "Pioneer ",
                publishedDate = "04-04-2025"
            ),
            NewsItem(
                id = "22",
                title = "Controversy around the dire wolf 'de-extinctions'",
                snippet = "...brought back dire wolves (Aenocyon dirus) from extinction after more than 10,000 years.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "Live Science on MSN",
                publishedDate = "22-03-2025"
            ),
            NewsItem(
                id = "23",
                title = "In Kerala politics, Satheesan's shoes are issue, not Trump or tariffs",
                snippet = "The politics in Kerala operate in a different universe",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = false,
                source = "Gulf News",
                publishedDate = "02-03-2025"
            ),
            NewsItem(
                id = "24",
                title = "US now 'most dysfunctional and unfree political system' in industrialized world: expert",
                snippet = "Political scientist Ian Bremmer says that President Donald Trump has quickly made the United States into...",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = true,
                source = "Raw Story",
                publishedDate = "07-03-2025"
            ),
            NewsItem(
                id = "25",
                title = "Max Verstappen 'offered biggest contract in F1 history' to leave Red Bull for rival",
                snippet = "Max Verstappen is said to be mulling over a mega-money contract offer from Aston Martin as the reigning world champion considers his future with Red Bull.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = false,
                source = "Mirror",
                publishedDate = "11-04-2025"
            ),
            NewsItem(
                id = "26",
                title = "Victor Montagliani: Travel bans nor politics will impact World Cup 2026 ... maybe",
                snippet = "Controversy has dogged the FIFA Men’s World Cup for decades.",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = true,
                source = "Province on MSN",
                publishedDate = "21-01-2025"
            ),
            NewsItem(
                id = "27",
                title = "Scientists from Japan, UK race to fight drug resistance",
                snippet = "What happens if the world's antibiotics stop working?",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "NHK",
                publishedDate = "08-01-2025"
            ),
            NewsItem(
                id = "28",
                title = "Party like it’s 1999",
                snippet = "Amorim uses treble as ‘inspiration’ for crazy Lyon comeback",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = true,
                source = "The Telegraph",
                publishedDate = "15-02-2025"
            ),
            NewsItem(
                id = "29",
                title = "Trump, Putin and better world politics?",
                snippet = "During World War II, Russia (then part of the Soviet Union ... ",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Politika",
                isFeatured = false,
                source = "Daily",
                publishedDate = "17-02-2025"
            ),
            NewsItem(
                id = "30",
                title = "The oldest football clubs in history",
                snippet = "A trip down memory lane",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = false,
                source = "SportCC",
                publishedDate = "12-02-2025"
            ),
            NewsItem(
                id = "31",
                title = "'One club men'",
                snippet = "The 20 most loyal players in football history",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = false,
                source = "SportCC",
                publishedDate = "17-01-2025"
            ),
            NewsItem(
                id = "32",
                title = "The 25 Best Strikers in World Football Right Now",
                snippet = "Ranked from Lowest to Highest",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Sport",
                isFeatured = false,
                source = "Lente Desportiva",
                publishedDate = "11-02-2025"
            ),
            NewsItem(
                id = "33",
                title = "Environmental Science News",
                snippet = " Scientists use small peptides to enhance symbiosis between plants and fungi",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "Science Daily",
                publishedDate = "23-03-2025"
            ),
            NewsItem(
                id = "34",
                title = "Scientists reveal advance in brain research once thought impossible",
                snippet = "From a cubic millimeter of tissue, scientists constructed a precise, 3D map of the activity in a mouse’s brain, detailing ...",
                imageUrl = "https://via.placeholder.com/800x400.png?text=Igokea",
                category = "Nauka/tehnologija",
                isFeatured = false,
                source = "CNN",
                publishedDate = "13-04-2025"
            )
        )
    }
}
*/