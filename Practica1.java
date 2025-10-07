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
        // Iteramos sobre todos los pares de conjuntos en la lista col
        for (int i = 0; i < col.size(); i++) {
            for (int j = i + 1; j < col.size(); j++) {
                // Obtenemos los conjuntos de los índices i y j
                Set<T> set1 = col.get(i);
                Set<T> set2 = col.get(j);

                // Generamos la unión de los dos conjuntos
                Set<T> union = new HashSet<>(set1);
                union.addAll(set2);

                // Comprobamos si la unión es igual al conjunto u
                if (union.equals(u)) {
                    // Si es igual, devolvemos los dos conjuntos encontrados en una lista
                    return Arrays.asList(set1, set2);
                }
            }
        }

        // Si no se encuentra ningún par de conjuntos, devolvemos una colección vacía
        return Collections.emptyList();
    }



}