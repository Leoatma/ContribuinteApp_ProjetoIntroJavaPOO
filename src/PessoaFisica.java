public class PessoaFisica extends Contribuinte {
    
    
    private double gastosSaude;
    
    public PessoaFisica() {
    }
    
    public PessoaFisica(double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }
    
    public PessoaFisica(String nome, double rendaAnual, double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }
    
    public double getGastosSaude() {
        return gastosSaude;
    }
    
    public void setGastosSaude(double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }
    
    @Override
    public double calcularImposto() {
        double impostoPF = 0.0;
        
        if (getRendaAnual() > 20_000) {
            impostoPF = getRendaAnual() * 0.25;
        } else {
            impostoPF = getRendaAnual() * 0.15;
        }
        
        if (getGastosSaude() > 0) {
            impostoPF -= getGastosSaude()*0.5;
        }
        
        if (impostoPF < 0) {
            impostoPF = 0.0;
        }
        return impostoPF;
    }
    
}
