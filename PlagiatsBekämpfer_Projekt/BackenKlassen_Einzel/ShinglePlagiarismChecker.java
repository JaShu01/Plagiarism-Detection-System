package edu.fra.uas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShinglePlagiarismChecker { 

	public static List<String> CreateShingles(String text, int shingleSize) {        // Diese Methode erstellt Shingles aus einem Text mit einer bestimmten Shingle-Größe.
		text = text.replaceAll("[^a-zA-Z ]", "");                                   // Der Text wird zuerst von allen Nicht-Buchstaben und Leerzeichen befreit.
		String[] words = text.split(" ");                                          // Anschließend wird der Text in ein String-Array von Wörtern aufgeteilt.
		List<String> shingles = new ArrayList<>(words.length - shingleSize + 1);  // Eine neue Liste zum Speichern der richtigen Größe für die Anzahl der möglichen Shingles wird initialisiert.
		for (int i = 0; i <= words.length - shingleSize; i++) {                  // Eine Schleife iteriert über alle möglichen Shingles und fügt diese der Liste hinzu.
			shingles.add(String.join(" ", Arrays.copyOfRange(words, i, i + shingleSize))); // Die Methode Arrays.copyOfRange zum Erstellen neuen Subarrays von Wörtern mit der angegebenen Shingle-Größe.
			                                                                              // Zum Erstellen einer einzelnen Shingle werden die Wörter im Subarray mit einem Leerzeichen getrennt.
		}
		return shingles;                                                                // Am Ende wird die Liste aller Shingles zurückgegeben.
	}

	public static double CheckSimilarity(List<String> set1, List<String> set2) {    // Diese Methode nimmt zwei Listen von Strings und prüft ihre Ähnlichkeit.
		Set<String> set2Copy = new HashSet<>(set2);   // Erstellt eine Kopie der zweiten Liste.
		set2Copy.retainAll(new HashSet<>(set1));     // Behält nur die Elemente, die auch in der ersten Liste sind.
		int similarity = set2Copy.size();           // Berechnet die Anzahl ähnlicher Elemente und gibt sie aus.
		
		if(similarity/set1.size()>1){
			return 1;
			
		}
		return (double) similarity / set1.size(); // Am Ende wird die Anzahl ähnlicher Elemente zur Größe der ersten Liste zurückgegeben.
	}
}
