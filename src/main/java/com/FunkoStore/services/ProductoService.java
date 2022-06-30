package com.FunkoStore.services;

import java.util.List;

import com.FunkoStore.model.Producto;

public interface ProductoService {
	
	public List<Producto> listarProductos();
	
	public Producto obtenerProducto(Long id);
	
	public Producto guardarProducto(Producto producto);
	
	public void eliminarProducto(Long id);
}
