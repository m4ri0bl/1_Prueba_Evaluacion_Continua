package dominio;

/**
 * Copyright 2025 Mario Blanco Herranz
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tablero {
    private static int DIMENSION = 30;
    private int[][] estadoActual = new int[DIMENSION][DIMENSION];
    private int[][] estadoSiguiente = new int[DIMENSION][DIMENSION];

    public void leerEstadoActual() {
        try {
            Scanner sc = new Scanner(new File("matriz"));
            for (int i = 0; i < DIMENSION; i++) {
                String linea = sc.nextLine();
                for (int j = 0; j < DIMENSION; j++) {
                    estadoActual[i][j] = Character.getNumericValue(linea.charAt(j));
                }
            }
            sc.close();
            calcularEstadoSiguiente();
        } catch (FileNotFoundException e) {
            System.out.println("Fichero 'matriz' no encontrado.");
            e.printStackTrace();
        }
    }

    public void generarEstadoActualPorMontecarlo() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoActual[i][j] = (Math.random() < 0.5) ? 1 : 0;
            }
        }
        calcularEstadoSiguiente();
    }

    private void calcularEstadoSiguiente() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                int vecinas = contarVecinas(i, j);
                if (estadoActual[i][j] == 1) {
                    if (vecinas == 2 || vecinas == 3) {
                        estadoSiguiente[i][j] = 1;
                    } else {
                        estadoSiguiente[i][j] = 0;
                    }
                } else {
                    if (vecinas == 3) {
                        estadoSiguiente[i][j] = 1;
                    } else {
                        estadoSiguiente[i][j] = 0;
                    }
                }
            }
        }
    }

    private int contarVecinas(int fila, int columna) {
        int contador = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int nuevaFila = (fila + i + DIMENSION) % DIMENSION;
                int nuevaColumna = (columna + j + DIMENSION) % DIMENSION;
                contador += estadoActual[nuevaFila][nuevaColumna];
            }
        }
        return contador;
    }

    public void transitarAlEstadoSiguiente() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoActual[i][j] = estadoSiguiente[i][j];
            }
        }
        calcularEstadoSiguiente();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (estadoActual[i][j] == 1) {
                    sb.append("x");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}