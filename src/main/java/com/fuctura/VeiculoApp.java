package com.fuctura;

import com.fuctura.dao.impl.VeiculoDAO;
import com.fuctura.model.Veiculo;

public class VeiculoApp {
	public static void main(String[] args) {
		
		Veiculo veiculo = new Veiculo();
		VeiculoDAO veiculoDao = new VeiculoDAO();
		
		// salvar
		veiculo.setAnoFabricacao(2015);
		veiculo.setMarca("Renault");
		veiculo.setModelo("Sandero");
		veiculo.setPreco(40000);
		veiculoDao.salvar(veiculo);
		
		
		// buscar por id
		Veiculo veiculoRecuperado = veiculoDao.buscarPorId(1L);
		System.out.println(veiculoRecuperado);
		
		// listar todos
		System.out.println(veiculoDao.listarTodos());
		
		// atualizar o preço do veiculo id 1 
		veiculoRecuperado.setPreco(60000);
		veiculoDao.atualizar(veiculoRecuperado);
		System.out.printf("Preço veículo id: %d atualizado para %.2f\n",veiculoRecuperado.getId(), veiculoRecuperado.getPreco());
		
		// deletando o veiculo id 3 Sandero
		veiculoDao.deletar(3L);
		System.out.println("Veículo excluído");
	}

}
