import java.util.Scanner;

public class rede {
    public static void main(String[] args)
    {
        java.util.Scanner input = new Scanner(System.in);
        int c;

        System.out.print("Digite uma opcao: ");
        System.out.print("\n[1] Criar uma Conta\n[2] Editar o Perfil\n[3] Adicionar Amigos\n[4] Enviar uma mensagem\n[5] Criar uma comunidade\n[6] Membros\n[7] Recuperar informacoes\n[8] Remover uma Conta\n[9] Enviar mensagens no feed de noticias\n[10] Visualzar mensagns no feed\n");
        c = input.nextInt();

        switch(c)
        {
          case 1:

          String nome, login, senha;

          System.out.print("Digite o seu nome: ");
          nome = input.next();

          System.out.print("Crie seu login: ");
          login = input.next();

          System.out.print("Crie uma senha: ");
          senha = input.next();

          conta c1 = new conta();

          c1.adicionar(nome, login, senha);
          break;

          case 2:

          String logine, senhae;

          System.out.printf("Digite seu login: ");
          logine = input.next();

          System.out.printf("Digite sua senha: ");
          senhae = input.next();

          conta ce = new conta();

          ce.editar(logine, senhae);
          break;
          
          //case 3:
          //case 4:
          //case 5:
          //case 6:
          //case 7:

          case 8:
            
            String loginr, senhar;
            int e;

            System.out.printf("Digite seu login: ");
            loginr = input.next();

            System.out.printf("Digite sua senha: ");
            senhar = input.next();

            System.out.printf("Tem certeza que deseja excluir a sua conta? [1] SIM\n[2] NAO");
            e = input.nextInt();

              if(e == 1)
              {
                conta cr = new conta();
                cr.remover(loginr, senhar);
              }
              else
              {
                return;
              }
          break;

          //case 9:
          //case 10:
          
          default:
            System.out.printf("Nenhuma das opcoes foi escolhida.\n");
          break;
        }
    }
}