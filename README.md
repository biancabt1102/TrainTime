# TrainTime

<i>O projeto consiste em um sistema para academias que permite aos alunos terem acesso a seus treinos diários criados pelos instrutores de forma fácil e prática. Com o sistema, os alunos poderão acessar seus treinos personalizados, a partir de qualquer dispositivo mobile.

O sistema funcionará por meio de um aplicativo que será instalado no celular do aluno. Esse aplicativo irá sicronizar com o sistema da academia, permitindo que o aluno acesse seu treino diário e obtenha orientação do instrutor na própria academia para realizar os exercícios de forma correta.
</i>

<hr>

## Endpoints

<h3 style="font-size: 18px"> Avaliador </h3>

- Avaliação
    - [Cadastrar](#cadastrar-avaliação)
    - [Listar todos](#listar-avaliação)
    - [Alterar](#alterar-avaliação)
    - [Detalhes](#detalhes-avaliação)
    - [Excluir](#excluir-avaliação)

<h3 style="font-size: 18px"> Aluno </h3>

- Exercícios
    - [Listar todos](#listar-exercícios)
    - [Detalhes](#detalhes-exercícios)
    - [Alterar](#alterar-exercícios)
  
<hr>

### Cadastrar Avaliação 

`POST` /traintime/api/{avaliador}/avaliacao


*Campos da requisição*

| Campo        | Tipo   | Obrigatório | Descrição|
|--------------|--------|:-----------:|----------|
|nomeExercicio |texto   |sim| Um texto informando o nome do exercicio|
|qtdDeRepeticoes|inteiro |sim| A quantidade de repetições do exercicio|
|qtdSerie      |inteiro |sim| Quantas séries terão o exercicio|
|categoriaId   |inteiro |sim| O id de uma categoria previamente cadastrada|
|diaDaSemanaId |inteiro |sim| O id de um dia da semana previamente cadastrada|
|idExercicio   |Long    |sim| O id de um exercício previamente criado|

```
{
    "nomeExercicio": 'Remada baixa',
    "qtdDeRepeticoes": 15,
    "qtdSerie": 3,
    "cargaTotal": null,
    "Descanso": null,
    "categoriaId": 1,
    "diaDaSemanaId": 0,
    "idExercicio": 1
}
```

*Corpo da resposta*
|código|descrição|
|:----:|---------|
|201| Avaliação criada com sucesso|
|400| Avaliação inválida|

<hr>

### Alterar Avaliação

`PUT` /traintime/api/{avaliador}/avaliacao/{id}

*Campos de requisição*

| Campo        | Tipo   | Obrigatório | Descrição|
|--------------|--------|:-----------:|----------|
|nomeExercicio  |texto   |não| Um texto informando o nome do exercicio|
|qtdDeRepeticoes|inteiro |não| A quantidade de repetições do exercicio|
|qtdSerie       |inteiro |não| Quantas séries terão o exercicio|
|categoriaId    |inteiro |não| O id de uma categoria previamente cadastrada|
|diaDaSemanaId  |inteiro |não| O id de um dia da semana previamente cadastrada|
|idExercicio    |Long    |sim| O id de um exercício previamente criado|

```
{
    "nomeExercicio": 'Remada Baixa',
    "qtdDeRepeticoes": 15,
    "qtdSerie": 3,
    "cargaTotal": null,
    "intervaloDescanso": null,
    "categoriaId": 1,
    "diaDaSemanaId": 2,
    "idExercicio": 1
}
```

*Corpo de resposta*
|código|descrição|
|:----:|---------|
|200| Alteração realizada com sucesso|
|400| Alteração inválida|
|404| Avaliação não encontrada|

<hr>

### Listar Avaliação

`GET` /traintime/api/{avaliador}/avaliacao

*Exemplo de resposta*

| Campo        | Tipo   | Descrição|
|--------------|--------|----------|
|nomeExercicio |texto   | O nome do exercício|
|qtdDeRepeticoes     |inteiro | A quantidade de repetições do exercício|
|qtdSerie         |inteiro | A quantidade de séries do exercício|
|categoriaId   |inteiro  | O id de uma categoria previamente cadastrada|
|diaDaSemanaId |inteiro  | O id de um dia da semana previamente cadastrada|
|idExercicio   |Long    |sim| O id de um exercício previamente criado|

```
[
    {
        "nomeExercicio": 'Remada Baixa',
        "qtdDeRepeticoes": 15,
        "qtdSerie": 3,
        "cargaTotal": null,
        "intervaloDescanso": null,
        "categoriaId": 2,
        "diaDaSemana": 2,
        "idExercicio": 1
    },

    {
        "nomeExercicio": 'Leg press',
        "qtdDeRepeticoes": 20,
        "qtdSerie": 3,
        "cargaTotal": null,
        "intervaloDescanso": null,
        "categoriaId": 3,
        "diaDaSemanaId": 3,
        "idExercicio": 2
    },

    {
        "nomeExercicio": 'Cadeira extensora',
        "qtdDeRepeticoes": 15,
        "qtdSerie": 3,
        "cargaTotal": null,
        "intervaloDescanso": null,
        "categoriaId": 4,
        "diaDaSemana": 6,
        "idExercicio": 3
    }
]
```

*Resposta*

|código|descrição|
|:----:|---------|
|  200 | Listagem feita com sucesso|
|  404 | Lista não encontrada|

<hr>

### Detalhes Avaliação

`GET` /traintime/api/{avaliador}/avaliacao/{id}

*Exemplo de resposta*

| Campo        | Tipo   | Descrição|
|--------------|--------|----------|
|nomeExercicio |texto   | O nome do exercício|
|qtdDeRepeticoes     |inteiro | A quantidade de repetições do exercício|
|qtdSerie         |inteiro | A quantidade de séries do exercício|
|categoriaId   |inteiro  | O id de uma categoria previamente cadastrada|
|diaDaSemanaId |inteiro  | O id de um dia da semana previamente cadastrada|
|idExercicio   |Long    |sim| O id de um exercício previamente criado|

```
{
    "nomeExercicio": 'Cadeira extensora',
    "qtdDeRepeticoes": 15,
    "qtdSerie": 3,
    "cargaTotal": null,
    "intervaloDescanso": null,
    "categoriaId": 5,
    "diaDaSemana": 1,
    "idExercicio": 1
}
```

*Resposta*

| código | descrição
|--------|---------
|200| Os dados foram retornados com sucesso
|404| Não foi encontrado a avaliação com esse ID

<hr>

### Excluir Avaliação

`DELETE` /traintime/api/{avaliador}/avaliacao/{id}


*Resposta*
|código|descrição|
|------|---------|
|204| Conteúdo não encontrado|

### Listar Exercícios

`GET` /traintime/api/{aluno}/exercicios

*Exemplo de resposta*

| Campo        | Tipo   | Descrição|
|--------------|--------|----------|
|diaDaSemanaId |inteiro  | O id de um dia da semana previamente cadastrada|
|nomeExercicio |texto   | O nome do exercício|
|qtdSerie         |inteiro | A quantidade de séries do exercício|
|qtdDeRepeticoes     |inteiro | A quantidade de repetições do exercício|
|cargaTotal         |inteiro | CargaTotal total utilizada durante o exercício|
|intervaloDescanso     |inteiro | IntervaloDescanso de descanso (em segundos) entre as séries|


```
[
    {
        "diaDaSemanaId": 1,
        "nomeExercicio": "Remada Baixa",
        "qtdSerie": 3,
        "qtdDeRepeticoes": 15,
        "cargaTotal": null,
        "intervaloDescanso": null
    },
    {
        "diaDaSemanaId": 2,
        "nomeExercicio": "Supino Vertical",
        "qtdSerie": 3,
        "qtdDeRepeticoes": 15,
        "cargaTotal": null,
        "intervaloDescanso": null
    },
    {
        "diaDaSemanaId": 3,
        "nomeExercicio": "Mesa Flexora",
        "qtdSerie": 3,
        "qtdDeRepeticoes": 15,
        "cargaTotal": null,
        "intervaloDescanso": null
    },
]
```

*Resposta*
|código|descrição|
|:----:|---------|
|  200 | Listagem feita com sucesso|
|  404 | Lista não encontrada|

<hr>

### Detalhes Exercícios

`GET` /traintime/api/{aluno}/exercicios/{id}

*Exemplo de resposta*

| Campo        | Tipo   | Descrição|
|--------------|--------|----------|
|diaDaSemanaId |inteiro  | O id de um dia da semana previamente cadastrada|
|nomeExercicio |texto   | O nome do exercício|
|qtdSerie         |inteiro | A quantidade de séries do exercício|
|qtdDeRepeticoes     |inteiro | A quantidade de repetições do exercício|
|cargaTotal         |inteiro | CargaTotal total utilizada durante o exercício|
|intervaloDescanso     |inteiro | IntervaloDescanso de descanso (em segundos) entre as séries|


```
{
    "diaDaSemanaId": 1,
    "nomeExercicio": "Remada Baixa",
    "qtdSerie": 3,
    "qtdDeRepeticoes": 15,
    "cargaTotal": null,
    "intervaloDescanso": null
}
```

*Resposta*
|código|descrição|
|:----:|---------|
|200| Os dados foram retornados com sucesso
|404| Não foi encontrado a avaliação com esse ID

<hr>

### Alterar Exercícios

`PUT` /traintime/api/{aluno}/exercicio/{id}

*Campos de requisição*

| Campo     | Tipo   | Obrigatório | Descrição|
|-----------|--------|:-----------:|----------|
|qtdDeRepeticoes  |inteiro |não| A quantidade de repetições do exercicio|
|cargaTotal      |inteiro |sim| A cargaTotal (peso em Kg) que será utilizada no exercício|
|intervaloDescanso  |inteiro |sim| O intervaloDescanso de descanso em segundos entre as séries do exercício|

```
{
    "qtdDeRepeticoes": 20,
    "cargaTotal": 10,
    "intervaloDescanso": 10
}
```

*Corpo resposta*
|código|descrição|
|:----:|---------|
|200| Alteração feita com sucesso|
|400| Alteração inválida|
|404| Alteração não encontrada|