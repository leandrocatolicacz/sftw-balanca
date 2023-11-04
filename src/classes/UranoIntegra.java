package classes;

import classes.exceptions.ObjetoNulo;
import interfaces.Balanca;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class UranoIntegra implements Balanca<Produto> {

    @Override
    public void export(List<Produto> products, String path) {
        if(products.isEmpty()){
            throw new ObjetoNulo("Lista vazia");
        }
        try {
        String result = products.stream().peek(produto -> {
            if(produto == null){
                throw new ObjetoNulo("Produto nulo");
            }
        }).map(product ->
                String.format("%06d", product.getCode()) +
                        "*" +
                        "0" +
                        String.format("%-20s", product.getDescription()).substring(0, 20) +
                        String.format("%09.2f", product.getValue()).replace('.', ',') +
                        "00000" +
                        "D"
        ).collect(Collectors.joining("\n"));

            File file = new File(path+"/PRODUTOS.TXT");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(result);
            writer.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }catch (ObjetoNulo e){
            System.err.println(e.getMessage());
        }
    }
}
