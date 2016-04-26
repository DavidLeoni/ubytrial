package it.unitn.disi.ubitrial;

import org.junit.Test;

import de.tudarmstadt.ukp.lmf.model.core.LexicalEntry;
import de.tudarmstadt.ukp.lmf.model.core.LexicalResource;
import de.tudarmstadt.ukp.lmf.model.core.Lexicon;
import de.tudarmstadt.ukp.lmf.transform.DBConfig;




/**
 * Unit test for simple App.
 */
public class AppTest   
{ 
 
	private void log(String msg){
		System.out.println("****  DAV TESTER:  " + msg);
	}
	private void log(){
		System.out.println();
	}
	
    @Test
    public void testApp()
    {
    	LexicalResource lexRes;
    	
    	DBConfig dbc = new DBConfig();
    	
    	TestDb db = new TestDb();
        
    	db.loadLmfXml("ca_wordnet_xtract_lmf_fixed.xml");    	
    	db.loadLmfXml("es_wordnet_xtract_lmf_fixed.xml");
    	
    	log("Printing lexicons...");
    	log();
    	log();
    	for (Lexicon lex : db.getUby().getLexicons()){
    		log("Printing lexicon id: " + lex.getId() + "   name: " + lex.getName());
    		log();
    		for (LexicalEntry entry : lex.getLexicalEntries()){
    			log("Printing entry:");
    			log(entry.toString());
    		}
    	}
    }
}


