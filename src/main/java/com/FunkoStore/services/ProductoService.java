package com.FunkoStore.services;

import java.util.List;

import com.FunkoStore.model.producto;

public interface ProductoService {
	
	public List<producto> listarProductos();
	
	public producto obtenerProducto(Long id);
	
	public producto guardarProducto(producto producto);
	
	public void eliminarProducto(Long id);
}
