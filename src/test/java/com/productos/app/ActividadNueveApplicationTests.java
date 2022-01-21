package com.productos.app;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.productos.controller.ProductosController;
import com.productos.entity.Producto;

@SpringBootTest
class ActividadNueveApplicationTests {

	private ProductosController productosController;
	
	@Test
	void contextLoads() {	

	}
	
	@Test
	void getProductos(){
		List<Producto> pruducto;
		pruducto = productosController.getProductos();
		assertNotNull(pruducto);
	}
	
//	@Test
//	void postProducto() {
//		Producto pruducto=new Producto();
//		pruducto.setIdProducto(3L);
//		pruducto.setNombreProducto("Pastel");;
//		pruducto.setProCat(2L);	
//		productosController.postProducto(pruducto);
//	}
}
