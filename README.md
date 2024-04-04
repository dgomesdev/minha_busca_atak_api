## My Google search Search API Documentation

### Introduction

The Search API allows users to retrieve search results from Google based on a query text. It provides a simple interface to access search results in a structured JSON format.

### Base URL

The base URL for the API is:

```
http://ec2-3-88-165-28.compute-1.amazonaws.com:8080
```

### Endpoint

#### Search Endpoint

- **URL**: `/search/{queryText}`
- **Method**: GET
- **Description**: Retrieves search results from Google based on the provided query text.
- **Request Parameters**:
  - `queryText` (string): The text to be used as the search query.
- **Response**:
  - **Status Codes**:
    - `200 OK`: Successfully retrieved search results.
    - `400 Bad Request`: Error occurred while processing the request.
  - **Body**: List of search results in JSON format. Each search result contains a title and a link.
    - `title` (string): Title of the search result.
    - `link` (string): Link to the search result.

### Example

#### Request

```
GET /search/maringa
```

#### Response

```json
[
    {
        "title": "Maringá",
        "link": "https://en.wikipedia.org/wiki/Maring%C3%A1"
    },
    {
        "title": "Maringá | Brazilian City, Tourist Destination",
        "link": "https://www.britannica.com/place/Maringa"
    },
    {
        "title": "Maringa 2024 Top Things to Do - Maringa Travel Guides",
        "link": "https://us.trip.com/travel-guide/destination/maringa-14027/"
    },
    ...
]
```

### Error Handling

If an error occurs while processing the request, the API will return an appropriate HTTP status code along with an error message in the response body.

### Rate Limiting

Currently, there are no rate limits imposed on the API. However, abuse of the API may result in rate limiting or suspension of access.

### Contact

For any inquiries or issues related to the API, please contact the API maintainer at [maintainer@example.com](mailto:maintainer@example.com).
