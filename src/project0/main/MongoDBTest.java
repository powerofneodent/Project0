package project0.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import project0.dao.ProdutoDAO;
import project0.dao.impl.ProdutoDAOImpl;
import project0.model.Produto;
import project0.model.Sample;

public class MongoDBTest {

	private static final Logger logger = Logger.getLogger(MongoDBTest.class.getName());
	
	public static void main(String[] args) {
		
		try {
			ProdutoDAO produtoDAO = new ProdutoDAOImpl();
//	
//			Produto p = new Produto();
//			p.setNome("p7");
//			p.setPrezo(2.34);
//			
//			List<Sample> samples = new ArrayList<Sample>();
//			Sample testSample = new Sample();
//			testSample.setId(UUID.randomUUID().toString());
//			testSample.setWeight(24.00);
//			testSample.setCollectDateTime(LocalDateTime.now());
//			
//			samples.add(testSample);
//			
//			p.setSamples(samples);
//			
			

//			Produto produto = produtoDAO.findById("9a9e03c3-2278-4c0f-9243-fcdffd77c143");
//			
//			produto.setNome("p2");
//			
//			produtoDAO.update(produto);
						
//			logger.info("Produto Insertado "+produtoDAO.create(p));
			String id = "a36053ad-6763-4afe-82c6-053a80e092d0";
			
			logger.info("Produto Insertado "+produtoDAO.findSampleById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
