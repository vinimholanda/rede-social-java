import java.util.ArrayList;

public class MinhasInfoCommand implements Command{
    @Override

    public void execute(Conta uTemp, ArrayList<Conta> contas, ArrayList<Palavra> palavras, ArrayList<Feed> feeds, ArrayList<Comunidade> comunidades){
        System.out.println("\n== Seus dados atuais:");
        System.out.println("Nome: " + uTemp.getNome());
        System.out.println("Email: " + uTemp.getLogin());
        System.out.println("Senha: " + uTemp.getSenha());
        System.out.println("Para alterar qualquer dado use a funcao editar perfil quando logado na rede.");
    }
    
}
