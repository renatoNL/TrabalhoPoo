package model;

public class Music {

    private int musicaID;
    private String nomeMusica;
    private String artista;
    private String genero;
    private String album;

    public Music(int musicaID, String nomeMusica, String artista, String genero, String album){
        this.musicaID = musicaID;
        this.nomeMusica = nomeMusica;
        this.artista = artista;
        this.genero = genero;
        this.album = album;
    }
    public Music(){

    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    // MusicaID nao deve ter metodo GET

    public void setMusicaID(int musicaID) {
        this.musicaID = musicaID;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
