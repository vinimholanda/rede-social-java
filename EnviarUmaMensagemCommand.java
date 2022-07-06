import java.util.ArrayList;
import java.util.Scanner;

public class EnviarUmaMensagemCommand implements Command{
    @Override

    public void execute(Conta uTemp, ArrayList<Conta> contas, ArrayList<Palavra> palavras, ArrayList<Feed> feeds, ArrayList<Comunidade> comunidades){

        Scanner teclado = new Scanner(System.in);
        System.out.println("\nQual o tipo de mensagem que voce quer enviar?\n[1] Privada\n[2] Publica");
        int choice = teclado.nextInt();
        teclado.nextLine();
        int zzcont = 0;
        
        if(choice == 1){
            System.out.println("Digite o usuario que recebera a mensagem:");
            String usu1 = teclado.nextLine();
                    
            for(int zz = 0; zz < contas.size(); zz++)
            {
                Conta zzedTemp = contas.get(zz);
                    
                if(usu1.equals(zzedTemp.getNome())){ //achou o usuario
                    zzcont = 1;
    
                    while(true){
                        System.out.printf("\nDigite que a mensagem para %s\n", usu1);
                        String mensag = teclado.nextLine();
                                                            
                        if (mensag.isBlank()) {
                            System.out.println("Sua mensagem nao pode ser em branco");
                        } else {
                            break;
                        }
                    }
                    System.out.print("\nMensagem enviada.\n");
                    break;
                    }}
                    
                    if(zzcont == 0){
                    System.out.println("\nUsuario nao encontrado.");
                    }
                    
                    
                    }else if(choice == 2){
                    String post;
                                        
                    while(true){
    
                        System.out.println("No que voce esta pensando?\n");
                        post = teclado.nextLine();
    
                        int contz = 0;
    
                        if (post.isBlank()) {
                            System.out.println("(!) Sua mensagem nao pode ser em branco\n");
                        } else {
    
                            for(int z = 0; z < palavras.size(); z++){
    
                            Palavra zedTemp = palavras.get(z);
    
                        if(post.contains(zedTemp.getPalavra())){
                            contz = contz + 1;
                        }
                        }
    
                        if(contz > 0){
                            System.out.printf("\n(!) Sua mensagem contem uma palavra ofensiva e portando nao pode ser postado no feed publico\n\n");
                        }else{
                            break;
                        }   
                        }
                        }
                                                    
                        Feed fe = new Feed();
        
                        fe.adicionar(uTemp.getLogin(), post);
                        feeds.add(fe);
    
                        System.out.print("\nPostado no feed com sucesso.\n");
                        }
                    
                    
                        else{
                            System.out.println("\nEscolha uma alternativa valida!");
                     }
    }
    
}
