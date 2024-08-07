import java.util.ArrayList;

public class Artista {
    private String nombre;
    private ArrayList<Album> albums;

    public Artista(String nombre) {
        this.nombre = nombre;
        this.albums = new ArrayList<>();
    }

    public void agregarAlbum(Album album) {
        albums.add(album);
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nombre='" + nombre + '\'' +
                ", albums=" + albums +
                '}';
    }
}

