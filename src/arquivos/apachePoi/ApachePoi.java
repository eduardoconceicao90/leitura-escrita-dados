package arquivos.apachePoi;

import arquivos.domain.Pessoa;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApachePoi {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\eduar\\Desktop\\Eduardo\\projetos back-end\\arquivos\\arquivo_excel.xls");

        if (!file.exists()) {
            file.createNewFile();
        }

        Pessoa p1 = new Pessoa("Telma","p1@mail.com",65);
        Pessoa p2 = new Pessoa("Eduardo","p2@mail.com",33);
        Pessoa p3 = new Pessoa("Natália","p3@mail.com",35);
        Pessoa p4 = new Pessoa("Alex","p4@mail.com",38);

        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);
        pessoas.add(p4);

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); /* Vai ser usado para escrever a planilha */
        HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas"); /* Criar a planilha */

        int numeroLinha = 0;

        for (Pessoa p : pessoas) {
            Row linha = linhasPessoa.createRow(numeroLinha ++ ); /* Criando a linha na planilha */

            int celula = 0;

            Cell celNome = linha.createCell(celula ++);/* Celula 1 */
            celNome.setCellValue(p.getNome());


            Cell celemail = linha.createCell(celula ++); /* Celula 2 */
            celemail.setCellValue(p.getEmail());


            Cell celIdade = linha.createCell(celula ++); /* Celula 3 */
            celIdade.setCellValue(p.getIdade());

        } /* Termino de montrar a planilha */

        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida); /* Escreve planilha em arquivo */
        saida.flush();
        saida.close();

        System.out.println("Planilha foi criada");

    }
}
