package modelo;

/**
 * Clase que representa un toldo motorizado.
 * Hereda de Prodcuto e implementa su propio calculo.
 */
public class ToldoMotorizado extends Producto {

    private String tipoMotor;
    private double precioMotor;

    // Contructor que usa "super" para reutilizar constructor padre.
    public ToldoMotorizado(int id, String descripcion, double precioBase, double ancho, double linea, String tipoMotor, double precioMotor) {
        super(id, descripcion, precioBase, ancho, linea); // Llama al constructor de Producto.
        if (precioMotor < 0){
            throw new IllegalArgumentException("El precio del motor no puede ser negativo.");
        }
        this.tipoMotor = tipoMotor;
        this.precioMotor = precioMotor;
    }

    // Polimorfismo.
    @Override
    public double calcularPrecioFinal(){
        return getPrecioBase() + this.precioMotor;
    }

    // Getters y Setters.

    public String getTipoMotor() {
        return tipoMotor;
    }
    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public double getPrecioMotor() {
        return precioMotor;
    }
    public void setPrecioMotor(double precioMotor) {
        this.precioMotor = precioMotor;
    }

    @Override
    public String toString(){
        return super.toString() + " | Motor: " + tipoMotor + " | Precio final: " + calcularPrecioFinal() + "€";
        }

}
