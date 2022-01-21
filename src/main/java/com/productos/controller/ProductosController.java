package com.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productos.entity.Producto;
import com.productos.service.ProductosService;

import io.swagger.annotations.ApiOperation;
import org.junit.jupiter.api.Test;
@RestController
public class ProductosController {

	@Autowired
	private ProductosService productoService;
	
	@ApiOperation(value = "Prueba de listado de productos", notes="Esta es la lista de productos almacenados en la tabla de productos")
	@GetMapping(value = "/productos")
	public List<Producto> getProductos(){

		try {
			return productoService.findAll();
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@ApiOperation(value = "Prueba de listado de productos", notes="Esta es la lista de productos almacenados en la tabla de productos")
	@PostMapping(value = "/productos")
	public void postProducto(){

		try {
			Producto producto = new Producto();
			
			producto.setIdProducto(6L);
			producto.setNombreProducto("Paleta");
			producto.setDescripcionProducto("Es un producto frío");
			producto.setProCat(5L);
			
			productoService.saveOne(producto);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@ApiOperation(value = "Prueba de listado de productos", notes="Esta es la lista de productos almacenados en la tabla de productos")
	@PutMapping(value = "/productos/{idProducto}")
	public void putProducto(@RequestParam(value="idProducto")Long idProducto){

		try {

			Producto producto = productoService.findOne(idProducto);
			
			producto.setNombreProducto("Pastelito");
			producto.setDescripcionProducto("Es un producto cremoso");
			producto.setProCat(4L);
			
			productoService.saveOne(producto);
		}
		catch(Exception e) {
			System.out.println(e);

		}
	}
	
	@ApiOperation(value = "Prueba de listado de productos", notes="Esta es la lista de productos almacenados en la tabla de productos")
	@PatchMapping(value = "/productos/{idProducto}")
	public void patchProducto(@RequestParam(value="idProducto")Long idProducto){

		try {
			Producto producto = productoService.findOne(idProducto);
			
			producto.setNombreProducto("Pastelillo relleno");
			
			productoService.saveOne(producto);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@ApiOperation(value = "Prueba de listado de productos", notes="Esta es la lista de productos almacenados en la tabla de productos")
	@DeleteMapping(value = "/productos/{idProducto}")
	public void deleteProducto(@RequestParam(value="idProducto")Long idProducto){

		try {
			productoService.delete(productoService.findOne(idProducto));
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
