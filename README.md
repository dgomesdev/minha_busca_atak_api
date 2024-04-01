## Documentação da API Minha Busca Atak

### Introdução

A API Minha Busca Atak permite aos usuários recuperar resultados de pesquisa do Google com base em um texto de consulta. Ela fornece uma interface simples para acessar os resultados de pesquisa em um formato JSON estruturado.

### URL Base

A URL base para a API é:

```
http://ec2-3-88-165-28.compute-1.amazonaws.com:8080
```

### Endpoint

#### Endpoint de Busca

- **URL**: `/search/{queryText}`
- **Método**: GET
- **Descrição**: Recupera resultados de pesquisa do Google com base no texto de consulta fornecido.
- **Parâmetros da Requisição**:
    - `queryText` (string): O texto a ser usado como consulta de pesquisa.
- **Resposta**:
    - **Códigos de Status**:
        - `200 OK`: Resultados de pesquisa recuperados com sucesso.
        - `400 Bad Request`: Ocorreu um erro ao processar a solicitação.
    - **Corpo**: Lista de resultados de pesquisa no formato JSON. Cada resultado de pesquisa contém um título e um link.
        - `title` (string): Título do resultado de pesquisa.
        - `link` (string): Link para o resultado de pesquisa.

### Exemplo

#### Requisição

```
GET /search/maringa
```

#### Resposta

```
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
    }
]
```