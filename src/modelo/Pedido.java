package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


// Gestiona la informacion de un pedido.

public class Pedido {

    private int idPedido;
    private Cliente cliente;
    private List<Producto> listaProductos;
    private LocalDate fechaInstalacion;
    private EstadoPedido estado;
    private String operarioAsignado;

    // Constructor.

    public Pedido(int idPedido, Cliente cliente, LocalDate fechaInstalacion, String operarioAsignado) {
        if (cliente == null) {
            throw new IllegalArgumentException("Un pedido debe tener obligatoriamente un cliente asociado.");
        }
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.fechaInstalacion = fechaInstalacion;
        this.operarioAsignado = operarioAsignado;

        this.estado = EstadoPedido.PENDIENTE;
        this.listaProductos = new java.util.ArrayList<>();
    }


    // Metodo para añadir productos al pedido.
    public void añadirProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("No se puede añadir un producto nulo al pedido.");
        }
        this.listaProductos.add(producto);
    }

    // Logica backend
    public double calcularTotalPedido() {
        double total = 0;
        for (Producto prod : listaProductos) {
            // Polimorfistmo. Java que calcularPrecioFinal() usar.
            total += prod.calcularPrecioFinal();
        }
        return total;
    }

    // Getters and Setters.

    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }
    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public LocalDate getFechaInstalacion() {
        return fechaInstalacion;
    }
    public void setFechaInstalacion(LocalDate fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public EstadoPedido getEstado() {
        return estado;
    }
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getOperarioAsignado() {
        return operarioAsignado;
    }
    public void setOperarioAsignado(String operarioAsignado) {
        this.operarioAsignado = operarioAsignado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append("PEDIDO Nº: ").append(idPedido).append(" | Estado: ").append(estado).append("\n");
        sb.append(cliente.toString()).append("\n");
        sb.append("Fecha Instalación: ").append(fechaInstalacion).append(" | Operario: ").append(operarioAsignado).append("\n");
        sb.append("---------------- Productos ----------------\n");
        for (Producto prod : listaProductos) {
            sb.append("- ").append(prod.toString()).append("\n");
        }
        sb.append("-------------------------------------------\n");
        sb.append("TOTAL ENCARGO: ").append(calcularTotalPedido()).append("€\n");
        sb.append("========================================");
        return sb.toString();
    }
}
