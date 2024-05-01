package test;

import currencyConvertor.Conversor;
import models.ConversorRecord;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = -1;

        System.out.println("---------- Bienvenido al Conversor de Monedas ----------\n");

        while(opc != 0){
            System.out.println("****************************************");
            System.out.println("----- Monedas principales -----");
            System.out.println("""
                1) Dólar -> Peso argentino
                2) Peso argentino -> Dólar
                3) Dólar -> Real brasileño
                4) Real brasileño -> Dólar
                5) Dólar -> Euro
                6) Euro -> Dólar
                7) Otras monedas
                0) Salir
                ****************************************
                Elija el tipo de cambio que desea realizar: """);
            opc = Integer.parseInt(sc.nextLine());


            switch(opc){
                case 1:
                    Conversor.usd_ars();
                    break;
                case 2:
                    Conversor.ars_usd();
                    break;
                case 3:
                    Conversor.usd_brl();
                    break;
                case 4:
                    Conversor.brl_usd();
                    break;
                case 5:
                    Conversor.usd_eur();
                    break;
                case 6:
                    Conversor.eur_usd();
                    break;
                case 7:
                    System.out.println("Ingrese la moneda base (en formato ISO 4217 [CNY]): ");
                    String monedaBase = sc.nextLine().toUpperCase();
                    System.out.println("Ingrese la moneda a la cual quiere convertir (en formato ISO 4217 [JPY]): ");
                    String monedaTarget = sc.nextLine().toUpperCase();
                    Conversor.otroCambio(monedaBase, monedaTarget);
                    break;
                case 0:
                    System.out.println("\n¡Gracias por usar el Conversor de Monedas!\n");
                    System.out.println("----- Historial de conversion -----\n");
                    break;
                default:
                    System.out.println("\nOpción incorrecta. Ingrese nuevamente\n");
            }
        }
    }
}
