/* 
 * Copyright 2020 Mario Merlos Abella - mario.merlos.alum@iescamp.es.
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
package org.japo.java.libraries;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Mario Merlos Abella - mario.merlos.alum@iescamp.es
 */
public class UtilesPasswordRegular {

    public static final Random RND = new Random();

    public final static String CADENA_SIG = "_@#$~%&";
    public final static String CADENA_MIN = "abcdefghijklmnopqrstuvwxyz";
    public final static String CADENA_MAY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public final static String CADENA_DIG = "0123456789";

    public final static String CADENA_ENG_MIN = "a-z";
    public final static String CADENA_ENG_MAY = "A-Z";

    //Rango 
    public static final int MAX = 15;
    public static final int MIN = 8;

    public static int rangoRandom = RND.nextInt(MAX - MIN + 1) + MIN;
    int casoRandom = RND.nextInt(3 - 0 + 1) + 0;

    public static final String crearPass() {

        String str = "Voy a ser una contraseña chachi";

        ArrayList<Character> futuroString = new ArrayList<>();

        Pattern p = Pattern.compile(
                "(?=.*[" + CADENA_DIG + "])"
                + "(?=.*[" + CADENA_SIG + "])"
                + "(?=.*[" + CADENA_ENG_MAY + "])"
                + "(?=.*[" + CADENA_ENG_MIN + "])"
                + "\\S{" + MIN + "," + MAX + "}");

        boolean b;
        do {

            for (int i = 0; i < rangoRandom; i++) {

                int n = RND.nextInt(3 - 0 + 1) + 0;
                switch (n) {
                    case 0:
                        int rmin = RND.nextInt(24 - 0 + 1) + 0;
                        futuroString.add(CADENA_MIN.charAt(rmin));
                        break;
                    case 1:
                        int rmax = RND.nextInt(24 - 0 + 1) + 0;
                        futuroString.add(CADENA_MAY.charAt(rmax));
                        break;
                    case 2:
                        int rdig = RND.nextInt(8 - 0 + 1) + 0;
                        futuroString.add(CADENA_DIG.charAt(rdig));
                        break;
                    case 3:
                        int rsig = RND.nextInt(6 - 0 + 1) + 0;
                        futuroString.add(CADENA_SIG.charAt(rsig));
                        break;
                }
            }
            //Eliminar contenido innecesario
            str = futuroString.toString();
            str = str.replaceAll("[\\s\\,\\[\\]]", "");

            //Comprobación de Constraseña
            Matcher m = p.matcher(str);
            //Conversión a boolean para validación
            b = m.matches();
            futuroString.clear();

        } while (!b);

        return str;
    }

}
