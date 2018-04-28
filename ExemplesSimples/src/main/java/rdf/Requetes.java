package rdf;

public class Requetes {
	
	// requete sur le graphe /vc-db-1.rdf
	public static String queryString_1 =			
								" PREFIX vCard: <http://www.w3.org/2001/vcard-rdf/3.0#> "+
								" SELECT ?Given " +
								"WHERE {"  +
									" ?person vCard:Given ?Given } "+
								" ORDER BY ?Given ";			

	
	// requete sur le graphe /vc-db-2.rdf
	public static String queryString_2 =			
								" PREFIX vCard: <http://www.w3.org/2001/vcard-rdf/3.0#> "+
							    " PREFIX info: <http://somewhere/peopleInfo#> "+
								" PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
								" SELECT ?person" +
								"WHERE {"  +
									" ?person info:age ?age  "+
								" FILTER (?age >= 24) }";
	
	
	// requete sur le graphe /vc-db-2.rdf
	public static String queryString_3 =			
								" PREFIX vCard: <http://www.w3.org/2001/vcard-rdf/3.0#> "+
							    " PREFIX info: <http://somewhere/peopleInfo#> "+
								" PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
								" SELECT ?Given ?age" +
								"WHERE {"  +
									" ?person vCard:Given ?Given . "+
									" ?person info:age ?age } "+
								" ORDER BY ?Given ";	
	/**
	 * FILTER : 
	 * regex est comme like
	 * trouver les prenoms qui contienent un r ou R
	 * i = insensible à la casse
	 * */
	// requete sur le graphe /vc-db-1.rdf
	public static String queryString_1_B =			
								" PREFIX vCard: <http://www.w3.org/2001/vcard-rdf/3.0#> "+
								" SELECT ?g " +
								"WHERE {"  +
									" ?person vCard:Given ?g."
									+ " FILTER regex(?g, 'r','i') } "
								;	
}
