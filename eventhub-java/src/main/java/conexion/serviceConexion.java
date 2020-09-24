package conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class serviceConexion {

    public ArrayList<vistaSinc> getVistasSinc(){
        ArrayList<vistaSinc> vistas = new ArrayList<>();
        try {
            ArrayList<String> vts = getVistas();
            Statement stmt = null;
            ResultSet rsv = null;
            Connection con =  new Conexion().getConexion();
            for (String elem: vts) {
                    stmt = con.createStatement();
                    rsv = stmt.executeQuery( "SELECT '"+elem+"' as tabla,count(*) as filas from \"aggregate\".\""+elem+"\"" );
                    while ( rsv.next() ) {
                        vistas.add(new vistaSinc(rsv.getString(1),rsv.getInt(2)));
                    }
                    rsv.close();
            }
            rsv.close();
            stmt.close();
            con.close();
        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return vistas;
    }

    public ArrayList<String> getVistas(){
        ArrayList<String> vistas = new ArrayList<>();
        Connection con =  new Conexion().getConexion();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT viewname FROM pg_catalog.pg_views pv WHERE schemaname = 'aggregate';" );
            while ( rs.next() ) {
                vistas.add(rs.getString(1));
            }
            rs.close();
            stmt.close();
            con.close();
        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return vistas;
    }


}
