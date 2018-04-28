package rdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.rdf.model.Statement;

public class RDFPerson {
	
	private Model model;
	
	public void writeModel() throws FileNotFoundException {
		
		/**
		 * Permet d'afficher le résultat dans un fichier
		 * (Utile pour le Challenge, on ne se jamais)Lol
		 * 
		 * */
		File file_rdf = new File("../OutPut1-rdf.rdf");
		File file_turtle = new File("../OutPut1-turtle.rdf");
		model.write(new PrintWriter(file_rdf),"RDF/XML");
		model.write(new PrintWriter(file_turtle),"TURTLE");
		
		/**
		 * Affiche le résultat dans la console*/
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
	
	public void createModel() {
		model = ModelFactory.createDefaultModel();
		String ns ="http://www.example.org#";
		
		//Set a namespace
		model.setNsPrefix("per", ns);
		model.setNsPrefix("foaf", FOAF.getURI());
		
		addStatement(ns + "Student",RDFS.subClassOf, ns + "Person");
		addStatement(ns + "Staff",RDFS.subClassOf, ns + "Person");
		
		addStatement(ns + "Undergraduate",RDFS.subClassOf, ns + "Student");
		addStatement(ns + "Graduate",RDFS.subClassOf, ns + "Student");
		
		addStatement(ns + "Professor",RDFS.subClassOf, ns + "Staff");
		addStatement(ns + "Assistant",RDFS.subClassOf, ns + "Staff");
		
		// addStatement(ns + "prof1", RDF.type, ns + "Professor");
		// addStatement(ns + "prof1", FOAF.name, ns + "Bob");
		// addStatement(ns + "prof1", FOAF.age, ns + "50");
		
		RDFNode undergraduate = model.createResource(ns + "Undergraduate");
		RDFNode professor = model.createResource(ns + "Professor");
		
		Resource alice = model.createResource()
								.addProperty(RDF.type, undergraduate)
								.addLiteral(FOAF.name, "Alice")
								.addLiteral(FOAF.age, 36);
		
		Resource bob = model.createResource()
				.addProperty(RDF.type, professor)
				.addLiteral(FOAF.name, "Bob")
				.addLiteral(FOAF.age, 50);
	}
	
	public static void main(String[] args) {
		RDFPerson person = new RDFPerson();
		person.createModel();
		try {
			person.writeModel();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
