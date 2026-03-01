# 🔄 Rebase Workflow - MaisForte

Este documento define o fluxo oficial de rebase de branches no projeto MaisForte.

⚠️ Este projeto é exclusivamente para estudo de arquitetura e uso de IA.
Mesmo sendo educacional, seguimos boas práticas reais de versionamento.

---

# 🎯 Objetivo do Rebase

O rebase é utilizado para:

- Manter histórico linear
- Evitar commits de merge desnecessários
- Reduzir conflitos acumulados
- Garantir que a branch esteja atualizada com a `main`

---

# 🌳 Quando Fazer Rebase?

Você deve realizar rebase quando:

- A `main` recebeu novos merges
- Sua branch está desatualizada
- Antes de abrir um PR
- Antes de continuar uma branch encadeada

---

# 🚀 Fluxo Oficial de Rebase

Siga EXATAMENTE essa ordem:

## 1️⃣ Ir para a main

```bash
git checkout main
```

## 2️⃣ Atualizar a main

```bash
git pull origin main
```

## 3️⃣ Voltar para sua branch

```bash
git checkout sua-branch
```

## 4️⃣ Fazer o rebase

```bash
git rebase main
```

## 5️⃣ Resolver conflitos (se houver)

Se houver conflitos avise! Não faça nenhum push

## 6️⃣ Forçar o push (com segurança)

```bash
git push --force-with-lease
```

---

# ⚠️ Regras Importantes

## ✅ PODE fazer rebase em:

- Branches pessoais
- Branches de feature não mergeadas
- Branches antes de abrir PR

## ❌ NÃO PODE fazer rebase em:

- `main`
- Branches já mergeadas
- Branches compartilhadas por múltiplas pessoas

---

# 🔒 Por que `--force-with-lease`?

O `--force-with-lease` é mais seguro que `--force` porque:

- Verifica se há commits remotos que você não tem localmente
- Evita sobrescrever trabalho de outros desenvolvedores
- Previne perda acidental de código

**Nunca use `git push --force` simples!**

---

# 📋 Checklist de Rebase

Antes de fazer push após rebase, verifique:

- [ ] Todos os conflitos foram resolvidos
- [ ] Os testes ainda passam localmente
- [ ] O build funciona
- [ ] Nenhum commit foi perdido
- [ ] A branch está sincronizada com a `main`

---

# 🆘 Em Caso de Problemas

Se algo der errado durante o rebase:

```bash
# Abortar o rebase
git rebase --abort

# Voltar ao estado anterior
git reflog
git reset --hard HEAD@{n}  # onde n é o commit antes do rebase
```

---

# 📚 Referências

- [Git Governance](./GIT_GOVERNANCE.md)
- [Documentação oficial do Git Rebase](https://git-scm.com/docs/git-rebase)

---

**Mantenha o histórico limpo! 🧹**
