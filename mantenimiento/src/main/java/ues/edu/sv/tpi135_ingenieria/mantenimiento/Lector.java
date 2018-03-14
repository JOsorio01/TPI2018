/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135_ingenieria.mantenimiento;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

/**
 *
 * @author kevin
 */
public class Lector implements Serializable {
    
    private static final Lector instancia = new Lector();
    
    public static Lector getInstance(){
        return instancia;
    }

     public boolean verificarArchivo(final String path){
        if(path != null && !path.trim().isEmpty()){
            //Verifica que el path sea un archivo, tenga permisos de lectura y que no sea oculto
            return (Paths.get(path).toFile().isFile() && Paths.get(path).toFile().canRead() && !Paths.get(path).toFile().isHidden());
        }
        
        return false;
    }
    
    public boolean verificarDirectorio(final String path){
        if(path != null && !path.trim().isEmpty()){
            //Verifica que el path sea un directorio, tenga permisos de lectura y que no sea oculto
            return (Paths.get(path).toFile().isDirectory() && Paths.get(path).toFile().canRead() && !Paths.get(path).toFile().isHidden());
        }
        return false;
    }
    
    public List<String> obtenerArchivos(final String path){
        List<String> listaArchivos = new ArrayList<>();
        if(verificarArchivo(path)){
            listaArchivos.add(path);
        }else if(verificarDirectorio(path)){
            try {           
            Files.walk(Paths.get(path)).filter(a -> a.toFile().getName().endsWith(".csv")).forEach(p -> listaArchivos.add(p.toString()));
            listaArchivos.forEach(System.out::println);
   
            } catch (IOException ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        return listaArchivos;
    }
    
    public void leerArchivo(List<String> listaArchivos){
        List<List> cadena = new ArrayList(); //aqui se almacenan los objetos separados por comas de cada linea que contenga el archivo
        listaArchivos.forEach(l -> {
            try {
                Stream<String> stream = Files.lines(Paths.get(l)).skip(1); //se obtiene el flujo de datos y se realiza un salto de linea
                stream.forEach(a -> cadena.add(separador(a)));
            } catch (IOException ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        cadena.forEach(a -> a.forEach(System.out::println));
    }
    
    public List<String> separador(String linea){
        String[] separado = linea.split(","); // separa la linea por comas
        List<String> listaSeparado = new ArrayList<>(Arrays.asList(separado));  //se convierte a una lista 
        
        return listaSeparado; 
    }
    
    public List<List<String>> parser(final String path, final boolean saltarLinea, final String separador) throws IOException{
        List<List<String>> listado=new ArrayList<>();  //Algo asi como que una lista multidimensional     
        if (verificarArchivo(path)) { //llamamos al metodo validar que creamos
            try (Stream<String> lines = Files.lines(Paths.get(path))) {
            lines.skip(saltarLinea?1:0).filter(l->l.contains(separador)).
                    forEach(s -> {
                String[] separado = s.split(separador);   
                listado.add(Arrays.asList(separado));
                    });
            return listado;
            }
        }
        
        return null;
    }

}
