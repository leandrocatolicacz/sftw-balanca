package classes;

import classes.exceptions.ObjetoNulo;
import interfaces.Balanca;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BalancaFizola implements Balanca<Produto> {
    @Override

    public void export(List<Produto> products, String path) {
        if (products.isEmpty()) {
            throw new ObjetoNulo("Lista vazia");
        }
        try {
        String result = products.stream().peek(produto -> {
                    if (produto == null) {
                        throw new ObjetoNulo("Produto nulo");
                    }if(!(produto.getType().equals("P") || produto.getType().equals("U"))){
                        throw new InvalidParameterException("Paramentro invalido, forneca um tipo valido");
                    }
                }).map(product ->
                        String.format("%06d", product.getCode()) +
                                product.getType() +
                                String.format("%-22s", product.getDescription()).substring(0, 22) +
                                String.format(("%07d"), (int) (product.getValue() * 100)) +
                                "000")
                .collect(Collectors.joining("\n"));

            File file = new File(path + "/CADTXT.txt");

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(result);
            writer.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ObjetoNulo e) {
            System.err.println(e.getMessage());
        }catch (InvalidParameterException e){
            System.err.println(e.getMessage());
        }
    }
}

