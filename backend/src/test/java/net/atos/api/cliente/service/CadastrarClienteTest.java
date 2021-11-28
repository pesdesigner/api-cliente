package net.atos.api.cliente.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.ws.rs.BadRequestException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import net.atos.api.cliente.domain.Cliente;

@ExtendWith(MockitoExtension.class)
class CadastrarClienteTest {

	private CadastrarCliente cadastrarCliente;
	
	@BeforeEach
	public void iniciarTeste() {
		cadastrarCliente = new CadastrarCliente();
	}
	
	@Test
	@DisplayName("Teste do campo: data de cadastro")
	public void test_dataCadastro_null_lancarExcessao() {
		
		assertNotNull(cadastrarCliente);
		
		Cliente cliente = new Cliente();
		
		var assertThrows = assertThrows(BadRequestException.class, () -> cadastrarCliente.persistir(cliente));
		
		assertEquals("Campo: cadastroData não pode ser nulo", assertThrows.getMessage());
	}
	
	@Test
	@DisplayName("Teste do campo: data de alteração")
	public void test_dataAlteracao_null_lancarExcessao() {
		
		assertNotNull(cadastrarCliente);
		
		Cliente cliente = new Cliente();
		cliente.setDataCadastro(LocalDate.now());
		
		var assertThrows = assertThrows(BadRequestException.class, () -> cadastrarCliente.persistir(cliente));
		
		assertEquals("Campo: DataAlteracao não pode ser nulo", assertThrows.getMessage());	
	}
	
	@Test
	@DisplayName("Teste do status do cliente")
	public void test_status_null_lancarExcessao() {
		
		assertNotNull(cadastrarCliente);
		
		Cliente cliente = new Cliente();
		cliente.setDataCadastro(LocalDate.now());
		cliente.setDataAlteracao(LocalDateTime.now());
		
		var assertThrows = assertThrows(BadRequestException.class, () -> cadastrarCliente.persistir(cliente));
		
		assertEquals("status do cliente não pode ser nulo", assertThrows.getMessage());
	}

	
	
}
