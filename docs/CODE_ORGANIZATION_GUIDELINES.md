# 🧱 Code Organization Guidelines - MaisForte

Este documento define as regras obrigatórias de organização de código do projeto MaisForte.

⚠️ Este projeto é exclusivamente para estudo de arquitetura, boas práticas e uso de IA.
Mesmo sendo educacional, seguimos padrões profissionais rigorosos.

---

# 🏗️ Estrutura Arquitetural

Cada serviço segue a estrutura:

```
domain/
application/
infrastructure/
presentation/
```

Separação obrigatória de responsabilidades entre camadas.

---

# 🗄️ Banco de Dados e Migrations

## ✅ Regras Obrigatórias

1. Toda nova tabela DEVE ser criada via migration do Flyway.
2. É PROIBIDO criar tabelas automaticamente via Exposed.
3. Nenhuma estrutura de banco deve existir sem migration versionada.
4. Toda migration deve seguir versionamento incremental.

## ❌ Proibido

- `SchemaUtils.create`
- Criação automática de tabela via ORM
- Alterações manuais no banco sem migration

---

# 🧩 Entidades (Entity)

## Regras

1. Toda tabela precisa estar representada no código como uma Entity.
2. Entity representa estrutura de persistência.
3. Entity NÃO pode trafegar entre serviços.
4. Entity NÃO pode ser retornada por Services.
5. Entity NÃO pode ser exposta pelo Controller.

Entities são exclusivamente internas ao domínio.

---

# 🗃️ Repository Layer

## Regra Fundamental

Quem acessa a Entity é apenas o:

```
<Contexto>RepositoryService
```

Exemplo:

- WorkoutRepositoryService
- ProfileRepositoryService
- ExecutionRepositoryService

## Proibições

- Controller acessar repository
- Service de outro domínio acessar repository diretamente
- Exposição de Entity fora da camada de persistência

---

# 🧠 Service Layer (Regra de Negócio)

Toda regra de negócio deve estar no:

```
<Contexto>Service
```

Exemplo:

- WorkoutService
- ExecutionService
- AccountService

## Regras

1. Service não deve retornar Entities.
2. Service deve retornar apenas DTOs.
3. Service não deve acessar diretamente banco fora do RepositoryService.
4. Service deve centralizar validações e regras de negócio.

---

# 📦 DTOs

## Padrão

Service deve retornar apenas:

```
DTOs
```

Controller deve receber:

```
<Contexto><Action>Request
```

Controller deve retornar:

```
<Contexto>Response
```

DTOs são contratos externos.

Entities são modelos internos.

Nunca misturar os dois.

---

# 🌐 Controller Layer

## Regras Obrigatórias

1. Controller deve apenas chamar Services.
2. Controller NÃO pode:
   - Chamar Repository
   - Chamar outra Controller
   - Conter regra de negócio
3. Controller deve trabalhar apenas com:
   - <Contexto>Request
   - <Contexto>Response

Controller é apenas orquestração HTTP.

---

# 🔗 Comunicação Entre Domínios

Se um `<Contexto>Service` precisar se comunicar com outro domínio:

Deve utilizar:

```
<Domain>Client
```

Exemplo:

- AccountClient
- TrainingClient
- AuthClient

## Proibições

- Acessar repository de outro domínio
- Instanciar Service de outro domínio diretamente
- Compartilhar Entities entre domínios

Comunicação entre domínios deve ser desacoplada.

---

# 🧪 Testes

Cada camada deve possuir testes unitários.

Obrigatório:

- Testes de Service
- Testes de Repository (quando aplicável)
- Testes de Controller
- Testes de Client

Testes devem validar:

- Regras de negócio
- Casos de erro
- Validações
- Comportamento esperado

---

# 🚫 Anti-Patterns Proibidos

- Controller com regra de negócio
- Service retornando Entity
- Repository sendo usado fora do domínio
- Migration ausente para nova tabela
- DTO sendo usado como Entity
- Comunicação direta entre domínios

---

# 🎯 Objetivo

Este guideline existe para:

- Garantir isolamento de domínio
- Manter arquitetura limpa
- Facilitar evolução futura
- Evitar acoplamento acidental
- Treinar disciplina arquitetural

Seguir essas regras faz parte do aprendizado profissional.
