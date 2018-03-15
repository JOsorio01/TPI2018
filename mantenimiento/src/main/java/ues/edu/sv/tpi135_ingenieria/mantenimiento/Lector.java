package ues.edu.sv.tpi135_ingenieria.mantenimiento;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Lector implements Serializable {
  private final String separador;
  private final String path;
  
  public Lector(String path) {
    this.path = path;
    separador = ",";
  }
  
  public Lector(String path, String separador) {
    this.path = path;
    this.separador = separador;
  }
  
  public String getPath() {
    return path;
  }
  
  public String getSeparador() {
    return separador;
  }
  
  public boolean validarPath(final String path) {
    if (path != null && !path.trim().isEmpty()) { //verifica que el path no sea nulo ni vacio
      if (Paths.get(path).toFile().isFile()) { //si es un archivo...
        return Paths.get(path).toFile().canRead() && !Paths.get(path).toFile().isHidden();
      } else if (Paths.get(path).toFile().isDirectory()) { //si es un directorio...
        return validarPathDirectorio(path);
      }
    }
    return false;
  }

  public boolean validarPathDirectorio(final String path) {
    if (Paths.get(path).toFile().canRead() && !Paths.get(path).toFile().isHidden()) {
      ArrayList<String> listaArchivosCSV = new ArrayList<>();
      try {
        Files.walk(Paths.get(path)).filter(a -> a.toFile().getName().endsWith(".csv")).forEach(p -> listaArchivosCSV.add(p.toString()));
      } catch (IOException ex) {
        Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
      }
      return !listaArchivosCSV.isEmpty();
    }
    return false;
  }

  public ArrayList<String> obtenerArchivos(final String path) {
    ArrayList<String> listaArchivosCSV = new ArrayList<>();
    if (Paths.get(path).toFile().isFile()) {
      listaArchivosCSV.add(path);
    } else {
      try {
        Files.walk(Paths.get(path)).filter(a -> a.toFile().getName().endsWith(".csv")).forEach(p -> listaArchivosCSV.add(p.toString()));
      } catch (IOException ex) {
        Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return listaArchivosCSV;
  }

  public List<List<String>> leerArchivo(List<String> listaArchivos) {
    List<List<String>> cadena = new ArrayList<>(); //aqui se almacenan los objetos separados por comas de cada linea que contenga el archivo
    listaArchivos.forEach(l -> {
      try {
        Stream<String> stream = Files.lines(Paths.get(l)); //se obtiene el flujo de datos y se realiza un salto de linea
        stream.forEach(a -> cadena.add(separador(a)));
      } catch (IOException ex) {
        Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
      }
    });
    
    return cadena;
  }

  public List<String> separador(String linea) {
    if (!linea.trim().isEmpty()) {
      String[] separado = linea.split(separador); // separa la linea por comas
      List<String> listaSeparado = new ArrayList<>(Arrays.asList(separado));  //se convierte a una lista 

      return listaSeparado;
    } 
    return new ArrayList<>(); //si la linea esta vacia, retorna una lista vacia
  }
}