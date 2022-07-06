import java.util.Scanner;
import java.util.ArrayList;

public class AdicionarMembrosComunidadeCommand implements Command{
    @Override

    public void execute(Conta uTemp, ArrayList<Conta> contas, ArrayList<Palavra> palavras, ArrayList<Feed> feeds, ArrayList<Comunidade> comunidades){
        int contcomunidade = 0;
        Scanner teclado = new Scanner(System.in);
                                    
        System.out.println("\n=== Adicionar memrbos a uma comunidade");
        System.out.print("Digite o nome da comunidade: ");
        String ncomunidade = teclado.nextLine();
                                    
        
        for(int ii = 0; ii < comunidades.size(); ii++)
        {
            Comunidade iTemp = comunidades.get(ii);
        
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
    }
}
