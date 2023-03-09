package Proyecto_Arquitectura.Arquitectura_Web.Servicios;

import java.util.List;

import Proyecto_Arquitectura.Arquitectura_Web.Modelo.Producto;

public interface ProductoServices {


	public List<Producto> listarProductos();
	public Producto guardeProducto(Producto producto);
	public Producto buscarXid(Long id);
	public Producto actualizarProducto(Producto producto);
	public void eliminarProducto(Long id);
}
