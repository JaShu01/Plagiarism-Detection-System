function counter() { //Funktion um Wörter während der Eintippen zu zählen und Maximale Anzahl zu setzen
  var text = document.getElementById("text_area").value; //Text in Text Area den "text" Variable zuweisen
  var words_number = text.trim().split(/\s+/).length; //Wörter Aufteilung in List

  if (words_number > 1000) { //Anweisung um Wörter Anzahl zu begrenzen
    var limited_text = text.split(/\s+/).slice(0, 1000).join(" "); //falls text mehr als 1000 word,Löschung
    words_number = 1000; //Anzahl wieder als 1000 setzen
    document.getElementById("text_area").value = limited_text; //den begrenzte Text als eingegebene Text zurückgeben
  }

  var counting_numbers = words_number + "/1000"; //initial Numbers auf neue Numbers zu ändern
  document.getElementById("initial_wordnumber").innerHTML = counting_numbers; //Ersetzung durch counting
}
  
  
async function checking() { //Funktion um ein Response in Backend abzuschicken und Results von Plagiat Erkennung zu bekommen
  const text = document.getElementById('text_area').value; //Text in Text Area den "text" Variable zuweisen 
  const connection = await fetch('http://localhost:8080/plagiarism-check', { // Verbindung zum Backend Spring Boot Standart Host durch Fetch Methode
    method: 'POST', //Fetch HTTP  Abfrage Durch Post
    headers: { //Abfrage Kopf durch JSON Setzen
     'Content-Type': 'application/json'
    },
   body: JSON.stringify({ text: text }) //Daten in JSON Format zu enthalten
  });
  const docs = await connection.json(); // Liest den Antwort des Servers in JSON Weise
  const plagiarismusGrad = docs.count; //Zuwesiung von Server Antowrt zum Plagiarismus Variable
  const show = document.getElementById('plagiarism'); //Plagiarism Schreiben Zuweisung
  show.textContent = `Plagiarismus: ${plagiarismusGrad}%`; //Ersetzung von Plagiarismus Prozent durch Ergebnis von Backend

  let scale = document.getElementById("scale"); //Zuweisung von "scale" aus html Datei zu "scale" Variable
  scale.style.width = plagiarismusGrad + "%"; // Waage Breit Änderung Anhand Plagiarismusgrad

  // Waage Farbe Änderung Anhand Plagiarismusgrad
  if (plagiarismusGrad <= 33) { //Falls Plagiarismus kleine/gleich als 33% dann Grün
    scale.style.backgroundColor = "green";
  } else if (plagiarismusGrad > 33 && plagiarismusGrad < 66) { //Falls Plagiarismus grösser als 33% und kleine als 66% dann Gelb
    scale.style.backgroundColor = "yellow";
  } else { //Falls Plagiarismus grösser/gleich als 66% dann Rot
    scale.style.backgroundColor = "red";
  }
  }


