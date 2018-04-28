/**
 * 
 */
package TrainingCode;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

/**
 * @author jessi
 *
 */
public class ConstruireFromGraphe extends Object {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String personURI ="http://somewhere/JohnSmith";
		String givenName = "John";
		String familyName = "Smith";
		String fullName = givenName + " "+ familyName;
		
		//création du modèle
		Model model = ModelFactory.createDefaultModel();
		
		//Création ressource et ajout des proprietes en cascade
		
		Resource johnSmith = model.createResource(personURI)
				.addProperty(VCARD.FN, fullName)
				.addProperty(VCARD.N, 
						model.createResource()
							.addProperty(VCARD.Given, givenName)
							.addProperty(VCARD.Family, familyName));
		
		model.write(System.out);
	}

}
