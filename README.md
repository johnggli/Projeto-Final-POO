<h1 align="center">Projeto Final POO 2018.2</h1>
## Listanime
![ic_listanime](https://user-images.githubusercontent.com/43749971/52528344-77af6280-2cbb-11e9-8b18-e811b58a3c74.png)

Trata-se de um aplicativo cuja função é servir como ferramenta para listagem e acompanhamento de animes.
## Classes Modelo
- **Usuário**
  - Atributos
    - nome;
    - email;
    - senha;
    - lista de animes;
    - lista de tops;
    - logado.
  - Métodos
    - adicionar anime;
    - remover anime;
    - adicionar top;
    - remover top;
    - getters e setters.
- **Anime**
  - Atributos
    - título;
    - estúdio;
    - status;
    - diretor;
    - descrição;
    - ano de exibição;
    - episódios totais;
    - episódios assistidos;
    - pontuação;
    - lista de anotações;
    - favorito.
  - Métodos
    - adicionar anotação;
    - remover anotação;
    - getters e setters.
- **Anotação**
  - Atributos
    - texto anotação;
    - data da anotação.
  - Métodos
    - getters e setters.
- **Top**
  - Atributos
    - título do top;
    - lista de animes do top.
  - Métodos
    - adicionar anime ao top;
    - remover anime do top;
    - getters e setters.
## Relacionamentos
Um Usuário possui um ou vários Animes (que por sua vez possuem uma ou várias Anotações) e um ou vários Tops (que possuem um ou vários Animes).
## Persistência de dados
ObjectBox.
## Diagrama de Classe simplificado
![diagrama de classe simplificado](https://user-images.githubusercontent.com/43749971/52528425-0c669000-2cbd-11e9-8b31-9ce131616a67.png)
## Funcionalidades
- Cadastrar novo usuário ou entrar em uma conta já existente;
- Adicionar anime de forma simplificada (informando apenas título, estúdio, ano de exibição e quantidade total de episódios);
- Incluir informações adicionais ao anime (status, diretor, descrição, quantidade de episódios assistidos e nota avaliativa);
- Favoritar, editar ou excluir anime;
- Adicionar, editar ou excluir anotações sobre o anime;
- Visualizar o número de animes, bem como a quantidade de animes por status (Assistindo, Concluído, Pretendo assistir ou Descartado);
- Criar Tops de animes, sendo editável, podendo adicionar animes ou excluí-lo;
- Editar informações de conta do usuário;
- Encerrar sessão de usuário.
## Requisitos e Restrições
- Aplicativo desenvolvido utilizando linguagem de programação Java;
- Compatível com smartphones e tablets de API 15: Android 4.0.3 ou superior.
## Storyboard de navegação do aplicativo
![storyboard](https://user-images.githubusercontent.com/43749971/52529194-90744400-2ccc-11e9-8735-e032f382dd16.png)

## Telas iniciais
![screenshot_20190209-212159](https://user-images.githubusercontent.com/43749971/52529417-29588e80-2cd0-11e9-8811-2aea26f45e72.png)
![screenshot_20190209-212201](https://user-images.githubusercontent.com/43749971/52529419-2a89bb80-2cd0-11e9-9733-333290de49f5.png)

## Entrar ou Cadastrar
![screenshot_20190209-212208](https://user-images.githubusercontent.com/43749971/52529433-6290fe80-2cd0-11e9-9f8a-e985ab6d01d3.png)
![screenshot_20190209-212214](https://user-images.githubusercontent.com/43749971/52529434-63299500-2cd0-11e9-9c59-2ea02ca2f2d3.png)

## Fragments do Main
![screenshot_20190209-214748](https://user-images.githubusercontent.com/43749971/52529437-72104780-2cd0-11e9-8750-9ea90671b7f8.png)
![screenshot_20190209-214755](https://user-images.githubusercontent.com/43749971/52529439-72a8de00-2cd0-11e9-93b0-4922756a610f.png)
![screenshot_20190209-214759](https://user-images.githubusercontent.com/43749971/52529440-73417480-2cd0-11e9-80c0-e31693b991d9.png)
## Menu Lateral
![screenshot_20190209-214829](https://user-images.githubusercontent.com/43749971/52529443-7fc5cd00-2cd0-11e9-8146-c782e7fe14d9.png)
## Editar anime ou ir para Anotações
![screenshot_20190209-214949](https://user-images.githubusercontent.com/43749971/52529448-894f3500-2cd0-11e9-9898-6978764ee2d7.png)
## Adicionar, editar ou remover anime
- Adicionar anime

![screenshot_20190209-212324](https://user-images.githubusercontent.com/43749971/52529455-9b30d800-2cd0-11e9-9626-8129a50160e2.png)
![screenshot_20190209-212331](https://user-images.githubusercontent.com/43749971/52529456-9c620500-2cd0-11e9-8512-9f6c805b7eb3.png)
- Editar e excluir anime

![screenshot_20190209-214957](https://user-images.githubusercontent.com/43749971/52529464-b3085c00-2cd0-11e9-94b3-de3fac9e6ed8.png)
![screenshot_20190209-215002](https://user-images.githubusercontent.com/43749971/52529466-b3a0f280-2cd0-11e9-88c5-08629d953551.png)
![screenshot_20190209-215015](https://user-images.githubusercontent.com/43749971/52529467-b4d21f80-2cd0-11e9-8123-5b283ab32445.png)
![screenshot_20190209-215019](https://user-images.githubusercontent.com/43749971/52529470-bd2a5a80-2cd0-11e9-8423-19ab8e4cfce0.png)
## Adicionar, editar ou excluir Anotação
![screenshot_20190209-215436](https://user-images.githubusercontent.com/43749971/52529481-d9c69280-2cd0-11e9-8755-85ad052ddc08.png)
![screenshot_20190209-215441](https://user-images.githubusercontent.com/43749971/52529482-db905600-2cd0-11e9-88b9-9ece4fcf236c.png)
![screenshot_20190209-215456](https://user-images.githubusercontent.com/43749971/52529483-dcc18300-2cd0-11e9-8da0-2428ebadbe57.png)
## Meus números
![screenshot_20190209-214844](https://user-images.githubusercontent.com/43749971/52529485-e8ad4500-2cd0-11e9-9289-e49a9522e283.png)
## Adicionar, editar ou remover Top
![screenshot_20190209-215612](https://user-images.githubusercontent.com/43749971/52529492-fcf14200-2cd0-11e9-8fce-7f55f9077b20.png)
![screenshot_20190209-215515](https://user-images.githubusercontent.com/43749971/52529493-fd89d880-2cd0-11e9-9741-a7872f1d8fa0.png)
![screenshot_20190209-215627](https://user-images.githubusercontent.com/43749971/52529494-ff539c00-2cd0-11e9-8818-bcbadae7db32.png)
![screenshot_20190209-215631](https://user-images.githubusercontent.com/43749971/52529495-ffec3280-2cd0-11e9-8ee0-c5ac9d705ef3.png)
![screenshot_20190209-215636](https://user-images.githubusercontent.com/43749971/52529497-01b5f600-2cd1-11e9-8419-8fb0faaf68c2.png)
![screenshot_20190209-215651](https://user-images.githubusercontent.com/43749971/52529498-024e8c80-2cd1-11e9-9826-eb51679f1e41.png)
## Pretendo assistir
![screenshot_20190209-215705](https://user-images.githubusercontent.com/43749971/52529500-0ed2e500-2cd1-11e9-9275-c83bcc2bdbf0.png)
## Descartados
![screenshot_20190209-215711](https://user-images.githubusercontent.com/43749971/52529502-10041200-2cd1-11e9-8787-ba95c220706a.png)
## Configurações
![screenshot_20190209-215719](https://user-images.githubusercontent.com/43749971/52529503-11353f00-2cd1-11e9-965a-49e3e37decef.png)
