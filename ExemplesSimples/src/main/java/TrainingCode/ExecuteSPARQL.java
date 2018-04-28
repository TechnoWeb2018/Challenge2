package TrainingCode;

import java.io.IOException;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;

import rdf.ReadRDFsecond;
import rdf.Requetes;

public class ExecuteSPARQL {

	/*
	 * Toutes les requetes à tester se trouve dans la classe Requetes
	 * 
	 * Ainsi que le nom du RDF sur lequel elles sont executées
	 * 
	 * Si vous changer les requetes, il faut adapter le code pour l'affichage
	 * 
	 * */
	static final String inputFileName = "../vc-db-2.rdf ";

	static void ExecuteSPARQL(String inputRDFName, String requete, String literal[]) {
		
        Model model1 = ReadRDFsecond.ReadModelFromFile(inputRDFName);
        Query query = QueryFactory.create(requete);
	
        QueryExecution qexec = QueryExecutionFactory.create(query,model1);
        try {
        	ResultSet results = qexec.execSelect();
        		while (results.hasNext()) {
        			QuerySolution person = results.nextSolution();
        			for(int i = 0 ; i<literal.length;i++) System.out.print(person.getLiteral(literal[i])+" ");
        			System.out.println();
			}			
		}
        finally {
        	qexec.close();
		}			
	}
	/*
	static void sparqlTest() throws IOException {

        Model model1 = ReadRDFsecond.ReadModelFromFile(inputFileName);
        
	Query query = QueryFactory.create(Requetes.queryString_1);
	
	QueryExecution qexec = QueryExecutionFactory.create(query,model1);
	try {
		ResultSet results = qexec.execSelect();
		while (results.hasNext()) {
			QuerySolution person = results.nextSolution();
			Literal name = person.getLiteral("Given");	
			Literal familyName = person.getLiteral("Family");
			Literal age = person.getLiteral("age");
			System.out.println(name + " " + familyName + " "+age );
			}			
		}
	finally {
		qexec.close();
		}		
	}	*/
	public static void main(String[] args) throws IOException {	
		//sparqlTest();
		String literal [] = {"Given"};
		ExecuteSPARQL(inputFileName,Requetes.queryString_3,literal);
	}
}
