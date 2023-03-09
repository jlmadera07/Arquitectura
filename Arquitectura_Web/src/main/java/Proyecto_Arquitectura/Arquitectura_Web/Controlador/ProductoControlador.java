package Proyecto_Arquitectura.Arquitectura_Web.Controlador;

import java.util.List;import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Proyecto_Arquitectura.Arquitectura_Web.Modelo.Producto;
import Proyecto_Arquitectura.Arquitectura_Web.Servicios.ProductoImpl;


@RestController
@RequestMapping("/api")
public class ProductoControlador {
	
	@Autowired
	ProductoImpl productoImpl;
	
	@GetMapping("/productos")
	public List<Producto> listProductos(){
		return productoImpl.listarProductos();
	}
	
	@PostMapping("/productos")
	public Producto guardarProducto(@RequestBody Producto producto)
	{
	return productoImpl.guardeProducto(producto);	
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<?> actualizaProducto(@PathVariable Long id, @RequestBody Producto producto)
	{
		Producto producto_seleccionado = new Producto();
		Producto producto_actualizado = new Producto();
		
		producto_seleccionado= productoImpl.buscarXid(id);
		
		producto_seleccionado.setNombre (producto.getNombre());
		producto_seleccionado.setMarca(producto.getMarca());
		producto_seleccionado.setDescripcion(producto.getDescripcion());
		producto_seleccionado.setImagen(producto.getImagen());
		producto_seleccionado.setUnidades(producto.getUnidades());
		
		producto_actualizado = productoImpl.actualizarProducto(producto_seleccionado);
		System.out.println("El cliente actualizado es: " + producto_actualizado);
		
		
		return ResponseEntity.ok(Map.of("Message", "El producto ha sido actualizado con exito"));
	}
	
	/*
	@PutMapping("/productos/{id}")
	public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable Long id)
	{
		try {
			Producto productoExistente = productoImpl.buscarXid(id);
			productoImpl.guardeProducto(producto);
			return new ResponseEntity<Producto>(HttpStatus.OK);
			
			
		} catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
	}
	*/
	
	@DeleteMapping("/productos/{id}")
	public void eliminarProducto(@PathVariable Long id)
	{
		productoImpl.eliminarProducto(id);
	}


	
}
