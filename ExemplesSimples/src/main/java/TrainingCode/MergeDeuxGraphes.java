package TrainingCode;


import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class MergeDeuxGraphes {

	 	static final String inputFileName1 = "../OutPut1.rdf";    
	    static final String inputFileName2 = "../OutPut1-rdf.rdf";
	    
	    public static void main (String args[]) {
	        // create an empty model
	        Model model1 = ModelFactory.createDefaultModel();
	        Model model2 = ModelFactory.createDefaultModel();
	       
	        
	        // read the RDF/XML files
	        model1.read( inputFileName1);
	        model2.read( inputFileName2 );
	        
	        // merge the graphs
	        Model model = model1.union(model2);
	        
	        // print the graph as RDF/XML
	        model.write(System.out, "RDF/XML-ABBREV");
	        System.out.println();
	    }

}
