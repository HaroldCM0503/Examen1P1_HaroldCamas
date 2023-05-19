/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen1p1_haroldcamas;
import java.util.Scanner;
/**
 *
 * @author harol
 */
public class Examen1P1_HaroldCamas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        Scanner cadena = new Scanner (System.in);
        boolean respuesta = true;
        int opcion = 0;
        
        while (respuesta){
            System.out.println("\n" + "MENU" + "\n" + "1.)Suma Binaria" + "\n" + "2.)Estrella de David" + "\n" + "3.)Salir");
            opcion = leer.nextInt();
            
            switch(opcion){
                case 1:
                    String numero1,numero2;
                    String resultado = "";
                    String verdadero = "";
                    char char1,char2;
                    int codigo1,codigo2;
                    String one = "1";
                    String zero = "0";
                    boolean llevar = false;
                    boolean es_binario = true;
                    
                    System.out.println("Ingrese su primera numero: ");
                    numero1 = cadena.next();
                    System.out.println("Ingrese su segundo numero: ");
                    numero2 = cadena.next();
                    
                    //Inicio Validacion.
                    if (numero1.length() != numero2.length()){
                        System.out.println("Sus numeros no tienen el mismo tamaño.");
                        break;
                    }
                    for (int i = 0; i < numero1.length(); i++ ){
                        codigo1 = numero1.charAt(i);
                        codigo2 = numero2.charAt(i);
                        if ((codigo1 != 48 && codigo1 != 49) || (codigo2 != 48 && codigo2 != 49)){
                            es_binario = false;
                        }
                    }
                    if (es_binario == false){
                        System.out.println("Sus numero no son binarios.");
                        break;
                    }
                    //Fin validacion.
                    
                    //Incio suma.
                    for (int j = numero1.length() - 1; j >= 0; j--){
                        char1 = numero1.charAt(j);
                        char2 = numero2.charAt(j);
                        //Si tenemos 0 0.
                        if (char1 == 48 && char2 == 48){
                            if (llevar == true){
                                resultado += one;
                                llevar = false;
                            }
                            else {
                                resultado += zero;
                                llevar = false;
                            }
                        }
                        //Si tenemos 1 0 o 0 1.
                        if ((char1 == 49 && char2 == 48) || (char1 == 48 && char2 == 49)){
                            if (llevar == true){
                                resultado += zero;
                                llevar = true;
                            }
                            else {
                                resultado += one;
                                llevar = false;
                            }
                        }
                        // Si tenemos 1 1.
                        if (char1 == 49 && char2 == 49){
                            if (llevar == true){
                                resultado += one;
                                llevar = true;
                            }
                            else {
                                resultado += zero;
                                llevar = true;
                            }
                        }
                        //Si ya es el ultimo j y en el anterior se llevo 1, se suma un uno.
                        if (j == 0 && llevar == true){
                            resultado += one;
                        }
                    }
                    //Fin suma.
                    
                    //Darle vuelta al resultado del for anterior porque me lo tira asi y no quiero escribir todo el codigo de nuevo, entonces es mas facil solo darle vuelta.
                    for (int k = resultado.length() - 1; k >= 0; k--){
                        verdadero += resultado.charAt(k);
                    }
                    System.out.println(verdadero);
                    //Fin del todo.
                    break;


                    
                case 2:
                    System.out.println("Ingrese el tamaño de su estrella: ");
                    int base = leer.nextInt();
                    //Validacion
                    while (base < 10 || base%2 == 0){
                        System.out.println("Solo puede ingresar numero impares mayores que 9.");
                        base = leer.nextInt();
                    }
                    int altura = (base/2)+2;
                    
                    //For para imprimir el + del tope.
                    for (int j = 1; j <= base; j++){
                        if (j == (base/2) + 1){
                            System.out.print("+");
                        }
                        else {
                            System.out.print(" ");
                        }
                    }
                    //Fin for del +.
                    
                    System.out.println("");
                    
                    //For para imprimir los 2 triangulos de arriba.
                    for (int i = 2; i <= (altura/2) + 1; i++){
                        for (int j = 1; j <= base; j++){
                            if (i == 2 || j == i - 1 || j == base - i + 2){
                                System.out.print("*");
                            }
                            else if (j == (base/2) - i + 2 || j == (base/2) + i){
                                System.out.print("+");
                            }
                            else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println("");
                    }
                    //Fin for de los triangulos de arriba.
                    
                    //For para imprimir los 2 triangulos de abajo.
                    for (int i = (altura/2) + 2; i < altura; i++){
                        for (int j = 1; j <= base; j++){
                            if (j == i - 1 || j == base - i + 2){
                                System.out.print("*");
                            }
                            else if (j == (base/2) - i + 2 || j == (base/2) + i || i == altura - 1){
                                System.out.print("+");
                            }
                            else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println("");
                    }
                    //Fin for de los triangulos de abajo.
                    
                    //For para imprimir el * del fondo de la estrella.
                    for (int j = 1; j <= base; j++){
                        if (j == (base/2) + 1){
                            System.out.print("*");
                        }
                        else {
                            System.out.print(" ");
                        }
                    }
                    //Fin de todo.
                    break;

                    
                case 3:
                    System.out.println("Nos vemos!");
                    respuesta = false;
                    break;
                    
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        }
        
    }
    
}
