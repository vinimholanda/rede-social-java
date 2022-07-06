import java.util.Scanner;
import java.util.ArrayList;

public class AdicionarAmigoCommand implements Command{
    @Override

    public void execute(Conta uTemp, ArrayList<Conta> contas, ArrayList<Palavra> palavras, ArrayList<Feed> feeds, ArrayList<Comunidade> comunidades){
        
        int zcont = 0;
        Scanner teclado = new Scanner(System.in);
                                    
        System.out.print("\nDigite o usuario que voce quer enviar a solicitacao: "); 
        String zed = teclado.nextLine();
        
        for(int z = 0; z < contas.size(); z++){
            Conta zedTemp = contas.get(z);
        
            if(zed.equals(zedTemp.getNome())){
            zcont = 1;
            System.out.printf("Solicitacao enviada para @%s\n", zed);
            break;
            }
        }
        
        if(zcont == 0){
            System.out.println("\nUsuario nao encontrado.");
        }                                              
    }
  
}
