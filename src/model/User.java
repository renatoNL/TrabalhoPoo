package model;

public class User {

    private int userID;
    private String name;
    private String bio;
    private String email;
    private String gender;

    public User(int userID, String gender, String email, String name, String bio) {
        this.userID = userID;
        this.gender = gender;
        this.email = email;
        this.name = name;
        this.bio = bio;
    }

    public User(){

    }

    // Nao deve haver o metodo get para o ID do usuario

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }//Coletar o nome do Usuário

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }//Biografia do Usuário

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }//Email do Usuário

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }//Gênero do usuário

    public void setGender(String gender) {
        this.gender = gender;
    }
}
