package com.negocio.models;

// ERROR 1: Atributos públicos (Mala práctica de encapsulamiento)
public  class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(int id, String nombre, double precio, int stock) {
        // Validaciones en el constructor para asegurar un estado inicial válido
        if (id <= 0) {
            throw new IllegalArgumentException("El ID del producto debe ser un número positivo.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio del producto no puede ser negativo.");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock inicial no puede ser negativo.");
        }

        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters para acceder a los atributos (leer)
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    // Setters (solo si es necesario permitir cambios después de la creación)
    // Se recomienda validar también en los setters
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio del producto no puede ser negativo.");
        }
        this.precio = precio;
    }

    public void reducirStock(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad a reducir no puede ser negativa.");
        }
        if (this.stock < cantidad) { // Verifica si hay suficiente stock
            throw new IllegalStateException("No hay suficiente stock para reducir.");
        }
        this.stock -= cantidad; // Se usa -= para abreviar
    }

    public void aumentarStock(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad a aumentar no puede ser negativa.");
        }
        this.stock += cantidad;
    }


    // ERROR 4: Método con lógica incorrecta
    public boolean hayStock(int cantidad) {
        return stock >= cantidad; // Debería ser >= para permitir exactamente la cantidad
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }

    public double getCantidad() {
        return 0;
    }
    }
