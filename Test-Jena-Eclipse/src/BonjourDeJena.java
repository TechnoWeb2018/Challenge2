import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;


public class BonjourDeJena {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Model monModele = ModelFactory.createDefaultModel();
		//cr�er une ressource MESSAGE
		Resource message = monModele.createResource("http://webtutoriel/message");
		//cr�er une propri�t� VALEUR
		Property valeurProp = monModele.createProperty("http://webtutoriel/valeur");
		//Assigner une valeur � la ressource
		message.addProperty(valeurProp, "Bonjour � tous");
		//Imprimer le contenu du mod�le dans la syntaxe TTL
		monModele.write(System.out, "TTL");
			
		
	}

}
