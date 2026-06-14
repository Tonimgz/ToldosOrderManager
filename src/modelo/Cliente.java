package modelo;

// Representa a un cliente en el sistema de gestión de pedidos.

public class Cliente {

    // Atributos privados para garantizar encapsulamiento.
    private int id;
    private String nombre;
    private String telefono;
    private String direccion;

    // Constructor completo.
    public Cliente(int id, String nombre, String telefono, String direccion) {
        this.id = id;
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
        }
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Métodos Getters y Setters.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Metodo ToString modificado para informacion limpia en JOptionPane
    @Override
    public String toString() {
        return "ID: " + id + " | Cliente: " + nombre + " | Telefono: " + telefono + " | Direccion: " + direccion;
    }
}
