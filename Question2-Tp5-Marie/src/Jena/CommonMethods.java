package Jena;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;

public class CommonMethods {

	private Model model;

	public void writeModel() {
		model.write(System.out,"RDF/XML");
		model.write(System.out, "TURTLE");
	}
	
	public void addStatement(String s, String p, String o) {
		Resource subject = model.createResource(s);
		Property predicate = model.createProperty(p);
		RDFNode object = model.createResource(o);
		Statement statement = model.createStatement(subject, predicate, object);
		model.add(statement);
	}
	
	public void addStatement(String s, Property p, String o) {
		Resource subject = model.createResource(s);
		RDFNode object = model.createResource(o);
		Statement statement = model.createStatement(subject, p, object);
		model.add(statement);
	}	
}
