import java.util.*;

public class App {
    public static void main(String[] args)
    {
        int opcao, auxparar = 0, auxparar2 = 0;
        boolean parar = false;
        String nome, login, senha;
        
        Scanner teclado = new Scanner(System.in);
        
        ArrayList<Conta> contas = new ArrayList<>();
        ArrayList<Comunidade> comunidades = new ArrayList<>();
        ArrayList<Feed> feeds = new ArrayList<>();
        ArrayList<Palavra> palavras = new ArrayList<>();

        while(parar == false){
            try {

                if(auxparar == 1){//resolver bug do usuario fechar conta enquanto logado
                    contas.remove(auxparar2);
                }
                
                
                System.out.print("\n===== A rede social =====\nDigite uma opcao:\n");
                System.out.print("\n[1] Criar uma conta\n[2] Fazer login\n[3] Admin\n[-1] Sair\n");
                opcao = teclado.nextInt();
                teclado.nextLine(); 
                int cont = 0; //contador para exibir se a conta existe não, ele é reiniciado toda vez que um usuario desloga
    
                switch(opcao){
                
                    case -1: //parar o programa
                    {
                    System.out.printf("Encerrando...");
                    parar = true;
                    break;
                    }

                    case 1: //criar uma conta (main)
    
                    System.out.println("=== Bem-Vindo! ===");
                    
                    while(true){

                        System.out.print("Digite o seu nome: ");
                        nome = teclado.nextLine();

                        boolean isNumeric = nome.chars().allMatch( Character::isDigit );

                        if (isNumeric) {
                            System.out.println("\n(!) Seu nome nao pode ser somente numeros\n");
                            continue;
                        } else {
                            break;
                        }
                    }

                    while(true){

                        System.out.print("Crie seu login: ");
                        login = teclado.nextLine();

                        if (login.contains("@") && login.contains(".")) {
                            break;
                        } else {
                            System.out.println("\n(!) Digite um e-mail do tipo exemplo@exemplo.com\n");
                        }
                    }

                    while(true){
                        System.out.print("Crie uma senha: ");
                        senha = teclado.nextLine();
                        
                        if((senha.contains("@") || senha.contains("#") || senha.contains("$") || senha.contains("%") || senha.contains("&") || senha.contains("*"))){
                            
                            if ((senha.contains("1") || senha.contains("2") || senha.contains("3") || senha.contains("4") || senha.contains("5") || senha.contains("6") || senha.contains("7") || senha.contains("8") || senha.contains("9"))) {
                                break;
                            } else {
                                System.out.println("\n(!) Sua senha deve conter no minimo 1 numero e 1 caractere especial (@, #, $, %, &, *)\n");
                            }

                        }else{
                            System.out.println("\n(!) Sua senha deve conter no minimo 1 numero e 1 caractere especial (@, #, $, %, &, *)\n");
                        }
                    }
    
                    Conta c = new Conta();
    
                    c.adicionar(nome, login, senha);
                    contas.add(c);
    
                    break;
    
                    case 2: //Fazer login
                    System.out.print("Digite seu login: ");
                    String elogin = teclado.nextLine();
                    System.out.print("Digite sua senha: ");
                    String esenha = teclado.nextLine();
    
                    for(int i = 0; i < contas.size(); i++)
                    {
                    Conta uTemp = contas.get(i);
    
                    if(elogin.equals(uTemp.getLogin()) && esenha.equals(uTemp.getSenha()))//logado
                    {
                        int opcao2 = 0;
                        boolean parar2 = false;
                        
                        while(parar2 == false){

                            try {
                                System.out.println("\n============\nOla, " + contas.get(i).getNome() + "!");
                                System.out.print("\nDigite uma opcao: \n[1] Editar seu perfil\n[2] Adicionar amigos\n[3] Escrever uma mensagem\n[4] Criar uma comunidade\n[5] Adicionar membros a uma comunidade\n[6] Minhas informacoes\n[7] Visualizar mensagens no feed\n[8] Remover sua conta\n[-1] Sair\n");
                                opcao2 = teclado.nextInt();
                                teclado.nextLine();
                                cont = cont + 1;

                                if(opcao2 == -1){
                                    System.out.println("Saindo...");
                                    parar2 = true;
                                }else if(opcao2 == 8){
                                    System.out.println("Digite sua senha novamente:");
                                    String rsenha = teclado.nextLine();
                                    
                                            if(rsenha.equals(uTemp.getSenha())){
                                                System.out.print("\nSenha confere. Tem certeza que quer remover sua conta?\n[1]SIM\n[2]NAO\n");
                                                int ee = teclado.nextInt();
                                                                    
                                            if(ee == 1){
                                                System.out.println("Conta removida!");
                                                auxparar = 1;
                                                auxparar2 = i;
                                                parar2 = true;
                                                break;
                                            }else{
                                                System.out.println("Sua conta nao foi removida.");
                                                break;
                                            }
                                            }else{
                                                System.out.println("Senha incorreta.");
                                            }
                                }else{
                                    Invoker.invoke(opcao2, uTemp, contas, palavras, feeds, comunidades);
                                }
  
                            } catch (InputMismatchException e_userlogado) {
                                System.err.println("\nVocê deve digitar um numero.");
                                teclado.nextLine();// limpar input anterior
                                continue;

                            } catch (java.lang.NullPointerException e_userlogado){
                                System.err.println("\nNenhuma das opções foi escolhida.");
                                //teclado.nextLine();// limpar input anterior
                                continue;
                            }
                            catch (java.util.NoSuchElementException e_userlogado){
                                teclado.nextLine();// limpar input anterior
                                continue;
                            }
                        }   
                    }
                    }
                    
                    if(cont == 0){
                        System.out.println("\nConta nao encontrada! Verifique se o login e senha estao corretos.");
                    }
                    break;
    
                    case 3: //ADMIN (TELA PRINCIPAL) 
    
                    String senha_padrao = "1234";
                    int opcao3;
                    System.out.print("Digite a senha de admin:\n");
                    String asenha = teclado.nextLine();
    
                    do{
                        try {
                            
                            if(asenha.equals(senha_padrao)){
                                do{
                                System.out.println("\n==== Modo admin\nDigite uma opcao:\n[1] Mostrar usuarios criados\n[2] Mostrar comunidades criadas\n[3] Apagar conta de usuario\n[4] Recuperar informacoes de um usuario\n[5] Adicionar palavra ofensiva\n[6] Mostrar palavras ofensivas\n[-1] Sair");
                                opcao3 = teclado.nextInt();
                                teclado.nextLine();
                                
                                switch(opcao3){
                                        case -1:
                                            System.out.println("Saindo...");
                                        break;
            
                                        case 1:
                                            System.out.println("=== Lista de Usuarios cadastrados:");
                                            for(int i = 0; i < contas.size(); i++){
                                        
                                                System.out.println("\nUsuario " + i);
                                                System.out.println("Nome: " + contas.get(i).getNome());
                                                System.out.println("Login: " + contas.get(i).getLogin());
                                                System.out.println("Senha: " + contas.get(i).getSenha());
                                            }
                                        break;
                                        case 2:
                                            System.out.println("=== Lista de comunidades criadas:");
                                            for(int i = 0; i < comunidades.size(); i++){
                            
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
                                        Conta uTemp = contas.get(i);
            
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
                                            Conta uTemp = contas.get(i);
            
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

                                        case 5:
                                        System.out.println("== Adicionar palavra ofensiva");
                                        System.out.print("Digite o palavra ofensiva a ser adicionada: ");
                                        String palavra_ofensiva = teclado.nextLine();

                                        Palavra p = new Palavra();
                                        p.adicionar_palavra(palavra_ofensiva);
                                        palavras.add(p);
                                    
                                        break;

                                        case 6:
                                            System.out.println("=== Lista palavras ofensivas:");
                                            for(int r = 0; r < palavras.size(); r++){
                    
                                                System.out.println("\n'" + palavras.get(r).getPalavra() + "'");
                                                }
                                        break;
            
                                        /*case 7: //alterar senha de admin
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
                                        System.out.println("\nNenhuma das opcoes foi escolhida");
                                        break;
                                }
                                
                                }while(opcao3!=-1);
                                break;
                                
                            }else{
                                System.out.println("\nSenha incorreta.");
                                break;
                            }

                        }catch (InputMismatchException e_adminlogado) {
                            System.err.println("\nVocê deve digitar um numero.");
                            teclado.nextLine();// limpar input anterior
                            continue;
                        }

                    }while(asenha!=senha_padrao);
                    break;
    
                    default:
                    System.out.printf("\nNenhuma das opcoes foi escolhida.\n");
                    break;
                    
                }//switch menu principal (criar, logar admin)


            } catch (InputMismatchException e_menuprincipal) {
                System.err.println("\nVocê deve digitar um numero.");
                teclado.nextLine();// limpar input anterior
                continue;
            }
            
        }//while parar o programa  
    }//fim da classe main
}//fim da classe App
