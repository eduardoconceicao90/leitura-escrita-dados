package arquivos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EscreveJSON {

    public static void main(String[] args) throws IOException {

        Usuario usuario1 = new Usuario("eduardo90","123","55448785422", "Eduardo");
        Usuario usuario2 = new Usuario("telma58","123","55478899978", "Telma");
        Usuario usuario3 = new Usuario("joao99","123","55777988852", "João");

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); /* Formata o json para vir organizado */
        String jsonUser = gson.toJson(usuarios);
        System.out.println(jsonUser);

        FileWriter fileWriter = new FileWriter("C:\\Users\\eduar\\Desktop\\Eduardo\\projetos back-end\\arquivos\\file_json.json");

        fileWriter.write(jsonUser);
        fileWriter.flush();
        fileWriter.close();

    }
}
