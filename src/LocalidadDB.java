import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.TreeSet;

public class LocalidadDB {
    private static int error;
    private static int poblacion_min;
    private static TreeSet<Localidad>fallos=new TreeSet<>();
    public static Localidad generarLocalidad(){
        try {
            String sql="select l.nombre as localidad,p.nombre as provincia,c.nombre as comunidad,poblacion from localidades l\n" +
                    "join provincias p using (n_provincia)\n" +
                    "join comunidades c using (id_comunidad)\n" +
                    "where l.poblacion>=?\n" +
                    "order by rand()\n" +
                    "limit 1";
            PreparedStatement ps=AdminConexion.con.prepareStatement(sql);
            ps.setInt(1,poblacion_min);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                error=InfoError.OK;
                return new Localidad(rs.getString("localidad"),rs.getString("provincia"), rs.getString("comunidad"), rs.getInt("poblacion") );
            }else {
                return null;
            }
        }catch (SQLException sqle){
            error=InfoError.ERRPR_RECOGER_DATOS;
            System.out.println(InfoError.getMensaje(error));
            return null;
        }
    }
    public static boolean comprobarPoblacion(){
        try {
            int nºl=0;
            String sql = "select count(*) as n_localidades from localidades\n" +
                    "where poblacion>=?";
            PreparedStatement ps = AdminConexion.con.prepareStatement(sql);
            ps.setInt(1,poblacion_min);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                nºl= rs.getInt("n_localidades");
                error=InfoError.OK;
            }
            if(nºl<50){
                return false;
            }else {
                return true;
            }

        }catch (SQLException sqle){
            error=InfoError.ERRPR_RECOGER_DATOS;
            System.out.println(InfoError.getMensaje(error));
            return false;
        }
    }

    public static void setPoblacion_min(int poblacion_min) {
        LocalidadDB.poblacion_min = poblacion_min;
    }
}
