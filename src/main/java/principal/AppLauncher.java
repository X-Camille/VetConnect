package principal;

import model.VetConnect;
import vista.GUIVetConnect;

public class AppLauncher {
    public static void main(String[] args) {
        VetConnect clinica = new VetConnect();
        GUIVetConnect ventana = new GUIVetConnect(clinica);
        ventana.mostrarInterfaz();
    }
}
