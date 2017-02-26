package accesodatos_mongodb.classe_criminale;

/**
 * CONTENEDOR DE DESTINOS.
 *
 * @author hector
 * @version RTM;
 */
public class Destino {

    private String id;
    private String pais;
    private String ciudad;
    private String imgRuta;
    private String lugares;
    private String aux;

    public Destino() {
        System.out.println("Creado un nuevo objeto destino");
    }

    public void setId(String _id) {
        this.id = _id;
    }

    public String getAux() {
        return aux;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setRuta_imagen(String ruta_imagen) {
        this.imgRuta = ruta_imagen;
    }

    public void setLugares(String lugares) {
        this.lugares = lugares;
    }

    public String getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getRuta_imagen() {
        return imgRuta;
    }

    public String getLugares() {
        return lugares;
    }

}
