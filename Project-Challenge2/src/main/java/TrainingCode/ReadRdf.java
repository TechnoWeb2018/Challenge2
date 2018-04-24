package TrainingCode;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class ReadRdf {

	private String Ns = "../20140114.rdf";
	
	public void load() {
		Model model = ModelFactory.createDefaultModel();
		model.read(Ns);
		model.write(System.out);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadRdf readRdf = new ReadRdf();
		readRdf.load();
	}

}
