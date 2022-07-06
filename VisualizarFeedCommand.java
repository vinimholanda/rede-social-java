import java.util.ArrayList;

public class VisualizarFeedCommand implements Command{
    @Override

    public void execute(Conta uTemp, ArrayList<Conta> contas, ArrayList<Palavra> palavras, ArrayList<Feed> feeds, ArrayList<Comunidade> comunidades){
        System.out.println("=== Visualizar feed");
        for(int r = 0; r < feeds.size(); r++){
                        
        System.out.println("\n(@)"+feeds.get(r).getUser() + " postou: ");
        System.out.println(feeds.get(r).getTexto());
        }
    }
}
