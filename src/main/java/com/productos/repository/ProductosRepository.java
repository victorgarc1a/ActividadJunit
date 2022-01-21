package com.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productos.entity.Producto;

public interface ProductosRepository extends JpaRepository<Producto, Long> {

}
