import java.util.ArrayList;
import java.util.Scanner;

public class app {
    public static void main(String[] args)
    {
        int opcao;
        String nome, login, senha;

        Scanner teclado = new Scanner(System.in);
        ArrayList<conta> contas = new ArrayList<>();
        ArrayList<comunidade> comunidades = new ArrayList<>();
        ArrayList<feed> feeds = new ArrayList<>();


        do{
          System.out.print("\n===== MENU =====\nDigite uma opcao:\n");
          System.out.print("\n[1] Criar uma Conta\n[2] Editar um Perfil\n[3] Adicionar Amigos\n[4] Enviar uma mensagem\n[5] Criar uma comunidade\n[6] Adicionar membros a uma comunidade\n[7] Recuperar informacoes de uma conta\n[8] Remover uma Conta\n[9] Enviar mensagens no feed de noticias\n[10] Visualzar mensagens no feed\n[11] Mostrar Cadastrados\n[12] Mostrar Comunidades\n[-1] Sair\n");
          opcao = teclado.nextInt();
          teclado.nextLine(); 

          switch(opcao){
          
            case -1: //parar o programa
            {
              System.out.printf("Saindo...");
            }
            break;

            case 1: //criar uma conta
            
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

            case 2: //editar um perfil

            System.out.println("\n=== Editar um perfil");

            System.out.print("Digite seu login: ");
            String elogin = teclado.nextLine();
            System.out.print("Digite sua senha: ");
            String esenha = teclado.nextLine();

            for(int i = 0; i < contas.size(); i++)
            {
              conta uTemp = contas.get(i);

              if(elogin.equals(uTemp.getLogin()) && esenha.equals(uTemp.getSenha()))
              {
                int e;
                System.out.println("\nConta encontrada. Que informacao voce quer editar?\n[1]NOME\n[2]LOGIN\n[3]SENHA\n");
                e = teclado.nextInt();
                teclado.nextLine();
                
                switch(e)
                {
                  case 1:
                  String x;
                  System.out.print("Digite seu novo nome: ");
                  x = teclado.nextLine();
                  uTemp.setNome(x);

                  System.out.print("== Nome alterado com sucesso.");
                  break;

                  case 2:
                  String y;
                  System.out.print("Digite seu novo login: ");
                  y = teclado.nextLine();
                  uTemp.setLogin(y);

                  System.out.print("== Login alterado com sucesso.");
                  break;

                  case 3:
                  String z;
                  System.out.print("Digite sua nova senha: ");
                  z = teclado.nextLine();
                  uTemp.setSenha(z);
                  System.out.print("== Senha alterada com sucesso");
                  break;
                }
              }else{
                System.out.println("\nConta nao encontrada.");
                break;
              }

            }
            break;

            case 3: //adicionar amigos

            System.out.println("\n=== Adicionar amigos");
            System.out.print("Digite seu login: ");
            String alogin = teclado.nextLine();

            System.out.print("Digite sua senha: ");
            String asenha = teclado.nextLine();

            for(int i = 0; i < contas.size(); i++)
            {
              conta uTemp = contas.get(i);

              if(alogin.equals(uTemp.getLogin()) && asenha.equals(uTemp.getSenha()))
              {
                String e;
                System.out.print("\nConta encontrada. Digite o usuario que voce quer enviar a mensagem: ");
                e = teclado.nextLine();
                
                System.out.printf("Solicitacao enviada para @%s\n", e);
              }else{
                System.out.println("\nSenha ou e-mail invalidos.");
                break;
              }
            }


            break;
            
            case 4: //enviar mensagens

            System.out.println("\n=== Enviar mensagens");
            System.out.print("Digite seu login: ");
            String enlogin = teclado.nextLine();

            System.out.print("Digite sua senha: ");
            String ensenha = teclado.nextLine();

            for(int i = 0; i < contas.size(); i++)
            {
              conta uTemp = contas.get(i);

              if(enlogin.equals(uTemp.getLogin()) && ensenha.equals(uTemp.getSenha()))
              {
                String e, msg;
                System.out.print("\nConta encontrada. Digite o usuario que voce quer enviar a mensagem: ");
                e = teclado.nextLine();
                
                System.out.println("Digite a mensagem a ser enviada:\n");
                {
                  msg = teclado.nextLine();
                }

                System.out.printf("Mensagem enviada para @%s\n", e);
              }else{
                System.out.println("\nSenha ou e-mail invalidos.");
                break;
              }
            }

            break;
            
            case 5: //criar uma comunidade

            System.out.println("\n=== Criar uma comunidade");
            System.out.print("Digite seu login: ");
            String cmlogin = teclado.nextLine();

            System.out.print("Digite sua senha: ");
            String cmsenha = teclado.nextLine();

            for(int i = 0; i < contas.size(); i++)
            {
              conta uTemp = contas.get(i);

              if(cmlogin.equals(uTemp.getLogin()) && cmsenha.equals(uTemp.getSenha()))
              {
                String nome_comunidade, descricao_comunidade;
                System.out.print("\nConta encontrada. Digite o nome que da comunidade a ser criada: ");
                nome_comunidade = teclado.nextLine();
                
                System.out.println("Escreva uma breve descricao sobre a comunidade:\n");
                
                descricao_comunidade = teclado.nextLine();
                

                comunidade cm = new comunidade();

                cm.adicionar(uTemp.getNome(), nome_comunidade, descricao_comunidade, uTemp.getNome());
                comunidades.add(cm);
                
                }else{
                System.out.println("\nSenha ou e-mail invalidos.");
                }
            }

            break; 
            case 6: //adicionar membros a uma comunidade
            System.out.println("\n=== Adicionar memrbos a uma comunidade");
            System.out.print("Digite o nome da comunidade: ");
            String ncomunidade = teclado.nextLine();

            for(int i = 0; i < comunidades.size(); i++)
            {
              comunidade uTemp = comunidades.get(i);

              if(ncomunidade.equals(uTemp.getNome()))
              {
                String nmembro;
                System.out.print("\nComunidade encontrada. Digite o nome do membro a ser adicionado: ");
                nmembro = teclado.nextLine();

                uTemp.setMembros(nmembro);

                System.out.print("\n=== Membro adicionado");

              }else{
                System.out.println("\nSenha ou e-mail invalidos.");
                break;
              }
            }
            break;

            case 7: //recuperar infomarções

            System.out.println("\n=== Recuperar informacoes de um usuario");
            System.out.print("Digite seu nome: ");
            String recupera = teclado.nextLine();

            for(int i = 0; i < contas.size(); i++)
            {
              conta uTemp = contas.get(i);

              if(recupera.equals(uTemp.getNome())){
                System.out.print("\n== Usuario encontrado!!\n");
                System.out.printf("Dados de %s:\n", recupera);
                System.out.println("Email: " + uTemp.getLogin());
                System.out.println("Senha: " + uTemp.getSenha());
              }
            }

            break;

            case 8: //remover usuario
            System.out.println("\n=== Remover uma conta");

            System.out.print("Digite seu login: ");
            String rlogin = teclado.nextLine();

            System.out.print("Digite sua senha: ");
            String rsenha = teclado.nextLine();

            for(int i = 0; i < contas.size(); i++)
            {
              conta uTemp = contas.get(i);

              if(rlogin.equals(uTemp.getLogin()) && rsenha.equals(uTemp.getSenha()))
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
                System.out.println("\nSenha ou e-mail invalidos.");
                break;
              }
            }
            break;

            case 9: //envio de mensagens no feed
            System.out.println("\n=== Enviar mensagens no feed");
            System.out.print("Digite seu login: ");
            String flogin = teclado.nextLine();

            System.out.print("Digite sua senha: ");
            String fsenha = teclado.nextLine();

            for(int i = 0; i < contas.size(); i++)
            {
              conta uTemp = contas.get(i);

              if(flogin.equals(uTemp.getLogin()) && fsenha.equals(uTemp.getSenha()))
              {
                String post;
                
                System.out.println("No que voce esta pensando?\n");
                
                post = teclado.nextLine();
                
                feed fe = new feed();

                fe.adicionar(uTemp.getLogin(), post);
                feeds.add(fe);
                
                }else{
                System.out.println("\nSenha ou e-mail invalidos.");
                }
            }

            break;
            case 10: //controle de visualizacao do feed
            System.out.println("=== Visualizar feed");
            for(int i = 0; i < feeds.size(); i++){
              
              feed utemp = feeds.get(i);
              System.out.println("\n@"+feeds.get(i).getUser() + "postou: ");
              System.out.println(feeds.get(i).getTexto());
            }

            break;

            case 11:
            System.out.println("=== Lista de Usuarios cadastrados:");
            for(int i = 0; i < contas.size(); i++){
              
              conta utemp = contas.get(i);
              System.out.println("\nUsuario " + i);
              System.out.println("Nome: " + contas.get(i).getNome());
              System.out.println("Login: " + contas.get(i).getLogin());
              System.out.println("Senha: " + contas.get(i).getSenha());
            }
            break;
          
            case 12:
            System.out.println("=== Lista de comunidades criadas:");
            for(int i = 0; i < comunidades.size(); i++){
              
              comunidade utemp = comunidades.get(i);
              System.out.println("Dono: " + comunidades.get(i).getDono());
              System.out.println("Nome: " + comunidades.get(i).getNome());
              System.out.println("Descricao: " + comunidades.get(i).getDescricao());
              System.out.println("Membros: " + comunidades.get(i).getMembros());
            }
            break;

            default:
              System.out.printf("Nenhuma das opcoes foi escolhida.\n");
            break;
    
        }
      }while(opcao!=-1);
      }
    }
