package currencyConvertor;

import com.google.gson.Gson;
import models.ConversorRecord;
import models.HistorialConversion;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Conversor {
    private static double cantidad = 0;
    private static final List<HistorialConversion> historial = new ArrayList<>();
    private static void conversor(String moneda_base, String moneda_target, double cantidad){
        HttpClient client = HttpClient.newBuilder().build();

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/4a4e0050f86c4dc0dddc9321/pair/"
                + moneda_base.toUpperCase() + "/" + moneda_target.toUpperCase() + "/" + cantidad);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ConversorRecord conversor = new Gson().fromJson(response.body(), ConversorRecord.class);
            System.out.println(conversor);
            String fecha = establecerTiempo();
            HistorialConversion registro = new HistorialConversion(fecha, conversor);
            agregarRegistro(registro);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void pedirCantidad(){
        Scanner sc = new Scanner(System.in);
        do{
            try {
                System.out.println("Ingrese la cantidad de dinero a convertir: ");
                cantidad = sc.nextDouble();
            }catch (InputMismatchException e){
                System.out.println("\nDebe ingresar una cantidad en número\n");
                sc.nextLine();
                continue;
            }
            break;
        }while(true);
    }

    public static void usd_ars(){
        Conversor.pedirCantidad();
        Conversor.conversor("USD","ARS", cantidad);
    }
    public static void ars_usd(){
        Conversor.pedirCantidad();
        Conversor.conversor("ARS","USD", cantidad);
    }
    public static void usd_brl(){
        Conversor.pedirCantidad();
        Conversor.conversor("USD","BRL", cantidad);
    }
    public static void brl_usd(){
        Conversor.pedirCantidad();
        Conversor.conversor("BRL","USD", cantidad);
    }
    public static void usd_eur(){
        Conversor.pedirCantidad();
        Conversor.conversor("USD","EUR", cantidad);
    }
    public static void eur_usd(){
        Conversor.pedirCantidad();
        Conversor.conversor("EUR","USD", cantidad);
    }

    public static void otroCambio(String monedaBase, String monedaTarget){
        Conversor.pedirCantidad();
        Conversor.conversor(monedaBase,monedaTarget, cantidad);
    }

    private static void agregarRegistro(HistorialConversion registro){
        historial.add(registro);
    }

    public static String establecerTiempo(){
        LocalDate fechaActual = LocalDate.now();
        String fecha = fechaActual.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        LocalTime horaActual = LocalTime.now();
        String hora = horaActual.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        String fechaHora = fecha + " " + hora;
        return fechaHora;
    }

    public static void mostrarHistorial(){
        for(HistorialConversion conversion : historial){
            System.out.println(conversion);
        }
    }

    public static double getCantidad() {
        return cantidad;
    }
}
