package com.fuctura.dao.impl;

import java.util.List;

import com.fuctura.dao.IVeiculoDao;
import com.fuctura.model.Veiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class VeiculoDAO implements IVeiculoDao {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FUCTURA-PU");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	@Override
	public void salvar(Veiculo veiculo) {
		entityManager.getTransaction().begin();
		entityManager.persist(veiculo);
		entityManager.getTransaction().commit();
	}

	@Override
	public Veiculo buscarPorId(Long id) {
		return entityManager.find(Veiculo.class, id);
	}

	@Override
	public List<Veiculo> listarTodos() {
		return entityManager.createQuery("SELECT v FROM Veiculo v", Veiculo.class).getResultList();
	}

	@Override
	public void atualizar(Veiculo veiculo) {
		entityManager.getTransaction().begin();
		entityManager.merge(veiculo);
		entityManager.getTransaction().commit();
	}

	@Override
	public void deletar(Long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Veiculo veiculo = entityManager.find(Veiculo.class, id);
		if (veiculo != null) {
			entityManager.remove(veiculo);
		}
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
