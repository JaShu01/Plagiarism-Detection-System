

package edu.fra.uas;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
//Annotation aus der Vorlesung zum REST Bildung
@RestController
//CROS um den POST Methode bein allen Domains zu erlauben
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.POST })

public class PlagiarismController {
     //POST Zugriff auf Localhost:8080/plagiarism-check
    @PostMapping("/plagiarism-check")
    //Methode zum Plagiatserkennung und Response zurück in Backend
    public Map<String, Double> checkPlagiat(@RequestBody Map<String, String> requestBody) {
    	 //Variable Text wird text aus Frontend zugewiesen
        String text = requestBody.get("text"); 
        List<String> shingle2 = ShinglePlagiarismChecker.CreateShingles(text, main.shingleSize);
        //Treffer Anzahl Check für Jedem Text mit UserText
        double similarity1 = ShinglePlagiarismChecker.CheckSimilarity(shingle2, main.shingle3);
        double similarity2 = ShinglePlagiarismChecker.CheckSimilarity(shingle2, main.shingle4);
        double similarity3 = ShinglePlagiarismChecker.CheckSimilarity(shingle2, main.shingle5);
        double similarity4 = ShinglePlagiarismChecker.CheckSimilarity(shingle2, main.shingle6);
        double similarity5 = ShinglePlagiarismChecker.CheckSimilarity(shingle2, main.shingle7);
        double similarity6 = ShinglePlagiarismChecker.CheckSimilarity(shingle2, main.shingle8);
        double similarity7 = ShinglePlagiarismChecker.CheckSimilarity(shingle2, main.shingle9);
        double similarity8 = ShinglePlagiarismChecker.CheckSimilarity(shingle2,main.shingle10);
        double similarity9 = ShinglePlagiarismChecker.CheckSimilarity(shingle2, main.shingle11);
        double similarity10 = ShinglePlagiarismChecker.CheckSimilarity(shingle2, main.shingle12);
        double plagiat_degree = similarity1+similarity2+similarity3+similarity4+similarity5+similarity6+similarity7+similarity8+similarity9+similarity10;
    	//Falls ein Fehler gibt, die Plagiarismus mehr als 1 angibt, wird es 1 sein, denn mehr als 100% kann Plagiat nicht sein 
    	if(plagiat_degree>1) {
    		plagiat_degree=1;
    	}
    	//Runding von Double Zahl
        double plagiarismus = Math.round(plagiat_degree *100);
        //Zuweisung von Response Variable
        Map<String, Double> response = new HashMap<>();
        //Response den Plagiarismus Wert zugewiesen
        response.put("count", plagiarismus);
        return response;
        
      }
      
    }
