package TrainingCode;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;

public class SPARQLservice {

	public static void main(String[] args) {
		
		Query query = QueryFactory.create("PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
				"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
				"PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" +
				"PREFIX dc: <http://purl.org/dc/elements/1.1/>\n" +
				"PREFIX : <http://dbpedia.org/resource/>\n" +
				"PREFIX dbpedia2: <http://dbpedia.org/property/>\n" +
				"PREFIX dbpedia: <http://dbpedia.org/>\n" +
				"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>" +
				"PREFIX dbo: <http://dbpedia.org/ontology/> "
				+ "SELECT ?name ?birth ?death ?person "
				+ "WHERE {"
				+ " ?person dbo:birthPlace :Berlin ."
				+ " ?person dbo:birthDate ?birth ."
				+ " ?person foaf:name ?name ."
				+ " ?person dbo:deathDate ?death ."
				+ " FILTER (?birth < \"1900-01-01\"^^xsd:date) ."
				+ " } "
				+ "ORDER BY ?name");
		
		try (QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query)) {
			ResultSet results = qexec.execSelect() ;
			for ( ; results.hasNext() ; )
				{
					QuerySolution soln = results.nextSolution() ;
					Literal name = soln.getLiteral("name"); // Get a result variable - must be a literal
					Literal birth = soln.getLiteral("birth"); // Get a result variable - must be a literal
					Literal death = soln.getLiteral("death"); // Get a result variable - must be a literal
					Resource person = soln.getResource("person"); // Get a result variable - must be a literal
					
					System.out.println(name);
					System.out.println(birth);
					System.out.println(death);
					System.out.println(person);
				}
			}
	}	
}
