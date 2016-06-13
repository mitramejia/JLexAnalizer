package analizador;

public enum Tokens
{
	SUMA("SUMA"), 
        RESTA("RESTA"), 
        MULTIPLICACION("MULTIPLICACION"), 
        DIVISION("DIVISION"), 
        POTENCIA("POTENCIA"), 
        ERROR("ERROR"), 
        DIGITO("DIGITO"),
        PAREN_LFT("PAREN_LFT"),
        PAREN_RGT("PAREN_RGT"),
        VALIDO("VALIDO"),
        SEPARADOR("SEPARADOR");

    private final String name;   
    
    private Tokens(String s) {
        name = s;
    }

    @Override
    public String toString() {
       return this.name;
    }    
}