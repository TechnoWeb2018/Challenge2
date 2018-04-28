package rdf;

public class Requetes {
	
	// requete sur le graphe /vc-db-1.rdf
	public static String queryString_1 =			
								" PREFIX vCard: <http://www.w3.org/2001/vcard-rdf/3.0#> "+
								" PREFIX info: <http://somewhere/peopleInfo#> " +
								" SELECT ?Given ?Family " +
								" WHERE {"  +
									" ?person vCard:Given ?Given . " +
									" ?person vCard:Family ?Family } "+
								" ORDER BY ?Given ";			

	
	// requete sur le graphe /vc-db-2.rdf
	/**
	 * Utilisation du Filter 
	 * ou de Optional
	 * */
	public static String queryString_2 =			
								" PREFIX vCard: <http://www.w3.org/2001/vcard-rdf/3.0#> "+
							    " PREFIX info: <http://somewhere/peopleInfo#> "+
								" PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
								" SELECT ?FN ?age " +
								" WHERE {"  +
									" ?person vCard:FN ?FN . "+
									" OPTIONAL { ?person info:age ?age . FILTER (?age > 24) } } ";
								//" FILTER (?age >= \"24\"^^xsd:integer) }";
	/**
	 * FILTER : 
	 * regex est comme like
	 * trouver les prenoms qui contienent un r ou R
	 * i = insensible à la casse
	 * */
	// requete sur le graphe /vc-db-1.rdf
	public static String queryString_3 =			
								" PREFIX vCard: <http://www.w3.org/2001/vcard-rdf/3.0#> "+
								" SELECT ?Given " +
								" WHERE {"  +
									" ?person vCard:Given ?Given . "
									+ " FILTER regex(?Given, 'r','i') } "
								;	
	
	/**
	 * Utilisation de Optional*/
	// requete sur le graphe /vc-db-2.rdf
	public static String queryString_4 =			
								" PREFIX vCard: <http://www.w3.org/2001/vcard-rdf/3.0#> "+
								" PREFIX info: <http://somewhere/peopleInfo#> " +
								" SELECT ?Given ?Family ?age " +
								" WHERE {"  +
									" ?person vCard:Given ?Given . " +
									" ?person vCard:Family ?Family . "+
									" ?person info:age ?age  } "+
								" ORDER BY ?Given ";	
}
