/**
 * 
 */
package rdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDFS;

/**
 * @author jessi
 *
 */
public class ConstruireRDF_Question3_Tp5 {
	
	private Model model;

	/**
	 * Permet d'afficher le résultat dans un fichier
	 * */	
	public void writeModelInFile() throws FileNotFoundException {
		
		File file_rdf = new File("../OutPut1-rdf.rdf");
		File file_turtle = new File("../OutPut1-turtle.rdf");
		model.write(new PrintWriter(file_rdf),"RDF/XML");
		model.write(new PrintWriter(file_turtle),"TURTLE");
	}
	
	/**
	 * Affiche le résultat dans la console*/	
	public void writeModel(){

		model.write(System.out,"RDF/XML");
		model.write(System.out, "TURTLE");
	}	
	
	public void createModel() {
		
		//definition
		String ContinentURI = "http://somewhere/continent";
		String ContinentAfricaURI = "http://somewhere/continent#Africa";
		String ContinentSouthAfricaURI = "http://somewhere/continent/africa#SouthAFrica";
		String ContinentEuropeURI = "http://somewhere/continent#Europe";
		String ContinentBelgiumURI = "http://somewhere/continent/Europe#Belgium";		
		String PropertyURIname = "http://somewhere/propeerty#name";
		String PropertyURIisln = "http://somewhere/propeerty#isln";
		
		
		//Créer un model vide
		model = ModelFactory.createDefaultModel();
		Property property = model.createProperty(PropertyURIname);
		Property propertyISLn = model.createProperty(PropertyURIisln);
		
		//création des ressources et ajout des proprietes en cascade		
		Resource Continent = model.createResource(ContinentURI)
				.addProperty(property, "Continent")
				.addProperty(RDFS.subClassOf, 
						model.createResource(ContinentAfricaURI)
							.addProperty(property, "Africa")
							.addProperty(propertyISLn, 
									model.createResource(ContinentSouthAfricaURI)
										.addProperty(property, "South Africa")))
				.addProperty(RDFS.subClassOf, 
						model.createResource(ContinentEuropeURI)
							.addProperty(property, "Europe")
							.addProperty(propertyISLn, 
									model.createResource(ContinentBelgiumURI)
										.addProperty(property, "Belgium"))							
						
						
						);
	}
	
	public static void main(String[] args) {
		
		ConstruireRDF_Question3_Tp5 Q = new ConstruireRDF_Question3_Tp5();
		Q.createModel();
		Q.writeModel();

	}

}
