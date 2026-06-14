package modelo;

/**
 * Clase abstracta que sirve de base.
 * Define atributos comunes y el metodo abstracto para calculo de costes.
 */
public abstract class Producto {

    private int id;
    private String descripcion;
    private double precioBase;
    private double ancho; //en metros.
    private double linea; // en metros. (salida/proyeccion del toldo).

    // Constructor.
    public Producto(int id, String descripcion, double precioBase, double ancho, double linea) {
        if (precioBase < 0 || ancho <= 0 || linea <= 0) {
            throw new IllegalArgumentException("Los valores de precio, anch y línea deben ser mayores que cero.");
        }
        this.id = id;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.ancho = ancho;
        this.linea = linea;
    }

    //Metodo Abstracto.
    public abstract double calcularPrecioFinal();

    // Getters y Setters.
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioBase() {
        return precioBase;
    }
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getAncho() {
        return ancho;
    }
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getLinea() {
        return linea;
    }
    public void setLinea(double linea) {
        this.linea = linea;
    }

    @Override
    public String toString() {
        return descripcion + "(Medidas: " + ancho + "m x " + linea + "m)";
    }
}
