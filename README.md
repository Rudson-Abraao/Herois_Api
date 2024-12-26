# Api_Herois

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

## Sobre

- Api rest desenvolvida para gerenciar hérois em um banco de dados relacional, podendo adicionar, consultar, atualizar e deletar.
- url base: `http://localhost:8080/herois`

## Endpoints

### `POST`
`http://localhost:8080/herois`
- Adiciona um ou vários hérois no banco de dados
#### Requisição
```json
{
    "nomeHeroi": "Deadpool",
    "nomeCivil": "Wade Wilson",
    "universo": "Terra-616 (Marvel Comics)",
    "primeiraAparicao": "The New Mutants #98 (1991)"
}
```
- `nomeHeroi` (String, obrigatório)
- `nomeCivil` (String, obrigatório)
- `universo` (String, obrigatório)
- `primeiraAparicao` (String, obrigatório)

### `GET`

`http://localhost:8080/herois/lista`
- Retorna uma pagina com uma lista de 20 hérois por pagina.

#### Reposta
```json
{
    "content": [
        {
            "id": 1,
            "nomeHeroi": "Superman",
            "nomeCivil": "Clark Kent / Kal-El",
            "universo": "Terra-0 (DC Comics)",
            "primeiraAparicao": "Action Comics #1 (1938)"
        },
        {
            "id": 2,
            "nomeHeroi": "Homem de Ferro",
            "nomeCivil": "Tony Stark",
            "universo": "Terra-616 (Marvel Comics)",
            "primeiraAparicao": "Tales of Suspense #39 (1963)"
        },
        {
            "id": 3,
            "nomeHeroi": "Hulk",
            "nomeCivil": "Bruce Banner",
            "universo": "Terra-616 (Marvel Comics)",
            "primeiraAparicao": "The Incredible Hulk #1 (1962)"
        },

```
---

`http://localhost:8080/herois/{id}` 
- Retorna um héroi a depender do id da url.

#### Resposta 
```json
{
    "id": 11,
    "nomeHeroi": "Wolverine",
    "nomeCivil": "Logan",
    "universo": "Terra-616 (Marvel Comics)",
    "primeiraAparicao": "The Incredible Hulk #180 (1974)"
}
```

## `PUT`
`http://localhost:8080/herois`
- Permite a atualização de algumas propriedades do héroi.

#### Requisição
```json
{
    "id": "11",
    "nomeCivil": "Logan"
}
```
- O `id` é obrigatório para alteração dos dados do héroi

## `DELETE`
`http://localhost:8080/herois/{id}`
- Deleta determinado héroi do banco de dados.





