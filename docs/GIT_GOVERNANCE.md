# Governança Git - MaisForte

Este documento define as regras de versionamento, branches e Pull Requests do projeto.

## Princípios

- **Branches pequenas e focadas**: Cada branch deve ter escopo bem definido
- **PRs atômicos**: Um PR deve conter apenas uma alteração lógica
- **Um domínio por PR**: Não misture alterações de diferentes serviços
- **Toda feature nasce da main**: Sempre derive branches a partir da `main` atualizada

## Padrão de Nomenclatura de Branches

```
<domain-service>/<contexto>/<alteracao-curta>
```

### Exemplos

```
auth-service/authentication/add-jwt-validation
account-service/user-profile/update-email-field
training-service/exercises/create-exercise-entity
bff-web/api/add-login-endpoint
shared/database/add-transaction-helper
```

### Componentes

- **domain-service**: Nome do serviço ou módulo afetado
- **contexto**: Área funcional ou técnica sendo alterada
- **alteracao-curta**: Descrição breve e em kebab-case

## Padrão de Título de Pull Request

```
<tipo>(<domain-service>): <descrição curta>
```

### Tipos Permitidos

- **feature**: Nova funcionalidade
- **fix**: Correção de bug
- **bug**: Identificação/documentação de bug
- **refac**: Refatoração de código
- **chore**: Tarefas de manutenção
- **test**: Adição ou modificação de testes
- **migration**: Alterações de schema/banco de dados

### Exemplos

```
feature(auth-service): adiciona validação de JWT
fix(account-service): corrige cálculo de idade do usuário
refac(training-service): extrai lógica de domínio para use case
chore(bff-web): atualiza dependências do Ktor
test(shared): adiciona testes para helpers de data
migration(auth-service): cria tabela de refresh tokens
```

## Template Obrigatório de Pull Request

Todo PR deve seguir o template definido em `.github/pull_request_template.md`:

### Estrutura

```markdown
## Motivo
[Descreva por que esta alteração é necessária]

## Resumo das alterações
[Liste as principais mudanças realizadas]

## Migration
- [ ] Não houve migration
- [ ] Houve migration retrocompatível
- [ ] Houve migration NÃO retrocompatível

## Testes
- [ ] Possui testes unitários
- [ ] Não necessita testes unitários
- [ ] Testado manualmente
- [ ] Não testado manualmente

## Dependência
[Descreva se este PR depende de outro PR ou se outro PR depende deste]
```

## Fluxo de Trabalho

1. **Atualizar main**: `git checkout main && git pull`
2. **Criar branch**: `git checkout -b auth-service/jwt/add-validation`
3. **Desenvolver**: Fazer commits atômicos e descritivos
4. **Abrir PR**: Seguir o template obrigatório
5. **Code Review**: Aguardar aprovação
6. **Merge**: Squash and merge para manter histórico limpo

## Branches Encadeadas

Quando uma feature depende de outra ainda não mergeada:

1. Crie a primeira branch a partir da `main`
2. Abra o primeiro PR
3. Crie a segunda branch a partir da primeira
4. Abra o segundo PR indicando a dependência
5. Após merge do primeiro, faça rebase do segundo em `main`

## Regras de Merge

- **Squash and merge**: Padrão para manter histórico limpo
- **Rebase antes de merge**: Manter branch atualizada com `main`
- **Sem force push em branches compartilhadas**: Apenas em branches pessoais

## Commits

Use mensagens de commit claras e descritivas:

```
Adiciona validação de token expirado no AuthService

- Implementa verificação de timestamp
- Lança JwtExpiredException quando token expirado
- Adiciona testes unitários para cenários de expiração
```

## Migrations

- **Retrocompatíveis**: Podem ser aplicadas sem quebrar sistema em produção
- **Não retrocompatíveis**: Requerem coordenação e planejamento
- **Sempre documente**: Indique no PR se houve migration e o tipo

## Code Review

- **Obrigatório**: Todo PR precisa de pelo menos uma aprovação
- **Foco**: Legibilidade, testes, arquitetura e padrões
- **Construtivo**: Comentários devem ser educativos e respeitosos

## Regra Pós-Merge (OBRIGATÓRIA)

Após o merge de um PR:

### 1) Se NÃO houver nova branch dependente:

- Voltar para a branch `main`
- Executar `pull` para atualizar a `main`
- Criar nova branch sempre a partir da `main` atualizada

### 2) Se houver próxima branch encadeada:

- Garantir que a branch base esteja atualizada
- Rebase ou merge da `main` quando necessário
- Manter cadeia de dependência limpa

### 3) Nunca continuar desenvolvendo em branch já mergeada.

### 4) Nunca criar nova branch a partir de branch desatualizada.
