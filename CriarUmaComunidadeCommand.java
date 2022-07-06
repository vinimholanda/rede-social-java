import java.util.Scanner;
import java.util.ArrayList;

public class CriarUmaComunidadeCommand implements Command{
    @Override

    public void execute(Conta uTemp, ArrayList<Conta> contas, ArrayList<Palavra> palavras, ArrayList<Feed> feeds, ArrayList<Comunidade> comunidades){
    
        String nome_comunidade, descricao_comunidade;
        Scanner teclado = new Scanner(System.in);
    
        while(true){//verifica se o nome da comunidade e a descricao estao vazias nao esta em branco
            System.out.print("\nDigite o nome que da comunidade a ser criada: ");
            nome_comunidade = teclado.nextLine();

            if(verificaBranco(nome_comunidade) == true){
                System.out.println("\n(!) Você nao pode deixar o nome da comunidade em branco.");
                continue;
            }else{

                while(true){

                    System.out.println("Escreva uma breve descricao sobre a comunidade:\n");
                    descricao_comunidade = teclado.nextLine();
                
                    if(verificaBranco(descricao_comunidade) == true){
                        System.out.println("\n(!) Você nao pode deixar a descricao da comunidade em branco.\n");
                    }else{
                        Comunidade cm = new Comunidade();

                        cm.adicionar(uTemp.getNome(), nome_comunidade, descricao_comunidade, uTemp.getNome());
                        comunidades.add(cm);
                        break;
                    }
                }
                break;
            } 
        }
    }

    public static boolean verificaBranco(String texto){
        if(texto.isBlank()){
            return true;
        }else{
            return false;
        }
    }
}