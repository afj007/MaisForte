# MaisForte

> ⚠️ **Projeto Exclusivo de Estudo**
> Este repositório foi criado para fins educacionais, focado em aprendizado de programação e exploração de ferramentas de IA. **Não é um produto comercial** e não deve ser usado em ambientes de produção.

## Sobre o Projeto

MaisForte é um monorepo backend desenvolvido em **Kotlin** que simula uma arquitetura de microserviços para gestão de treinamentos e usuários. O objetivo é explorar boas práticas de desenvolvimento, design de APIs, arquitetura de software e integração com IAs generativas.

## Arquitetura

O projeto segue uma estrutura de **monorepo** com múltiplos serviços e BFFs (Backend for Frontend), organizados seguindo princípios de **Domain-Driven Design (DDD)** de forma leve.

### Serviços

- **auth-service**: Gerenciamento de autenticação e autorização
- **account-service**: Gerenciamento de contas e perfis de usuários
- **training-service**: Gestão de treinos e exercícios

### BFFs

- **bff-web**: Backend voltado para aplicação web
- **bff-app**: Backend voltado para aplicação mobile

### Módulos Compartilhados

- **shared**: Código comum entre os serviços (utilitários, configurações, etc.)

## Stack Tecnológica

- **Linguagem**: Kotlin
- **Framework Web**: Ktor
- **ORM**: Exposed
- **Migrations**: Flyway
- **Testes**: JUnit 5
- **Banco de Dados**: PostgreSQL (recomendado)

## Filosofia de Uso de IA

Este projeto incentiva o uso de **IAs generativas** como ferramentas de aprendizado e produtividade:

- Exploração de padrões de código
- Geração de testes
- Refatoração assistida
- Documentação automatizada
- Revisão de código

O objetivo é entender como integrar IA no fluxo de desenvolvimento moderno, mantendo controle e qualidade do código.

## Governança de Branches

O projeto adota uma estratégia de branches pequenas e encadeadas:

- Toda feature nasce da `main`
- PRs atômicos e focados
- Um domínio por PR
- Template obrigatório de Pull Request

Para detalhes completos, consulte [docs/GIT_GOVERNANCE.md](docs/GIT_GOVERNANCE.md).

## Como Executar

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/MaisForte.git

# Configure o banco de dados
# (ajuste connection strings conforme necessário)

# Execute as migrations
./gradlew flywayMigrate

# Inicie um serviço específico
./gradlew :auth-service:run
```

## Estrutura de Diretórios

```
MaisForte/
├── auth-service/
├── account-service/
├── training-service/
├── bff-web/
├── bff-app/
├── shared/
├── docs/
└── .github/
```

## Contribuindo

Como este é um projeto de estudo, contribuições são voltadas para aprendizado. Siga as regras de governança descritas em `docs/GIT_GOVERNANCE.md`.

## Licença

Este projeto é de uso educacional e não possui licença comercial.
