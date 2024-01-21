package arquivos.json;

import arquivos.domain.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerJSON {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("C:\\Users\\eduar\\Desktop\\Eduardo\\projetos back-end\\arquivos\\file_json.json");

        JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);

        List<Usuario> usuarios = new ArrayList<>();

        for(JsonElement jsonElement : jsonArray){

            Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
            usuarios.add(usuario);

        }

        System.out.println("Leitura do arquivo JSON: " + usuarios);

    }
}
