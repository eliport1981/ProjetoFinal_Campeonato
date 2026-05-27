import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partida {
    //método que identifica o time com mais vitórias em 2008
    public static String vitorias2008(List<String[]> partidas) {
        Map<String, Integer> qtdVitorias = new HashMap<>();

        partidas.remove(0); //retira o cabeçalho
        //transformando a lista em stream
        partidas.stream()
                .filter(ano2008 -> {
                    String dataStr = ano2008[2].replace("\"", "").trim();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                    LocalDate data1 = LocalDate.parse(dataStr, formatter);
                    //System.out.println(data1);
                    return data1.getYear() == 2008;
                })
                //filtra apenas os times cujo o nome possui tamanho maior que 3
                .filter(tamVencedor -> tamVencedor[10].trim().length() > 3)
                .map(vencedor -> vencedor[10]) // nome do time vencedor da partida
                .forEach(vencedor ->
                        qtdVitorias.put(vencedor, qtdVitorias.getOrDefault(vencedor, 0) + 1));


        //time com mais vitórias
        return qtdVitorias.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum time encontrado no ano de 2008");

    }


    // identificar o Estado que teve menos jogos dentro do período 2003 a 2022
    public static String EstadoMenosJogos(List<String[]> partidas) {
        Map<String, Integer> menosJogos = new HashMap<>();
        partidas.stream()
                .map(mandante -> mandante[14])
                .forEach(mandante -> menosJogos.put(mandante, menosJogos.getOrDefault(mandante, 0) + 1));

        return menosJogos.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum time encontrado no período de 2003 a 2022");
    }

    // MÉTODO: Placar da partida com mais gols
    public static String partidaComMaisGols(List<String[]> partidas) {
        Map<String, Integer> placares = new HashMap<>();

        partidas.stream()
                .skip(1) // Pula o cabeçalho do arquivo CSV
                .filter(linha -> linha.length > 13) // Garante que a linha tem as colunas de gols
                .forEach(linha -> {
                    // No arquivo 'full': Coluna 4 é Mandante, 5 é Visitante
                    String mandante = linha[4].replace("\"", "").trim();
                    String visitante = linha[5].replace("\"", "").trim();

                    // Coluna 12 são os gols do mandante, Coluna 13 são os gols do visitante
                    int golsMandante = Integer.parseInt(linha[12].replace("\"", "").trim());
                    int golsVisitante = Integer.parseInt(linha[13].replace("\"", "").trim());

                    // Somamos os gols daquela partida específica
                    int totalGols = golsMandante + golsVisitante;

                    // Montamos o texto do placar bonitinho
                    String textoPlacar = mandante + " " + golsMandante + " x " + golsVisitante + " " + visitante;

                    // Guardamos no nosso mapa
                    placares.put(textoPlacar, totalGols);
                });

        // Procuramos no mapa qual "textoPlacar" teve a maior quantidade de gols salvos
        return placares.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhuma partida encontrada!");

    }

}