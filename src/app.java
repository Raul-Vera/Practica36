import java.util.Scanner;

public class app {
    public static void ejecutar(){
        Scanner teclado=new Scanner(System.in);
        boolean seguir=true;
        String elelccion;
        do {
            System.out.println("Buenas jugador");
            System.out.println("Introduce la poblacion minima por provincia con la que  quieres jugar");
            LocalidadDB.setPoblacion_min(teclado.nextInt());
            if(LocalidadDB.comprobarPoblacion()){
                System.out.println(LocalidadDB.generarLocalidad());
            }else {
                System.out.println("No existen mas de 50 localidades con esa poblacion");
            }

        }while (seguir);
    }
    public static void main(String[] args) {
        AdminConexion.obtenerConexion();
        ejecutar();

    }
}
