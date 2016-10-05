"use strict";
		var $ = function(id) { return document.getElementById(id); };
		//calculates  final grade stores results in results array.
	var calculateFinalGrade = function(score1,score2,score3){
		var results=[];
		results[0]=(score1+score2+score3);
			if(results[0]>=270){
			results[1]="A";
			}
			else if(results[0]>=240 && results[0]<=269){
			results[1]="B";
			}
			else if(results[0]>=210 && results[0]<=239){
			results[1]="C";
			}
			else if(results[0]>=209 && results[0]<180){
			results[1]="D";
			}
			else if(results[0]<=180){
			results[1]="F";
			}
			return results;
			};
			//takes in the values of the score and checks valid and returns results to the total score and grade.
		var processEntries = function() {
            var score1 = parseInt($("score1").value);
		    var score2 = parseInt($("score2").value);
			var score3 = parseInt($("score3").value);
	
			var message ="";
			var totalscore, finalgrade;
			
			//modify the following data validation code to do validate for each test score
            if (isNaN(score1) || isNaN(score2)|| isNaN(score3)) {
                alert("All entries must be numeric!");
            } 
			else if (score1<0 || score1>100)
			{
				message = 'Score 1 should be between 0 and 100!';
				alert(message);
			}
			else if (score2<0 || score2>100)
			{
				message = 'Score 2 should be between 0 and 100!';
				alert(message);
			}
			else if (score3<0 || score3>100)
			{
				message = 'Score 3 should be between 0 and 100!';
				alert(message);
			}
			else{
			//holds the array to be used
			var hold=calculateFinalGrade(score1,score2,score3);
			$('scoreTotal').value=hold[0];
			$('scoreFinal').value=hold[1];
			}
        };
		
		window.onload = function() {
			$("calculate").onclick = processEntries;
			$("score1").focus();
        };
