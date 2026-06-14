package vista;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.EstadoPedido;
import modelo.Pedido;
import modelo.Producto;
import modelo.ToldoMotorizado;

/**
 * Clase principal que gestiona la interfaz de usuario mediante JOptionPane.
 * Controla el flujo de la aplicación sin mezclar lógica en el modelo.
 */
public class AppGestion {

    public static void main(String[] args) {
        try {
            // 1. Simulación de captura de datos de un Cliente
            JOptionPane.showMessageDialog(null,
                    "¡Bienvenido al Sistema de Gestión de Toldos!\nVamos a registrar un nuevo pedido.",
                    "ToldosApp 2026",
                    JOptionPane.INFORMATION_MESSAGE);

            String nombre = solicitarDatoTexto("Introduce el nombre del cliente:");
            String telefono = solicitarDatoTexto("Introduce el teléfono del cliente:");
            String direccion = solicitarDatoTexto("Introduce la dirección de instalación:");

            // Instanciamos el cliente (Si los datos fallan, el modelo lanzará la excepción)
            Cliente cliente = new Cliente(1, nombre, telefono, direccion);

            // 2. Creación del Pedido (asociamos la fecha de hoy y un operario)
            String operario = solicitarDatoTexto("Introduce el nombre del operario/instalador asignado:");
            Pedido pedido = new Pedido(101, cliente, LocalDate.now(), operario);

            // 3. Bucle para añadir productos mediante ventanas de confirmación
            boolean añadirMasProductos = true;
            int contadorProductos = 1;

            while (añadirMasProductos) {
                String desc = solicitarDatoTexto("Descripción del toldo nº " + contadorProductos + ":");
                double ancho = solicitarDatoDouble("Ancho del toldo (en metros):");
                double linea = solicitarDatoDouble("Línea/Salida del toldo (en metros):");
                double precioBase = solicitarDatoDouble("Precio base del toldo (€):");

                // Preguntamos si es motorizado usando un diálogo de confirmación (Sí/No)
                int respuestaMotor = JOptionPane.showConfirmDialog(null,
                        "¿Este toldo lleva motorización?",
                        "Configuración de Producto",
                        JOptionPane.YES_NO_OPTION);

                Producto producto;

                if (respuestaMotor == JOptionPane.YES_OPTION) {
                    String tipoMotor = solicitarDatoTexto("Tipo/Modelo de motor:");
                    double precioMotor = solicitarDatoDouble("Precio del motor (€):");
                    // Aplicamos polimorfismo instanciando la clase hija
                    producto = new ToldoMotorizado(contadorProductos, desc, precioBase, ancho, linea, tipoMotor, precioMotor);
                } else {
                    // Si no es motorizado, podríamos instanciar un ToldoEstandar (o una subclase similar)
                    // Para el ejemplo, usamos una clase anónima o extendemos la funcionalidad simulando el base
                    producto = new Producto(contadorProductos, desc, precioBase, ancho, linea) {
                        @Override
                        public double calcularPrecioFinal() {
                            return getPrecioBase();
                        }
                    };
                }

                // Añadimos el producto al pedido
                pedido.añadirProducto(producto);
                contadorProductos++;

                // ¿Desea seguir añadiendo más toldos a este mismo pedido?
                int respuestaSeguir = JOptionPane.showConfirmDialog(null,
                        "¿Deseas añadir otro producto a este pedido?",
                        "Continuar",
                        JOptionPane.YES_NO_OPTION);

                if (respuestaSeguir != JOptionPane.YES_OPTION) {
                    añadirMasProductos = false;
                }
            }

            // 4. Cambiar estado del pedido para demostrar el uso del Enum
            int respuestaInstalado = JOptionPane.showConfirmDialog(null,
                    "¿Se ha realizado ya la instalación de este encargo?",
                    "Actualizar Estado",
                    JOptionPane.YES_NO_OPTION);

            if (respuestaInstalado == JOptionPane.YES_OPTION) {
                pedido.setEstado(EstadoPedido.INSTALADO);
            } else {
                pedido.setEstado(EstadoPedido.EN_PROCESO);
            }

            // 5. MOSTRAR RESULTADO FINAL
            // Gracias al StringBuilder y al toString del modelo, se verá impecable
            JOptionPane.showMessageDialog(null,
                    pedido.toString(),
                    "Resumen del Pedido Generado",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IllegalArgumentException e) {
            // Capturamos los errores de validación del modelo de forma controlada
            JOptionPane.showMessageDialog(null,
                    "Error de validación: " + e.getMessage(),
                    "Datos Incorrectos",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Capturamos cualquier otro error inesperado
            JOptionPane.showMessageDialog(null,
                    "Ha ocurrido un error inesperado: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // --- MÉTODOS AUXILIARES DE VALIDACIÓN PARA LOS JOPTIONPANE ---

    private static String solicitarDatoTexto(String mensaje) {
        String dato = JOptionPane.showInputDialog(mensaje);
        if (dato == null || dato.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo solicitado no puede cancelarse ni dejarse vacío.");
        }
        return dato.trim();
    }

    private static double solicitarDatoDouble(String mensaje) {
        String dato = JOptionPane.showInputDialog(mensaje);
        try {
            return Double.parseDouble(dato);
        } catch (NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("Debes introducir un número decimal válido (ej: 450.50).");
        }
    }
}