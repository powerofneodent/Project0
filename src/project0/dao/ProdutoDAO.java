package project0.dao;

import java.util.List;

import project0.criteria.ProdutoCriteria;
import project0.model.Produto;
import project0.model.Sample;
import project0.service.Results;

public interface ProdutoDAO {
	
	public abstract List<Produto> findAll() throws Exception;
	public abstract Produto findById(String id) throws Exception;
	public abstract Produto create(Produto produto) throws Exception;
	public abstract boolean update(Produto produto) throws Exception;
	public abstract boolean delete(String id) throws Exception;
	public abstract Results<Produto> findByCriteria(ProdutoCriteria criteria, int from,int pageSize) throws Exception;
	public abstract Produto findSampleById(String id) throws Exception;
}
