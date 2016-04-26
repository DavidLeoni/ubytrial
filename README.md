
Some trial for UBY library. 

Tests are in [AppTest](src/test/java/it/unitn/disi/ubytrial/AppTest.java)

Loaded xmls are in [files/](files/) folder.


In order to avoid exceptions like 
	
```	
	Caused by: org.dom4j.DocumentException: ids for this class must be manually assigned before calling save(): de.tudarmstadt.ukp.lmf.model.core.LexicalResource Nested exception: ids for this class must be manually assigned before calling save(): de.tudarmstadt.ukp.lmf.model.core.LexicalResource
```

I did this:

1) Added name to LexicalResource:
<LexicalResource name="Some trial es">

2) Added id to Lexicon:
<Lexicon id="some-id-es" 