package net.atos.api.cliente.service;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.stereotype.Service;

import net.atos.api.cliente.domain.Cliente;

@Service
public class CadastrarCliente {

	public void persistir(Cliente cliente) {
		
		Optional.ofNullable(cliente.getDataCadastro())
				.orElseThrow(() -> new BadRequestException("Campo: cadastroData não pode ser nulo"));
		Optional.ofNullable(cliente.getDataAlteracao())
				.orElseThrow(() -> new BadRequestException("Campo: DataAlteracao não pode ser nulo"));

	}
	
	
}
