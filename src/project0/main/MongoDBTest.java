package project0.main;

import java.util.logging.Logger;

import project0.dao.ProdutoDAO;
import project0.dao.impl.ProdutoDAOImpl;
import project0.model.Produto;

public class MongoDBTest {

	private static final Logger logger = Logger.getLogger(MongoDBTest.class.getName());
	
	public static void main(String[] args) {
		
		try {
			ProdutoDAO produtoDAO = new ProdutoDAOImpl();
//	
//			Produto p = new Produto();
//			p.setNome("p4");
//			p.setPrezo(5.5);
//			
//
//			produtoDAO.create(p);

		
			Produto produto = produtoDAO.findById("9a9e03c3-2278-4c0f-9243-fcdffd77c143");
			
			produto.setNome("p2");
			
			produtoDAO.update(produto);
			logger.info("Produto actualizado: " + produtoDAO.findById("9a9e03c3-2278-4c0f-9243-fcdffd77c143"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
