package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

    public static void main(String[] args) throws IOException {

        Pessoa p1 = new Pessoa("Telma","p1@mail.com",65);
        Pessoa p2 = new Pessoa("Eduardo","p2@mail.com",33);
        Pessoa p3 = new Pessoa("Natália","p3@mail.com",35);

        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);

        //File arquivo = new File("C:\\Users\\eduar\\Desktop\\Eduardo\\projetos back-end\\arquivos\\arquivo.txt");
        File arquivo = new File("C:\\Users\\eduar\\Desktop\\Eduardo\\projetos back-end\\arquivos\\arquivo.csv");

        if(!arquivo.exists()){
            arquivo.createNewFile();
        }

        FileWriter escreverNoArquivo = new FileWriter(arquivo);

        for(Pessoa p : pessoas){
            escreverNoArquivo.write(p.getNome() + ";" + p.getEmail() + ";" + p.getIdade() + "\n");
        }

        escreverNoArquivo.flush();
        escreverNoArquivo.close();
    }
}
