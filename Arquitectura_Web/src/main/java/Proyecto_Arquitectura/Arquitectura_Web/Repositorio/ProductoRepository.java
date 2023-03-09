package Proyecto_Arquitectura.Arquitectura_Web.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Proyecto_Arquitectura.Arquitectura_Web.Modelo.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	
}
