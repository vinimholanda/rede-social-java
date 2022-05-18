// MELHORIAS: InputMismatchException, IndexOutOfBoundsException
// Senha para acesso no modo admin: 1234 (pode ser alterada na linha 276).

//Algumas ideias: Alterar criar uma conta email(o email nao pode ser um numero)
//Alterar criar uma conta email(o email nao pode ser um numero)

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;

public class bckp {
    public static void main(String[] args)
    {
        int opcao;
        String nome, login, senha;

        Scanner teclado = new Scanner(System.in);
        ArrayList<conta> contas = new ArrayList<>();
        ArrayList<comunidade> comunidades = new ArrayList<>();
        ArrayList<feed> feeds = new ArrayList<>();

        try {
            
            do{
                System.out.print("\n===== A rede social =====\nDigite uma opcao:\n");
                System.out.print("\n[1] Fazer login\n[2] Criar uma conta\n[3] Admin\n[-1] Sair\n");
                opcao = teclado.nextInt();
                teclado.nextLine(); 
                int cont = 0; //contador para exibir se a conta existe não, ele é reiniciado toda vez que um usuario desloga
      
                switch(opcao){
                
                  case -1: //parar o programa
                  {
                    System.out.printf("Saindo...");
                  }
                  break;
      
                  case 1: //logar
                  System.out.print("Digite seu login: ");
                  String elogin = teclado.nextLine();
                  System.out.print("Digite sua senha: ");
                  String esenha = teclado.nextLine();
      
                  for(int i = 0; i < contas.size(); i++)
                  {
                    conta uTemp = contas.get(i);
      
                    if(elogin.equals(uTemp.getLogin()) && esenha.equals(uTemp.getSenha()))//logado
                    {
                      int opcao2 = 0;
                      do{
                          System.out.println("\n============\nOla, " + contas.get(i).getNome() + "!");
                          System.out.print("\nDigite uma opcao: \n[1] Editar seu perfil\n[2] Adicionar amigos\n[3] Escrever uma mensagem\n[4] Criar uma comunidade\n[5] Adicionar membros a uma comunidade\n[6] Minhas informacoes\n[7] Visualizar mensagens no feed\n[8] Remover sua conta\n[-1] Sair\n");
                          opcao2 = teclado.nextInt();
                          teclado.nextLine();
                          cont = cont + 1;
                          
      
                          switch(opcao2){ // ESCOLHA DO USUARIO LOGADO
                              case -1:
                              System.out.println("Saindo...");
                              break;
      
                              case 1: //editar perfil
                                  System.out.println("\nQue informacao voce quer editar?\n[1]NOME\n[2]LOGIN\n[3]SENHA\n[-1]SAIR\n");
                                  int e = teclado.nextInt();
                                  teclado.nextLine();
                                  switch(e){
                                    case 1:
                                    System.out.print("Digite seu novo nome: ");
                                    String x = teclado.nextLine();
                                    uTemp.setNome(x);
    
                                    System.out.print("== Nome alterado com sucesso.");
                                    break;
    
                                    case 2:
                                    System.out.print("Digite seu novo login: ");
                                    String y = teclado.nextLine();
                                    uTemp.setLogin(y);
    
                                    System.out.print("== Login alterado com sucesso.");
                                    break;
    
                                    case 3:
                                    System.out.print("Digite sua nova senha: ");
                                    String z = teclado.nextLine();
                                    uTemp.setSenha(z);
                                    System.out.print("== Senha alterada com sucesso");
                                    break;
                                
                                    case -1:
                                    System.out.println("Processo cancelado");
                                    break;
                                
                                    default: 
                                    System.out.println("Nenhuma das opcoes foi escolhida.");
                                    break;
                                }
                                  
                              break;
      
                              case 2: //adicionar amigos
                              String ed;
                              int zcont = 0;
                              System.out.print("\nDigite o usuario que voce quer enviar a solicitacao: ");
                              String zed = teclado.nextLine();
      
                                  for(int z = 0; z < contas.size(); z++)
                                  {
                                  conta zedTemp = contas.get(z);
      
                                  if(zed.equals(zedTemp.getNome())){
                                      zcont = 1;
                                      System.out.printf("Solicitacao enviada para @%s\n", zed);
                                      break;
                                  }}
      
                                  if(zcont == 0){
                                      System.out.println("\nUsuario nao encontrado.");
                                  }
                                  
                              break;
      
                              case 3: //enviar uma mensagem
                              System.out.println("\nQual o tipo de mensagem que voce quer enviar?\n[1] Privada\n[2] Publica");
                              int choice = teclado.nextInt();
                              teclado.nextLine();
                              int zzcont = 0;
      
                              if(choice == 1){
                                  System.out.println("Digite o usuario que recebera a mensagem:");
                                  String usu1 = teclado.nextLine();
      
                                  for(int zz = 0; zz < contas.size(); zz++)
                                  {
                                  conta zzedTemp = contas.get(zz);
      
                                  if(usu1.equals(zzedTemp.getNome())){
                                      zzcont = 1;
                                      System.out.printf("\nDigite que a mensagem para @%s\n", usu1);
                                      String mensag = teclado.nextLine();
      
                                      System.out.print("\nMensagem enviada.\n");
                                      break;
                                  }}
      
                                  if(zzcont == 0){
                                      System.out.println("\nUsuario nao encontrado.");
                                  }
      
                                  break;
      
                              }else if(choice == 2){
                                  String post;
                      
                                  System.out.println("No que voce esta pensando?\n");
                                  post = teclado.nextLine();
                      
                                  feed fe = new feed();
      
                                  fe.adicionar(uTemp.getLogin(), post);
                                  feeds.add(fe);
      
                              }else{
                                  System.out.println("\nEscolha uma alternativa valida!");
                              }
                              break;
      
                              case 4: //criar uma comunidade
                                  String nome_comunidade, descricao_comunidade;
                                  System.out.print("Digite o nome que da comunidade a ser criada: ");
                                  nome_comunidade = teclado.nextLine();
                      
                                  System.out.println("Escreva uma breve descricao sobre a comunidade:\n");
                                  descricao_comunidade = teclado.nextLine();
                      
                                  comunidade cm = new comunidade();
      
                                  cm.adicionar(uTemp.getNome(), nome_comunidade, descricao_comunidade, uTemp.getNome());
                                  comunidades.add(cm);
                              break;
      
                              case 5: //adicionar membros a uma comunidade
                              int contcomunidade = 0;
                              System.out.println("\n=== Adicionar memrbos a uma comunidade");
                              System.out.print("Digite o nome da comunidade: ");
                              String ncomunidade = teclado.nextLine();
                              
      
                              for(int ii = 0; ii < comunidades.size(); ii++)
                              {
                              comunidade iTemp = comunidades.get(ii);
      
                              if(ncomunidade.equals(iTemp.getNome()))
                              {
                                  String nmembro;
                                  contcomunidade = 1;
                                  System.out.print("\nComunidade encontrada. Digite o nome do membro a ser adicionado: ");
                                  nmembro = teclado.nextLine();
      
                                  iTemp.setMembros(nmembro);
      
                                  System.out.print("\n=== Membro adicionado");
                                  break;
                              }}
                              if(contcomunidade == 0){
                                  System.out.println("\nComunidade nao encontrada.");
                              }
                              break;
      
                              case 6: //Minhas informacoes da conta
                              System.out.println("\n== Seus dados atuais:");
                              System.out.println("Nome: " + uTemp.getNome());
                              System.out.println("Email: " + uTemp.getLogin());
                              System.out.println("Senha: " + uTemp.getSenha());
                              System.out.println("Para alterar qualquer dado use a funcao editar perfil quando logado na rede.");
                              break;
      
                              case 7: //visualizar mensagens no feed
                              System.out.println("=== Visualizar feed");
                              for(int r = 0; r < feeds.size(); r++){
                    
                              feed utemp = feeds.get(r);
                              System.out.println("\n@"+feeds.get(r).getUser() + " postou: ");
                              System.out.println(feeds.get(r).getTexto());
                              }
                              break;
      
                              case 8: //remover conta
      
                                try {
                                    System.out.println("Digite sua senha novamente:");
                                  String rsenha = teclado.nextLine();
      
                                  if(rsenha.equals(uTemp.getSenha())){
                                      System.out.print("\nSenha confere. Tem certeza que quer remover sua conta?\n[1]SIM\n[2]NAO\n");
                                      int ee = teclado.nextInt();
                          
                                      if(ee == 1){
                                          contas.remove(i);
                                          System.out.println("Conta removida!\nEncerrando a rede...");
                                          break;
                                      }else{
                                          System.out.println("Sua conta nao foi removida.");
                                          break;
                                          }
                                  }else{
                                      System.out.println("Senha incorreta.");
                                  }
                                } catch (IndexOutOfBoundsException ee) {
                                    System.out.println("Conta encerrada.");
                                }

                              break;
      
                              default:
                                  System.out.println("Nenhuma das opcoes foi selecionada.");
                              break;
                          }
      
                      }while(opcao2!=-1);
                       
                    }
                  }
                  
                  if(cont == 0){
                      System.out.println("\nConta nao encontrada! Verifique se o login e senha estao corretos.");
                  }
                  break;
      
                  case 2: //criar
      
                  System.out.println("=== Bem-Vindo! ===");
                  System.out.print("Digite o seu nome: ");
                  nome = teclado.nextLine();
                  System.out.print("Crie seu login: ");
                  login = teclado.nextLine();
                  System.out.print("Crie uma senha: ");
                  senha = teclado.nextLine();
      
                  conta c = new conta();
      
                  c.adicionar(nome, login, senha);
                  contas.add(c);
      
                  break;
      
                  case 3: //admin 
      
                  String senha_padrao = "1234";
                  int opcao3;
                  System.out.print("Digite a senha de admin:\n");
                  String asenha = teclado.nextLine();
      
                  do{
                      if(asenha.equals(senha_padrao)){
                          do{
                          System.out.println("\n==== Modo admin\nDigite uma opcao:\n[1] Mostrar usuarios criados\n[2] Mostrar comunidades criadas\n[3] Apagar conta de usuario\n[4] Recuperar informacoes de um usuario\n[-1] Sair");
                          opcao3 = teclado.nextInt();
                          teclado.nextLine();
                          
                          switch(opcao3){
                              case -1:
                                  System.out.println("Saindo...");
                              break;
      
                              case 1:
                                  System.out.println("=== Lista de Usuarios cadastrados:");
                                  for(int i = 0; i < contas.size(); i++){
                                
                                      conta utemp = contas.get(i);
                                      System.out.println("\nUsuario " + i);
                                      System.out.println("Nome: " + contas.get(i).getNome());
                                      System.out.println("Login: " + contas.get(i).getLogin());
                                      System.out.println("Senha: " + contas.get(i).getSenha());
                                  }
                              break;
                              case 2:
                                  System.out.println("=== Lista de comunidades criadas:");
                                  for(int i = 0; i < comunidades.size(); i++){
                    
                                      comunidade utemp = comunidades.get(i);
                                      System.out.println("Dono: " + comunidades.get(i).getDono());
                                      System.out.println("Nome: " + comunidades.get(i).getNome());
                                      System.out.println("Descricao: " + comunidades.get(i).getDescricao());
                                      System.out.println("Membros: " + comunidades.get(i).getMembros());
                                  }
                              break;
                              
                              case 3:
                              System.out.println("=== Apagar um usuario");
                              System.out.print("Digite o nome do usuario:\n");
                              String rnome = teclado.nextLine();
      
                              for(int i = 0; i < contas.size(); i++)
                              {
                              conta uTemp = contas.get(i);
      
                              if(rnome.equals(uTemp.getNome()))
                              {
                                  int e;
                                  System.out.print("\nConta encontrada. Voce tem certeza que quer remover sua conta?\n[1]SIM\n[2]NAO\n");
                                  e = teclado.nextInt();
                      
                                  if(e == 1){
                                  contas.remove(i);
                                  System.out.println("\n== Conta removida!");
                                  }else{
                                  break;
                                  }
                                  
                              }else{
                              System.out.println("\nUsuario nao encontrado.");}}
                              break;
      
                              case 4:
                              System.out.println("== Recuperar infomacoes de um usuario");
                              System.out.print("Digite o nome do usuario: ");
                              String recupera = teclado.nextLine();
      
                              for(int i = 0; i < contas.size(); i++)
                              {
                                  conta uTemp = contas.get(i);
      
                                  if(recupera.equals(uTemp.getNome())){
                                      System.out.print("\n== Usuario encontrado!!\n");
                                      System.out.printf("Dados de %s:\n", recupera);
                                      System.out.println("Email: " + uTemp.getLogin());
                                      System.out.println("Senha: " + uTemp.getSenha());
                                  }else{
                                      System.out.println("\nUsuario nao encontrado.");
                                  }
                              }
                              break;
      
                              /*case 5: //alterar senha de admin
                              System.out.println("Digite a senha atual novamente: ");
                              int vsenha = teclado.nextInt();
                              teclado.nextLine();
                              if(vsenha == senha_padrao){
                                  System.out.println("Digite a nova senha: (Deve ser uma sequencia de numeros inteiro)");
                                  int aux = teclado.nextInt();
                                  teclado.nextLine();
                                  senha_padrao = aux;
                                  break;
                              }else{
                                  System.out.println("Senha incorreta");
                              }
                              break;*/
      
                              default:
                              System.out.println("Nenhuma das opcoes foi escolhida");
                              break;
                          }
                          
                  }while(opcao3!=-1);
                  break;
                          
                      }else{
                          System.out.println("Senha incorreta.");
                          break;
                      }
                  }while(asenha!=senha_padrao);
                  break;
      
                  default:
                    System.out.printf("\nNenhuma das opcoes foi escolhida.\n");//Nenhuma escolha no menu principal
                  break;
              }
                  }while(opcao!=-1);

        } catch (InputMismatchException e) {
            System.out.print("Você deve digitar um numero!\nPrograma encerrando...");
        }
        
    }
}