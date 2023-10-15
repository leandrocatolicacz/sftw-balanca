import classes.FabricadeBalancas;
import classes.Produto;
import classes.TypeBalance;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var product = new Produto(1, "QUEIJO GRUYERE KG", "P", 35.59);

        List<Produto> products = Arrays.asList(product);
        System.out.println("-----------FINXOLA_SMART------------");
        FabricadeBalancas.getBalance(TypeBalance.FINZOLA_SMART).export(products);
        System.out.println("-----------TOLEDO_MGV6------------");
        FabricadeBalancas.getBalance(TypeBalance.TOLETO_MGV6).export(products);
        System.out.println("-----------URANO_INTEGRA------------");
        FabricadeBalancas.getBalance(TypeBalance.URANO_INTEGRA).export(products);
    }
}
