
Some trial for UBY library. 

Tests are in [AppTest](src/test/java/it/unitn/disi/ubytrial/UbyTest.java)

Loaded xmls are in [files/](files/) folder, including [UBY standard xml](files/UbyTestLexicon.xml) example to compare with.


### Maven

In order to use Maven, as of this writing (Apr 26, 2016) there are no Maven uby artifacts on central, but they are in a separate repo provided by UBY maintainers, see [Download instructions](https://dkpro.github.io/dkpro-uby/downloads/) for using them in your project.

### Loading LMF XMLs

For loading example xmls, in order to avoid exceptions like 
	
```	
	Caused by: org.dom4j.DocumentException: ids for this class must be manually assigned before calling save(): de.tudarmstadt.ukp.lmf.model.core.LexicalResource Nested exception: ids for this class must be manually assigned before calling save(): de.tudarmstadt.ukp.lmf.model.core.LexicalResource
```

I did this:

1) Added name to LexicalResource:
```
<LexicalResource name="Some trial es">
```
2) Added id to Lexicon:
```
<Lexicon id="some-id-es"
``` 