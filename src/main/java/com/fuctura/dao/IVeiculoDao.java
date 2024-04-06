package com.fuctura.dao;

import java.util.List;

import com.fuctura.model.Veiculo;

public interface IVeiculoDao {
	
	void salvar(Veiculo veiculo);
	Veiculo buscarPorId(Long id);
	List<Veiculo> listarTodos();
	void atualizar(Veiculo veiculo);
	void deletar(Long id);

}
