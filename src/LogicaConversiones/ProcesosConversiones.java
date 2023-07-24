package LogicaConversiones;

public class ProcesosConversiones {
    // Atributos
    private double monto;
    private String monedaOrigen;
    private String monedaDestino;

    // Constructor
    public ProcesosConversiones(double monto, String monedaOrigen, String monedaDestino) {
        this.monto = monto;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
    }

    // Métodos de conversión
    public double convertir() {
        double tasaMonedaOrigen = obtenerTasa(monedaOrigen);
        double tasaMonedaDestino = obtenerTasa(monedaDestino);

        // Realizar la conversión
        double montoConvertido = monto * (tasaMonedaDestino / tasaMonedaOrigen);
        return montoConvertido;
    }

    private double obtenerTasa(String moneda) {
        switch (moneda) {
            case "Dólar (USD)":
                return 1.0;
            case "Euro":
                return 0.90;
            case "Libras":
                return 0.78;
            case "Yen":
                return 141.70;
            case "Won Coreano":
                return 1286.65;
            case "Pesos (COP)":
                return 3976.46;
            default:
                throw new IllegalArgumentException("Moneda no soportada");
        }
    }
}