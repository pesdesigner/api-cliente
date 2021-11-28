package net.atos.api.cliente.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cliente {
	
	private LocalDate dataCadastro;
	private LocalDateTime dataAlteracao;

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

}
