# Projeto Crud de Produtos da matéria POO Avançada
## ````Prof. Luciano Ferretto ````

##````Alunos: André Canton, Guilherme Bortolotti, Bruno Abido, Matheus Rodrigues, Arthur Vassoler````

## URLs de acesso

URL: http://localhost:8080/api/v1

## Métodos
Requisições para a API devem seguir os padrões:

| Método | Descrição |
|---|---|
| `GET` | Retorna informações de um ou mais registros. |
| `POST` | Utilizado para criar um novo registro. |
| `PUT` | Atualiza dados de um registro ou altera sua situação. |
| `DELETE` | Remove um registro do sistema. |


## Respostas

| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema.|
| `401` | Dados de acesso inválidos.|
| `404` | Registro pesquisado não encontrado (Not found).|
| `405` | Método não implementado.|
| `410` | Registro pesquisado foi apagado do sistema e não esta mais disponível.|
| `422` | Dados informados estão fora do escopo definido para o campo.|
| `429` | Número máximo de requisições atingido. (*aguarde alguns segundos e tente novamente*)|


### Listar Todos (List) [GET /produto]

```Request (application/json)```

+ Response 200 (application/json)

        {
          "content": [
              {
                  "id": "eaacbd50-ac8f-4394-8bf7-c433532a3cf8",
                  "nome": "Caneca Python",
                  "valorUnidade": 22.20
              },
              {
                  "id": "d7201712-370f-4b46-874c-9bbe47586312",
                  "nome": "Caneca MicroSoft",
                  "valorUnidade": 340.30
              },
                ....
          ],
          "pageable": {
              "sort": {
                  "empty": true,
                  "unsorted": true,
                  "sorted": false
              },
              "offset": 0,
              "pageNumber": 0,
              "pageSize": 20,
              "paged": true,
              "unpaged": false
          },
          "last": true,
          "totalPages": 1,
          "totalElements": 5,
          "first": true,
          "size": 20,
          "number": 0,
          "sort": {
          "empty": true,
          "unsorted": true,
          "sorted": false
          },
          "numberOfElements": 5,
          "empty": false
        }



### Novo (Create) [POST /produto]

+ Attributes (object)

    + nome: nome do produto (string, obrigatório)
    + numero (BigDecimal, obrigatório)


+ Request (application/json)
    + Body

          {
              "nome": "Caneca Linux",
              "valorUnidade": 1.0
          }

  + Response 200 (application/json)

    + Body

          {
              "id": "97478f1e-a26b-4326-b5c1-0d65329d9f36",
              "nome": "Caneca Linux",
              "valorUnidade": 1.0
          }

### Deletar (Delete) [DELETE /produto/{id}]
+ Parameters
    + id (UUID, obrigatório)


+ Response 200
    + Message

          Sucesso ao deletar o Produto:
          ede5c2cd-9bcc-47b4-9944-a432e21f02c1

### Alterar (Update) [PUT /produto]

+ Attributes (object)

    + id: (UUID, obrigatório)
    + nome: nome do produto (string, obrigatório)
    + numero: (BigDecimal, obrigatório)


+ Request (application/json)
    + Body

          {
              "id": "97478f1e-a26b-4326-b5c1-0d65329d9f36",
              "nome": "Caneca Nova",
              "valorUnidade": 1.0
          }

    + Response 200 (application/json)

        + Body

              {
                  "id": "97478f1e-a26b-4326-b5c1-0d65329d9f36",
                  "nome": "Caneca Nova",
                  "valorUnidade": 1.0
              }

<br>

-----


