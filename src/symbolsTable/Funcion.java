package symbolsTable;

import java.util.List;
import java.util.ArrayList;

/**
 * Funcion
 */
public class Funcion extends Id {

    private List<Variable> parametros;

    public Funcion(){
        super();
        this.parametros = new ArrayList<Variable>();
    }

    public Funcion(boolean inicializado, boolean utilizado, String tipoDato, String tokenNombre, List<Variable> parametros){
        super(inicializado, utilizado, tipoDato, tokenNombre);
        this.parametros = parametros;
    }

    public void setParametros(List<Variable> parametros) {
        this.parametros = parametros;
    }
    
    public List<Variable> getParametros() {
        return parametros;
    }

    public boolean areParametersEquals(List<Variable> parameters){
        return this.parametros.equals(parameters);
    }



    
    
    @Override
    public String toString(){
        return this.getTipoDato() + " " + this.getTokenNombre() + " " + this.parametros.toString();
    }

}