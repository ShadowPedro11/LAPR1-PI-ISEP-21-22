import java.io.*;
import java.util.Scanner;

public class UnitTest {


    public static void main(String[] args) throws IOException {
        runTestesSemUtilizador();
    }

    public static void runTestesSemUtilizador() throws IOException {
        if(test_leitura_de_dados() && test_pretende_carregar() && test_carregar_dados() && test_executar_funcao()
                && test_verificar_ficheiro_correto() && test_menu() && test_conetor_funcao() && test_verificar_pretende_visualizar()
                && test_media(2) && test_desvio_padrao() && test_verificar_data() && test_matriz_markov()  && test_matrix_previsao()
                && test_matriz_transicoes() && test_diferenca_matrizes() && test_decomposicaoLU() && test_matriz_inversa_lower()
                && test_matriz_inversa_upper() && test_matriz_inversa_final() && test_obter_transicao() && test_diferenca_de_dias()
                && test_matriz_previsao_markov_dias_em_falta() && test_get_first_monday() && test_get_last_sunday() && test_get_first_day_of_month()
                && test_last_day_of_month() && test_print_writer_interativo() && test_carregar_dados_nao_interativo() && test_funcao_previsoes()
                && test_funcao_previsoes_morte() && test_fun() && test_escrever_dados_comparar() && test_comparar_dados_dias() && test_escolher_tempo_comparar()
                && test_funcao_comparar() && test_visualizar_data_temporal_semana() && test_visualizar_data_temporal_mes() && test_visualizar_data_temporal_dias()
                && test_escolher_Tempo() && test_funcao_visualizar() && test_guardar_dados_comparar() && test_trabalhar_dados() && test_executar_visualizar() && test_executar_comparar() && teste_funcao_comparar_nao_interativa()
                && teste_vizualizar_novosCasos_nao_interativo() && teste_funcao_visualizar_total_casos_nao_interativa() && test_executar_previsoes_nao_interativo()
                && test_visualizar_e_comparar_nao_interativo() && test_executar_todas_as_funcoes_nao_interativo() && test_naoInterativo()){
            System.out.println("UnitTest OK");
        }else {
            System.out.println("leitura_dos_dados: " + (test_leitura_de_dados() ? "OK" : "NOT Ok" + "\n"));

            System.out.println("verificar pretende carregar: " + ((test_pretende_carregar()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar carregar dados: " + ((test_carregar_dados()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar executar funcao: " + ((test_executar_funcao()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar ficheiro correto: " + ((test_verificar_ficheiro_correto()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("menu: " + (test_menu() ? "OK" : "NOT OK" + "\n"));

            System.out.println("conectorFuncaoPretendidaParaArrayComOsDados: " + (test_conetor_funcao() ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar pretende visualizar: " + (test_verificar_pretende_visualizar() ? "OK" : "NOT OK" + "\n"));

            System.out.println("media: " + ((test_media(2)) ? "OK" : "NOT OK" + "\n"));

            System.out.println("desvio padrão: " + ((test_desvio_padrao()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar data: " + ((test_verificar_data()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar matriz markov: " + ((test_matriz_markov()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar matriz previsao markov: " + ((test_matrix_previsao()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar matriz transicoes: " + ((test_matriz_transicoes()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar diferenca de matrizes: " + ((test_diferenca_matrizes()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar decomposicao LU: " + ((test_decomposicaoLU()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar matrix inversa lower: " + ((test_matriz_inversa_lower()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar matriz inversa upper: " + ((test_matriz_inversa_upper()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar matriz inversa final: " + ((test_matriz_inversa_final()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar obter trasicao: " + ((test_obter_transicao()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar diferenca de dias: " + ((test_diferenca_de_dias()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar previsao dias em falta: " + ((test_matriz_previsao_markov_dias_em_falta()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar get first monday: " + ((test_get_first_monday()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar get last sunday: " + ((test_get_last_sunday()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar get first day of month: " + ((test_get_first_day_of_month()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar last day of the month: " + ((test_last_day_of_month()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar print writer interativo: " + ((test_print_writer_interativo()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar carregar dados nao iterativo: " + ((test_carregar_dados_nao_interativo()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar funcao previsoes: " + ((test_funcao_previsoes()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar funcao previsoes morte: " + ((test_funcao_previsoes_morte()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar previsoesMain: " + ((test_fun()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar escrever dados comparar: " + ((test_escrever_dados_comparar()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar escrever dados comparar: " + ((test_comparar_dados_dias()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar escolher tempo comparar: " + ((test_escolher_tempo_comparar()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar funcao comparar: " + ((test_funcao_comparar()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar visualizar data temporal mes: " + ((test_visualizar_data_temporal_mes()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar visualizar data temporal semana: " + ((test_visualizar_data_temporal_semana()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar visualizar data temporal dia: " + ((test_visualizar_data_temporal_dias()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar funcao visualizar: " + ((test_funcao_visualizar()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar visualizar data temporal dia: " + ((test_visualizar_data_temporal_dias()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar guardar dadso comparar: " + ((test_guardar_dados_comparar()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar executar visualizar: " + ((test_executar_visualizar()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar executar comparar: " + ((test_executar_comparar()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar trabalhar dados: " + ((test_trabalhar_dados()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar funcao comparar nao interativo: " + ((teste_funcao_comparar_nao_interativa()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar visualizar novos casos nao interativo: " + ((teste_vizualizar_novosCasos_nao_interativo()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar funcao visualizar total casos nao interativo: " + (( teste_funcao_visualizar_total_casos_nao_interativa()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar executar previsoes nao interativo: " + (( test_executar_previsoes_nao_interativo()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar visualizar e comparar nao interativo: " + ((test_visualizar_e_comparar_nao_interativo()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar executar todas as funcoes nao interativo: " + (( test_executar_todas_as_funcoes_nao_interativo()) ? "OK" : "NOT OK" + "\n"));

            System.out.println("verificar nao interativo: " + ((test_naoInterativo()) ? "OK" : "NOT OK" + "\n"));
        }
    }

    public static boolean test_print_writer_interativo() throws IOException {
        String[] guardarDados = {("teste1"), ("teste2"), ("teste3"), null};
        String dados = "Dados";
        String nome = "testeVerificarPrintWriter.csv";
        String nome2 = "verificarPrintWriter.csv";
        File Verificar = new File(nome);
        File Comparar = new File(nome2);

        Project.printWriter(guardarDados, Verificar, dados, 1);

        Scanner ficheiro1 = new Scanner(Verificar);
        Scanner ficheiro = new Scanner(Comparar);
        int count = 0;

        while (guardarDados.length != count) {
            String uno = ficheiro1.nextLine();
            String dos = ficheiro.nextLine();
            if (uno.compareTo(dos) == 0) {
                count++;
            }
        }
        if (count == 4) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_pretende_carregar() {
        if (Project.pretendeCarregar(1) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_carregar_dados() {
        if (Project.carregarDados(1).equals("testMarkov.csv")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_verificar_ficheiro_correto() throws FileNotFoundException {
        if (Project.verificarFicheiroCorreto("testLeituraDeDados.csv", 1)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_verificar_pretende_visualizar() {
        if (Project.pretendeVisualizar("t") == 0) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean test_leitura_de_dados() throws FileNotFoundException {
        File dadosTest = new File("testLeituraDeDados.csv");
        Scanner sc = new Scanner(dadosTest);
        sc.nextLine();
        String test = "testLeituraDeDados.csv";
        final int DIASMAXIMOS = 1000;
        final int DADOS = 5;
        String[] dias = new String[DIASMAXIMOS];
        String[][] diasSeparados = new String[DIASMAXIMOS][3];
        int[][] dados = new int[DIASMAXIMOS][DADOS];

        if (Project.leituraDeDados(dias, dados, diasSeparados, "", test) == 5) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_conetor_funcao() {
        if (Project.conectorFuncaoPretendidaParaArrayComOsDados(1) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_menu() {
        if (Project.menu(1) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_media(int expected) {
        int[][] dados = {{3, 3, 3}, {1, 2, 3}};
        if (Project.media(dados, 0) == expected) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_verificar_data() {
        String[] dias = {"2020-04-01", "2020-04-02", "2020-04-03"};
        String[][] diasSeparados = {{"2020", "04", "01"}, {"2020", "04", "02"}, {"2020", "04", "03"}};
        if (Project.verificarData(3, dias, "2020-04-02", diasSeparados) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_executar_funcao() {
        if (Project.executarFuncao("s")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_trabalhar_dados () throws FileNotFoundException { //##################
        String[] dias = {"5","10","15","20","25"};
        int[][] dadosCovid = {{5,5,5,5,5},{10,10,10,10,10},{15,15,15,15,15},{20,20,20,20,20},{25,25,25,25,25}};
        String[][] diasSeparados = new String[5][5];
        Project.trabalharDados(dias, dadosCovid, diasSeparados, "a", "t");
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (dadosCovid[i][j] == 5) {
                    count++;
                }
            }
        }

        if (count == 25) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_executar_comparar () throws IOException { //#######################
        if (test_funcao_comparar()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_executar_visualizar () throws IOException { //################
        if (test_funcao_visualizar()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_guardar_dados_comparar() { //###################
        int[][] dadosCovid = {{1,1,1},{1,1,1},{1,1,1}};
        int posicaoi1 = 1;
        int posicaoi2 = 1;
        int dadoApresentar = 1;
        String[] dias = new String[5];
        int pretendeVisualizar = 1;
        int test = 1;
        String[] guardarDados = new String[5];
        int linhaGuardar = 0;
        int linha = 1;
        int copiaPos1 = 1;
        int[][] dadosIntervalo = {{1,1,1},{1,1,1}};
        int[][] dadosIntervalo2 = {{1,1,1},{1,1,1},{1,1,1}};
        int[][] valorComparacao = {{1,1,1},{1,1,1}};
        String tipoDados = "a";
        if (Project.guardarDadosComparar(dadosCovid,posicaoi1,posicaoi2,dadoApresentar,dias,pretendeVisualizar,test,guardarDados,linhaGuardar,linha,copiaPos1,0,dadosIntervalo, dadosIntervalo2, valorComparacao, tipoDados) == 0) {
            return true;
        }else {
            return false;
        }
    }

    public static boolean test_funcao_visualizar() throws IOException { //#########################3
        if (test_escolher_Tempo() && test_verificar_data() && test_conetor_funcao()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_escolher_Tempo() throws IOException { //################
        if (test_verificar_data() && test_visualizar_data_temporal_dias() && test_visualizar_data_temporal_semana() && test_visualizar_data_temporal_mes() && test_executar_funcao()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_visualizar_data_temporal_dias() { //###################
        if (test_conetor_funcao()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_visualizar_data_temporal_semana () throws IOException { //####################
        if (test_get_first_day_of_month() && test_last_day_of_month() && test_conetor_funcao() && test_print_writer_interativo()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_visualizar_data_temporal_mes() throws IOException { //#########################
        if (test_get_first_day_of_month() && test_last_day_of_month() && test_conetor_funcao() && test_print_writer_interativo()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_funcao_comparar () throws IOException { //#############################
        if (test_conetor_funcao() && test_escolher_tempo_comparar() && test_executar_funcao()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_escolher_tempo_comparar() throws IOException { //##########################3
        if (test_verificar_data() && test_comparar_dados_dias() && test_executar_funcao()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_comparar_dados_dias() throws IOException { //######################
        if (test_guardar_dados_comparar() && test_media(2) && test_desvio_padrao() && test_print_writer_interativo() && test_escrever_dados_comparar()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_escrever_dados_comparar() { //###############################
        String tipoDados = "casos totais";
        int comprimento = 1;
        int[][] dadosDoIntervalo1 = {{1,1},{1,1}};
        int[][] dadosDoIntervalo2 = {{1,1},{1,1}};
        int[][] valorDaComparacao = {{1,1},{1,1}};
        String[] guardarDados = new String[10];
        String[] dias = new String[10];
        int posicaoInicio = 1;
        int posicaoInicio2 = 1;
        int linhaGuardar = 0;
        int test = 1;
        if (Project.escreverDadosComparar(tipoDados, comprimento, dadosDoIntervalo1, dadosDoIntervalo2, valorDaComparacao, guardarDados, dias, posicaoInicio, posicaoInicio2, linhaGuardar, test)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_desvio_padrao() {
        int[][] dadosDoIntervalo = {{1, 7, 3, 5}, {9, 4, 6, 11, 10}};
        double media = 5;
        if (Project.desvioPadrao(dadosDoIntervalo, media, 0) == 4) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_get_first_monday() {
        String[][] diasSeparados = {{"2020", "04", "01"}, {"2020", "04", "02"}, {"2020", "04", "03"}, {"2020", "04", "04"}, {"2020", "04", "05"}, {"2020", "04", "06"}, {"2020", "04", "07"}, {"2020", "04", "08"}, {"2020", "04", "09"}, {"2020", "04", "10"}, {"2020", "04", "11"}, {"2020", "04", "12"}, {"2020", "04", "13"}, {"2020", "04", "14"}, {"2020", "04", "15"}, {"2020", "04", "16"}, {"2020", "04", "17"}, {"2020", "04", "18"}, {"2020", "04", "19"}, {"2020", "04", "20"}};
        int numeiro1 = 0;
        int numeiro2 = 19;
        if (Project.getFirstMonday(diasSeparados, numeiro1, numeiro2) == 5) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_get_last_sunday() {
        String[][] diasSeparados = {{"2020", "04", "01"}, {"2020", "04", "02"}, {"2020", "04", "03"}, {"2020", "04", "04"}, {"2020", "04", "05"}, {"2020", "04", "06"}, {"2020", "04", "07"}, {"2020", "04", "08"}, {"2020", "04", "09"}, {"2020", "04", "10"}, {"2020", "04", "11"}, {"2020", "04", "12"}, {"2020", "04", "13"}, {"2020", "04", "14"}, {"2020", "04", "15"}, {"2020", "04", "16"}, {"2020", "04", "17"}, {"2020", "04", "18"}, {"2020", "04", "19"}, {"2020", "04", "20"}};
        int numeiro1 = 0;
        int numeiro2 = 19;
        if (Project.getLastSunday(diasSeparados, numeiro1, numeiro2) == 19) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_get_first_day_of_month() {
        String[][] diasSeparados = {{"2020", "04", "01"}, {"2020", "04", "02"}, {"2020", "04", "03"}, {"2020", "04", "04"}, {"2020", "04", "05"}, {"2020", "04", "06"}, {"2020", "04", "07"}, {"2020", "04", "08"}, {"2020", "04", "09"}, {"2020", "04", "10"}, {"2020", "04", "11"}, {"2020", "04", "12"}, {"2020", "04", "13"}, {"2020", "04", "14"}, {"2020", "04", "15"}, {"2020", "04", "16"}, {"2020", "04", "17"}, {"2020", "04", "18"}, {"2020", "04", "19"}, {"2020", "04", "20"}, {"2020", "04", "21"}, {"2020", "04", "22"}, {"2020", "04", "23"}, {"2020", "04", "24"}, {"2020", "04", "25"}, {"2020", "04", "26"}, {"2020", "04", "27"}, {"2020", "04", "28"}, {"2020", "04", "29"}, {"2020", "04", "30"}, {"2020", "05", "01"}, {"2020", "05", "02"}};
        int numeiro1 = 0;
        int numeiro2 = 31;
        if (Project.getFirstDayOfMonth(diasSeparados, numeiro1, numeiro2) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_last_day_of_month() {
        String[][] diasSeparados = {{"2020", "04", "01"}, {"2020", "04", "02"}, {"2020", "04", "03"}, {"2020", "04", "04"}, {"2020", "04", "05"}, {"2020", "04", "06"}, {"2020", "04", "07"}, {"2020", "04", "08"}, {"2020", "04", "09"}, {"2020", "04", "10"}, {"2020", "04", "11"}, {"2020", "04", "12"}, {"2020", "04", "13"}, {"2020", "04", "14"}, {"2020", "04", "15"}, {"2020", "04", "16"}, {"2020", "04", "17"}, {"2020", "04", "18"}, {"2020", "04", "19"}, {"2020", "04", "20"}, {"2020", "04", "21"}, {"2020", "04", "22"}, {"2020", "04", "23"}, {"2020", "04", "24"}, {"2020", "04", "25"}, {"2020", "04", "26"}, {"2020", "04", "27"}, {"2020", "04", "28"}, {"2020", "04", "29"}, {"2020", "04", "30"}, {"2020", "05", "01"}, {"2020", "05", "02"}};
        int numeiro1 = 0;
        int numeiro2 = 31;
        if ((Project.getLastDayOfMonth(diasSeparados, numeiro1, numeiro2)) == 29) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_matriz_markov() throws FileNotFoundException {
        double[][] matriz = new double[5][5];
        matriz = Project.matrizMarkov(matriz, "testMarkov.csv");
        double[][] matrizTest = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
        boolean iguais = true;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matriz[i][j] != matrizTest[i][j]) {
                    iguais = false;
                }
            }
        }
        if (iguais) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_matrix_previsao() {
        double[] test = {75, 75, 75, 75, 75};
        int[][] dadosConvid = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        double[][] matrizProbabilidades = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
        double[] comparar = Project.matrizPrevisaoMarkov(dadosConvid, matrizProbabilidades, 0);
        boolean iguais = true;
        for (int i = 0; i < 5; i++) {
            if (test[i] != comparar[i]) {
                iguais = false;
            }
        }
        if (iguais) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_matriz_transicoes() throws FileNotFoundException {
        double[][] test = Project.matrizTransicoes("testMarkov.csv");
        double[][] comparar = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        boolean iguais = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (test[i][j] != comparar[i][j]) {
                    iguais = false;
                }
            }
        }

        if (iguais) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_diferenca_matrizes() {
        double[][] test = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        double[][] comparar = new double[4][4];
        test = Project.diferencaDeMatrizes(test);
        boolean iguais = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (test[i][j] != comparar[i][j]) {
                    iguais = false;
                }
            }
        }
        if (iguais) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_decomposicaoLU() {
        double[][] transicoes = {{1.20, -0.84, 2.28, 1.21}, {1.743, 3.00, -0.59, 2.45}, {0.81, -0.98, 2.33, -0.33}, {2.90, -0.59, -0.86, 0.86}};
        double[][] lower = new double[4][4];
        double[][] upper = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        double[][] test = {{1.20, 0, 0, 0}, {1.743, 4.2201, 0, 0}, {0.81, -0.41300000000000003, 0.4091602094737093, 0}, {2.90, 1.44, -5.038645766687994, -15.587678466941988}};
        lower = Project.decomposicaoLU(transicoes, upper, lower);
        boolean iguais = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (test[i][j] != lower[i][j]) {
                    iguais = false;
                }
            }
        }
        if (iguais) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_matriz_inversa_lower() {
        double[][] test = {{1, 0, 0, 0}, {-1, 1, 0, 0}, {-1, 0, 1, 0}, {-1, 0, 0, 1}};
        double[][] lower = {{1, 0, 0, 0}, {1, 1, 0, 0}, {1, 0, 1, 0}, {1, 0, 0, 1}};
        lower = Project.matrizInversaLower(lower);
        boolean iguais = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (test[i][j] != lower[i][j]) {
                    iguais = false;
                }
            }
        }
        if (iguais) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean test_matriz_inversa_upper() {
        double[][] test = {{1, -2, 1, -6}, {0, 1, -2, 7}, {0, 0, 1, -4}, {0, 0, 0, 1}};
        double[][] upper = {{1, 2, 3, 4}, {0, 1, 2, 1}, {0, 0, 1, 4}, {0, 0, 0, 1}};
        upper = Project.matrizInversaUpper(upper);
        boolean iguais = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (test[i][j] != upper[i][j]) {
                    iguais = false;
                }
            }
        }
        if (iguais) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_matriz_inversa_final() {
        double[][] lower = {{1, 0, 0, 0}, {1, 1, 0, 0}, {1, 0, 1, 0}, {1, 0, 0, 1}};
        double[][] upper = {{3, 3, 3, 3}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        double[][] transicoes = {{3, 3, 3, 3}, {3, 3, 3, 3}, {3, 3, 3, 3}, {3, 3, 3, 3}};
        double[][] test = Project.matrizInversaFinal(upper, lower);
        boolean iguais = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (transicoes[i][j] != test[i][j]) {
                    iguais = false;
                }
            }
        }
        if (iguais) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_obter_transicao() {
        double[][] inversaFinal = {{2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}};
        double[] test = {8, 8, 8, 8};
        double[] transicao = Project.obterTransicao(inversaFinal);
        boolean iguais = true;
        for (int i = 0; i < 4; i++) {
            if (test[i] != transicao[i]) {
                iguais = false;
            }
        }
        if (iguais) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_diferenca_de_dias() {
        String[][] diasSeparados = {{"30", "12", "2021"}, {"31", "12", "2021"}};

        if (Project.diferencaDeDias("02-01-2022", diasSeparados, 2) == 3) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_matriz_previsao_markov_dias_em_falta() {
        double[][] transicao = {{2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}};
        double[] previsao = {1, 1, 1, 1};
        double[] expected = {8, 8, 8, 8};
        double[] resultado = Project.matrizPrevisaoMarkovDiasEmFalta(previsao, transicao);
        boolean iguais = true;
        for (int i = 0; i < 4; i++) {
            if (resultado[i] != expected[i]) {
                iguais = false;
            }
        }
        if (iguais) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_carregar_dados_nao_interativo() {
        if (Project.carregarDadosNaoInterativo("testLeituraDeDados.csv").equals("testLeituraDeDados.csv")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_funcao_previsoes() throws FileNotFoundException {
        if (test_verificar_data() && !test_diferenca_de_dias() && test_matriz_markov() && test_matrix_previsao() && test_matriz_previsao_markov_dias_em_falta()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_funcao_previsoes_morte() throws FileNotFoundException {
        if (test_matriz_transicoes() && test_diferenca_matrizes() && test_decomposicaoLU() && test_matriz_inversa_upper() && test_matriz_inversa_lower() && test_matriz_inversa_final() && test_obter_transicao()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_fun() throws FileNotFoundException {
        if (test_funcao_previsoes() && test_funcao_previsoes_morte()) {
            return true;
        } else {
            return false;
        }
    }
    //////
    public static boolean test_naoInterativo() throws IOException {
        if (test_verificar_ficheiro_correto() && test_executar_todas_as_funcoes_nao_interativo() && test_visualizar_e_comparar_nao_interativo() && test_executar_previsoes_nao_interativo()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_executar_todas_as_funcoes_nao_interativo() throws IOException {
        if (test_carregar_dados_nao_interativo() && test_leitura_de_dados() && !test_diferenca_de_dias() && test_verificar_data() && teste_funcao_visualizar_total_casos_nao_interativa() && teste_funcao_comparar_nao_interativa() && test_funcao_previsoes_morte() && test_funcao_previsoes() && test_executar_previsoes_nao_interativo()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_visualizar_e_comparar_nao_interativo() throws IOException {
        if (test_carregar_dados_nao_interativo() && test_leitura_de_dados() && test_verificar_data() && teste_funcao_visualizar_total_casos_nao_interativa() && teste_funcao_comparar_nao_interativa()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean test_executar_previsoes_nao_interativo() throws FileNotFoundException {
        if (test_matriz_markov() && test_matrix_previsao() && test_matriz_previsao_markov_dias_em_falta()) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean teste_funcao_visualizar_total_casos_nao_interativa(){
        if (teste_vizualizar_novosCasos_nao_interativo() && test_get_first_monday() && test_get_last_sunday() && test_get_first_day_of_month() && test_last_day_of_month()){
            return true;
        }else{
            return false;
        }
    }

    public static boolean teste_vizualizar_novosCasos_nao_interativo() {
        if (test_get_first_monday() && test_get_last_sunday() && test_get_first_day_of_month() && test_last_day_of_month()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean
    teste_funcao_comparar_nao_interativa() throws IOException {
        if (test_media(2) && test_desvio_padrao()){
            return true;
        }else{
            return false;
        }
    }
}