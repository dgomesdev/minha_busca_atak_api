package com.dgomesdev.atak.my_google_search.controller

import com.dgomesdev.atak.my_google_search.model.SearchResult
import com.dgomesdev.atak.my_google_search.service.SearchService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SearchController {

    @Autowired
    lateinit var searchService: SearchService

    @GetMapping("/search/{queryText}", produces = ["application/json;charset=UTF-8"])
    fun search(@PathVariable(value = "queryText") queryText: String): ResponseEntity<List<SearchResult>> {
        try {
            val results = searchService.searchOnGoogle(queryText)
            return ResponseEntity.ok(results)
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null)
        }
    }
}