package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {

    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream entradaArquivo =
                new FileInputStream(new File("C:\\Users\\eduar\\Desktop\\Eduardo\\projetos back-end\\arquivos\\arquivo.txt"));

        Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");

        List<Pessoa> pessoas = new ArrayList<>();

        while (lerArquivo.hasNext()){

            String linha = lerArquivo.nextLine();

            if(linha != null && !linha.isEmpty()){

                String[] dados = linha.split("\\;");
                Pessoa pessoa = new Pessoa(dados[0], dados[1], Integer.parseInt(dados[2]));

                pessoas.add(pessoa);

            }

        }

        pessoas.forEach(System.out::println);

        System.out.println("-----------------------------");

        for (Pessoa pessoa : pessoas){
            System.out.println(pessoa);
        }

    }
}
