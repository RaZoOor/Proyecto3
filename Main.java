/*  Laboratorio 3 de Metodos de programacion
    Francisco Guajardo Villa
    19005801-8
    Ingenieria civil en informativa - Usach - Junio 2017
*/
import java.util.Scanner;
import java.util.ArrayList;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese nombre archivo sopa 1: ");
    String file = sc.next();
    System.out.print("Ingrese nombre archivo sopa 2: ");
    String file2 = sc.next();
    /* Creamo el objeto para manejar los archivos, del cual obtenemos un array de la lista de palabras
    y un array con la sopa en forma de "matriz", quitandole los espacios y simbolos especiales */
    ManejoArchivos inFiles = new ManejoArchivos();
    ArrayList<String> sopa_letras_1 = inFiles.leerSopa(file);
    ArrayList<String> sopa_letras_2 = inFiles.leerSopa2(file2);
    //lista_palabras se debe generar a partir de la sopa 1
    ArrayList<String> lista_palabras = inFiles.generarPalabras(sopa_letras_1);

    ArrayList<String> si_presentes = new ArrayList<String>();
    PrimeraLetra coordenadas_primera = new PrimeraLetra();
    Estado ins;
    /* Recorremos la sopa, buscando coincidencias con la primera letra de la palabra, cuyas coordenadas
    son almacenadas para crear asi todos los posibles estados iniciales de cada palabra */
    for (int i = 0; i < lista_palabras.size(); i++)
    {
      String auxiliar_palabra = lista_palabras.get(i);
      ArrayList<int[]> lista_coincidencias = coordenadas_primera.buscarPrimeraLetra(auxiliar_palabra, sopa_letras_2);
        for (int j = 0; j < lista_coincidencias.size(); j++)
        {
          int[] auxiliar_posicion = lista_coincidencias.get(j);
          ins = new Estado(auxiliar_posicion[0], auxiliar_posicion[1], 0);
          if (ins.buscarPalabra(0, auxiliar_palabra, sopa_letras_2) && si_presentes.contains(auxiliar_palabra) != true)
            si_presentes.add(auxiliar_palabra);
        }
    }

    ManejoArchivos outFiles = new ManejoArchivos();
    outFiles.escribirResultados(si_presentes);
  }
}
