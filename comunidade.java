public class comunidade {
    
    private String dono;
    private String nome;
    private String descricao;
    private String membros;

    public void adicionar(String x, String y, String z){
        setDono(x);
        setNome(y);
        setDescricao(z);

        System.out.printf("\nComunidade criada com sucesso\n");
    }
    public String getNome() {
        return nome;
    }
    public String getDono() {
        return dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
