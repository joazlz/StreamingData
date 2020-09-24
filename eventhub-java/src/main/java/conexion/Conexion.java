package conexion;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private String user = "postgres";
    private String password = "odk1234";
    private String ip = "192.168.1.116";
    private String port = "5432";
    private String database = "aggregate";

    public Connection getConexion(){
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://"+ip+":"+port+"/"+database, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return c;
    }
}
