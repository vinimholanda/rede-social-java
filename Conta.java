public class Conta {
    
    private String nome;
    private String login;
    private String senha;


    public void adicionar(String nome, String login, String senha){
        setNome(nome);
        setLogin(login);
        setSenha(senha);

        System.out.printf("\nConta adicionada com sucesso.\n");
    }

    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}