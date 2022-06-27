package com.FunkoStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FunkoStore.model.Cliente;
import com.FunkoStore.repository.ClienteDAO;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteDAO clienteRepository;
	
	@Override
	public List<Cliente> listarCliente() {
		// TODO Auto-generated method stub
		return this.clienteRepository.findAll();
	}

}
