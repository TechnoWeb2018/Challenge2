package TrainingCode;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import rdf.ReadRDFsecond;

public class ExecuteSPARQL {

	private static String fileToString(String chemin) throws IOException {
		String reponse ="";
		String Chemin = "../"+chemin;
		Path path = Paths.get(Chemin);		
		List<String> lignes = Files.readAllLines(path, Charset.defaultCharset());		
		for(String ligne : lignes) reponse = reponse + ligne + "\n";		
		return reponse;
	}
	static final String inputFileName = "../foaf.rdf ";

	static void sparqlTest() {

        Model model1 = ReadRDFsecond.ReadModelFromFile(inputFileName);
        
		String queryString = 
				" PREFIX mov:<http://rdf.freebase.com/ns/> " +
				" SELECT ?who ?film " +
				"WHERE {"  +
					" ?film mov:film.film.directed_by ?who . "+
					" ?person1 rdfs:subClassOf ?Person . "+
					" ?film mov:film.film.starring ?who . } ";	
		
	Query query = QueryFactory.create(queryString);
	QueryExecution qexec = QueryExecutionFactory.create(query,model1);
	try {
		ResultSet results = qexec.execSelect();
		while (results.hasNext()) {
			QuerySolution person = results.nextSolution();
			Literal name = person.getLiteral("name");
			Literal age = person.getLiteral("age");
			
			System.out.println(name + " "+ age);
			}			
		}
	finally {
		qexec.close();
		}		
	}	
	public static void main(String[] args) throws IOException {	
		sparqlTest();			
	}
}
