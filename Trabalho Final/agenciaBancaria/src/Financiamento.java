import java.text.NumberFormat;
import java.util.Locale;

class Financiamento {
    private double valorFinanciado;
    private int quantidadeParcelas;
    private double valorParcela;
    private static final double TAXA_JUROS = 0.02;
    private double valorTotal;
    private static final NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    public Financiamento(double valorFinanciado, int quantidadeParcelas) {
        this.valorFinanciado = valorFinanciado;
        this.quantidadeParcelas = quantidadeParcelas;
        calcularParcelas();
    }

    private void calcularParcelas() {
        double fator = Math.pow(1 + TAXA_JUROS, quantidadeParcelas);
        valorParcela = (valorFinanciado * TAXA_JUROS * fator) / (fator - 1);
        valorTotal = valorParcela * quantidadeParcelas;
    }

    @Override
    public String toString() {
        return "Valor Financiado: " + formatoMoeda.format(valorFinanciado) + "\nQuantidade de Parcelas: " + quantidadeParcelas + "\nValor da Parcela: " + formatoMoeda.format(valorParcela) + "\nValor Total a Pagar: " + formatoMoeda.format(valorTotal);
    }
}
