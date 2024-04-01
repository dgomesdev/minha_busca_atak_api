package com.dgomesdev.atak.my_google_search.controller

import com.dgomesdev.atak.my_google_search.model.SearchResult
import com.dgomesdev.atak.my_google_search.service.SearchService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus

@ExtendWith(MockitoExtension::class)
class SearchControllerTest {

    @Mock
    lateinit var searchService: SearchService

    @InjectMocks
    lateinit var searchController: SearchController

    @Test
    fun `search with valid query return 200`() {
        // GIVEN
        val query = "test"
        val expectedResult = listOf(
            SearchResult("Title 1", "https://example.com/1"),
            SearchResult("Title 2", "https://example.com/2")
        )
        Mockito.`when`(searchService.searchOnGoogle(query)).thenReturn(expectedResult)

        // WHEN
        val result = searchController.search(query)

        // THEN
        assert(result.statusCode == HttpStatus.OK)
        assert(result.body == expectedResult)
    }

    @Test
    fun `search query with no results return 200`() {
        // GIVEN
        val query = "cfeozjknbvaùrovbrùovbrùvrb"
        val expectedResult = emptyList<SearchResult>()
        Mockito.`when`(searchService.searchOnGoogle(query)).thenReturn(expectedResult)

        // WHEN
        val result = searchController.search(query)

        // THEN
        assert(result.statusCode == HttpStatus.OK)
        assert(result.body == expectedResult)
    }

    @Test
    fun `search with exception when there is no internet connection`() {
        // GIVEN
        val queryText = "testQuery"
        Mockito.`when`(searchService.searchOnGoogle(queryText)).thenThrow(RuntimeException("No internet connection"))

        // WHEN
        val response = searchController.search(queryText)

        // THEN
        assertEquals(HttpStatus.SERVICE_UNAVAILABLE, response.statusCode)
        assertNull(response.body)
    }
}
