package classes;

import interfaces.Balanca;

public class FabricadeBalancas {
    public static Balanca<Produto> getBalance(TypeBalance typeBalance) {
        if(TypeBalance.FINZOLA_SMART.equals(typeBalance)){
            return new BalancaFizola();
        } else if (TypeBalance.TOLETO_MGV6.equals(typeBalance)) {
            return new ToledoMGV6();
        }
        else if(TypeBalance.URANO_INTEGRA.equals(typeBalance)){
            return new UranoIntegra();
        }

        assert getBalance(typeBalance) != null;
        return null;
    }
}
