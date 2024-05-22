public class Localidad implements Comparable<Localidad> {
     private String nombre;
    private String provincia;
    private String comunidad;
    private int poblacion;
    private  int fallos;

    public int getFallos() {
        return fallos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }

    public Localidad(String nombre) {
        this.nombre = nombre;
    }
    public Localidad(String nombre,String provincia,String comunidad,int poblacion){
        this.nombre=nombre;
        this.comunidad=comunidad;
        this.poblacion=poblacion;
        this.provincia=provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre+"  |Provincia: "+provincia+"  |Comunidad:"+comunidad+"  |Poblacion: "+poblacion;
    }

    @Override
    public int compareTo(Localidad o) {
        return this.nombre.compareTo(o.nombre);
    }
}
