Project: weblog-analyzer
Aothors: David J. Barnes and Michael Kolling

This project is part of the Java 5 supplementary material for
chapter 4 of the book

   Objects First with Java - A Practical Introduction using BlueJ
   Fourth edition
   David J. Barnes and Michael Kolling
   Pearson Education, 2008


Purpose of project: To provide an illustration of the use of arrays.
How to start this project: Create a LogAnalyzer object.

The LogfileReader expects to read a file, weblog.txt,
containing lines of data in the format:

    year month day hour minute

month values are in the range 1-12 and day values in the range 1-31. If
the sample file cannot be found, the reader will create some simulated
data.
--------------------
respostas teóricas:

1. Corrija todos os erros no método a seguir:
/**
 * Imprime todos os valores no array de marcas
 * que são maiores que a média
 * @param marks Um array de valores de marca.
 * @param mean O valor da marca média
 */
public void printGreater(double marks, double mean)
{
   for(int index = 0; index < marks.length; index++) {
      if(marks[index] > mean) {
         System.out.println(marks[index]);
      }
   }
}

2. Reescreva o seguinte método, de modo que utilize um loop for 
   ao invés de um loop while:
/**
 * Lista todas as notas no bloco de notas.
 */
public void listNotes()
{
   for(int index = 0; index < notes.size(); index++) {
      System.out.println(notes.get(index));
   }
}
4. Reescreva o mesmo método mais uma vez para utilizar um loop for-each.
public void listNotes()
{
   for(String note : notes) {
      System.out.println(note);
   }
}

7. Que hora é retornada por seu método busiestHour se mais de uma 
   hora tiver a maior contagem?
R: a menor hora que tem a maior contagem

9. Verifique o funcionamento do loop do-while em: 
   https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html. 
   Escreva um loop do-while que imprima na tela os números de 1 até 10.
int i = 1;
do {
   System.out.println(i);
while ( i <= 10);
