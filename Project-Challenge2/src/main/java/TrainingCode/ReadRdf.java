package TrainingCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class ReadRdf {

	private String Ns = "../20140114.rdf";
	
	public void load() throws FileNotFoundException{
		Model model = ModelFactory.createDefaultModel();
		model.read(Ns);
		model.write(System.out);
		model.write(new PrintWriter(System.out));
		//File file = new File("../OutPut1.rdf");
		//model.write(new PrintWriter(file));
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		ReadRdf readRdf = new ReadRdf();
		readRdf.load();
	}

}
