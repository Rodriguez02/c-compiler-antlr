package symbolsTable;

/**
 * Id
 */
public abstract class Id {

    private boolean inicializado;
    private boolean utilizado;
    private String tipoDato;
    private String tokenNombre;

    public Id(){
        
    }

    public Id(boolean inicializado, boolean utilizado, String tipoDato, String tokenNombre){
        this.inicializado = inicializado;
        this.utilizado = utilizado;
        this.tipoDato = tipoDato;
        this.tokenNombre = tokenNombre;
    }


    public void setInicializado(boolean inicializado) {
        this.inicializado = inicializado;
    }
    public boolean isInicializado() {
        return inicializado;
    }

    public void setUtilizado(boolean utilizado) {
        this.utilizado = utilizado;
    }
    public boolean isUtilizado() {
        return utilizado;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }
    public String getTipoDato() {
        return tipoDato;
    }
    
    public void setTokenNombre(String tokenNombre) {
        this.tokenNombre = tokenNombre;
    }
    public String getTokenNombre() {
        return tokenNombre;
    }

    @Override
    public String toString() {
        return String.valueOf(this.isInicializado());
    }

}