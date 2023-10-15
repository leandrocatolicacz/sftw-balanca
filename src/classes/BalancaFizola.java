package classes;

import interfaces.Balanca;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class BalancaFizola implements Balanca<Produto> {


    @Override
    public void export(List<Produto> products) {
        String result = products.stream().map(product ->
                        String.format("%06d", product.getCode()) +
                                product.getType() +
                                String.format("%-22s", product.getDescription()).substring(0, 22) +
                                String.format(("%07d"), (int) (product.getValue() * 100)) +
                                "000")
                .collect(Collectors.joining("\n"));

        System.out.println(result);

        try {
            File file = new File("CADTXT.txt");

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(result);
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

