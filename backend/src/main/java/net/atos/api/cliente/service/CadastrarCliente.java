package net.atos.api.cliente.service;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.ws.rs.BadRequestException;

import org.springframework.stereotype.Service;

import net.atos.api.cliente.domain.Cliente;
import net.atos.api.cliente.repository.ClienteRepository;
import net.atos.api.cliente.repository.entity.ClienteEntity;

@Service
public class CadastrarCliente {
	
	private Validator validator;
	
	private ClienteRepository clienteRepository;
	
	public CadastrarCliente(Validator v, ClienteRepository repository) {
		this.validator = v;
		this.clienteRepository = repository;
	}

	public Cliente persistir(@NotNull(message = "Cadastro não pode ser null") Cliente cliente) {
		
		Set<ConstraintViolation<Cliente>>
			validate = this.validator.validate(cliente);
		
		if(!validate.isEmpty()) {
			throw new ConstraintViolationException("Operação inválida", validate);
		}
		
		if(!cliente.getDataCadastro().isEqual(LocalDate.now())) {
			throw new BadRequestException("A data do cadastro deve ser atual");
		}
		
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setDataCadastro(cliente.getDataCadastro());
		clienteEntity.setDataAlteracao(cliente.getDataAlteracao());
		clienteEntity.setStatus(cliente.getStatus());
		clienteEntity.setNome(cliente.getNome());
		clienteEntity.setCpf(cliente.getCpf());
		clienteEntity.setEmail(cliente.getEmail());
		clienteEntity.setTelefone(cliente.getTelefone());
		clienteEntity.setCelular(cliente.getCelular());
		clienteEntity.setNascimento(cliente.getNascimento());
		clienteEntity.setLogradouro(cliente.getLogradouro());
		clienteEntity.setBairro(cliente.getBairro());
		clienteEntity.setCidade(cliente.getCidade());
		clienteEntity.setEstado(cliente.getEstado());
		clienteEntity.setCep(cliente.getCep());
		clienteEntity.setComplemento(cliente.getComplemento());
		
		clienteRepository.save(clienteEntity);
		
		cliente.setId(clienteEntity.getId());
		
		return cliente;

	}
	
	
}
