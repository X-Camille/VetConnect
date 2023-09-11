import org.example.Propietario;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PropietarioTest {
    private String[] rut;
    private Boolean[] validacionRutEsperada;
    private String[] email;
    private Boolean[] validacionEmailEsperada;
    private final Propietario propietario = new Propietario();
    private String[] telefonos;
    private Boolean[] validacionTelefonosEsperada;

    @BeforeEach
    public void init(){
        rut = new String[]{"214701456", " ", "ashdh23sdh", "8456273K"};
        validacionRutEsperada = new Boolean[]{true, false, false, true};

        email = new String[]{"josesito@gmail@com", " ", "juanito.diaz.gmail.com", "ejemplo.correo@gmail.com"};
        validacionEmailEsperada = new Boolean[]{false, false, false, true};

        telefonos = new String[]{" ", "0000000", "58276362"};
        validacionTelefonosEsperada = new Boolean[]{false, false, true};
    }

    @Test
    public void validarRutTest(){
        boolean resultadoCorrecto = true;
        for(int i=0; i < rut.length; i++){
            if(propietario.validarRut(rut[i]) != validacionRutEsperada[i]) {
                resultadoCorrecto = false;
            }
        }
        assertTrue(resultadoCorrecto);
    }

    @Test
    public void validarEmailTest(){
        boolean resultadoCorrecto = true;
        for(int i=0; i < email.length; i++){
            if(propietario.validarEmail(email[i]) != validacionEmailEsperada[i]){
                resultadoCorrecto = false;
            }
        }
        assertTrue(resultadoCorrecto);
    }

    @Test
    public void validarTelefonoTest(){
        boolean resultadoCorrecto = true;
        for(int i=0; i < telefonos.length; i++){
            if(propietario.validarTelefono(telefonos[i]) != validacionTelefonosEsperada[i]){
                resultadoCorrecto = false;
            }
        }
        assertTrue(resultadoCorrecto);
    }
}
