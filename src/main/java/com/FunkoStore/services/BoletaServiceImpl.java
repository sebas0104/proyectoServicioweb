package com.FunkoStore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FunkoStore.model.Boleta;
import com.FunkoStore.repository.BoletaDAO;

@Service
public class BoletaServiceImpl implements BoletaService {

	@Autowired
	private BoletaDAO boletaRepository;

	@Override
	public List<Boleta> listarBoleta() {
		// TODO Auto-generated method stub
		return this.boletaRepository.findAll();
	}

	@Override
	public Boleta listarBoletaId(Long fecha1) {
		// TODO Auto-generated method stub
		Optional<Boleta> boleta = this.boletaRepository.findById(fecha1);
		if (boleta.isPresent()) {
			return boleta.get();
		}
		return null;
	}

}
