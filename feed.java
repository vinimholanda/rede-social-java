public class feed {
    private String user;
    private String texto;

    void adicionar(String x, String y)
    {
        setUser(x);
        setTexto(y);
    }
    
    public String getUser() {
        return user;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public void setUser(String user) {
        this.user = user;
    }

    
}
