package edu.fra.uas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class main {
	//Shingles Bestimmung um Zugang in anderen Klassen zu haben
	 public static int shingleSize = 3; 
	 public static List<String> shingle3;
	 public static List<String> shingle4;
	 public static List<String> shingle5;
	 public static List<String> shingle6;
	 public static List<String> shingle7;
	 public static List<String> shingle8;
	 public static List<String> shingle9;
	 public static List<String> shingle10;
	 public static List<String> shingle11;
	 public static List<String> shingle12;
	 
	

	public static void main(String[] args) throws IOException { //Exceiption falls Datei nicht vorhanden ist
		SpringApplication.run(main.class, args);
		
		//Zugang auf Txt Dateien 
		String Soziale_Medien = String.join("\n", Files.readAllLines(Paths.get(        
				"C:\\Users\\jashu\\Downloads\\Text 5_Soziale Medien_1419 wörter.txt")));
		//System.out.println(Soziale_Medien);
		String Web_Anwendung = String.join("\n", Files.readAllLines(Paths.get(
				"C:\\Users\\jashu\\Downloads\\Text 2_Webanwendung_1052 wörter.txt")));
		String OOP = String.join("\n", Files.readAllLines(Paths.get(
				"C:\\Users\\jashu\\Downloads\\Text 2_Webanwendung_1052 wörter.txt")));
		String Impfstoff = String.join("\n", Files.readAllLines(Paths.get(
				"C:\\Users\\jashu\\Downloads\\Text 8_Covid19Impfstoffen_545 wörter.txt")));
		String Social_Media = String.join("\n", Files.readAllLines(Paths.get(
				"C:\\Users\\jashu\\Downloads\\Text 6_Social Media_923 wörter.txt")));
		String COVID19_Pandemie = String.join("\n", Files.readAllLines(Paths.get(
				"C:\\Users\\jashu\\Downloads\\Text 7_Covid19Pandemie_1765 wörter.txt")));
		String Online_Anwendung = String.join("\n", Files.readAllLines(Paths.get(
				"C:\\Users\\jashu\\Downloads\\Text 1_Web Anwendung_447 wörter.txt")));
		String objektorientierte_Programmierung = String.join("\n", Files.readAllLines(Paths.get(
				"C:\\Users\\jashu\\Downloads\\Text 10_OOP_1010 wörter.txt")));
		String Wirtschaftsinformatik_Studium = String.join("\n", Files.readAllLines(Paths.get(
				"C:\\Users\\jashu\\Downloads\\Text 4_Wirtschaftsinformatik Studium_931 wörter.txt")));
		String Wirtschaftsinformatik = String.join("\n", Files.readAllLines(Paths.get(
				"C:\\Users\\jashu\\Downloads\\Text 3_Wirtschaftsinformatik_1136 wörter.txt")));

	    
		
		//Erstellung von Shingles aus Jedem DatenBank Text

		 shingle3 = ShinglePlagiarismChecker.CreateShingles(Wirtschaftsinformatik, shingleSize);
		 shingle4 = ShinglePlagiarismChecker.CreateShingles(Impfstoff, shingleSize);
		 shingle5 = ShinglePlagiarismChecker.CreateShingles(OOP, shingleSize);
		 shingle6 = ShinglePlagiarismChecker.CreateShingles(objektorientierte_Programmierung, shingleSize);
		 shingle7 = ShinglePlagiarismChecker.CreateShingles(COVID19_Pandemie, shingleSize);
		 shingle8 = ShinglePlagiarismChecker.CreateShingles(Social_Media, shingleSize);
		 shingle9 = ShinglePlagiarismChecker.CreateShingles(Online_Anwendung, shingleSize);
		 shingle10 = ShinglePlagiarismChecker.CreateShingles(Web_Anwendung, shingleSize);
		 shingle11 = ShinglePlagiarismChecker.CreateShingles(Soziale_Medien, shingleSize);
		 shingle12 = ShinglePlagiarismChecker.CreateShingles(Wirtschaftsinformatik_Studium, shingleSize);
	}

}
