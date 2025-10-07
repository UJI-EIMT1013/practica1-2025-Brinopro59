package practica1;

import java.util.*;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos (Iterator<Integer> it) {
        List<Integer> elementos = new ArrayList<>();
        while(it.hasNext()){
            int n = it.next();
            if(n!= 0) elementos.add(n);
        }

        Set<Integer> resultado = new HashSet<>();
        for (int i = 0; i<elementos.size(); i++){
            int actual = elementos.get(i);
            for(int j = 0; j<elementos.size(); j++){
                if( i != j && actual % elementos.get(i) == 0){
                    resultado.add(actual);
                    break;
                }
            }
        }

        return resultado;
    }

    //EJERCICIO2
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {
        Iterator<Integer> it = cuadrados.iterator();
        while(it.hasNext()){
            int elemento = it.next();
            if (elemento == 1 && noCuadrados.contains(1)){
                noCuadrados.remove(1);
            }else{
                noCuadrados.add(elemento);
                it.remove();
            }
        }
        it = noCuadrados.iterator();
        while(it.hasNext()) {
            int elemento = it.next();
            int cElemento = elemento * elemento;
            if (noCuadrados.contains(cElemento) && elemento != 1){
                cuadrados.add(cElemento);
            }
        }
        noCuadrados.removeAll(cuadrados);
    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        List<Set<T>> resultado = new ArrayList<>();

        while(it.hasNext()){
            T elemento = it.next();
            boolean añadido = false;

            for(Set<T> set: resultado){
                if(!set.contains(elemento)){
                    set.add(elemento);
                    añadido = true;
                    break;
                }
            }
            if(!añadido){
                Set<T> nuevoSet = new HashSet<>();
                nuevoSet.add(elemento);
                resultado.add(nuevoSet);
            }
        }

        return resultado;
    }

    // EJERCICIO 4
    public static <T> Collection<Set<T>> coverageSet2(Set<T> u, ArrayList<Set<T>> col) {
        Collection<Set<T>> resultado = new HashSet<Set<T>>() ;
        Collection<Set<T>> colecVacia = new HashSet<Set<T>>() ;
        if(u.isEmpty()){ // si el conjunto u es vació no hace falta buscar la unión de dos conjuntos
            return colecVacia;
        }
        for (int i = 0; i < col.size()-1; i++){ // recorro la lista
            for(int j = i + 1; j < col.size(); j++){ // recorro la lista a partir del siguiente elemento
                Set<T> aux = new HashSet<>(); // creo un conjunto auxiliar donde almaceno los elementos de ambos conjuntos a analizar
                if (!col.get(i).equals(u) && !col.get(j).equals(u))
                {
                    aux.addAll(col.get(i)); //añado los elementos al conjunto auxiliar
                    aux.addAll(col.get(j));
                    if (aux.equals(u)) { // miro si el conjunto auxiliar contiene todos los elementos de u
                        resultado.add(col.get(i));
                        resultado.add(col.get(j)); // si lo verifica, añado ambos conjuntos al conjunto a devolver
                        return resultado; // devuelvo el conjunto que verifica la condición
                    }
                }
            }
        }
        return colecVacia;
    }
}



