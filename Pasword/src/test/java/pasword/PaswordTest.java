
package pasword;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PaswordTest {

    @Test
    public void testContrasenaValida() {
        try {
            String contrasena = "Juan37$*";
            String confirmarContrasena = "Juan37$*";
            Pasword.validatePassword(contrasena, confirmarContrasena);
        } catch (Exception e) {
            fail("Se produjo una excepción inesperada: " + e.getMessage());
        }
    }

    @Test
    public void testContrasenaCorta() {
        try {
            String contrasena = "Juan37$";
            String confirmarContrasena = "Juan37$";
            Pasword.validatePassword(contrasena, confirmarContrasena);
            fail("Se esperaba una excepción debido a la longitud insuficiente de la contraseña.");
        } catch (Exception e) {
            assertEquals("La contraseña debe tener al menos 8 caracteres.", e.getMessage());
        }
    }

    @Test
    public void testContrasenaConEspacio() {
        try {
            String contrasena = "Juan 37$*";
            String confirmarContrasena = "Juan 37$*";
            Pasword.validatePassword(contrasena, confirmarContrasena);
            fail("Se esperaba una excepción debido a la presencia de espacios en la contraseña.");
        } catch (Exception e) {
            assertEquals("La contraseña no debe contener espacios en blanco.", e.getMessage());
        }
    }

    @Test
    public void testContrasenaFaltaTiposCaracteres() {
        try {
            String contrasena = "faltaCaracteres";
            String confirmarContrasena = "faltaCaracteres";
            Pasword.validatePassword(contrasena, confirmarContrasena);
            fail("Se esperaba una excepción debido a la falta de caracteres requeridos en la contraseña.");
        } catch (Exception e) {
            assertEquals("La contraseña debe contener al menos un carácter en minúscula, un carácter en mayúscula, un número y un carácter especial.", e.getMessage());
        }
    }

    @Test
    public void testContrasenasNoCoinciden() {
        try {
            String contrasena = "Juan37$*";
            String confirmarContrasena = "Juan37$-";
            Pasword.validatePassword(contrasena, confirmarContrasena);
            fail("Se esperaba una excepción debido a la falta de coincidencia entre las contraseñas.");
        } catch (Exception e) {
            assertEquals("Las contraseñas no coinciden.", e.getMessage());
        }
    }
}
