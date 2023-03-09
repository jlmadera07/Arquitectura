package Proyecto_Arquitectura.Arquitectura_Web.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import Proyecto_Arquitectura.Arquitectura_Web.Modelo.Producto;
import Proyecto_Arquitectura.Arquitectura_Web.Repositorio.ProductoRepository;

@Service
public class ProductoImpl implements ProductoServices{

	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public List<Producto> listarProductos() {
		return productoRepository.findAll();
	}

	@Override
	public Producto guardeProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);
		
	}

	@Override
	public Producto buscarXid(Long id) {
		return productoRepository.findById(id).get();
	}
	

}
