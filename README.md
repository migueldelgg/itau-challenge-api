# Itaú Unibanco - Desafio de Programação

## 1.0 Endpoints da API

A seguir serão especificados os endpoints que devem estar presentes na sua API e a funcionalidade esperada de cada um deles.

---

### 1.1 Receber Transações: `POST /transacao`

Este é o endpoint que irá receber as transações. Cada transação consiste de um valor e uma `dataHora` de quando ela aconteceu:

```json
{
    "valor": 123.45,
    "dataHora": "2020-08-07T12:34:56.789-03:00"
}

```

📌 Campos no JSON:
Campo	Significado	Obrigatório?
valor	Valor em decimal com ponto flutuante da transação	✅ Sim
dataHora	Data/Hora no padrão ISO 8601 em que a transação aconteceu	✅ Sim
Dica: O Spring Boot, por padrão, consegue compreender datas no padrão ISO 8601 sem problemas. Experimente utilizar um atributo do tipo OffsetDateTime!

## ✅ A API só aceitará transações que:

- Tenham os campos `valor` e `dataHora` preenchidos.
- **NÃO DEVEM** acontecer no futuro.
- **DEVEM** ter acontecido a qualquer momento no passado.
- **NÃO DEVEM** ter valor negativo.
- **DEVEM** ter valor igual ou maior que `0` (zero).

---

### 📌 Respostas esperadas:

| Código HTTP | Significado |
|------------|-------------|
| `201 Created` | A transação foi aceita (validada e registrada) |
| `422 Unprocessable Entity` | A transação não foi aceita (por não atender aos critérios de aceitação, como valor menor que `0`) |
| `400 Bad Request` | A API não compreendeu a requisição do cliente (exemplo: JSON inválido) |

---

## 1.2 Limpar Transações: `DELETE /transacao`

Este endpoint simplesmente apaga todos os dados de transações que estejam armazenados.

### 📌 Respostas esperadas:

| Código HTTP | Significado |
|------------|-------------|
| `200 OK` | Todas as informações foram apagadas com sucesso |

---

## 1.3 Calcular Estatísticas: `GET /estatistica`

Este endpoint deve retornar estatísticas das transações que aconteceram nos últimos 60 segundos (1 minuto).

📌 Exemplo de resposta:
```json
{
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
}
```

### 📌 Campos no JSON:

| Campo  | Significado | Obrigatório? |
|--------|------------|--------------|
| `count` | Quantidade de transações nos últimos 60 segundos | ✅ Sim |
| `sum`   | Soma total do valor transacionado nos últimos 60 segundos | ✅ Sim |
| `avg`   | Média do valor transacionado nos últimos 60 segundos | ✅ Sim |
| `min`   | Menor valor transacionado nos últimos 60 segundos | ✅ Sim |
| `max`   | Maior valor transacionado nos últimos 60 segundos | ✅ Sim |

📌 Respostas esperadas:
Código HTTP	Significado
200 OK	Retorna um JSON com os campos count, sum, avg, min e max, todos preenchidos com seus respectivos valores
⚠️ Atenção!
Quando não houverem transações nos últimos 60 segundos, considere todos os valores como 0 (zero).
