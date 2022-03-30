import java.util.Scanner;

public class conta {
    
    //Atributos
    private String nome;
    private String login;
    private String senha;

    //Métodos
    void adicionar(String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;

        System.out.printf("Conta adicionada com sucesso.\n");
    }

    void editar(String login, String senha)
    {
        java.util.Scanner input = new Scanner(System.in);
        String info;

        int v;
        this.login = login;
        this.senha = senha;

        System.out.printf("Que informacao voce quer editar: ");
        info = input.next();

        //-->
    }

    void remover(String login, String senha){
        this.login = login;
        this.senha = senha;

        System.out.printf("Conta removida com sucesso.\n");
    }
}