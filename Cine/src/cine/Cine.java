package cine;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Cine {

    public static void main(String[] args) {
        //Creacion de un tipo de matriz
        String cine[][];

        //hoja de texto:
        JTextArea hoja = new JTextArea();
        //variables:
        String salida = "";
        String butacas[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String asiento = "";
        String cualLetra = "";
        String cualNumero = "";
        int filas;
        int columnas;
        int fila;
        int columna;
        int cualFila = -1;
        int cualColumna = -1;
        int opcion;
        boolean salir = false;
        boolean encontrado = false;

        //indicar el tamanio del cine:
        do {
            filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de filas: "));
            columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de columnas: "));
        } while ((filas < 0) || (columnas < 0));

        //Crear la sala del cine con el tamanio de las columnas y filas indicadas;
        cine = new String[filas][columnas];

        //  Imprimir matriz
        for (fila = 0; fila < filas; fila++) {
            for (columna = 0; columna < columnas; columna++) {
                cine[fila][columna] = butacas[fila] + String.valueOf(columna + 1);
            }
        }

        while (salir == false) { // menu
            //  Seleccionar opcion
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desea: \n1. Ver sala \n2. Asignar Asiento \n3. Desocupar asiento\n4. Salir"));
            //  Opcion 1
            if (opcion == 1) { // Ver la matriz
                salida = "";
                salida += "\t\tPANTALLA\n\t====================================\n\n";
                for (fila = 0; fila < filas; fila++) {
                    for (columna = 0; columna < columnas; columna++) {
                        salida += cine[fila][columna] + "\t";
                    }
                    salida += "\n";
                }
                hoja.setText(salida);
                JOptionPane.showMessageDialog(null, hoja);

            } //  Opcion 2
            else if (opcion == 2) { // ocupar asiento
                salida = "";
                salida += "\t\tPANTALLA\n\t====================================\n\n";
                for (fila = 0; fila < filas; fila++) {
                    for (columna = 0; columna < columnas; columna++) {
                        salida += cine[fila][columna] + "\t";
                    }
                    salida += "\n";
                }
                salida += "\n\nCual asiento desea reservar?";
                hoja.setText(salida);
                asiento = JOptionPane.showInputDialog(hoja).toUpperCase();

                // leer asientos
                for (fila = 0; fila < filas; fila++) {
                    for (columna = 0; columna < columnas; columna++) {
                        if (asiento.equals(cine[fila][columna])) { // solo si encuentra el asiento.
                            encontrado = true;
                            cualFila = fila;
                            cualColumna = columna;
                        }
                    }
                }

                if (encontrado = true) { // si el asiento se encuentra 
                    if (cine[cualFila][cualColumna].equals("O")) { // el asiento esta ocupado, no se puede volver a vender
                        JOptionPane.showMessageDialog(null, "Error. El asiento " + asiento + " se encuentra ocupado.");
                    } else {// asiento disponible, si se puede vender.
                        cine[cualFila][cualColumna] = "O";
                        JOptionPane.showMessageDialog(null, "Asiento reservado");
                    }

                } else if (encontrado = false) { // si el asiento no se encuentra disponible
                    JOptionPane.showMessageDialog(null, "Error. El asiento " + asiento + " no se encontra en la sala de cine.");
                }

            } //  Opcion 3
            else if (opcion == 3) { // desocupar asiento
                encontrado = false;
                salida = "";
                salida += "\t\tPANTALLA\n\t====================================\n\n";
                for (fila = 0; fila < filas; fila++) {
                    for (columna = 0; columna < columnas; columna++) {
                        salida += cine[fila][columna] + "\t";
                    }
                    salida += "\n";
                }
                salida += "\n\nCual asiento desea desocupar?";
                hoja.setText(salida);
                asiento = JOptionPane.showInputDialog(hoja).toUpperCase();
                cualLetra = String.valueOf(asiento.charAt(0));
                cualColumna = Integer.parseInt(String.valueOf(asiento.charAt(1)));

                for (fila = 0; fila < filas; fila++) {
                    if (cualLetra.equals(butacas[fila])) { // Encontro
                        encontrado = true;
                        cualFila = fila;
                    }
                }

                if (encontrado = true) { // si el asiento se encuentra 
                    if (cine[cualFila][cualColumna - 1].equals("O")) { // el asiento esta ocupado, si se puede devolver
                        cine[cualFila][cualColumna - 1] = asiento;
                        JOptionPane.showMessageDialog(null, "El asiento " + asiento + " se ha liberado.");
                    } else {// asiento no esta reservado

                        JOptionPane.showMessageDialog(null, "Error. El asiento " + asiento + " se encuentra libre.");
                    }

                } else if (encontrado = false) { // si el asiento no se encuentra disponible
                    JOptionPane.showMessageDialog(null, "Error. El asiento " + asiento + " no se encontra en la sala de cine.");
                }

                System.out.println(asiento);
                System.out.println(cualFila);
                System.out.println(cualColumna - 1);

            } //  Opcion 4
            else if (opcion == 4) { // salir
                salir = true;
            } //  Ninguna opcion:
            else {
                JOptionPane.showMessageDialog(null, "Seleccione una opcion valida");
            }

        }

    }
}
