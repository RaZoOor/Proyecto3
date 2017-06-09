import java.util.ArrayList;
import java.util.*;

public class EstadoSopa{
  //Atributos
  char[] consonantes = {'b','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','x','y','z'};
  char[] vocales = {'a','e','i','o','u'};
  int i, j, k, l;
  //Metodo
  public ArrayList<String> generarPalabras(){
    ArrayList<String> palabras = new ArrayList<String>();
    for (i = 0; i < 19; i++)
    {
      for (j = 0; j < 5; j++)
      {
        for (k = 0; k < 19; k++)
        {
          for (l = 0; l < 5; l++)
          {
            String palabra = "";
            palabra = palabra + consonantes[i] + vocales[j] + consonantes[k] + vocales[l];
            palabras.add(palabra);
          }
        }
      }
    }
    return palabras;
  }
}
