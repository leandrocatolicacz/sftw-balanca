package classes;

import classes.exceptions.ObjetoNulo;
import interfaces.Balanca;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ToledoMGV6 implements Balanca<Produto> {

    @Override
    public void export(List<Produto> products, String path) {
        if (products.isEmpty()){
            throw new NullPointerException("Lista vazia");
        }
        try {
            String result = products.stream().peek(produto -> {
                if (produto == null) {
                    throw new ObjetoNulo("Produto nulo");
                }
            }).map(product ->
                    String.format("01" +
                            "1" +
                            "%06d", product.getCode()) +
                            String.format("%06d", (int) (product.getValue() * 100)) +
                            "000" +
                            String.format("%-50s", product.getDescription()).substring(0, 50) +
                            "000000" +
                            "0000" +
                            "000000" +
                            "0" +
                            "0" +
                            "0000" +
                            "000000000000" +
                            "00000000000" +
                            "0" +
                            "0000" +
                            "0000" +
                            "0000" +
                            "0000" +
                            "0000" +
                            "0000" +
                            "000000000000" +
                            "000000" +
                            "|01|" +
                            String.format("%-35s", "") +
                            String.format("%-35s", "") +
                            "000000" +
                            "000000" +
                            "000000" +
                            "0000000|0000|0||"
            ).collect(Collectors.joining("\n"));



            File file = new File(path+"/ITENSMGV.TXT");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(result);
            writer.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ObjetoNulo e) {
            System.err.println(e.getMessage());
        }
    }
}
