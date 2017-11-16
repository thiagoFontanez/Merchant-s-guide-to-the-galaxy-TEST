To start you will need the following items below
-------------------------------------------------- -------------

- Maven
- Project "Merchants Guide"
- Have an input.text file

-------------------------------------------------- -------------
---------------- Starting the project ------------------------
-------------------------------------------------- -------------
Step: 1

first create an input.txt file in the MerchantsGuide folder
contains an example file.
you can use the sample file to run the project.

Step: 2
Unzip the MerchantsGuide.targz project, and go to the MerchantsGuide folder
Turn the command below:

-> mvn clean package 

Step: 3
go to the target folder, "MerchantsGuide> target", inside the folder check if there is
a file named "MerchantsGuide-0.0.1-SNAPSHOT.jar"
	-> If yes, open your terminal at the location of the file "MerchantsGuide-0.0.1-SNAPSHOT.jar"
	-> run the following command:
		-> java -Dpath=Local/do/arquivo/input.txt -jar MerchantsGuide-0.0.1-SNAPSHOT.jar
	example -> java -Dpath=/home/thiagograciani/eclipse-workspace/MerchantsGuide/input.txt -jar MerchantsGuide-0.0.1-SNAPSHOT.jar

Obs -> it is extremely important to correctly include the location of the file for the program to work;

	-> if not, return to step: 2 and perform the procedure again;


-------------------------------------------------- ---------------------
Additional Information.
-------------------------------------------------- ----------------------

It was included unitary test to maintain the integrity of methodos;
	-> test of verification of the repetition of ROMANOS numerals, not being able to send more than 4x in the same sequence:
	-> test of the repetition of ROMANOS numbers D, L and V, can not repeat once;
	-> verification test of input file information;
	-> test to check Roman numerals translation for arabic "numerals".


