package model;

public class Publication {

    private int publicationID;
    private String descricao;
    private int avaliacao;
    private boolean like;

    public Publication(int PublicationID, String Descricao, int Avaliacao, boolean Like) {
        this.publicationID = publicationID;
        this.descricao = descricao;
        this.avaliacao = avaliacao;
        this.like = like;
    }

    public Publication() {

    }

    public void setPublicationID(int publicationID) {
        this.publicationID = publicationID;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public boolean getLike() {
        return like;
    }
}