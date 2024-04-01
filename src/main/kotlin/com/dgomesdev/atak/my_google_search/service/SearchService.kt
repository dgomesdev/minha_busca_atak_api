package com.dgomesdev.atak.my_google_search.service

import com.dgomesdev.atak.my_google_search.model.SearchResult
import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class SearchService {

    fun searchOnGoogle(queryText: String): List<SearchResult> {
        val url = "https://www.google.com/search?q=${queryText.replace(" ", "+")}"
        val doc = Jsoup.connect(url).get()
        val searchResults = doc.select("div.yuRUbf")

        val resultList = mutableListOf<SearchResult>()

        for (result in searchResults) {
            val title = result.select("h3").text()
            val linkElement = result.select("a[href]").first()
            val link = linkElement?.attr("href") ?: ""

            if (title.isNotEmpty() && link.isNotEmpty()) {
                resultList.add(SearchResult(title, link))
            }
        }

        return resultList
    }
}