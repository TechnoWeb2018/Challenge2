package TrainingCode;

import java.io.FileNotFoundException;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class ReadRdf {

	private String Ns = "../OutPut1.rdf";
	
	public void load() throws FileNotFoundException{
		Model model = ModelFactory.createDefaultModel();
		model.read(Ns);
		model.write(System.out);
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		ReadRdf readRdf = new ReadRdf();
		readRdf.load();
	}

}
