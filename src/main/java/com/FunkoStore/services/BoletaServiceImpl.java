package com.FunkoStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FunkoStore.model.Boleta;
import com.FunkoStore.repository.IBoletaRepository;


@Service
public class BoletaServiceImpl implements BoletaService{

	@Autowired
	private IBoletaRepository boletaRepository;
	
	@Override
	public List<Boleta> listarBoleta() {
		// TODO Auto-generated method stub
		return this.boletaRepository.findAll();
	}
	
}
