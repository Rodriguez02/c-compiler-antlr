package symbolsTable;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TablaSimbolos
 */
public class TablaSimbolos {

    private LinkedList<HashMap<String, Id>> tablaSimbolos;

    // lista de mapas
    public TablaSimbolos() {
        tablaSimbolos = new LinkedList<HashMap<String, Id>>();
    }

    // crea un nuevo mapa(contexto) dentro de la lista
    public void enterContext() {
        HashMap<String, Id> contexto = new HashMap<String, Id>();
        this.tablaSimbolos.add(contexto);
    }

    // remueve un mapa(contexto) de la lista
    public void exitContext() {
        this.tablaSimbolos.removeLast();
    }

    public ArrayList<String> unusedIDs() {
        ArrayList<String> variablesSinUso = new ArrayList<String>();
        for (Entry<String, Id> entry : tablaSimbolos.getLast().entrySet()) {
            if(!entry.getValue().isUtilizado() && !entry.getValue().getTokenNombre().equals("main")){
                if (entry.getValue() instanceof Funcion && !entry.getValue().isInicializado()) {
                    continue;
                }else{
                    variablesSinUso.add(entry.getKey()); 
                }
            }
        }
        return variablesSinUso;
    }

    // pre: recibe el nombre del identificador y los datos asociados(inicializado, utilizado, ...)
    // pos: agregar un par (clave, valor) a el contexto acutal(ultimo mapa en la lista)
    public void insert(String name, Id symbol){
        this.tablaSimbolos.getLast().put(name, symbol);
    }

    // pre: recibe el nombre del identificador 
    // pos: realiza una busqueda en el contexto acutal y en contextos superiores al actual,
    //      si encuentra un identificador con el mismo nombre lo devuelve
    //      sino encuentra indetificadores con ese nombre devuelve null
    public Id lookup(String id){
        Id symbol = lookupLocal(id);
        if(symbol != null){
            return symbol;
        }else{
            ListIterator<HashMap<String, Id>> symbolsIterator = this.tablaSimbolos.listIterator(tablaSimbolos.size() - 1);
            while(symbolsIterator.hasPrevious()){
                symbol = symbolsIterator.previous().get(id);
                if( symbol != null ){
                    return symbol;
                }
            }
        }

        return symbol;
    }

    // pre: recibe el nombre de un identificador
    // pos: devuelve un Id si en el contexto acutal (el ultimo mapa de la lista) existe un identificador con ese nombre
    //      devuelve null si en el contexto acutal no existe un identificador con ese nombre
    public Id lookupLocal(String id){
        Id symbol = tablaSimbolos.getLast().get(id);
        if(symbol != null){
            return symbol;
        }
        return null;
    }
    
    
    public LinkedList<HashMap<String, Id>> getTablaSimbolos() {
        return tablaSimbolos;
    }

    // public List<String> unusedIDs(){
    //     return this.tablaSimbolos.getLast().entrySet().stream()
    //                                                   .filter(id -> !id.getValue().isUtilizado() && 
    //                                                                 !id.getValue().getTokenNombre().equals("main"))
    //                                                   .map(id -> id.getKey())
    //                                                   .collect(Collectors.toList());
    // }

    @Override
    public String toString() {
        return tablaSimbolos.toString();
    }
    
}