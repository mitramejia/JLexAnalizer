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

*/