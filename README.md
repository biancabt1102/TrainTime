# TrainTime

<i>O projeto consiste em um sistema para academias que permite aos alunos terem acesso a seus treinos diários criados pelos instrutores de forma fácil e prática. Com o sistema, os alunos poderão acessar seus treinos personalizados, a partir de qualquer dispositivo mobile.

O sistema funcionará por meio de um aplicativo que será instalado no celular do aluno. Esse aplicativo irá sicronizar com o sistema da academia, permitindo que o aluno acesse seu treino diário e obtenha orientação do instrutor na própria academia para realizar os exercícios de forma correta.
</i>

## Endpoints

### Avaliador
- Avaliação
    - [Cadastrar](#cadastrar-avaliação)
    - [Listar todos](#listar-avaliação)
    - [Alterar](#alterar-avaliação)
    - [Detalhes](#detalhes-avaliação)

### Aluno
- Nome do exercício
    - Listar todos
    - Detalhes

- Repetição
    - Alterar
    - Detalhes

- Carga
    - Cadastrar
    - Listar todos
    - Alterar
    - Detalhes

- Categoria
    - Listar todos
    - Detalhes
    
- Intervalo
    - Cadastrar
    - Alterar
    - Detalhes
    
#### Cadastrar Avaliação
`POST` /traintime/api/avaliacao

*Campos da requisição*

| Campo        | Tipo   | Obrigatório | Descrição|
|--------------|--------|:-----------:|----------|
|nomeExercicio |texto   |sim| Um texto informando o nome do exercicio|
|repeticao     |inteiro |sim| A quantidade de repetições do exercicio|
|serie         |inteiro |sim| Quantas séries terão o exercicio|
|categoriaId   |objeto  |sim| O id de uma categoria previamente cadastrada|
|diaDaSemanaId |objeto  |sim| O id de um dia da semana previamente cadastrada|

```
{
    "nomeExercicio": 'Remada baixa',
    "repeticao": 15,
    "serie": 3,
    "categoriaId": {
        id: 1,
        "nome": "Treinamento de força"
    },
    "diaDaSemanaId": {
        "id": 0,
        "nome": "Domingo"
    }
}
```

*Corpo da resposta*
|código|descrição|
|:----:|---------|
|201| Avaliação criada com sucesso|
|400| Avaliação inválida|


#### Alterar Avaliação

`PUT` /traintime/api/avaliacao/{id}

*Campos de requisição*

| Campo        | Tipo   | Obrigatório | Descrição|
|--------------|--------|:-----------:|----------|
|nomeExercicio |texto   |não| Um texto informando o nome do exercicio|
|repeticao     |inteiro |não| A quantidade de repetições do exercicio|
|serie         |inteiro |não| Quantas séries terão o exercicio|
|categoriaId   |objeto |não| O id de uma categoria previamente cadastrada|
|diaDaSemanaId |objeto |não| O id de um dia da semana previamente cadastrada|

```
{
    "nomeExercicio": 'Remada Baixa',
    "repeticao": 15,
    "serie": 3,
    "categoriaId": {
        "id": 2,
        "nome": "Cardiovascular"
    },
    "diaDaSemanaId": {
        "id": 2,
        "nome": "Terça-feira"
    }
}
```

*Corpo de resposta*
|código|descrição|
|:----:|---------|
|200| Alteração realizada com sucesso|
|400| Alteração inválida|
|404| Avaliação não encontrada|

#### Listar Avaliação

`GET` /traintime/api/avaliacao

*Exemplo de resposta*

| Campo        | Tipo   | Descrição|
|--------------|--------|----------|
|nomeExercicio |texto   | O nome do exercício|
|repeticao     |inteiro | A quantidade de repetições do exercício|
|serie         |inteiro | A quantidade de séries do exercício|
|categoriaId   |objeto  | Objeto que contém informações da categoria do exercício|
|diaDaSemanaId |objeto  | Objeto que contém informações do dia da semana da avaliação|

```
[
    {
        "nomeExercicio": 'Remada Baixa',
        "repeticao": 15,
        "serie": 3,
        "categoria": {
            "id": 2,
            "nome": "Cardiovascular"
        },
        "diaDaSemana": {
            "id": 2,
            "nome": "Terça-feira"
        }
    },

    {
        "nomeExercicio": 'Leg press',
        "repeticao": 20,
        "serie": 3,
        "categoriaId": {
            "id": 3,
            "nome": "Perda de peso"
        },
        "diaDaSemanaId": {
            "id": 3,
            "nome": "Quarta-feira"
        }
    },

    {
        "nomeExercicio": 'Cadeira extensora',
        "repeticao": 15,
        "serie": 3,
        "categoriaId": {
            "id": 4,
            "nome": "Flexibilidade"
        },
        "diaDaSemana": {
            "id": 6,
            "nome": "Sábado"
        }
    }
]
```

*Resposta*

|código|descrição|
|:----:|---------|
|  200 | Listagem feita com sucesso|
|  404 | Lista não encontrada|


#### Detalhes Avaliação

`GET` /traintime/api/avaliacao/{id}

*Exemplo de resposta*

| Campo        | Tipo   | Descrição|
|--------------|--------|----------|
|nomeExercicio |texto   | O nome do exercício|
|repeticao     |inteiro | A quantidade de repetições do exercício|
|serie         |inteiro | A quantidade de séries do exercício|
|categoriaId   |objeto  | Objeto que contém informações da categoria do exercício|
|diaDaSemanaId |objeto  | Objeto que contém informações do dia da semana da avaliação|

```
{
    "nomeExercicio": 'Cadeira extensora',
    "repeticao": 15,
    "serie": 3,
    "categoriaId": {
        "id": 4,
        "nome": "Flexibilidade"
    },
    "diaDaSemana": {
        "id": 1,
        "nome": "Segunda"
    }
}
```

*Resposta*

| código | descrição
|--------|---------
|200| Os dados foram retornados com sucesso
|404| Não foi encontrado a avaliação com esse ID
