import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cartao {
    public static String contarAmarelo (List<String[]> cartoes) {
        Map<String, Integer> cartaoAmarelo = new HashMap<>();

        cartoes.stream()
                .skip(1)//pula cabeçalho do arq csv
                .filter(linha -> linha.length > 4) //verifica linha completa
                .filter(linha -> "Amarelo".equalsIgnoreCase(linha[3].replace("\"", "").trim()))
                .map(linha -> linha[4]) // nome do jogador
                .forEach(jogador ->
                        cartaoAmarelo.put(jogador, cartaoAmarelo.getOrDefault(jogador, 0) + 1));

        return cartaoAmarelo.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum jogador encontrado!");


    }
    // MÉTODO 2: Lógica do Cartão Vermelho
    public static String contarVermelho (List<String[]> cartoes) {
        Map<String, Integer> cartaoVermelho = new HashMap<>();

        cartoes.stream()
                .skip(1)//pula cabeçalho do arq csv
                .filter(linha -> linha.length > 4) //verifica linha completa
                .filter(linha -> "Vermelho".equalsIgnoreCase(linha[3].replace("\"", "").trim()))
                .map(linha -> linha[4]) // nome do jogador
                .forEach(jogador ->
                        cartaoVermelho.put(jogador, cartaoVermelho.getOrDefault(jogador, 0) + 1));

        return cartaoVermelho.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum jogador encontrado!");


    }

}









