package it.unitn.disi.ubytrial;

import java.io.File;
import java.io.FileNotFoundException;

import org.dom4j.DocumentException;

import de.tudarmstadt.ukp.lmf.api.Uby;
import de.tudarmstadt.ukp.lmf.hibernate.UBYH2Dialect;
import de.tudarmstadt.ukp.lmf.transform.DBConfig;
import de.tudarmstadt.ukp.lmf.transform.LMFDBUtils;
import de.tudarmstadt.ukp.lmf.transform.XMLToDBTransformer;

/**
 * david: taken from 
 * <a href="https://github.com/dkpro/dkpro-uby/blob/master/de.tudarmstadt.ukp.uby.testing-asl/src/main/java/de/tudarmstadt/ukp/test/resources/UbyTestDbProvider.java">
 * uby.testing-asl  UbyTestDbProvider </a> 
 * with some little mod
 * 
 * @author Eckle-Kohler
 * Provides an in-memory UBY test DB for testing.
 *
 */
public class DbMaker {

	private Uby uby;
	private DBConfig dbConfig;
	
	public DbMaker()  {
			
		try {
			this.uby = createDB();
		} catch (Exception ex){
			throw new RuntimeException("Error while creating ubi db!", ex);
		}

	}

	public Uby getUby() {
		return this.uby;
	}
	
	private Uby createDB() throws DocumentException, IllegalArgumentException, FileNotFoundException {
		String uby_user = "root";
		String uby_pass = "pass";
		
		dbConfig = new DBConfig("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1","org.h2.Driver",UBYH2Dialect.class.getName(),uby_user,uby_pass,true);
	
		LMFDBUtils.createTables(dbConfig);					
		
		Uby uby = new Uby(dbConfig);	

		return uby;
	}
	
	public void loadLmfXml(String filepath){
		XMLToDBTransformer trans = new XMLToDBTransformer(dbConfig);
		
		try {
				trans.transform(new File(filepath),"UbyTest"); // name seems not be required to be in the xml
		} catch (Exception ex){
			throw new RuntimeException("Error while loading lmf xml " + filepath, ex);
		}		
	}



}
