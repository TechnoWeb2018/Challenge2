package Jena;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDF;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Model model = ModelFactory.createDefaultModel();
		Resource Etudiant = ResourceFactory.createResource("htpp://exemple.org/Etudiant");
		
		model.add(Etudiant, RDF.type, FOAF.Person);
		model.add(Etudiant, FOAF.name,"Alice");
		model.add(Etudiant, FOAF.age, "36");
		
		model.write(System.out, "TURTLE");
	}

}
