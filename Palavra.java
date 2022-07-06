public class Palavra {
    
    private String palavra;

    public void adicionar_palavra(String palavra){
        setPalavra(palavra);

        System.out.println("\nPalavra adicionada com sucesso.");
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

}
