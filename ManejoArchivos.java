import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class ManejoArchivos{
	public ArrayList<String> leerSopa(String archivo){
		ArrayList<String> sopa = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		File f = new File(archivo);
		Scanner s;
		try {
			s = new Scanner(f);
			while (s.hasNextLine())
			{
				String linea = s.nextLine();
				String lineas = linea.replaceAll("\\s+", "");
				sopa.add(lineas.toLowerCase());
			}
			s.close();
		} catch (FileNotFoundException e){
			System.out.println("Archivo " + archivo + "  no existe en el directorio");
		}
		return sopa;
	}
	public ArrayList<String> leerSopa2(String archivo){
		ArrayList<String> sopa = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		File f = new File(archivo);
		Scanner s;
		try {
			s = new Scanner(f);
			while (s.hasNextLine())
			{
				String linea = s.nextLine();
				String lineas = linea.replaceAll("\\s+", "");
				sopa.add(lineas.toLowerCase());
			}
			s.close();
		} catch (FileNotFoundException e){
			System.out.println("Archivo " + archivo + "  no existe en el directorio");
		}
		return sopa;
	}
	public void escribirResultados(ArrayList<String> presentes){
		FileWriter fichero = null;
		PrintWriter pw = null;

		try {
			fichero = new FileWriter("Solucion.out");
			pw = new PrintWriter(fichero);

			pw.println("Palabras en la sopa:");
	    for (int i = 0; i < presentes.size(); i++)
	        pw.println(presentes.get(i));

		} catch (Exception e) {
			System.out.println("Error al crear archivo de salida");
		} finally {
			try {
				// para asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar fichero");
			}
		}
	}
	public ArrayList<String> generarPalabras(ArrayList<String> sopa){
		ArrayList<String> palabras = new ArrayList<String>();
		ArrayList<String> si_presentes = new ArrayList<String>();

		PrimeraLetra coordenadas_primera = new PrimeraLetra();
		Estado ins;

		EstadoSopa inFile = new EstadoSopa();
		ArrayList<String> lista_palabras = inFile.generarPalabras();

    /* Recorremos la sopa, buscando coincidencias con la primera letra de la palabra, cuyas coordenadas
    son almacenadas para crear asi todos los posibles estados iniciales de cada palabra */
    for (int i = 0; i < lista_palabras.size(); i++)
    {
      String auxiliar_palabra = lista_palabras.get(i);
      ArrayList<int[]> lista_coincidencias = coordenadas_primera.buscarPrimeraLetra(auxiliar_palabra, sopa);
        for (int j = 0; j < lista_coincidencias.size(); j++)
        {
          int[] auxiliar_posicion = lista_coincidencias.get(j);
          ins = new Estado(auxiliar_posicion[0], auxiliar_posicion[1], 0);
          if (ins.buscarPalabra(0, auxiliar_palabra, sopa) && si_presentes.contains(auxiliar_palabra) != true)
            si_presentes.add(auxiliar_palabra);
        }
    }
		return si_presentes;
	}
}
