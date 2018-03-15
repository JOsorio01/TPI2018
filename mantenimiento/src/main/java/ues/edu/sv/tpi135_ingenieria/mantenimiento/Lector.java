/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.tpi135_ingenieria.mantenimiento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author kevin
 */
public class Lector {

    public boolean verificarArchivo(final String path) {
        if (path != null && !path.trim().isEmpty()) {
            //Verifica que el path sea un archivo, tenga permisos de lectura y que no sea oculto
            return (Paths.get(path).toFile().isFile() && Paths.get(path).toFile().canRead()
                    && !Paths.get(path).toFile().isHidden());
        }

        return false;
    }

    public boolean verificarDirectorio(final String path) {
        if (path != null && !path.trim().isEmpty()) {
            //Verifica que el path sea un directorio, tenga permisos de lectura y que no sea oculto
            return (Paths.get(path).toFile().isDirectory() && Paths.get(path).toFile().canRead()
                    && !Paths.get(path).toFile().isHidden());
        }
        return false;
    }

    public List<String> obtenerArchivos(final String path) { // metodo encargado de buscar en el path todos los archivos .csv
        List<String> listaArchivos = new ArrayList<>();
        if (verificarArchivo(path)) {
            listaArchivos.add(path);
        } else if (verificarDirectorio(path)) {
            try {
                Files.walk(Paths.get(path)).filter(a -> a.toFile().getName().endsWith(".csv"))
                        .forEach(p -> listaArchivos.add(p.toString()));

                listaArchivos.forEach(System.out::println);

            } catch (IOException ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaArchivos;
    }

    // este metodo Genera una lista con los objetos separados por "," de todos los archivos .csv
    public List<List<String>> parser(final List<String> paths, final boolean saltarLinea,
            final String separador) throws IOException {

        List<List<String>> listado = new ArrayList<>();

        paths.forEach(p -> {
            if (verificarArchivo(p)) {
                try (Stream<String> lines = Files.lines(Paths.get(p))) {
                    lines.skip(saltarLinea ? 1 : 0)
                            .filter(l -> l.contains(separador))
                            .forEach(s -> {
                                String[] separado = s.split(separador);
                                List<String> lista = new ArrayList<>();
                                for (String string : separado) {
                                    lista.add(string.trim());
                                }
                                listado.add(lista);

                            });
                } catch (IOException ex) {
                    Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        for (List e : listado) {
            System.out.println(e);
        }

        return listado;
    }

}
