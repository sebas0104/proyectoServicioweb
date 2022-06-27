package com.FunkoStore.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FunkoStore.model.producto;
import  com.FunkoStore.repository.ProductoDAO;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDAO productoRepository;

	@Override
	public List<producto> listarProductos() {
		// TODO Auto-generated method stub
		return this.productoRepository.findAll();
	}

	@Override
	public producto obtenerProducto(Long id) {
		// TODO Auto-generated method stub
		Optional<producto> producto = this.productoRepository.findById(id);
		if (producto.isPresent()) {
			return producto.get();
		}
		return null;
	}

	@Override
	public producto guardarProducto(producto producto) {
		// TODO Auto-generated method stub
		try {
			producto guardarProducto = this.productoRepository.save(producto);
			return guardarProducto;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}


	@Override
	public void eliminarProducto(Long id) {
		// TODO Auto-generated method stub
		try {
			productoRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

}
