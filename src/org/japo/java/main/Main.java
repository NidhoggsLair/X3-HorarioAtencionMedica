/* 
 * Copyright 2020 Adrian Bueno Olmedo <adrian.bueno.alum@iescamp.es>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Adrian Bueno Olmedo <adrian.bueno.alum@iescamp.es>
 */
public class Main {

//           Scanner
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
//           Random
    public static final Random RND = new Random();
//           Calendar
    public static final Calendar tiempo = Calendar.getInstance();

    public static void main(String[] args) {
//           Variables
        int horaU, minU, tiempoU; // Tiempo Usuario
        int tiempoR, horaR, minR; // Tiempo Random
        int horaS, minS, tiempoS; // Tiempo sistema
//           Constantes
        final int MAX = 825; //Hora maxima de atencion en minutos
        final int MIN = 570; //Hora minima de atencion en minutos
        final int MAX_DIA = 1439;
        final int MIN_DIA = 0;

        try {
//           Introducir por pantalla
            System.out.print("Introduce Hora .....: ");
            horaU = SCN.nextInt();
            System.out.print("Introduce Minuto ...: ");
            minU = SCN.nextInt();

//           Tiempo Random y Calendar
            tiempoR = RND.nextInt(MAX_DIA - MIN_DIA + 1) + MIN_DIA;
            tiempoS = tiempo.get(Calendar.HOUR_OF_DAY) * 60
                    + tiempo.get(Calendar.MINUTE);
            
//           Calculos
            tiempoU = horaU * 60 + minU;
            horaR = tiempoR / 60;
            minR = tiempoR % 60;
            horaS = tiempoS / 60;
            minS = tiempoS % 60;

//           Comparación / Ternario
            String atencionU = (tiempoU >= MIN && tiempoU <= MAX
                    ? "Atención SI Disponible"
                    : "Atención NO Disponible");
            String atencionR = (tiempoR >= MIN && tiempoR <= MAX
                    ? "Atención SI Disponible"
                    : "Atención NO Disponible");
            String atencionD = (tiempoS >= MIN && tiempoS <= MAX
                    ? "Atención SI Disponible"
                    : "Atención NO Disponible");

//            Salida por pantalla
            System.out.printf("%nHorario de Atención%n");
            System.out.println("===================");

            System.out.printf("Hora usuario ......: %02d:%02dh %n",
                    horaU, minU);
            System.out.println(atencionU);
            System.out.println("------------------------------");

            System.out.printf("Hora aleatoria ....: %02d:%02dh %n",
                    horaR, minR);
            System.out.println(atencionR);
            System.out.println("------------------------------");

            System.out.printf("Hora sistema ......: %02d:%02dh %n",
                    horaS, minS);
            System.out.println(atencionD);
        } catch (Exception e) {
            System.out.println("ERROR. Entrada incorrecta.");
        } finally {
            SCN.nextLine();
        }
    }

}
