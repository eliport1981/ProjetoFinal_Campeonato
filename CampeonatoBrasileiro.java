//Projeto Final CaixaVerso_Técnicas de Programação
// Participantes:
// Aline, Hellen, Maria Elisiane

import java.util.List;

public class CampeonatoBrasileiro {
    public static void main(String[] args) throws Exception {
        // Caminhos dos arquivos CSV

        String linkGols = "https://raw.githubusercontent.com/vconceicao/ada_brasileirao_dataset/master/campeonato-brasileiro-gols.csv";
        String linkCartoes = "https://raw.githubusercontent.com/vconceicao/ada_brasileirao_dataset/refs/heads/master/campeonato-brasileiro-cartoes.csv";
        String linkEstatisticas = "https://github.com/vconceicao/ada_brasileirao_dataset/blob/master/campeonato-brasileiro-estatisticas-full.csv";
        String linkPartidas = "https://raw.githubusercontent.com/vconceicao/ada_brasileirao_dataset/refs/heads/master/campeonato-brasileiro-full.csv";

        // Leitura dos arquivos csv
        List<String[]> partidas = LerArquivo.leitorCSV(linkPartidas);
        List<String[]> gols = LerArquivo.leitorCSV(linkGols);
        List<String[]> cartoes = LerArquivo.leitorCSV(linkCartoes);
        List<String[]> estatisticas = LerArquivo.leitorCSV(linkEstatisticas);
        String caminhoCartoes = "https://raw.githubusercontent.com/vconceicao/ada_brasileirao_dataset/refs/heads/master/campeonato-brasileiro-cartoes.csv";

       //visualizando os dados dos arquivos csv, imprimindo ok
        //System.out.println("lista gols:");
        //LerCSV.imprimirDados(gols);
        //System.out.println("lista partida:");
        //LerCSV.imprimirDados(partidas);
        //System.out.println("lista cartões:");
        //LerCSV.imprimirDados(cartoes);

        //Elisiane
        //1. Time com mais vitórias em 2008
        String vitorias2008 = Partida.vitorias2008(partidas);
        //2. Estado com menos josgos no período 2003 a 2022
         String estadoMenosJogos = Partida.EstadoMenosJogos(partidas);


        //código Hellen
        // 1. Jogador que mais fez gols
        String maisGols = Gols.jogadorComMaisGols(gols);
        // 2. Jogador que mais fez gols de pênalti
        String maisPenaltis = Gols.jogadorComMaisGolsDeTipo(gols, "pen");
        // 3. Jogador que mais fez gols contra
        String maisContra = Gols.jogadorComMaisGolsDeTipo(gols, "contra");

        //1. Jogador com mais cartões amarelos
        String cartaoAmarelo = Cartao.contarAmarelo(cartoes);
        //2. Jogador com mais cartões vermelhos
        String cartaoVermelho = Cartao.contarVermelho(cartoes);
        //2. O placar da partida com mais gols.
        String maisGolsNaPartida = Partida.partidaComMaisGols(partidas);

        //3. Placar da partida com mais gols
        System.out.println("O time com mais vitórias no ano de 2008 :" + vitorias2008);
        System.out.println("O Estado com menos jogos no período de 2003 a 2022: " + estadoMenosJogos);
        System.out.println("Jogador com mais gols: " + maisGols);
        System.out.println("Jogador com mais gols de pênalti: " + maisPenaltis);
        System.out.println("Jogador com mais gols contra: " + maisContra);

    //fim código de Hellen

        System.out.println("Jogador com mais cartões amarelos: " + cartaoAmarelo);
        System.out.println("Jogador com mais cartões vermelhos: " + cartaoVermelho);
        System.out.println("Partida com mais gols: " + maisGolsNaPartida);
    }
}


