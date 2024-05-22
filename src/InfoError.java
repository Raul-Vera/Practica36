public class InfoError {
    public static final int OK=0;
    public static final int FALLO_DRIVER=1;
    public static final int FALLO_CONEXION=2;
    public static final int FALLO_CERRAR_CONEXION=3;
    public static final int ERRPR_RECOGER_DATOS=4;
    public static final int NºHABITANTES_INVALIDO=5;
    private static final String []MENSAJE={
            "Accion llevada a cabo con exito",
            "No se ha introducido el driver correctamente",
            "Error al conectar con la base de datos",
            "Error al cerrar conexion",
            "Error al recoger los datos",
            "No hay suficientes provincias para jugar"
    };
    public static String getMensaje(int codigo){
        return MENSAJE[codigo];
    }
}