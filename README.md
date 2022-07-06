# Rede social em JAVA

Projeto criado para a disciplina de Programação Orientada a Objetos da UFAL.

## Como executar o programa

Para programa funcionar é necessário executar a partir do **"App.java"** e manter os outros arquivos **".java"** na mesma pasta. Assim, eles conseguem se comunicar corretamente. A versão antiga, sem o uso dos padrões e das melhoria no código encontra-se na pasta **old**. Para executá-la será necessário abrir a pasta individualmente da pasta principal do programa.

## Funcionalidades

### Tela prinicipal
Após rodar o programa, o usuário terá *4 opções de escolha* no menu inicial:

- **[1] Criar uma conta**
- **[2] Fazer login**
- **[3] Admin**
- **[-1] Sair**

Ao selecionar a opção **"1"**, ele poderá a criar a conta que usará durante a rede. Nela ele colocará seu nome, um e-mail e uma senha válidos, que serão usados para logar posteriormente. 

### Usuário logado

Após criar sua conta, o usuário terá a opção de logar na rede selecionando a opção **"2"** no menu inicial. Ao fazer isso, será exibido um menu personalizado com as funções que podem ser feitas no perfil inividual para cada uma das contas. Cada usuário terá acesso as seguintes funcionalidades:

- **[1] Editar seu perfil**
> Aqui poderão ser alterados dados como nome, e-mail e senha.
- **[2] Adicionar amigos**
> Aqui poderá ser enviado uma "solicitação" para um usuário que tenha uma conta existente na rede (criada anteriormente).
- **[3] Escrever uma mensagem**
> Aqui é possível enviar uma mensagem pública, aparecendo para todos os usuários no feed ou uma mensagem privada para um outro usuário criado na rede.
- **[4] Criar uma comunidade**
> Aqui pode ser criado uma comunidade com um dono, um nome, uma descrição e membros.
- **[5] Adicionar membros a uma comunidade**
> Aqui um usuário da rede pode ser adicionado a uma comunidade existente.
- **[6] Minhas informacoes**
> Aqui é mostrado as informações atualizadas da conta logada.
- **[7] Visualizar mensagens no feed**
> Aqui é possível ver as mensagens públicas postadas por qualquer usuário, com a identificação de quem escreveu.
- **[8] Remover sua conta**
> Aqui é possível deletar a conta atual da rede.
- **[-1] Sair**
> Selecionando essa opção a conta é deslogada e consequentemente volta ao menu anterior.

### Modo Admin

No menu principal, há ainda a opção **"3"**, que quando selecionada leva o usuário para para a tela de admin, onde é possível administrar e ver o comportamento das contas/comunidades criadas e do chat público.

Para acessar a tela admin será solicitado uma senha para ter acesso as funcionalidades, por padrão, ela está definida para **"1234"**, mas pode ser alterada na **linha 172** da classe **App.java**. No modo admin é possivél realizar as seguinte operações:

- **[1] Mostrar usuarios criados**
- **[2] Mostrar comunidades criadas**
- **[3] Apagar conta de usuario**
- **[4] Recuperar informacoes de um usuario**
- **[5] Adicionar palavra ofensiva**
> Essa opção permite adicionar palavras ofensivas para controle do chat público. Um usuário não conseguirá publicar sua mensagem no feed público se conter uma das palavras adicionadas aqui.
- **[6] Mostrar palavras ofensivas**
- **[-1] Sair**

## Tratamento de exeções e Regras de negócio

As seguintes exceções foram adicionadas/corrigidas:

- Menus não param o programa caso um usuário digite um char ao invés de um número. É exibida a mensagem "Você deve digitar um número!";
- Menus exibem a mensagem "Nenhuma das opções foi escolhida" caso o usúario tente digitar um número que não está dentro dos que podem ser selecionados;
- Ao Criar ou editar um perfil, o nome não pode conter só números. Ao digitar "12345", por exemplo, será exibida a mensagem "Seu nome nao pode ser somente numeros";
- Ao Criar ou editar um perfil, o email deve ser do tipo "exemplo@exemplo.com";
- Ao Criar ou editar um perfil, a senha deve ter pelo menos uma letra, um numero e um caractere especial (@, #, $, %, &, *);
- Em editar perfil: seu e-mail, nome e senha não podem ser igual a última criada anteriormente;
- O amigo que um usuário quiser adicionar deve ser um usuário existente (criado anteriormente);
- Uma mensagem que um usuário tente enviar (pública ou privada) não pode ser um texto em branco;
- Uma mensagem pública não pode conter uma palavra ofensiva (A palavra pode ser adicionada no menu ADMIN);
- Um membro só poderá ser adicionado a uma comunidade caso ele existir;
- A descricao e nome de uma comunidade não pode estar vazia;
- A mensagem "Usuário não encontrado" é exibida caso o um usuário tente adicionar;
- O erro de ao tentar remover a conta do usuário estando logado nela fechar o programa foi corrigido.

## Code Smells e Padrões de projeto

Durante o desenvolvimento do projeto foram aplicados **padrões de projeto** para corrigir alguns **codes smells** que foram deixados passar ao longo da escrita código.

### Vários switches em uma classe (Switch Statements) e uma classe longa (Long Class)

Por antes estar utilizando o switch como forma de seleção para cada uma das funcionalides, o que pode deixar confuso quando há muitos casos associados a números, a classe principal **"App.java"** ficou com muitas linhas, gerando uma classe excessivamente longa. Então, para resolver esses problemas, foi implementado o padrão **Command** nas funcionalidades do usuário logado. Com ele, mais de 400 linhas foram divididas em diferentes arquivos que recebem instruções de uma **interface Command** juntamente com uma classe **Invoker**. Agora, a main "invoca" passando como parametro o número que o usuário digitou. Se por exemplo for colocado a opção **"[1] Editar perfil"**, será chamado o **Invoker** que tem o **"1"** associado a classe **"EditarPerfilCommand"** e então realizada a operação.

### Variáveis e parâmetros criados e nunca utilizados (Speculative Generality)

Durante o desenvolvimento, foram colocados variáveis e parâmetros que foram especulados para serem utilizados de alguma forma para resolver algumas da funcionalidades, mas acabaram por nunca ser utilizados, como por exemplo: as variaveis "isNumeric2", "utemp", "ed" que podem ser vistas dentro dos arquivos da pasta **old**.

### Código duplicado (Duplicade code)

Algumas linhas do código possuiam segmentos muito parecidos, o que podia criar uma ilusão de **códigos duplicados**, por mais que fizessem funções diferentes. Uma maneira melhorar isso, foi utilizar padrão **Extracted Method**, onde um novo método foi criado para relizar as funções iguais e retornar para eles o que precisavam. Um dos lugares que isso foi aplicado foi na classe **"CriarUmaCommunidadeCommand"**, que utiliza um methodo externo para exibir as mensagens de erro caso o nome e a descrição de uma comunidade nao sejam preenchidos corretamente.

### Boas práticas

Além dos padrões mostrados anteriormente, foi aplicado algumas outras práticas para melhorar legibilidade do programa como um todo e para facilitar uma possível manutenção no futuro, entre eles:

- Uso da nomeclatura Uppercase em todas as classes;
- Correção de warnings que poderiam a dar algum erro;
- Uso de comentários que explicam o funcionamento do código;
- Comentários desnecessários foram retirados;
- etc.
