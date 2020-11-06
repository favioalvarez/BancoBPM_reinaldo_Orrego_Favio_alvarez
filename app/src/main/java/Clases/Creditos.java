package Clases;

public class Creditos {
    private int creditoHipotecario;
    private int creditoAutomotriz;

    public Creditos()
    {
        creditoHipotecario = 1000000;
        creditoAutomotriz = 500000;
    }

    public int getCreditoHipotecario() {
        return creditoHipotecario;
    }

    public int getCreditoAutomotriz() {
        return creditoAutomotriz;
    }

    public void setCreditoHipotecario(int creditoHipotecario) {
        this.creditoHipotecario = creditoHipotecario;
    }

    public void setCreditoAutomotriz(int creditoAutomotriz) {
        this.creditoAutomotriz = creditoAutomotriz;
    }
}
