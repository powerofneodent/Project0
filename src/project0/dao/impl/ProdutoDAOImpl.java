package project0.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import project0.criteria.ProdutoCriteria;
import project0.dao.ProdutoDAO;
import project0.model.Produto;
import project0.service.Results;
import project0.util.MongoDBConnection;

public class ProdutoDAOImpl implements ProdutoDAO {

	private MongoCollection<Produto> produtos = null;

	public ProdutoDAOImpl() {
		super();
		produtos = MongoDBConnection.getDatabase().getCollection("produtos", Produto.class);
	}

	@Override
	public List<Produto> findAll() throws Exception {
		List<Produto> produtoList = new ArrayList<>();
		produtos.find().into(produtoList);
		return null;
	}

	@Override
	public Produto create(Produto produto) throws Exception {
		if (produto.getId() == null) {
			produto.setId(UUID.randomUUID().toString());
		}
		produtos.insertOne(produto);
		return produto;
	}

	@Override
	public Produto findById(String id) throws Exception {
		Bson idFilter = Filters.eq("_id", id);
		return produtos.find(idFilter).first();
	}

	@Override
	public boolean update(Produto nuevoProduto) throws Exception {
		try {
			Bson idFilter = Filters.eq("_id", nuevoProduto.getId());
			Bson updates = Updates.set("nome", nuevoProduto.getNome());
			produtos.updateOne(idFilter, updates);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Results<Produto> findByCriteria(ProdutoCriteria criteria, int from, int pageSize) throws Exception {
		Results<Produto> results = new Results<Produto>();

		List<Bson> filters = new ArrayList<Bson>();

		if (criteria.getNome() != null) {
			filters.add(Filters.lte("nome", criteria.getNome()));
		}

		if (criteria.getPrezoMin() != null) {
			filters.add(Filters.lte("prezo", criteria.getPrezoMin()));
		}

		if (criteria.getPrezoMax() != null) {
			filters.add(Filters.lte("prezo", criteria.getPrezoMax()));
		}

		Bson finalFilter = filters.isEmpty() ? Filters.empty() : Filters.and(filters);
		int skipValue = Math.max(0, from - 1);
		List<Produto> produtoPage = produtos.find(finalFilter).skip(skipValue).limit(pageSize).into(new ArrayList<Produto>());
		
		results.setPage(produtoPage);
		long total = produtos.countDocuments(finalFilter);
		results.setTotal((int) total);
		return results;
	}

	@Override
	public boolean delete(String id) throws Exception {
		try {
			Bson idFilter = Filters.eq("_id", id);
			produtos.findOneAndDelete(idFilter);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}