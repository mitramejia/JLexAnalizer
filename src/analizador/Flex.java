package analizador;

import java.io.File;
import java.io.StringReader;
import javax.swing.JOptionPane;


public class Flex
{
	public static void main(String [] args)
	{
		try
	 	{
			String path = "//Users//mitramejia//AnalizadorJLex//src//analizador//lexer.flex";
			generadorLexer(path);
			
			
				String input = (JOptionPane.showInputDialog("Ingrese la expresion"));
				AnalizadorJFlex analizador = new AnalizadorJFlex(new StringReader(input));
				for(int i=0;i<input.length();i++)
				{
					if(input.charAt(i)>='0' && input.charAt(i)<='9')
					{
						AnalizadorJFlex analizer = new AnalizadorJFlex(new StringReader(String.valueOf(input.charAt(i))));
						System.out.println(analizer.yylex());
					}
					if(input.charAt(i)=='+' || input.charAt(i)=='-' || input.charAt(i)=='*' || input.charAt(i)=='/' || input.charAt(i)=='^')
					{
						AnalizadorJFlex analizer = new AnalizadorJFlex(new StringReader(String.valueOf(input.charAt(i))));
						System.out.println(analizer.yylex());
					}
					if(input.charAt(i)==' ')
					{
						AnalizadorJFlex analizer = new AnalizadorJFlex(new StringReader(String.valueOf(input.charAt(i))));
						System.out.println(analizer.yylex());
					}
				}
				System.out.println("Expresion Regular="+analizador.yylex());		
			
			
			
		}
		catch(Exception ex)
		{
			System.out.println("ERROR LEXICO");
		}
		
	}
	
	public static void generadorLexer(String path)
	{
		File file = new File(path);
                jflex.Main.generate(file);
             
                
//		JFlex.Main.generate(file);
                
	}


}


/* 
Regex

Identificaor: (?![0-9])\w+
Matricula: ($[0-9]{2}\-)([0-9]{4})

1) En muchos lenguajes de programacion, los identicadores se definen como secuencias de letras, digitos y subrayados que no empiecen por un digito. Escribe la expresion regular correspondiente, luego realice un analizador léxico que identifique este patrón.

2) Escribe una expresion regular para las cadenas de dos o mas letras minusculas que empiezan por a o por b tales que la ultima letra coincide con la primera, luego realice un analizador léxico que identifique este patrón.

3) En Unibe las matrículas de los estudiantes están conformadas de un patrón de dos dígitos seguidos de un guión y luego cuatro dígitos (ej. 15-1234). Escribe una expresión regular que evalúe la composición correcta de una matrícula de Unibe y luego realice un analizador léxico que identifique este patrón.

4) Escribe una expresion regular para el conjunto de las palabras reservadas integer, real y char escritas en minusculas y otra que permita escribirlas con cualquier combinacion de mayusculas y minusculas. Realice un analizador léxico que identifique este patrón.



*/