# Rede social em JAVA

Projeto criado para a disciplina de Programação Orientada a Objetos da UFAL.

## Como executar e funcionalidades

Para executar o programa é necessário excutar o arquivo att/App.java, e manter os outros arquivos na mesma pasta.

O Menu admin pode ser acessado com a senha "1234"

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

Os code smells encontrados e os métodos que utilizados para corrigidos foram:

- Variáveis não utilizadas;
- Parâmetros passados e não utilizados;
- Comentários desnecessários;
- Lista longa de parâmetros em uma classe;
- Classe Main muito grande
- Vários switchs e ifs nos menus de escolha (Switch Statements);

Switch Statements, Long Class

Por ter várias funcionalidades utilizando o switch, classe principal 

Speculative Generality

Durante o desenvolvimento, foram colocados variáveis e parâmetros, que foram especulados para serem utilizados durante o desenvolvimento de alguma. 
Como por exemplo: "isNumeric2" (Linha x), "utemp" (linhas x, y e z), "ed" (linha x)

Além disso, foi aplicado outras práticas para melhorar o programa como todo, são elas:

A nomeclatura Uppercase foi usada em todas as classes;
Todos os warnings foram corrigidos;

