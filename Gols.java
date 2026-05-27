import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gols {

        // método Jogador com mais gols (todos os tipos)
        public static String jogadorComMaisGols(List<String[]> dados) {
            Map<String, Integer> contagem = new HashMap<>();

            dados.stream()
                    .map(linha -> linha[3]) // nome do jogador
                    .forEach(jogador ->
                            contagem.put(jogador, contagem.getOrDefault(jogador, 0) + 1)
                    );

            return contagem.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse("Nenhum");
        }

        // 2 e 3. Jogador com mais gols de um tipo específico
        public static String jogadorComMaisGolsDeTipo(List<String[]> dados, String tipo) {
            Map<String, Integer> contagem = new HashMap<>();

            dados.stream()
                    .filter(linha -> linha[5].toLowerCase().contains(tipo)) // aceita "pen", "pênalti", "penalty", etc.
                    .map(linha -> linha[3]) // nome do jogador
                    .forEach(jogador ->
                            contagem.put(jogador, contagem.getOrDefault(jogador, 0) + 1)
                    );

            return contagem.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse("Nenhum");
        }
    }


