
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Função para ler CSV da internet
public class LerArquivo{

    public static List<String[]> leitorCSV(String link) {
        try {
            List<String[]> dados = new ArrayList<>();
            URL url = new URL(link);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            // Remover cabeçalho
            dados = dados.stream().skip(1).collect(Collectors.toList());
            return br.lines()
                     .map(linha -> linha.split(","))
                     .collect(Collectors.toList());
        } catch (IOException e) {
             System.out.println ("Arquivo não encontrado!");
             return(null);
        }
    }

    public static void imprimirDados(List<String[]> dados) {
        for (String[] linha : dados)
            // Junta as colunas com espaço ou vírgula para exibir
            System.out.println(String.join(",", linha));
        }
}