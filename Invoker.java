import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Invoker {
    
    public static Map<Integer, Command> comandos = new HashMap<Integer, Command>();

    static{
        comandos.put(1, new EditarPerfilCommand());
        comandos.put(2, new AdicionarAmigoCommand());
        comandos.put(3, new EnviarUmaMensagemCommand());
        comandos.put(4, new CriarUmaComunidadeCommand());
        comandos.put(5, new AdicionarMembrosComunidadeCommand());
        comandos.put(6, new MinhasInfoCommand());
        comandos.put(7, new VisualizarFeedCommand());
    }

    public static void invoke(int command, Conta uTemp, ArrayList<Conta> contas, ArrayList<Palavra> palavras, ArrayList<Feed> feeds, ArrayList<Comunidade> comunidades){
        comandos.get(command).execute(uTemp, contas, palavras, feeds, comunidades);
    }

}
