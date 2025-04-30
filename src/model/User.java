package model;

public class User {

    private int usuarioID;
    private String nome;
    private String biografia;
    private String email;
    private String sexo;

    public User(int usuarioID, String sexo, String email, String nome, String biografia) {
        this.usuarioID = usuarioID;
        this.sexo = sexo;
        this.email = email;
        this.nome = nome;
        this.biografia = biografia;
    }

    public User() {

    }

    // Nao deve haver o metodo get para o ID do usuario

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
