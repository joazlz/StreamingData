import conexion.serviceConexion;
import conexion.vistaSinc;

import javax.swing.*;
import java.util.ArrayList;

public class eventhubMain {
    public static void main(String[] args) {
        ArrayList<vistaSinc> vstSinc = new serviceConexion().getVistasSinc();
        while(!false) {
            ArrayList<vistaSinc> vstNew = new serviceConexion().getVistasSinc();
            for (int i = 0; i < vstNew.size(); i++) {
                if (vstSinc.get(i).getFilas()!=vstNew.get(i).getFilas()) {
                    vstSinc = vstNew;
                }
            }
        }
    }
}
