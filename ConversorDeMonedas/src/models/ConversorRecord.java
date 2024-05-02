package models;

import currencyConvertor.Conversor;

public record ConversorRecord(String base_code, String target_code, Double conversion_result) {
    @Override
    public String toString() {
        return "---------------------------------------------------\n"
                +"Cantidad a convertir: " + Conversor.getCantidad()
                +"\nMoneda Base: \t\t\t" + base_code
                +"\nMoneda a convertir: \t" + target_code
                +"\nTotal de conversión: \t$" + conversion_result
                +"\n-------------------------------------------------\n";
    }
}

