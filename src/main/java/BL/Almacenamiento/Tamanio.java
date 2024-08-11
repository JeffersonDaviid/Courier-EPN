package BL.Almacenamiento;

public enum Tamanio{
    PEQUENIO(1),
    MEDIANO(2),
    GRANDE(3);

    private final int valor;

    Tamanio(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}