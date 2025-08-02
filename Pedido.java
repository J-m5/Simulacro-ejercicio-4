package com.negocio.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Producto> productos;
    private LocalDateTime fecha;
    private LocalDateTime hora;
    private double total;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.fecha = LocalDateTime.now();
        this.total = 0.0;
        this.hora = LocalDateTime.now();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productos.add(producto);
        calcularTotal();
    }

    // ERROR 5: Cálculo incorrecto del total (suma precios sin considerar cantidades)
    private void calcularTotal() {
        total = 0;
        for (Producto producto : productos) {
            // Multiplica el precio por la cantidad para obtener el subtotal de cada producto.
            total += producto.getPrecio() * producto.getCantidad();
        }
    }

    // ERROR 6: Método que puede causar IndexOutOfBoundsException
    public Producto obtenerPrimerProducto() {
        // Verifica si la lista está vacía.
        if (productos != null && !productos.isEmpty()) {
            return productos.get(0);
        }
        // Si la lista está vacía o es nula, devuelve null.
        return null;
    }

    // ERROR 7: Descuento mal aplicado
    public double aplicarDescuento(double porcentaje) {
        // Multiplica el total por (1 - porcentaje/100) para calcular el precio con descuento.
        return total * (1 - porcentaje / 100);
    }
    public interface DescuentoAplicable {
        /**
         * Aplica un descuento a un valor total.
         *
         * @param porcentaje El porcentaje de descuento a aplicar (ej. 10 para 10%).
         * @param total El valor total sobre el cual se aplica el descuento.
         * @return El nuevo valor después de aplicar el descuento.
         */
        double aplicarDescuento(double porcentaje, double total);
    }

    // Getters
    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<Producto> getProductos() { return productos; }
    public LocalDateTime getFecha() { return fecha; }
    public LocalDateTime gethora() { return hor
    public double getTotal() { return total; }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente.getNombre() +
                ", correo=" + cliente.getCorreo() +
                ", productos=" + productos.size() +
                ", fecha=" + fecha +
                ", total=" + total +
                ", hora=" + hora +
                '}';
    }
}
