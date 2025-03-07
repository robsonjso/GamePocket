# 🎮 GamePocket

GamePocket é um aplicativo Android para consulta e gerenciamento de jogos favoritos, consumindo a API da RAWG.io. O projeto possui uma arquitetura modular, incluindo integração com banco de dados local Room e comunicação via Retrofit.

## 📱 Funcionalidades

- Tela inicial com listagem de jogos populares.
- Pesquisa de jogos por nome.
- Detalhes completos de cada jogo, incluindo descrição, imagem e data de lançamento.
- Lista de jogos recomendados dentro da tela de detalhes.
- Salvamento de jogos favoritos no banco de dados local (Room).
- Visualização da lista de favoritos.
- Navegação entre telas utilizando `Navigation Component`.

---

## 🛠️ Tecnologias e Bibliotecas Utilizadas

- **Linguagem:** Kotlin
- **Arquitetura:** MVVM (Model - View - ViewModel)
- **Networking:** Retrofit + Gson
- **Banco de Dados:** Room Database
- **Coroutines & Flow:** Para operações assíncronas e reatividade.
- **Navigation Component:** Para gerenciamento da navegação.
- **ViewBinding:** Para manipulação das views.
- **Glide:** Para carregamento de imagens.
- **Material Design 3:** Para componentes visuais modernos.

---

## 🌐 API Utilizada

- [RAWG.io](https://api.rawg.io/docs/) - Plataforma de dados de jogos.

Endpoints implementados:
- `GET /games` - Listagem de jogos
- `GET /games/{id}` - Detalhes de um jogo específico
- `GET /games/{id}/suggested` - Lista de jogos recomendados

---

## ✅ O Que Já Foi Feito

### Conexão com a API
- Retrofit configurado e testado.
- Endpoints de listagem, detalhes e recomendados integrados.
- Suporte a parâmetros de busca e ordenação.
- Log detalhado no Logcat para debug.

### Banco de Dados Local (Room)
- Criação do banco de dados local.
- Entidade de jogos favoritos configurada.
- DAO com métodos de inserção, remoção e listagem.
- Integração do repositório com Room.

### Fragments e ViewModels
- **HomeFragment:** Lista de jogos populares.
- **SearchFragment:** Busca de jogos via API.
- **DetailFragment:** Detalhes completos do jogo e jogos recomendados.
- **FavoriteFragment:** Listagem de jogos favoritos armazenados localmente.

### Adapters e UI
- RecyclerView com adapter configurado.
- ViewBinding para manipulação de views.
- Glide para carregamento de imagens.
- Botão de favoritar usando `IconToggleButton` (Compose no futuro).

### Navegação
- `Navigation Component` configurado com `nav_graph.xml`.
- Fluxo completo: Home ➜ Detalhe ➜ Favoritar ➜ Lista de Favoritos.

---

## 🚀 Próximos Passos (Para o Time)

- **Melhorar UI/UX:**
    - Aplicar Material Design 3 completo.
    - Criar telas responsivas para tablets.
    - Implementar animações e transições.

- **Tratamento de Erros:**
    - Criar telas de erro (ex: sem internet, erro 404).
    - Adicionar loading (Shimmer ou ProgressBar).

- **Paginação:**
    - Implementar paginação infinita na Home e Busca.

- **Favoritos:**
    - Adicionar feedback visual (Snackbar ou Toast) ao favoritar/desfavoritar.

- **Testes:**
    - Criar testes unitários para ViewModels e Repository.
    - Criar testes instrumentados para fluxo completo.

- **Refinamento de Código:**
    - Criar uma camada de `UiState` para gerenciar estados (Loading, Success, Error).
    - Revisar logs e remover excessos.

---

## ⚠️ Observações Importantes

- A chave da API (`Constants.API_KEY`) deve ser protegida. Sugere-se migrar para uma solução segura no futuro (exemplo: Remote Config ou Keystore).
- O projeto já está funcional para continuar o desenvolvimento a partir da UI.

---

## 📚 Referências

- [Documentação RAWG.io](https://api.rawg.io/docs/)
- [Arquitetura MVVM com Flow](https://developer.android.com/kotlin/flow)
- [Guia de Material Design 3](https://m3.material.io)

---

## 🧑‍💻 Desenvolvido por

Equipe 3 HackSprint DevSpace, iniciado por [Robson Santos, Francisco Cleonis, Elieudo Silva, Geovâneo dos Santos Souza].

---

## 📦 Requisitos de Ambiente

- Android Studio Flamingo ou superior
- Kotlin 1.8+
- MinSDK 24
- TargetSDK 34
- Emulador ou dispositivo físico com internet

---

## 🏁 Como Executar

```bash
git clone <repositorio>
cd GamePocket
./gradlew assembleDebug
