import java.util.ArrayList;
import java.util.*;

public class Estado{
  //Atributos
  int x;
  int y;
  int esFin;
  ArrayList<String> posiciones_usadas;
  
  //Constructor del estado
  public Estado(int x, int y, int esFin){
    this.x = x;
    this.y = y;
    this.esFin = esFin;
    this.posiciones_usadas = new ArrayList<String>();
  }

  public boolean buscarPalabra(int actual, String palabraABuscar, ArrayList<String> sopa, String donde){
    if (x == -1 || y == -1) return false; //Comprobamos si la primera letra no esta en la sopa, para ahorrar procesos
    else if (x >= sopa.get(0).length() || y >= sopa.size()) return false; //Comprobamos que no se salga de los limites
    if (actual == 4) return true; //corroboramos si ya encontramos la palabra

    char auxX = (char) (48 + x);
    char auxY = (char) (48 + y);
    String aux = "";
    aux = aux + "(" + auxX + "," + auxY + ")";

    if (sopa.get(y).charAt(x) == palabraABuscar.charAt(actual) && posiciones_usadas.contains(aux) != true)
    {
      esFin++;
      posiciones_usadas.add(aux);
      //Movimiento arriba
      y--;
      if (buscarPalabra(esFin, palabraABuscar, sopa, "arriba")) return true;
      y++;
      //Movimiento izquierda
      x--;
      if (buscarPalabra(esFin, palabraABuscar, sopa, "izquierda")) return true;
      x++;
      //Movimiento abajo
      y++;
      if (buscarPalabra(esFin, palabraABuscar, sopa, "abajo")) return true;
      y--;
      //Movimiento derecha
      x++;
      if (buscarPalabra(esFin, palabraABuscar, sopa, "derecha")) return true;
      x--;
      return false;
    }
    return false;
  }
}
