package models;

public class HistorialConversion {
    private String fecha;
    private ConversorRecord conversor;

    public HistorialConversion(String fecha, ConversorRecord conversor) {
        this.fecha = fecha;
        this.conversor = conversor;
    }

    public ConversorRecord getConversor() {
        return conversor;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return getFecha() + "\n" + getConversor();
    }
}
