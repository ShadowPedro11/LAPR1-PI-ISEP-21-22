import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

public class Project {

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        UnitTest.runTestesSemUtilizador();
        String nomeMatriz = "";
        boolean ficheirosCarregadosMatriz = false;
        String test = "";
        final int DIASMAXIMOS = 1000;
        final int NUMERODADOS = 5;
        final int NUMERODADOSDIAS = 3;
        int tarefa;
        boolean interruptor = true;
        String[] dias = new String[DIASMAXIMOS];
        String[][] diasSeparados = new String[DIASMAXIMOS][NUMERODADOSDIAS];
        int[][] dadosCovid = new int[DIASMAXIMOS][NUMERODADOS];
        int diasTotais = 0;
        String[] dias2 = new String[DIASMAXIMOS];
        String[][] diasSeparados2 = new String[DIASMAXIMOS][NUMERODADOSDIAS];
        int[][] dadosCovid2 = new int[DIASMAXIMOS][NUMERODADOS];
        int diasTotais2 = 0;
        String nome = " ";
        boolean ficheirosCarregados = false;
        int ativos = 0;
        int acumulado = 0;

        if (args.length <= 0) {
            System.out.println();
            System.out.println("                            BEM VINDO AO PROGRAMA DE DADOS DE COVID-19");
            System.out.println();
            System.out.println("             ▄▄██████████▄▄");
            System.out.println("             ▀▀▀   ██   ▀▀▀                   ███▄       ▄███    ▄███████████▄  ███████████▄");
            System.out.println("     ▄██▄   ▄▄████████████▄▄   ▄██▄           ████▄     ▄████  ▄█████████████▀  █████████████▄");
            System.out.println("   ▄███▀  ▄████▀▀      ▀▀████▄  ▀███▄         █████▄   ▄█████  ████▀            ███       ▀███");
            System.out.println("  ████▄ ▄███▀              ▀███▄ ▄████        ██████▄ ▄██████  ███              ███        ███");
            System.out.println(" ███▀█████▀▄████▄      ▄████▄▀█████▀███       ███▀███▄███▀███  ███              ███        ███");
            System.out.println(" ██▀  ███▀ ██████      ██████ ▀███  ▀██       ███ ▀█████▀ ███  ███              ███       ▄███");
            System.out.println("  ▀  ▄██▀  ▀████▀      ▀████▀  ▀██▄  ▀        ███  ▀███▀  ███  ████▄            █████████████▀");
            System.out.println("     ███                        ███           ███   ▀▀▀   ███  ▀███████████▄    ███████████▀");
            System.out.println("     ███                        ███           ███         ███   ▀████████████▄  ███");
            System.out.println(" ▄█  ▀██▄  ▄████▄      ▄████▄  ▄██▀  █▄       ███         ███            ▀████  ███");
            System.out.println(" ███  ███▄ ██████      ██████ ▄███  ███       ███         ███              ███  ███");
            System.out.println(" ▀██▄█████▄▀████▀      ▀████▀▄█████▄██▀       ███         ███              ███  ███");
            System.out.println("  ▀███▀ ▀███▄              ▄███▀ ▀███▀        ███         ███              ███  ███");
            System.out.println("   ▀███▄  ▀████▄▄      ▄▄████▀  ▄███▀         ███         ███            ▄████  ███");
            System.out.println("     ▀███    ▀▀██████████▀▀▀   ███▀           ███         ███  ▄█████████████▀  ███");
            System.out.println("       ▀     ▄▄▄   ██   ▄▄▄     ▀             ███         ███  ▀███████████▀    ███");
            System.out.println("             ▀▀██████████▀▀");
            System.out.println();
            System.out.println("Insira o nome que pretende para o ficheiro onde será possível guardar os dados apresentados na consola");
            System.out.println();

            String nomeFicheiro = sc.next();
            File resuladosApresentadosNaConsola = new File(nomeFicheiro + ".csv");
            while (interruptor) {
                tarefa = menu(0);
                if (tarefa >= 1 && tarefa <= 5) {
                    if (ficheirosCarregados) {
                        interruptor = executarVisualizar(tarefa, interruptor, dias, diasSeparados, dadosCovid, diasTotais, dias2, diasSeparados2, dadosCovid2, diasTotais2, ativos, acumulado, resuladosApresentadosNaConsola);
                    } else {
                        System.out.println("Não há ficheiros carregados, prima qualquer tecla e clique ENTER para continuar");
                        sc.next();
                    }
                }
                if (tarefa >= 6 && tarefa <= 10) {
                    if (ficheirosCarregados) {
                        interruptor = executarComparar(tarefa, interruptor, dias, diasSeparados, dadosCovid, diasTotais, dias2, diasSeparados2, dadosCovid2, diasTotais2, ativos, acumulado, resuladosApresentadosNaConsola, 0);
                    } else {
                        System.out.println("Não há ficheiros carregados, prima qualquer tecla e clique ENTER para continuar");
                        sc.next();
                    }
                }
                if (tarefa == 11) {
                    if (ficheirosCarregadosMatriz && (ativos != 0)) {
                        File naoUsado = new File("");
                        interruptor = previsoesMain(diasTotais, dias, dadosCovid, diasSeparados, nomeMatriz, "", naoUsado, resuladosApresentadosNaConsola);
                    } else {
                        System.out.println("Não há ficheiros suficientes, prima qualquer tecla e clique ENTER para continuar");
                        sc.next();
                    }
                }
                if (tarefa == 12) {
                    if (ficheirosCarregados) {
                        System.out.println("Já existem ficheiros carregados, se pretende acrescentar os ficheiros clique (s)");
                        String resposta = sc.next();
                        if (resposta.compareTo("s") == 0) {
                            int ficheirosParaCarregar = pretendeCarregar(-1);
                            if (ficheirosParaCarregar == 0) {
                                //registoAcumulados
                                nome = carregarDados(0);
                                if (verificarFicheiroCorreto(nome, 1)) {
                                    diasTotais2 = leituraDeDados(dias2, dadosCovid2, diasSeparados2, nome, test);
                                    trabalharDados(dias2, dadosCovid2, diasSeparados2, nome, test);
                                    acumulado++;
                                } else {
                                    System.out.println("Ficheiro não corresponde ao tipo de dados que pretende observar");
                                }
                            } else if (ficheirosParaCarregar == 1) {
                                //registoTotais
                                nome = carregarDados(0);
                                if (verificarFicheiroCorreto(nome, 2)) {
                                    diasTotais = leituraDeDados(dias, dadosCovid, diasSeparados, nome, test);
                                    ativos++;
                                } else {
                                    System.out.println("Ficheiro não corresponde ao tipo de dados que pretende observar");
                                }
                            } else if (ficheirosParaCarregar == 2) {
                                //matriz
                                nomeMatriz = carregarDados(0);
                                ficheirosCarregadosMatriz = true;
                            }
                        } else {
                            System.out.println("Inválido");
                        }
                    } else {
                        ficheirosCarregados = true;
                        int ficheirosParaCarregar = pretendeCarregar(-1);
                        if (ficheirosParaCarregar == 0) {
                            //registoAcumulados
                            nome = carregarDados(0);
                            if (verificarFicheiroCorreto(nome, 1)) {
                                diasTotais2 = leituraDeDados(dias2, dadosCovid2, diasSeparados2, nome, test);
                                trabalharDados(dias2, dadosCovid2, diasSeparados2, nome, test);
                                acumulado++;
                            } else {
                                System.out.println("Ficheiro não corresponde ao tipo de dados que pretende observar");
                            }
                        } else if (ficheirosParaCarregar == 1) {
                            //registoTotais
                            nome = carregarDados(0);
                            if (verificarFicheiroCorreto(nome, 2)) {
                                diasTotais = leituraDeDados(dias, dadosCovid, diasSeparados, nome, test);
                                ativos++;
                            } else {
                                System.out.println("Ficheiro não corresponde ao tipo de dados que pretende observar");
                            }
                        } else if (ficheirosParaCarregar == 2) {
                            //matriz
                            nomeMatriz = carregarDados(0);
                            ficheirosCarregadosMatriz = true;
                        }
                    }
                }
                if (tarefa == 13) {
                    interruptor = false;
                }
            }
        } else {
            naoInterativo(args, test, dias, diasSeparados, dadosCovid, dias2, diasSeparados2, dadosCovid2);
        }
    }

    public static void trabalharDados(String[] dias, int[][] dadosCovid, String[][] diasSeparados, String nome, String test) throws FileNotFoundException {
        if (test.length() > 0) {
            nome = test;
        }
        int[][] guardarDados = new int[dias.length][5];
        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < dias.length; i++) {
                guardarDados[i][k] = dadosCovid[i][k];

            }
        }
        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < dias.length; i++) {
                if (i == 0) {
                    dadosCovid[i][k] = dadosCovid[i][k];
                } else {

                    dadosCovid[i][k] = dadosCovid[i][k] - guardarDados[i - 1][k];
                }
            }
        }
    }

    public static boolean executarComparar(int tarefa, boolean interruptor, String[] dias, String[][] diasSeparados, int[][] dadosCovid, int diasTotais, String[] dias2, String[][] diasSeparados2, int[][] dadosCovid2, int diasTotais2, int existenciaDeFicheiroTotais, int existenciaDeFicheiroAcumulados, File resuladosApresentadosNaConsola, int test) throws IOException {
        //test
        String funcao = "";
        if (test == 0) {
            funcao = "comparar";
        } else {
            funcao = "t";
        }
        int pretendeVisualizar = -1;
        int b = pretendeVisualizar(funcao);
        if (b == 0) {
            //registoTotal
            if (existenciaDeFicheiroTotais != 0) {
                pretendeVisualizar = 0;
                interruptor = funcaoComparar(tarefa, diasTotais, dias, dadosCovid, diasSeparados, pretendeVisualizar, resuladosApresentadosNaConsola, test);
            } else {
                System.out.println("Não há ficheiros carregados");
                sc.next();
            }
        } else if (b == 1) {
            //registoacumulados
            if (existenciaDeFicheiroAcumulados != 0) {
                pretendeVisualizar = 1;
                interruptor = funcaoComparar(tarefa, diasTotais2, dias2, dadosCovid2, diasSeparados2, pretendeVisualizar, resuladosApresentadosNaConsola, test);
            } else {
                System.out.println("Não há ficheiros carregados");
                sc.next();
            }
        }
        return interruptor;
    }

    public static boolean executarVisualizar(int tarefa, boolean interruptor, String[] dias, String[][] diasSeparados, int[][] dadosCovid, int diasTotais, String[] dias2, String[][] diasSeparados2, int[][] dadosCovid2, int diasTotais2, int ativos, int acumulado, File resuladosApresentadosNaConsola) throws IOException {
        String funcao = "visualizar";
        int pretendeVisualizar = -1;
        int dadosPretendidos = pretendeVisualizar(funcao);
        if (dadosPretendidos == 0) {
            if (ativos != 0) {
                pretendeVisualizar = 0;
                interruptor = funcaoVisualizar(tarefa, diasTotais, dias, dadosCovid, diasSeparados, pretendeVisualizar, resuladosApresentadosNaConsola);
            } else {
                System.out.println("Não há ficheiros carregados");
            }
        } else if (dadosPretendidos == 1) {
            if (acumulado != 0) {
                pretendeVisualizar = 1;
                interruptor = funcaoVisualizar(tarefa, diasTotais2, dias2, dadosCovid2, diasSeparados2, pretendeVisualizar, resuladosApresentadosNaConsola);
            }
            {
                System.out.println("Não há ficheiros carregados");
            }
        }
        return interruptor;
    }

    public static int pretendeCarregar(int test) {
        //test
        boolean interruptor = true;
        int retornar = -1;
        if (test != 1) {
            System.out.println();
            System.out.println("|==================================================================================|");
            System.out.println("|Pretende carregar o registo de número acumulado de casos para o caso de estudo (a)|");
            System.out.println("|Pretende carregar o registo de número total de casos para o caso de estudo     (t)|");
            System.out.println("|Pretende carregar ficheiro da matriz de transições                             (m)|");
            System.out.println("|==================================================================================|");
            System.out.println();
        }
        while (interruptor) {
            String resposta = "";
            if (test == -1) {
                resposta = sc.next();
            } else {
                resposta = "a";
            }
            if (resposta.compareTo("a") == 0) {
                retornar = 0;
                interruptor = false;
            } else if (resposta.compareTo("t") == 0) {
                retornar = 1;
                interruptor = false;
            } else if (resposta.compareTo("m") == 0) {
                retornar = 2;
                interruptor = false;
            } else {
                System.out.println("");
                System.out.println("Inválido");
                System.out.println("");
            }
        }
        return retornar;
    }

    public static String carregarDados(int test) {
        //test
        Scanner read = new Scanner(System.in);
        String nome = "";
        boolean exist = false;
        if (test == 0) {
            System.out.println();
            System.out.println("Insira o caminho do ficheiro");
            System.out.println();
        }
        while (!exist) {
            String nomeFicheiro = " ";
            if (test == 0) {
                nomeFicheiro = read.nextLine();
            } else {
                nomeFicheiro = "testMarkov.csv";
            }
            File ficheiro = new File(nomeFicheiro);
            if (ficheiro.exists()) {
                exist = true;
                nome = nomeFicheiro;
            } else {
                System.out.println("");
                System.out.println("Caminho inválido :(");
                System.out.println("Insira novamente o caminho");
                System.out.println("");
            }
        }

        return nome;
    }

    public static boolean verificarFicheiroCorreto(String nome, int function) throws FileNotFoundException {
        //
        boolean valor = false;
        File dados = new File(nome);
        Scanner ler = new Scanner(dados);
        String cabecalho = ler.nextLine();

        if (function == 2) {
            if (cabecalho.compareTo("data,naoInfetados,Infetados,hospitalizados,internadosUCI,obitos") == 0) {
                //total
                valor = true;
            }
        }
        if (function == 1) {
            if (cabecalho.compareTo("data,diario_nao_infetado,acumulado_infetado,acumulado_hospitalizado,acumulado_internadoUCI,acumulado_mortes") == 0) {
                //acumulado
                valor = true;
            }
        }
        if (function == 3) {
            String[] items = cabecalho.split("=");
            if (items[0].equals("p11")) {
                //matriz
                valor = true;
            }
        }
        ler.close();
        return valor;
    }

    public static int leituraDeDados(String[] dias, int[][] dadosCovid, String[][] diasSeparados, String nome, String test) throws FileNotFoundException {
        //test
        if (test.length() > 0) {
            nome = test;
        }
        File dados = new File(nome);
        Scanner ler = new Scanner(dados);
        ler.nextLine();
        int diasEfetivos = 0;
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            String[] itemsDaLinha = linha.split(",");
            dias[diasEfetivos] = itemsDaLinha[0];
            String[] linhaParaDias = dias[diasEfetivos].split("-");
            for (int i = 0; i < 3; i++) {
                diasSeparados[diasEfetivos][i] = linhaParaDias[i];
            }
            for (int i = 1; i < 6; i++) {
                dadosCovid[diasEfetivos][i - 1] = Integer.parseInt(itemsDaLinha[i]);
            }
            diasEfetivos++;
        }
        ler.close();
        return diasEfetivos;
    }

    public static int menu(int test) {
        //test
        int tarefa = 0;
        if (test == 0) {
            System.out.println();
            System.out.println("|==========================================|");
            System.out.println("|1.Visualizar números de casos             |");
            System.out.println("|2.Visualizar números de hospitalizações   |");
            System.out.println("|3.Visualizar números de internados da UCI |");
            System.out.println("|4.Visualizar números de mortes            |");
            System.out.println("|5.Visualizar todos os dados               |");
            System.out.println("|6.Comparar números de casos               |");
            System.out.println("|7.Comparar números de hospitalizações     |");
            System.out.println("|8.Comparar números de internados da UCI   |");
            System.out.println("|9.Comparar números de mortes              |");
            System.out.println("|10.Comparar todos os dados                |");
            System.out.println("|11.Previsão da Evolução da Pandemia       |");
            System.out.println("|12.Carregar Dados                         |");
            System.out.println("|13.Fechar programa                        |");
            System.out.println("|==========================================|");
            System.out.println();
        }
        while (tarefa == 0) {
            int tarefaPretendida;
            if (test == 0) {
                tarefaPretendida = sc.nextInt();
            } else {
                tarefaPretendida = test;
            }
            if (tarefaPretendida >= 1 && tarefaPretendida <= 13) {
                tarefa = tarefaPretendida;
            } else {
                System.out.println("Essa função não existe");
            }
        }
        return tarefa;
    }


    public static int verificarData(int diasTotais, String[] dias, String data, String[][] diasSeparados) {
        //test
        if (diasSeparados[0][0].length() == 4) {
            //aaaa-mm-dd
            // data= aaaa-mm-dd(dd-mm-aaaa)
            int contador = 0, i = 0;
            while (data.charAt(i) != '-') {
                i++;
                contador++;
            }
            if (contador == 2) {
                data = "" + data.charAt(6) + data.charAt(7) + data.charAt(8) + data.charAt(9) + "-" + data.charAt(3) + data.charAt(4) + "-" + data.charAt(0) + data.charAt(1);
            }
        } else if (diasSeparados[0][2].length() == 4) {
            //dd-mm-aaaa
            //data= dd-mm-aaaa(aaaa-mm-dd)
            int contador = 0, i = 0;
            while (data.charAt(i) != '-') {
                i++;
                contador++;
            }
            if (contador == 4) {
                data = "" + data.charAt(8) + data.charAt(9) + "-" + data.charAt(5) + data.charAt(6) + "-" + data.charAt(0) + data.charAt(1) + data.charAt(2) + data.charAt(3);
            }
        }
        int guardar = -1, contador = 0;
        for (int i = 0; i < diasTotais; i++) {
            if (data.compareTo(dias[i]) == 0) {
                guardar = i;
                contador = contador + 1;
            }
        }
        if (contador != -1) {
            return guardar;
        } else {
            return -1;
        }
    }

    public static boolean executarFuncao(String test) {
        //test
        boolean retornar = true;
        boolean ret = true;
        while (retornar) {
            if (test.equals("s")) {
                ret = true;
                retornar = false;
            } else {
                String resposta;
                if (test.equals("s")) {
                    resposta = test;
                } else {
                    resposta = sc.next();
                }

                if (resposta.compareTo("s") == 0) {
                    retornar = false;
                    ret = true;
                } else if (resposta.compareTo("n") == 0) {
                    retornar = false;
                    ret = false;
                } else {
                    System.out.println("Inválido");
                }
            }
        }
        return ret;
    }

    public static boolean verificarSePretendeExecutarMesmaFuncao(String test) {
        //test executar funcao
        if (!test.equals("s")) {
            System.out.println();
            System.out.println("Pretende voltar a executar esta função se sim (s) se não (n)");
        }
        return executarFuncao(test);
    }

    public static boolean verificarSePretendeExecutarOutraFuncao(String test) {
        //test executar funcao
        if (!test.equals("s")) {
            System.out.println();
            System.out.println("Pretende voltar a executar outra função se sim (s) se não (n)");
        }
        return executarFuncao(test);
    }

    public static int conectorFuncaoPretendidaParaArrayComOsDados(int funcao) {
        //test
        int conetor = 0;
        switch (funcao) {
            case 1:
            case 6:
                conetor = 1;
                break;
            case 2:
            case 7:
                conetor = 2;
                break;
            case 3:
            case 8:
                conetor = 3;
                break;
            case 4:
            case 9:
                conetor = 4;
                break;
            case 5:
            case 10:
                conetor = 5;
                break;
        }
        return conetor;
    }

    public static String conectorArrayComOsDadosParaFuncaoPretendida(int funcao) {
        //test
        String conetor = " ";
        switch (funcao) {
            case 1:
                conetor = "  Infetados com Covid ";
                break;
            case 2:
                conetor = " Hospitalizados com Covid ";
                break;
            case 3:
                conetor = " Internados em UCI com Covid ";
                break;
            case 4:
                conetor = " Mortes covid ";
                break;
        }
        return conetor;
    }

    public static boolean funcaoVisualizar(int tarefa, int diasTotais, String[] dias, int[][] dadosCovid, String[][] diasSeparados, int pretendeVisualizar, File resuladosApresentadosNaConsola) throws IOException {
        int dadoAApresentar = conectorFuncaoPretendidaParaArrayComOsDados(tarefa);
        escolherTempo(diasTotais, dias, dadosCovid, dadoAApresentar, diasSeparados, pretendeVisualizar, resuladosApresentadosNaConsola);
        boolean retornar = verificarSePretendeExecutarOutraFuncao("0");
        return retornar;
    }

    public static boolean escolherTempo(int diasTotais, String[] dias, int[][] dadosCovid, int dadoAApresentar, String[][] diasSeparados, int pretendeVisualizar, File resuladosApresentadosNaConsola) throws IOException {
        boolean interruptor = true;
        System.out.println("Insira o intervalo que pretende visualizar");
        while (interruptor) {
            System.out.print("Insira a data 1: ");
            String resposta1 = sc.next();
            System.out.print("Insira a data 2: ");
            String resposta2 = sc.next();
            int inicio = verificarData(diasTotais, dias, resposta1, diasSeparados);
            int fim = verificarData(diasTotais, dias, resposta2, diasSeparados);
            if (inicio != -1 && fim != -1 && fim >= inicio) {
                System.out.println("Insira o espaço temporal que pretende observar: diário(d), semanal (s) ou mensal (m) ");
                String resposta3 = sc.next();
                if (resposta3.compareTo("d") == 0) {
                    int posicaoInicio = verificarData(diasTotais, dias, resposta1, diasSeparados);
                    int posicaoFim = verificarData(diasTotais, dias, resposta2, diasSeparados);
                    if (dadoAApresentar == 5) {
                        for (int i = 1; i <= 4; i++) {
                            visualizarDataTemporalDias(dadosCovid, i, dias, posicaoInicio, posicaoFim, pretendeVisualizar, resuladosApresentadosNaConsola);
                        }
                    } else {
                        visualizarDataTemporalDias(dadosCovid, dadoAApresentar, dias, posicaoInicio, posicaoFim, pretendeVisualizar, resuladosApresentadosNaConsola);
                    }
                } else if (resposta3.compareTo("s") == 0) {
                    int posicaoInicio = verificarData(diasTotais, dias, resposta1, diasSeparados);
                    int posicaoFim = verificarData(diasTotais, dias, resposta2, diasSeparados);
                    if (dadoAApresentar == 5) {
                        for (int i = 1; i <= 4; i++) {
                            visualizarDataTemporalSemana(dadosCovid, i, dias, posicaoInicio, posicaoFim, diasSeparados, pretendeVisualizar, resuladosApresentadosNaConsola);
                        }
                    } else {
                        visualizarDataTemporalSemana(dadosCovid, dadoAApresentar, dias, posicaoInicio, posicaoFim, diasSeparados, pretendeVisualizar, resuladosApresentadosNaConsola);
                    }
                } else if (resposta3.compareTo("m") == 0) {
                    int posicaoInicio = verificarData(diasTotais, dias, resposta1, diasSeparados);
                    int posicaoFim = verificarData(diasTotais, dias, resposta2, diasSeparados);
                    if (dadoAApresentar == 5) {
                        for (int i = 1; i <= 4; i++) {
                            visualizarDataTemporalMes(dadosCovid, i, dias, posicaoInicio, posicaoFim, diasSeparados, pretendeVisualizar, resuladosApresentadosNaConsola);
                        }
                    } else {
                        visualizarDataTemporalMes(dadosCovid, dadoAApresentar, dias, posicaoInicio, posicaoFim, diasSeparados, pretendeVisualizar, resuladosApresentadosNaConsola);
                    }
                } else {
                    System.out.println("Inválido");
                }
                interruptor = verificarSePretendeExecutarMesmaFuncao("0");
            } else {
                System.out.println("Data 1 ou data 2 são inválidas");
            }
        }
        return interruptor;
    }

    public static int pretendeVisualizar(String funcao) {
        //test
        if (!funcao.equals("t")) {
            System.out.println();
            System.out.println("|===========================================================|");
            System.out.println("|Pretende " + funcao + " total de casos registados          (t) |");
            System.out.println("|Pretende " + funcao + " o número de novos casos registados (n) |");
            System.out.println("|===========================================================|");
            System.out.println();
        }

        boolean interruptor = true;
        int valorReturn = -1;
        while (interruptor) {
            String resposta;
            if (!funcao.equals("t")) {
                resposta = sc.next();
            } else {
                resposta = funcao;
            }
            if (resposta.compareTo("t") == 0) { //total
                valorReturn = 0;
                interruptor = false;
            } else if (resposta.compareTo("n") == 0) { //acumulado
                valorReturn = 1;
                interruptor = false;
            } else {
                System.out.println("Inválido");
            }
        }
        return valorReturn;
    }

    public static void visualizarDataTemporalDias(int[][] dadosCovid, int dadoAApresentar, String[] dias, int posicaoInicio, int posicaoFim, int pretendeVisualizar, File resuladosApresentadosNaConsola) throws IOException {
        String[] guardarDados = new String[100];
        int linhaGuardar = 0;
        guardarDados[linhaGuardar] = "";
        System.out.println();
        System.out.println(conectorArrayComOsDadosParaFuncaoPretendida(dadoAApresentar));
        linhaGuardar++;
        guardarDados[linhaGuardar] = conectorArrayComOsDadosParaFuncaoPretendida(dadoAApresentar);
        linhaGuardar++;

        if (posicaoFim >= posicaoInicio) {
            for (int i = posicaoInicio; i <= posicaoFim; i++) {
                if (i == 0 && pretendeVisualizar == 1) {
                    System.out.print(dias[i] + " : ");
                    System.out.print(dadosCovid[i][dadoAApresentar]);
                    System.out.println(" , não há dados do dia anterior");
                    guardarDados[linhaGuardar] = dias[i] + "," + dadosCovid[i][dadoAApresentar] + " , não há dados do dia anterior";
                    linhaGuardar++;
                } else {
                    System.out.print(dias[i] + " : ");
                    System.out.print(dadosCovid[i][dadoAApresentar]);
                    if (dadosCovid[i][dadoAApresentar] > dadosCovid[i - 1][dadoAApresentar]) {
                        int valor2 = dadosCovid[i][dadoAApresentar];
                        int valor1 = dadosCovid[i - 1][dadoAApresentar];
                        System.out.println(" Casos registados, acrescimo de " + (valor2 - valor1) + " casos registados em relação ao dia anterior");
                        guardarDados[linhaGuardar] = dias[i] + "," + dadosCovid[i][dadoAApresentar] + " Casos registados,acrescimo de " + (valor2 - valor1) + " casos registados em relação ao dia anterior";
                        linhaGuardar++;
                    } else if (dadosCovid[i][dadoAApresentar] < dadosCovid[i - 1][dadoAApresentar]) {
                        int valor2 = dadosCovid[i][dadoAApresentar];
                        int valor1 = dadosCovid[i - 1][dadoAApresentar];
                        System.out.println(" Casos registados, decrescimo de " + (valor2 - valor1) + " casos registados em relação ao dia anterior");
                        guardarDados[linhaGuardar] = dias[i] + "," + dadosCovid[i][dadoAApresentar] + " Casos registados,decrescimo de " + (valor2 - valor1) + " casos registados em relação ao dia anterior";
                        linhaGuardar++;
                    } else {
                        System.out.println(" Casos registados, o numero de novos casos é o mesmo do dia anterior ");
                        guardarDados[linhaGuardar] = dias[i] + "," + dadosCovid[i][dadoAApresentar] + " Casos registados,o numero de novos casos é o mesmo do dia anterior ";
                        linhaGuardar++;
                    }

                }
            }
        }

        String dados = "";
        if (pretendeVisualizar == 1) {
            dados = "Data,NovosCasosRegistados";
        } else if (pretendeVisualizar == 0) {
            dados = "data,DadosTotais,ComparaçãoDadosEmRelaçãoDiaAnterior";
        }
        printWriter(guardarDados, resuladosApresentadosNaConsola, dados, 0);
    }

    public static void printWriter(String[] guardarDados, File resuladosApresentadosNaConsola, String dados, int test) throws IOException {
        //test
        FileWriter fr = new FileWriter(resuladosApresentadosNaConsola, true);
        BufferedWriter br = new BufferedWriter(fr);
        PrintWriter printWriter = new PrintWriter(br);
        boolean interruptor = false;
        String resposta = "";

        if (test == 0) {
            System.out.println("Pretende guardar os dados apresentados sim (s) ou não (n)?");
            resposta = sc.next();
            while (!interruptor) {
                if (resposta.compareTo("s") == 0) {
                    int i = 0;
                    printWriter.println(dados);
                    while (guardarDados[i] != null) {
                        printWriter.println(guardarDados[i]);
                        i++;
                    }
                    printWriter.println("==========================================================================");
                    interruptor = true;
                } else if (resposta.compareTo("n") == 0) {
                    interruptor = true;
                } else {
                    System.out.println("Resposta inválida");
                }
            }
        } else {
            int i = 0;
            printWriter.println(dados);
            while (guardarDados[i] != null) {
                printWriter.println(guardarDados[i]);
                i++;
            }
        }
        printWriter.close();
        br.close();
        fr.close();
    }

    public static void visualizarDataTemporalSemana(int[][] dadosCovid, int dadoAApresentar, String[] dias, int posicaoInicio, int posicaoFim, String[][] diasSeparados, int pretendeVisualizar, File resuladosApresentadosNaConsola) throws IOException {
        int linhaGuardar = 0;
        String[] guardarDados = new String[100];
        int inicio = getFirstMonday(diasSeparados, posicaoInicio, posicaoFim) + posicaoInicio;
        int ultimo = getLastSunday(diasSeparados, posicaoInicio, posicaoFim) + posicaoInicio;
        int semana = 0, dadosSemanais = 0, numeroSemana = 0, guardarSegunda = 0, segunda = 0;
        int firstMonday1 = getFirstMonday(diasSeparados, posicaoInicio, posicaoFim);
        int lastSunday1 = getLastSunday(diasSeparados, posicaoInicio, posicaoFim);


        if (lastSunday1 <= firstMonday1) {
            System.out.println();
            System.out.println("O intervalo de tempo é invalido");
            System.out.println();
        } else {
            //totais
            System.out.println(conectorArrayComOsDadosParaFuncaoPretendida(dadoAApresentar));
            guardarDados[linhaGuardar] = conectorArrayComOsDadosParaFuncaoPretendida(dadoAApresentar);
            linhaGuardar++;
            for (int i = inicio; i <= ultimo; i++) {
                if (inicio == 0 && pretendeVisualizar == 1) {
                    System.out.println("Semana " + numeroSemana + " de " + dias[segunda] + " a " + dias[segunda + 6] + " não há dados ");
                    guardarDados[linhaGuardar] = "Semana " + numeroSemana + "," + dias[segunda] + "," + dias[segunda + 6] + ", não há dados  ";
                    linhaGuardar++;
                    i = i + 7;
                    numeroSemana++;
                }
                if (guardarSegunda == 0) {
                    segunda = i;
                    guardarSegunda++;
                }
                if (semana != 7) {
                    dadosSemanais = dadosSemanais + dadosCovid[i][dadoAApresentar];
                    semana++;
                }
                if (semana == 7) {
                    numeroSemana++;
                    System.out.println("Semana " + numeroSemana + " de " + dias[segunda] + " a " + dias[segunda + 6] + " registou " + dadosSemanais);
                    guardarDados[linhaGuardar] = "Semana " + numeroSemana + "," + dias[segunda] + "," + dias[segunda + 6] + ",registou " + dadosSemanais;
                    linhaGuardar++;
                    semana = 0;
                    dadosSemanais = 0;
                    guardarSegunda = 0;
                }
            }
            String dados = "";
            if (pretendeVisualizar == 1) {
                dados = "NumeroDaSemana,DataInicioSemana,DataFimDaSemana,NovosDadosRegistadosNaSemana";
            } else if (pretendeVisualizar == 0) {
                dados = "NumeroDaSemana,DataInicioSemana,DataFimDaSemana,DadosTotaisRegistadosNaSemana";
            }
            printWriter(guardarDados, resuladosApresentadosNaConsola, dados, 0);
        }
    }


    public static void visualizarDataTemporalMes(int[][] dadosCovid, int dadoAApresentar, String[] dias, int posicaoInicio, int posicaoFim, String[][] diasSeparados, int pretendeVisualizar, File resuladosApresentadosNaConsola) throws IOException {
        int linhaGuardar = 0;
        String[] guardarDados = new String[100];

        int inicio = getFirstDayOfMonth(diasSeparados, posicaoInicio, posicaoFim);
        int ultimo = getLastDayOfMonth(diasSeparados, posicaoInicio, posicaoFim);
        //totais
        if (ultimo <= inicio) {
            System.out.println();
            System.out.println("O intervalo de tempo é invalido");
            System.out.println();
        } else {
            System.out.println(conectorArrayComOsDadosParaFuncaoPretendida(dadoAApresentar));
            guardarDados[linhaGuardar] = conectorArrayComOsDadosParaFuncaoPretendida(dadoAApresentar);
            linhaGuardar++;
            int firstDay = posicaoInicio + inicio;
            int lastDay = posicaoInicio + ultimo;
            int casosRegistrados = 0, guardar = firstDay - 1;
            for (int i = firstDay; i <= lastDay; i++) {
                if (firstDay == 0 && pretendeVisualizar == 1) {
                    System.out.println(dias[guardar + 1] + " a " + dias[i] + " não há dados ");
                    guardarDados[linhaGuardar] = dias[guardar + 1] + "," + dias[i] + ",não há dados ";

                    while (diasSeparados[i][1].compareTo(diasSeparados[i + 1][1]) == 0) {
                        i++;
                    }
                }
                if (diasSeparados[i + 1][1] == null) {
                    casosRegistrados = casosRegistrados + dadosCovid[i][dadoAApresentar];
                    System.out.println(dias[guardar + 1] + " a " + dias[i] + " foram registados " + casosRegistrados);
                    guardarDados[linhaGuardar] = dias[guardar + 1] + "," + dias[i] + ",foram registados " + casosRegistrados;
                    linhaGuardar++;
                } else if (diasSeparados[i][1].compareTo(diasSeparados[i + 1][1]) == 0) {
                    casosRegistrados = casosRegistrados + dadosCovid[i][dadoAApresentar];
                } else if (diasSeparados[i][1].compareTo(diasSeparados[i + 1][1]) != 0) {
                    casosRegistrados = casosRegistrados + dadosCovid[i][dadoAApresentar];
                    System.out.println(dias[guardar + 1] + " a " + dias[i] + " foram registados " + casosRegistrados);
                    guardarDados[linhaGuardar] = dias[guardar + 1] + "," + dias[i] + " ,foram registados " + casosRegistrados;
                    linhaGuardar++;
                    guardar = i;
                    casosRegistrados = 0;
                }
            }
            String dados = "";
            if (pretendeVisualizar == 1) {
                dados = "DataInicioMes,DataFimMes,NovosCasosRegistadosMes";
            } else if (pretendeVisualizar == 0) {
                dados = "DataInicioMes,DataFimMes,CasosTotaisRegistadosMes";
            }
            printWriter(guardarDados, resuladosApresentadosNaConsola, dados, 0);
        }
    }

    public static boolean funcaoComparar(int tarefa, int diasTotais, String[] dias, int[][] dadosCovid, String[][] diasSeparados, int pretendeVisualizar, File resuladosApresentadosNaConsola, int test) throws IOException {
        boolean retornar = true;
        int dadoAApresentar = conectorFuncaoPretendidaParaArrayComOsDados(tarefa);
        escolherTempoComparar(diasTotais, dias, dadosCovid, dadoAApresentar, diasSeparados, pretendeVisualizar, resuladosApresentadosNaConsola, test);
        if (test == 0) {
            retornar = verificarSePretendeExecutarOutraFuncao("0");
        } else {
            retornar = false;
        }

        return retornar;
    }


    public static void escolherTempoComparar(int diasTotais, String[] dias, int[][] dadosCovid, int dadoAApresentar, String[][] diasSeparados, int pretendeVisualizar, File resuladosApresentadosNaConsola, int test) throws IOException {
        boolean interruptor = true;
        String resposta1 = "";
        String resposta2 = "";
        String resposta3 = "";
        String resposta4 = "";
        int posicaoInicio1;
        int posicaoFim1;
        int posicaoInicio2;
        int posicaoFim2;
        while (interruptor) {
            if (test == 0) {
                System.out.println();
                System.out.println("Insira os intervalos que pretende visualizar;");
                System.out.println("Indique o primeiro intervalo de tempo");
                System.out.print("Insira a data 1: ");
                resposta1 = sc.next();
                System.out.print("Insira a data 2: ");
                resposta2 = sc.next();
                System.out.println("Indique o segundo intervalo de tempo");
                System.out.print("Insira a data 1: ");
                resposta3 = sc.next();
                System.out.print("Insira a data 2: ");
                resposta4 = sc.next();
                posicaoInicio1 = verificarData(diasTotais, dias, resposta1, diasSeparados);
                posicaoFim1 = verificarData(diasTotais, dias, resposta2, diasSeparados);
                posicaoInicio2 = verificarData(diasTotais, dias, resposta3, diasSeparados);
                posicaoFim2 = verificarData(diasTotais, dias, resposta4, diasSeparados);
            } else {
                resposta1 = "01-10-2021";
                resposta2 = "03-10-2021";
                resposta3 = "04-10-2021";
                resposta4 = "06-10-2021";
                posicaoInicio1 = 0;
                posicaoFim1 = 2;
                posicaoInicio2 = 3;
                posicaoFim2 = 5;
            }

            if (posicaoInicio1 != -1 && posicaoFim1 != -1 && posicaoInicio2 != -1 && posicaoFim2 != -1 && posicaoInicio1 <= posicaoFim1 && posicaoInicio2 <= posicaoFim2) {
                if (dadoAApresentar == 5) {
                    for (int i = 1; i <= 4; i++) {
                        compararDadosDias(dadosCovid, posicaoInicio1, posicaoFim1, posicaoInicio2, posicaoFim2, i, dias, pretendeVisualizar, resuladosApresentadosNaConsola, test);
                    }
                } else {
                    compararDadosDias(dadosCovid, posicaoInicio1, posicaoFim1, posicaoInicio2, posicaoFim2, dadoAApresentar, dias, pretendeVisualizar, resuladosApresentadosNaConsola, test);
                }
                interruptor = verificarSePretendeExecutarMesmaFuncao("0");
            } else {
                System.out.println("Intervalo 1 ou 2 são inválidas");
            }
        }
    }


    public static void compararDadosDias(int[][] dadosCovid, int posicaoInicio1, int posicaoFim1, int posicaoInicio2, int posicaoFim2, int dadoAApresentar, String[] dias, int pretendeVisualizar, File resultadosApresentadosNaConsola, int test) throws IOException {
        final int DADOSPARAGUARDAR = 100;
        String[] guardarDados = new String[DADOSPARAGUARDAR];
        int linhaGuardar = 0;
        int linha1 = (posicaoFim1 - posicaoInicio1) + 1;
        int linha2 = (posicaoFim2 - posicaoInicio2) + 1;
        int copiaPosicaoInicio1 = posicaoInicio1;
        int copiaPosicaoInicio2 = posicaoInicio2;
        String dados = "";
        int[][] dadosDoIntervalo1 = new int[linha1][1];
        int[][] dadosDoIntervalo2 = new int[linha2][1];
        int[][] valorDaComparacao = new int[linha1][1];
        guardarDados[linhaGuardar] = "";
        System.out.println();
        System.out.println(conectorArrayComOsDadosParaFuncaoPretendida(dadoAApresentar));
        linhaGuardar++;
        guardarDados[linhaGuardar] = conectorArrayComOsDadosParaFuncaoPretendida(dadoAApresentar);
        linhaGuardar++;
        String tipoDados = " ";
        if (pretendeVisualizar == 0) {
            tipoDados = "casos totais";
        } else if (pretendeVisualizar == 1) {
            tipoDados = "novos casos";
        }

        if (dadosDoIntervalo1.length <= dadosDoIntervalo2.length) {
            linhaGuardar = guardarDadosComparar(dadosCovid, posicaoInicio1, posicaoInicio2, dadoAApresentar, dias, pretendeVisualizar, test, guardarDados, linhaGuardar, linha1, copiaPosicaoInicio1, copiaPosicaoInicio2, dadosDoIntervalo1, dadosDoIntervalo2, valorDaComparacao, tipoDados);
        } else {
            linhaGuardar = guardarDadosComparar(dadosCovid, posicaoInicio1, posicaoInicio2, dadoAApresentar, dias, pretendeVisualizar, test, guardarDados, linhaGuardar, linha2, copiaPosicaoInicio1, copiaPosicaoInicio2, dadosDoIntervalo1, dadosDoIntervalo2, valorDaComparacao, tipoDados);
        }
        double media1 = media(dadosDoIntervalo1, 0);
        double media2 = media(dadosDoIntervalo2, 0);
        double media3 = media(valorDaComparacao, 0);
        double desvio1 = desvioPadrao(dadosDoIntervalo1, media1, 0);
        double desvio2 = desvioPadrao(dadosDoIntervalo2, media2, 0);
        double desvio3 = desvioPadrao(valorDaComparacao, media3, 0);
        System.out.printf("- A média de casos totais no primeiro intervalo é %.4f | A média de casos totais no segundo intervalo é %.4f | A média da diferença de casos totais é %.4f\n", media1, media2, media3);
        System.out.printf("- O desvio padrão no primeiro intervalo é %.4f | O desvio padrão no segundo intervalo é %.4f | O desvio padrão da diferença é %.4f\n", desvio1, desvio2, desvio3);
        guardarDados[linhaGuardar] = String.format("Média casos totais primeiro intervalo: %.4f_Média casos totais segundo intervalo: %.4f_Média diferença casos totais: %.4f", media1, media2, media3).replaceAll(",", ".").replaceAll("_", ",");
        linhaGuardar++;
        guardarDados[linhaGuardar] = String.format("Desvio padrão casos totais primeiro intervalo: %.4f_Desvio padrão casos totais segundo intervalo: %.4f_Desvio padrão diferença de casos totais: %.4f", desvio1, desvio2, desvio3).replaceAll(",", ".").replaceAll("_", ",");
        linhaGuardar++;
        dados = "PrimeiraData,TotalCasosPrimeiraData,SegundaData,TotalCasosSegundaData,Comparação";
        printWriter(guardarDados, resultadosApresentadosNaConsola, dados, 0);

    }

    public static int guardarDadosComparar(int[][] dadosCovid, int posicaoInicio1, int posicaoInicio2, int dadoAApresentar, String[] dias, int pretendeVisualizar, int test, String[] guardarDados, int linhaGuardar, int linha, int copiaPosicaoInicio1, int copiaPosicaoInicio2, int[][] dadosDoIntervalo1, int[][] dadosDoIntervalo2, int[][] valorDaComparacao, String tipoDados) {
        if (posicaoInicio1 == 0 && pretendeVisualizar == 1) {
            System.out.println(dias[posicaoInicio1] + " : Não há dados do dia anterior ");
            guardarDados[linhaGuardar] = dias[posicaoInicio1] + " : Não há dados do dia anterior ";
            linhaGuardar++;
        } else {
            for (int i = 0; i < linha; i++) {
                dadosDoIntervalo1[i][0] = dadosCovid[copiaPosicaoInicio1][dadoAApresentar];
                copiaPosicaoInicio1++;
            }
        }
        if (posicaoInicio2 == 0 && pretendeVisualizar == 1) {
            System.out.println(dias[posicaoInicio2] + " : Não há dados do dia anterior ");
            guardarDados[linhaGuardar] = dias[posicaoInicio2] + " : Não há dados do dia anterior ";
            linhaGuardar++;
        } else {
            for (int i = 0; i < linha; i++) {
                dadosDoIntervalo2[i][0] = dadosCovid[copiaPosicaoInicio1][dadoAApresentar];
                copiaPosicaoInicio1++;
            }
        }
        boolean verificar = escreverDadosComparar(tipoDados, linha, dadosDoIntervalo1, dadosDoIntervalo2, valorDaComparacao, guardarDados, dias, posicaoInicio1, posicaoInicio2, linhaGuardar, test);
        return linhaGuardar;
    }

    public static boolean escreverDadosComparar(String tipoDados, int comprimento, int[][] dadosDoIntervalo1, int[][] dadosDoIntervalo2, int[][] valorDaComparacao, String[] guardarDados, String[] dias, int posicaoInicio, int posicaoInicio2, int linhaGuardar, int test) {
        for (int i = 0; i < comprimento; i++) {
            valorDaComparacao[i][0] = dadosDoIntervalo2[i][0] - dadosDoIntervalo1[i][0];
            int valorInteiroComparacao;
            if (valorDaComparacao[i][0] > 0) {
                if (test == 0) {
                    System.out.printf("No dia %s houveram %-4d %s | No dia %s houveram %-4d %s | Aconteceu um acréscimo de %d \n", dias[posicaoInicio], dadosDoIntervalo1[i][0], tipoDados, dias[posicaoInicio2], dadosDoIntervalo2[i][0], tipoDados, valorDaComparacao[i][0]);
                }
                guardarDados[linhaGuardar] = dias[posicaoInicio] + "," + dadosDoIntervalo1[i][0] + "," + dias[posicaoInicio2] + "," + dadosDoIntervalo2[i][0] + "," + "decrescimo " + valorDaComparacao[i][0];
                linhaGuardar++;
            } else {
                if (valorDaComparacao[i][0] < 0) {
                    valorInteiroComparacao = -valorDaComparacao[i][0];
                    if (test == 0) {
                        System.out.printf("No dia %s houveram %-4d %s | No dia %s houveram %-4d %s | Aconteceu um decréscimo de %d \n", dias[posicaoInicio], dadosDoIntervalo1[i][0], tipoDados, dias[posicaoInicio2], dadosDoIntervalo2[i][0], tipoDados, valorInteiroComparacao);
                    }
                    guardarDados[linhaGuardar] = dias[posicaoInicio] + "," + dadosDoIntervalo1[i][0] + "," + dias[posicaoInicio2] + "," + dadosDoIntervalo2[i][0] + "," + "acrescimo " + valorInteiroComparacao;
                    linhaGuardar++;
                } else {
                    if (test == 0) {
                        System.out.printf("No dia %s houveram %-4d %s| No dia %s houveram %-4d %s | O número de casos não se alterou %d \n", dias[posicaoInicio], dadosDoIntervalo1[i][0], tipoDados, dias[posicaoInicio2], dadosDoIntervalo2[i][0], tipoDados, valorDaComparacao[i][0]);
                    }
                    guardarDados[linhaGuardar] = dias[posicaoInicio] + "," + dadosDoIntervalo1[i][0] + "," + dias[posicaoInicio2] + "," + dadosDoIntervalo2[i][0] + "," + "numero de casos não se alterou " + valorDaComparacao[i][0];
                    linhaGuardar++;
                }
            }
            posicaoInicio++;
            posicaoInicio2++;
        }
        if (linhaGuardar == comprimento) {
            return true;
        } else {
            return false;
        }
    }

    public static double media(int[][] dados, int coluna) {
        //test
        double soma = 0;
        for (int i = 0; i < dados.length; i++) {
            soma += dados[i][coluna];
        }
        return (soma / dados.length);
    }

    public static double desvioPadrao(int[][] dadosDoIntervalo, double media, int coluna) {
        //test
        double somatorio = 0;
        for (int i = 0; i < dadosDoIntervalo.length; i++) {
            double ValorNaPosicaoMenosMediaTudoAoQuadrado = Math.pow((dadosDoIntervalo[i][coluna] - media), 2);
            somatorio = somatorio + ValorNaPosicaoMenosMediaTudoAoQuadrado;
        }
        double somatorioDividirPelaQuantidadeDeDados = somatorio / dadosDoIntervalo.length;
        double desvioPadrao = Math.sqrt(somatorioDividirPelaQuantidadeDeDados);
        return desvioPadrao;
    }

    public static int getFirstMonday(String[][] diasSeparados, int posicaoInicio, int posicaoFim) {
        //test
        int ano1 = 0, mes1 = 0, dia1 = 0, ano2 = 0, mes2 = 0, dia2 = 0;
        if (diasSeparados[0][0].length() == 4) {

            ano1 = Integer.parseInt(diasSeparados[posicaoInicio][0]);
            mes1 = Integer.parseInt(diasSeparados[posicaoInicio][1]);
            dia1 = Integer.parseInt(diasSeparados[posicaoInicio][2]);
            ano2 = Integer.parseInt(diasSeparados[posicaoFim][0]);
            mes2 = Integer.parseInt(diasSeparados[posicaoFim][1]);
            dia2 = Integer.parseInt(diasSeparados[posicaoFim][2]);
        } else if (diasSeparados[0][0].length() == 2) {
            ano1 = Integer.parseInt(diasSeparados[posicaoInicio][2]);
            mes1 = Integer.parseInt(diasSeparados[posicaoInicio][1]);
            dia1 = Integer.parseInt(diasSeparados[posicaoInicio][0]);
            ano2 = Integer.parseInt(diasSeparados[posicaoFim][2]);
            mes2 = Integer.parseInt(diasSeparados[posicaoFim][1]);
            dia2 = Integer.parseInt(diasSeparados[posicaoFim][0]);
        }
        Calendar startDate = Calendar.getInstance();
        startDate.set(ano1, (mes1 - 1), dia1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(ano2, (mes2 - 1), dia2);
        int count = 0;
        while (startDate.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            startDate.add(Calendar.DATE, 1);
            count = count + 1;
        }
        return count;
    }

    public static int getLastSunday(String[][] diasSeparados, int posicaoInicio, int posicaoFim) {
        //test
        int ano1 = 0, mes1 = 0, dia1 = 0, ano2 = 0, mes2 = 0, dia2 = 0;
        if (diasSeparados[0][0].length() == 4) {
            ano1 = Integer.parseInt(diasSeparados[posicaoInicio][0]);
            mes1 = Integer.parseInt(diasSeparados[posicaoInicio][1]);
            dia1 = Integer.parseInt(diasSeparados[posicaoInicio][2]);
            ano2 = Integer.parseInt(diasSeparados[posicaoFim][0]);
            mes2 = Integer.parseInt(diasSeparados[posicaoFim][1]);
            dia2 = Integer.parseInt(diasSeparados[posicaoFim][2]);
        } else if (diasSeparados[0][0].length() == 2) {
            ano1 = Integer.parseInt(diasSeparados[posicaoInicio][2]);
            mes1 = Integer.parseInt(diasSeparados[posicaoInicio][1]);
            dia1 = Integer.parseInt(diasSeparados[posicaoInicio][0]);
            ano2 = Integer.parseInt(diasSeparados[posicaoFim][2]);
            mes2 = Integer.parseInt(diasSeparados[posicaoFim][1]);
            dia2 = Integer.parseInt(diasSeparados[posicaoFim][0]);
        }
        Calendar startDate = Calendar.getInstance();
        startDate.set(ano1, (mes1 - 1), dia1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(ano2, (mes2 - 1), dia2);
        int count1 = 0;
        while (startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            count1++;
            startDate.add(Calendar.DATE, 1);
        }
        //startDate.add(Calendar.DATE, count1);
        int count = 0;
        while (startDate.before(endDate)) {
            startDate.add(Calendar.DATE, 1);
            count++;
        }
        return (count + count1);
    }

    public static int getFirstDayOfMonth(String[][] diasSeparados, int posicaoInicio, int posicaoFim) {
        //test
        int ano1 = 0, mes1 = 0, dia1 = 0, ano2 = 0, mes2 = 0, dia2 = 0;
        if (diasSeparados[0][0].length() == 4) {
            ano1 = Integer.parseInt(diasSeparados[posicaoInicio][0]);
            mes1 = Integer.parseInt(diasSeparados[posicaoInicio][1]);
            dia1 = Integer.parseInt(diasSeparados[posicaoInicio][2]);
            ano2 = Integer.parseInt(diasSeparados[posicaoFim][0]);
            mes2 = Integer.parseInt(diasSeparados[posicaoFim][1]);
            dia2 = Integer.parseInt(diasSeparados[posicaoFim][2]);
        } else if (diasSeparados[0][0].length() == 2) {
            ano1 = Integer.parseInt(diasSeparados[posicaoInicio][2]);
            mes1 = Integer.parseInt(diasSeparados[posicaoInicio][1]);
            dia1 = Integer.parseInt(diasSeparados[posicaoInicio][0]);
            ano2 = Integer.parseInt(diasSeparados[posicaoFim][2]);
            mes2 = Integer.parseInt(diasSeparados[posicaoFim][1]);
            dia2 = Integer.parseInt(diasSeparados[posicaoFim][0]);
        }
        Calendar startDate = Calendar.getInstance();
        startDate.set(ano1, (mes1 - 1), dia1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(ano2, (mes2 - 1), dia2);
        int count = 0;
        while (startDate.get(Calendar.DAY_OF_MONTH) != 1) {
            startDate.add(Calendar.DATE, 1);
            count = count + 1;
        }
        return count;
    }


    public static int getLastDayOfMonth(String[][] diasSeparados, int posicaoInicio, int posicaoFim) {
        //test
        int ano1 = 0, mes1 = 0, dia1 = 0, ano2 = 0, mes2 = 0, dia2 = 0;
        if (diasSeparados[0][0].length() == 4) {
            ano1 = Integer.parseInt(diasSeparados[posicaoInicio][0]);
            mes1 = Integer.parseInt(diasSeparados[posicaoInicio][1]);
            dia1 = Integer.parseInt(diasSeparados[posicaoInicio][2]);
            ano2 = Integer.parseInt(diasSeparados[posicaoFim][0]);
            mes2 = Integer.parseInt(diasSeparados[posicaoFim][1]);
            dia2 = Integer.parseInt(diasSeparados[posicaoFim][2]);
        } else if (diasSeparados[0][0].length() == 2) {
            ano1 = Integer.parseInt(diasSeparados[posicaoInicio][2]);
            mes1 = Integer.parseInt(diasSeparados[posicaoInicio][1]);
            dia1 = Integer.parseInt(diasSeparados[posicaoInicio][0]);
            ano2 = Integer.parseInt(diasSeparados[posicaoFim][2]);
            mes2 = Integer.parseInt(diasSeparados[posicaoFim][1]);
            dia2 = Integer.parseInt(diasSeparados[posicaoFim][0]);
        }
        Calendar startDate = Calendar.getInstance();
        startDate.set(ano1, (mes1 - 1), dia1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(ano2, (mes2 - 1), dia2);
        int count = 0;

        if (mes2 - 1 == 1 && ano2 == 2020) {
            //29 dias
            if (endDate.get(Calendar.DAY_OF_MONTH) != 29) {
                while (endDate.get(Calendar.DAY_OF_MONTH) != 31) {
                    endDate.add(Calendar.DATE, -1);
                    count++;
                }
            }
        } else if (mes2 - 1 == 1 && ano2 == 2019) {
            //28 dias
            if (endDate.get(Calendar.DAY_OF_MONTH) != 28) {
                while (endDate.get(Calendar.DAY_OF_MONTH) != 1) {
                    endDate.add(Calendar.DATE, -1);
                    count++;
                }
            }
        } else if (mes2 == 1 || mes2 == 3 || mes2 == 5 || mes2 == 7 || mes2 == 8 || mes2 == 10 || mes2 == 12) {
            //31 dias
            if (endDate.get(Calendar.DAY_OF_MONTH) != 31) {
                while (endDate.get(Calendar.DAY_OF_MONTH) != 1) {
                    endDate.add(Calendar.DATE, -1);
                    count++;
                }
            }
        } else {
            //30 dias
            if (endDate.get(Calendar.DAY_OF_MONTH) != 30) {
                while (endDate.get(Calendar.DAY_OF_MONTH) != 1) {
                    endDate.add(Calendar.DATE, -1);
                    count++;
                }
            }
        }
        if (count == 0) {
            return (posicaoFim - posicaoInicio - count);
        } else {
            return (posicaoFim - posicaoInicio - count - 1);
        }
    }

    public static boolean previsoesMain(int diasTotais, String[] dias, int[][] dadosCovid, String[][] diasSeparados, String nome, String diaNaoIterativo, File ficheiroFinal, File resultadosApresentadosNaConsola) throws IOException {
        //test
        boolean interruptor = true;
        double[] arrayNaoUsado = new double[9];

        while (interruptor) {
            System.out.println();
            System.out.println("|==================================================================================|");
            System.out.println("|Pretende prever a evolução da situação pandémica para um determinado dia       (e)|");
            System.out.println("|Pretende prever o número médio de dias até à morte                             (m)|");
            System.out.println("|==================================================================================|");
            System.out.println();
            String respota = sc.next();

            if (respota.compareTo("e") == 0) {
                interruptor = funcaoPrevisoes(diasTotais, dias, dadosCovid, diasSeparados, nome, diaNaoIterativo, resultadosApresentadosNaConsola, arrayNaoUsado);
            } else if (respota.compareTo("m") == 0) {
                interruptor = funcaoPrevisoesMorte(nome, diaNaoIterativo, resultadosApresentadosNaConsola, arrayNaoUsado);
            } else {
                System.out.println("Resposta Inválida");
            }
        }
        return verificarSePretendeExecutarOutraFuncao("0");
    }

    public static boolean funcaoPrevisoes(int diasTotais, String[] dias, int[][] dadosCovid, String[][] diasSeparados, String nome, String diaNaoIterativo, File resultadosApresentadosNaConsola, double[] passarParaEscrever) throws IOException {
        //test
        String dia = "";
        final int DADOSPARAGUARDAR = 10;
        String[] guardarDados = new String[DADOSPARAGUARDAR];
        int linhaGuardar = 0;

        if (diaNaoIterativo.isEmpty()) {
            System.out.println("indique o dia da previsão");
            dia = sc.next();
            System.out.println();
        } else {
            dia = diaNaoIterativo;
        }

        int diasEmFalta = 0;
        boolean diasFuturos = false;

        int data = (verificarData(diasTotais, dias, dia, diasSeparados)) - 1;
        if (data == -2) {
            data = diasTotais - 1;
            diasEmFalta = diferencaDeDias(dia, diasSeparados, diasTotais) - 1;
            diasFuturos = true;
        }
        double[][] matrizProbabilidades = new double[5][5];
        matrizProbabilidades = matrizMarkov(matrizProbabilidades, nome);
        double[] estimativa = matrizPrevisaoMarkov(dadosCovid, matrizProbabilidades, data);
        if (diasFuturos) {
            for (int i = 0; i < diasEmFalta; i++) {
                estimativa = matrizPrevisaoMarkovDiasEmFalta(estimativa, matrizProbabilidades);
            }
        }

        if (diaNaoIterativo.isEmpty()) {
            System.out.printf("Estimados não infetados totais: %.1f\n", estimativa[0]);
            System.out.printf("Estimados infetados totais: %.1f\n", estimativa[1]);
            System.out.printf("Estimados hospitalizados totais: %.1f\n", estimativa[2]);
            System.out.printf("Estimados internados UIC totais: %.1f\n", estimativa[3]);
            System.out.printf("Estimados obitos totais: %.1f\n", estimativa[4]);
            System.out.println();
            String dado1 = String.format("%.1f", estimativa[0]).replaceAll(",", ".");
            String dado2 = String.format("%.1f", estimativa[1]).replaceAll(",", ".");
            String dado3 = String.format("%.1f", estimativa[2]).replaceAll(",", ".");
            String dado4 = String.format("%.1f", estimativa[3]).replaceAll(",", ".");
            String dado5 = String.format("%.1f", estimativa[4]).replaceAll(",", ".");
            guardarDados[linhaGuardar] = dia + "," + dado1 + "," + dado2 + "," + dado3 + "," + dado4 + "," + dado5;
            linhaGuardar++;
            String dados = "DiaPrevisao,EstimadoNaoInfetados,EstimadoInfetados,EstimadoHospitalizados,EstimadoInternardosUCI,EstimadoMortes";
            printWriter(guardarDados, resultadosApresentadosNaConsola, dados, 0);
        } else {
            for (int i = 0; i < 5; i++) {
                passarParaEscrever[i] = estimativa[i];
            }
        }

        if (diaNaoIterativo.isEmpty()) {
            return verificarSePretendeExecutarMesmaFuncao("0");
        } else {
            return true;
        }
    }

    public static double[][] matrizMarkov(double[][] matriz, String nome) throws FileNotFoundException {
        //test
        File markov = new File(nome);
        Scanner ler = new Scanner(markov);
        final int TAMANHOAUX = 25;
        double[] auxiliar = new double[TAMANHOAUX];
        int cont = 0;

        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            linha = linha.trim();
            if (linha.length() > 0) {
                String[] itemsDaLinha = linha.split("=");
                if (itemsDaLinha.length == 2) {
                    auxiliar[cont] = Double.parseDouble(itemsDaLinha[1]);
                } else {
                    auxiliar[cont] = 0;
                }
                cont++;
            }
        }
        ler.close();

        cont = 0;
        for (int linha = 0; linha < 5; linha++) { //#############################################################################################
            for (int coluna = 0; coluna < 5; coluna++) {
                matriz[linha][coluna] = auxiliar[cont];
                cont++;
            }
        }
        return matriz;
    }

    public static double[] matrizPrevisaoMarkov(int[][] dadosCovid, double[][] matrizProbabilidades, int dia) {
        //test
        double[] previsao = new double[5];
        for (int linha = 0; linha < matrizProbabilidades.length; linha++) {
            for (int coluna = 0; coluna < matrizProbabilidades[0].length; coluna++) {
                previsao[linha] += matrizProbabilidades[linha][coluna] * dadosCovid[dia][coluna];
            }
        }
        return previsao;
    }

    public static double[] matrizPrevisaoMarkovDiasEmFalta(double[] estimativa, double[][] matrizProbabilidades) {
        //test
        double[] previsao = new double[5];
        for (int linha = 0; linha < matrizProbabilidades.length; linha++) {
            for (int coluna = 0; coluna < matrizProbabilidades[0].length; coluna++) {
                previsao[linha] += matrizProbabilidades[linha][coluna] * estimativa[coluna];
            }
        }
        return previsao;
    }

    public static boolean funcaoPrevisoesMorte(String nome, String diaNaoIterativo, File resultadosApresentadosNaConsola, double[] passarParaEscrever) throws IOException {
        String[] guardarDados = new String[10];
        int linhaGuardar = 0;
        double[][] transicoes = matrizTransicoes(nome);
        transicoes = diferencaDeMatrizes(transicoes);
        double[][] upper = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        double[][] lower = new double[4][4];
        decomposicaoLU(transicoes, upper, lower);
        double[][] inversaLower = matrizInversaLower(lower);
        double[][] inversaUpper = matrizInversaUpper(upper);
        double[][] inversaFinal = matrizInversaFinal(inversaLower, inversaUpper);
        double[] transicao = obterTransicao(inversaFinal);

        if (diaNaoIterativo.isEmpty()) {
            System.out.printf("Dias restantes para não infetados até à morte: %.1f\n", transicao[0]);
            System.out.printf("Dias restates para infetados até à morte: %.1f\n", transicao[1]);
            System.out.printf("Dias restantes para hosptalizdos até à morte: %.1f\n", transicao[2]);
            System.out.printf("Dias restantes para internados em UCI até à morte: %.1f\n", transicao[3]);
            String dado1 = String.format("%.1f", transicao[0]).replaceAll(",", ".");
            String dado2 = String.format("%.1f", transicao[1]).replaceAll(",", ".");
            String dado3 = String.format("%.1f", transicao[2]).replaceAll(",", ".");
            String dado4 = String.format("%.1f", transicao[3]).replaceAll(",", ".");
            guardarDados[linhaGuardar] = dado1 + "," + dado2 + "," + dado3 + "," + dado4;
            linhaGuardar++;
            String dados = "DiasMorteNaoInfetados,DiaMorteInfetados,DiaMorteHospitalizados,DiaMorteInternadosUCI";
            printWriter(guardarDados, resultadosApresentadosNaConsola, dados, 0);
        } else {
            for (int i = 0; i < 4; i++) {
                passarParaEscrever[i + 5] = transicao[i];
            }
        }
        if (diaNaoIterativo.isEmpty()) {
            return verificarSePretendeExecutarMesmaFuncao("0");
        } else {
            return true;
        }
    }

    public static double[][] matrizTransicoes(String nome) throws FileNotFoundException {
        //test
        double[][] transicoes = new double[4][4];
        double[][] matrizAux = new double[5][5];
        matrizAux = matrizMarkov(matrizAux, nome);
        for (int linhas = 0; linhas < 4; linhas++) {
            for (int colunas = 0; colunas < 4; colunas++) {
                transicoes[linhas][colunas] = matrizAux[linhas][colunas];
            }
        }
        return transicoes;
    }


    public static double[][] diferencaDeMatrizes(double[][] transicoes) {
        //test
        for (int linhas = 0; linhas < 4; linhas++) {
            for (int colunas = 0; colunas < 4; colunas++) {
                transicoes[linhas][colunas] *= -1;
            }
        }
        for (int diagonal = 0; diagonal < 4; diagonal++) {
            transicoes[diagonal][diagonal] += 1;
        }
        return transicoes;
    }

    public static double[][] decomposicaoLU(double[][] transicoes, double[][] upper, double[][] lower) {
        //test
        for (int i = 0; i < 4; i++) {
            lower[i][0] = transicoes[i][0];
        }
        for (int i = 1; i < 4; i++) {
            upper[0][i] = transicoes[0][i] / lower[0][0];
        }

        lower[1][1] = transicoes[1][1] - lower[1][0] * upper[0][1];
        upper[1][2] = ((transicoes[1][2] - lower[1][0] * upper[0][2]) / lower[1][1]);
        upper[1][3] = ((transicoes[1][3] - lower[1][0] * upper[0][3]) / lower[1][1]);

        lower[2][1] = transicoes[2][1] - lower[2][0] * upper[0][1];
        lower[2][2] = transicoes[2][2] - lower[2][0] * upper[0][2] - lower[2][1] * upper[1][2] - lower[2][2];
        upper[2][3] = (transicoes[2][3] - lower[2][0] * upper[0][3] - lower[2][1] * upper[1][3]) / lower[2][2];

        lower[3][1] = transicoes[3][1] - lower[3][0] * upper[0][1];
        lower[3][2] = transicoes[3][2] - lower[3][0] * upper[0][2] - lower[3][1] * upper[1][2];
        lower[3][3] = transicoes[3][3] - lower[3][0] * upper[0][3] - lower[3][1] * upper[1][3] - lower[3][2] * upper[2][3];

        return lower;
    }

    public static double[][] matrizInversaLower(double[][] lower) {
        //test
        double[][] inversa = new double[4][4];
        for (int i = 0; i < 4; i++) {
            inversa[i][i] = 1 / lower[i][i];
        }
        inversa[1][0] = ((-lower[1][0] * inversa[0][0]) / lower[1][1]);
        inversa[2][0] = ((-lower[2][0] * inversa[0][0] - lower[2][1] * inversa[1][0]) / lower[2][2]);
        inversa[2][1] = ((-lower[2][1] * inversa[1][1]) / lower[2][2]);
        inversa[3][0] = ((-lower[3][0] * inversa[0][0] - lower[3][1] * inversa[1][0] - lower[3][2] * inversa[2][1]) / lower[3][3]);
        inversa[3][1] = (-lower[3][1] * inversa[1][1] - lower[3][2] * inversa[2][1]) / lower[3][3];
        inversa[3][2] = ((-lower[3][2] * inversa[2][2]) / lower[3][3]);
        return inversa;
    }

    public static double[][] matrizInversaUpper(double[][] upper) {
        //test
        double[][] inversa = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        for (int i = 0; i < 3; i++) {
            inversa[i][i + 1] = -upper[i][i + 1];
        }
        inversa[0][2] = -upper[0][2] - upper[0][1] * inversa[1][2];
        inversa[1][3] = -upper[1][3] - upper[1][2] * inversa[2][3];
        inversa[0][3] = -upper[0][3] - upper[0][1] * inversa[1][3] - upper[0][2] * inversa[2][3];
        return inversa;
    }

    public static double[][] matrizInversaFinal(double[][] lower, double[][] upper) {
        //test
        double[][] inversaFinal = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    inversaFinal[i][j] += upper[i][k] * lower[k][j];
                }
            }
        }
        return inversaFinal;
    }

    public static double[] obterTransicao(double[][] inversaFinal) {
        //test
        double[] transicao = new double[4];
        for (int linha = 0; linha < 4; linha++) {
            for (int coluna = 0; coluna < 4; coluna++) {
                transicao[linha] += inversaFinal[coluna][linha];
            }
        }
        return transicao;
    }

    public static int diferencaDeDias(String dia, String[][] diasSeparados, int diasTotais) {
        //test
        int ano1 = 0, mes1 = 0, dia1 = 0, ano2 = 0, mes2 = 0, dia2 = 0;
        String[] diaSeparado = dia.split("-");
        diasTotais = diasTotais - 1;
        if (diasSeparados[0][0].length() == 4) {
            ano1 = Integer.parseInt(diasSeparados[diasTotais][0]);
            mes1 = Integer.parseInt(diasSeparados[diasTotais][1]);
            dia1 = Integer.parseInt(diasSeparados[diasTotais][2]);
            ano2 = Integer.parseInt(diaSeparado[0]);
            mes2 = Integer.parseInt(diaSeparado[1]);
            dia2 = Integer.parseInt(diaSeparado[2]);
        } else if (diasSeparados[0][0].length() == 2) {
            ano1 = Integer.parseInt(diasSeparados[diasTotais][2]);
            mes1 = Integer.parseInt(diasSeparados[diasTotais][1]);
            dia1 = Integer.parseInt(diasSeparados[diasTotais][0]);
            ano2 = Integer.parseInt(diaSeparado[2]);
            mes2 = Integer.parseInt(diaSeparado[1]);
            dia2 = Integer.parseInt(diaSeparado[0]);
        }

        Calendar startDate = Calendar.getInstance();
        startDate.set(ano1, (mes1 - 1), dia1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(ano2, (mes2 - 1), dia2);

        int count = 0;
        while (startDate.before(endDate)) {
            startDate.add(Calendar.DATE, 1);
            count = count + 1;
        }
        return count;
    }

    public static boolean naoInterativo(String[] args, String test, String[] dias, String[][] diasSeparados, int[][] dadosCovid, String[] dias2, String[][] diasSeparados2, int[][] dadosCovid2) throws IOException {
        String nome;
        String lerPrimeiroTipoDeParametro = args[0];
        boolean sucessoNaoInterativo = true;
        if (lerPrimeiroTipoDeParametro.equals("-r")) {
            String resolucaoTemporal = args[1];
            if ((resolucaoTemporal.equals("0") || resolucaoTemporal.equals("1") || resolucaoTemporal.equals("2")) && (args[2].equals("-di") && args[4].equals("-df") && args[6].equals("-di1") && args[8].equals("-df1") && args[10].equals("-di2") && args[12].equals("-df2"))) {
                String dataIncialVisualizar = args[3];
                String dataFinalVisualizar = args[5];
                String dataInicialComparar1 = args[7];
                String dataFinalComparar1 = args[9];
                String dataInicialComparar2 = args[11];
                String dataFinalComparar2 = args[13];
                if (args[14].equals("-T")) {
                    //faz tudo
                    String dataCalcularPrevisao = args[15];
                    String ficheiroNumeroTotalCasos = args[16];
                    File testFicheiro1 = new File(ficheiroNumeroTotalCasos);
                    String ficheiroNumeroAcumuladoCasos = args[17];
                    File testFicheiro2 = new File(ficheiroNumeroAcumuladoCasos);
                    String matrizTransicao = args[18];
                    File testFicheiro3 = new File(ficheiroNumeroAcumuladoCasos);
                    String nomeFicheiroParaGuardarResultados = args[19];
                    String copiaNomeFicheiroGuardarResultados = nomeFicheiroParaGuardarResultados.replace(".", "_");
                    String[] items = copiaNomeFicheiroGuardarResultados.split("_");
                    if (testFicheiro1.exists() && verificarFicheiroCorreto(ficheiroNumeroTotalCasos, 2) && testFicheiro2.exists() && verificarFicheiroCorreto(ficheiroNumeroAcumuladoCasos, 1) && testFicheiro3.exists() && verificarFicheiroCorreto(matrizTransicao, 3) && args.length == 20 && items[1].equals("txt")) {
                        sucessoNaoInterativo = executarTodasAsFuncoesNaoInterativo(test, dias, diasSeparados, dadosCovid, dias2, diasSeparados2, dadosCovid2, sucessoNaoInterativo, resolucaoTemporal, dataIncialVisualizar, dataFinalVisualizar, dataInicialComparar1, dataFinalComparar1, dataInicialComparar2, dataFinalComparar2, dataCalcularPrevisao, ficheiroNumeroTotalCasos, ficheiroNumeroAcumuladoCasos, matrizTransicao, nomeFicheiroParaGuardarResultados);
                    } else {
                        sucessoNaoInterativo = false;
                    }
                } else {
                    //só para visualizar e comparar
                    String ficheiroNumeroAcumuladoCasos = args[14];
                    File testFicheiro1 = new File(ficheiroNumeroAcumuladoCasos);
                    String nomeFicheiroParaGuardarResultados = args[15];
                    String copiaNomeFicheiroGuardarResultados = nomeFicheiroParaGuardarResultados.replace(".", "_");
                    String[] items = copiaNomeFicheiroGuardarResultados.split("_");
                    if (testFicheiro1.exists() && verificarFicheiroCorreto(ficheiroNumeroAcumuladoCasos, 1) && args.length == 16 && items[1].equals("txt")) {
                        sucessoNaoInterativo = visualizarECompararNaoInterativo(test, dias, diasSeparados, dadosCovid, dias2, diasSeparados2, dadosCovid2, sucessoNaoInterativo, resolucaoTemporal, dataIncialVisualizar, dataFinalVisualizar, dataInicialComparar1, dataFinalComparar1, dataInicialComparar2, dataFinalComparar2, ficheiroNumeroAcumuladoCasos, nomeFicheiroParaGuardarResultados);
                    } else {
                        sucessoNaoInterativo = false;
                    }
                }
            }else{
                sucessoNaoInterativo = false;
            }
        } else if (lerPrimeiroTipoDeParametro.equals("-T")) {
            //só para prever e media morte
            String dataCalcularPrevisao = args[1];
            String ficheiroNumeroTotalCasos = args[2];
            File testFicheiro1 = new File(ficheiroNumeroTotalCasos);
            String matrizTransicao = args[3];
            File testFicheiro2 = new File(matrizTransicao);
            String nomeFicheiroParaGuardarResultados = args[4];
            String copiaNomeFicheiroGuardarResultados = nomeFicheiroParaGuardarResultados.replace(".", "_");
            String[] items = copiaNomeFicheiroGuardarResultados.split("_");
            if (testFicheiro1.exists() && verificarFicheiroCorreto(ficheiroNumeroTotalCasos, 2) && testFicheiro2.exists() && verificarFicheiroCorreto(matrizTransicao, 3) && args.length == 5 && items[1].equals("txt")) {
                sucessoNaoInterativo = executarPrevisoesNaoInterativo(test, dias, diasSeparados, dadosCovid, sucessoNaoInterativo, dataCalcularPrevisao, ficheiroNumeroTotalCasos, matrizTransicao, nomeFicheiroParaGuardarResultados);
            } else {
                sucessoNaoInterativo = false;
            }
        }else{
            sucessoNaoInterativo = false;
        }
        if (sucessoNaoInterativo) {
            System.out.println("Terminado com sucesso");
        } else {
            System.out.println("Terminado sem sucesso");
        }
        return sucessoNaoInterativo;
    }

    public static boolean executarPrevisoesNaoInterativo(String test, String[] dias, String[][] diasSeparados, int[][] dadosCovid, boolean sucessoNaoInterativo, String dataCalcularPrevisao, String ficheiroNumeroTotalCasos, String matrizTransicao, String nomeFicheiroParaGuardarResultados) throws IOException {
        String nome;
        nome = carregarDadosNaoInterativo(ficheiroNumeroTotalCasos);
        int diasTotaisTotal = leituraDeDados(dias, dadosCovid, diasSeparados, nome, test);
        if (diferencaDeDias(dataCalcularPrevisao, diasSeparados, diasTotaisTotal) != 0) {
            File ficheiroFinal = new File(nomeFicheiroParaGuardarResultados);
            double[] passarParaEscrever = new double[9];
            String naoUsada = "";
            int[][] arrayNaoUsado = new int[1][1];
            String[] arrayNaoUsado1 = new String[2];
            if (!funcaoPrevisoes(diasTotaisTotal, dias, dadosCovid, diasSeparados, matrizTransicao, dataCalcularPrevisao, ficheiroFinal, passarParaEscrever)) {
                sucessoNaoInterativo = false;
            } else {
                if (funcaoPrevisoesMorte(matrizTransicao, dataCalcularPrevisao, ficheiroFinal, passarParaEscrever)) {
                    printWriterNaoInterativo(arrayNaoUsado, naoUsada, dias, ficheiroFinal, naoUsada, passarParaEscrever, arrayNaoUsado1);
                } else {
                    sucessoNaoInterativo = false;
                }
            }
        } else {
            sucessoNaoInterativo = false;
        }
        return sucessoNaoInterativo;
    }

    public static boolean visualizarECompararNaoInterativo(String test, String[] dias, String[][] diasSeparados, int[][] dadosCovid, String[] dias2, String[][] diasSeparados2, int[][] dadosCovid2, boolean sucessoNaoInterativo, String resolucaoTemporal, String dataIncialVisualizar, String dataFinalVisualizar, String dataInicialComparar1, String dataFinalComparar1, String dataInicialComparar2, String dataFinalComparar2, String ficheiroNumeroAcumuladoCasos, String nomeFicheiroParaGuardarResultados) throws IOException {
        String nome;
        nome = carregarDadosNaoInterativo(ficheiroNumeroAcumuladoCasos);
        int diasTotaisAcumulados = leituraDeDados(dias2, dadosCovid2, diasSeparados2, nome, test);
        int posicaoVI = verificarData(diasTotaisAcumulados, dias2, dataIncialVisualizar, diasSeparados2);
        int posicaoVF = verificarData(diasTotaisAcumulados, dias2, dataFinalVisualizar, diasSeparados2);
        int posicaoCI1Acumulado = verificarData(diasTotaisAcumulados, dias2, dataInicialComparar1, diasSeparados2);
        int posicaoCF1Acumulado = verificarData(diasTotaisAcumulados, dias2, dataFinalComparar1, diasSeparados2);
        int posicaoCI2Acumulado = verificarData(diasTotaisAcumulados, dias2, dataInicialComparar2, diasSeparados2);
        int posicaoCF2Acumulado = verificarData(diasTotaisAcumulados, dias2, dataFinalComparar2, diasSeparados2);
        File ficheiroFinal = new File(nomeFicheiroParaGuardarResultados);
        int posicaoNaoUsada1 = -1;
        int[][] arrayNaoUsado = {{0}, {0}};

        if (posicaoVI > posicaoVF) {
            sucessoNaoInterativo = false;
        } else {
            if (posicaoVI == -1) {
                sucessoNaoInterativo = false;
            } else {
                if (funcaoVisualizarTotalCasosNaoInterativa(resolucaoTemporal, arrayNaoUsado, dias, posicaoNaoUsada1, posicaoNaoUsada1, diasSeparados, posicaoVI, posicaoVF, dadosCovid2, ficheiroFinal, diasSeparados2, dias2) == 0) {
                    sucessoNaoInterativo = false;
                }
            }
        }

        if (posicaoCI1Acumulado > posicaoCF1Acumulado || posicaoCI2Acumulado > posicaoCF2Acumulado) {
            sucessoNaoInterativo = false;
        } else {
            if (posicaoCI1Acumulado == -1 || posicaoCI2Acumulado == -1) {
                sucessoNaoInterativo = false;
            } else {
                if (funcaoCompararNaoInterativa(dadosCovid, dadosCovid2, dias, posicaoNaoUsada1, posicaoNaoUsada1, posicaoNaoUsada1, posicaoNaoUsada1, posicaoCI1Acumulado, posicaoCF1Acumulado, posicaoCI2Acumulado, posicaoCF2Acumulado, ficheiroFinal, dias2) == 0) {
                    sucessoNaoInterativo = false;
                }
            }
        }
        return sucessoNaoInterativo;
    }

    public static boolean executarTodasAsFuncoesNaoInterativo(String test, String[] dias, String[][] diasSeparados, int[][] dadosCovid, String[] dias2, String[][] diasSeparados2, int[][] dadosCovid2, boolean sucessoNaoInterativo, String resolucaoTemporal, String dataIncialVisualizar, String dataFinalVisualizar, String dataInicialComparar1, String dataFinalComparar1, String dataInicialComparar2, String dataFinalComparar2, String dataCalcularPrevisao, String ficheiroNumeroTotalCasos, String ficheiroNumeroAcumuladoCasos, String matrizTransicao, String nomeFicheiroParaGuardarResultados) throws IOException {
        String nome;
        nome = carregarDadosNaoInterativo(ficheiroNumeroTotalCasos);
        int diasTotaisTotal = leituraDeDados(dias, dadosCovid, diasSeparados, nome, test);
        if (diferencaDeDias(dataCalcularPrevisao, diasSeparados, diasTotaisTotal) != 0) {
            nome = carregarDadosNaoInterativo(ficheiroNumeroAcumuladoCasos);
            int diasTotaisAcumulados = leituraDeDados(dias2, dadosCovid2, diasSeparados2, nome, test);
            int posicaoVITotal = verificarData(diasTotaisTotal, dias, dataIncialVisualizar, diasSeparados);
            int posicaoVIAcumulado = verificarData(diasTotaisAcumulados, dias2, dataIncialVisualizar, diasSeparados2);
            int posicaoVFTotal = verificarData(diasTotaisTotal, dias, dataFinalVisualizar, diasSeparados);
            int posicaoVFAcumulado = verificarData(diasTotaisAcumulados, dias2, dataFinalVisualizar, diasSeparados2);
            int posicaoCI1Total = verificarData(diasTotaisTotal, dias, dataInicialComparar1, diasSeparados);
            int posicaoCI1Acumulado = verificarData(diasTotaisAcumulados, dias2, dataInicialComparar1, diasSeparados2);
            int posicaoCF1Total = verificarData(diasTotaisTotal, dias, dataFinalComparar1, diasSeparados);
            int posicaoCF1Acumulado = verificarData(diasTotaisAcumulados, dias2, dataFinalComparar1, diasSeparados2);
            int posicaoCI2Total = verificarData(diasTotaisTotal, dias, dataInicialComparar2, diasSeparados);
            int posicaoCI2Acumulado = verificarData(diasTotaisAcumulados, dias2, dataInicialComparar2, diasSeparados2);
            int posicaoCF2Total = verificarData(diasTotaisTotal, dias, dataFinalComparar2, diasSeparados);
            int posicaoCF2Acumulado = verificarData(diasTotaisAcumulados, dias2, dataFinalComparar2, diasSeparados2);
            File ficheiroFinal = new File(nomeFicheiroParaGuardarResultados);
            double[] passarParaEscrever = new double[9];
            String naoUsada = "";
            int[][] arrayNaoUsado = new int[1][1];
            String[] arrayNaoUsado1 = new String[2];

            if (posicaoVITotal > posicaoVFTotal || posicaoVIAcumulado > posicaoVFAcumulado) {
                sucessoNaoInterativo = false;
            } else {
                if (posicaoVITotal != -1 && posicaoVIAcumulado != -1) {
                    if (funcaoVisualizarTotalCasosNaoInterativa(resolucaoTemporal, dadosCovid, dias, posicaoVITotal, posicaoVFTotal, diasSeparados, posicaoVIAcumulado, posicaoVFAcumulado, dadosCovid2, ficheiroFinal, diasSeparados2, dias2) == 0) {
                        sucessoNaoInterativo = false;
                    }
                } else {
                    sucessoNaoInterativo = false;
                }
            }
            if (posicaoCI1Total > posicaoCF1Total || posicaoCI1Acumulado > posicaoCF1Acumulado || posicaoCI2Total > posicaoCF2Total || posicaoCI2Acumulado > posicaoCF2Acumulado) {
                sucessoNaoInterativo = false;
            } else {
                if (posicaoCI1Total == -1 || posicaoCI1Acumulado == -1 || posicaoCI2Total == -1 || posicaoCI2Acumulado == -1) {
                    sucessoNaoInterativo = false;
                } else {
                    if (funcaoCompararNaoInterativa(dadosCovid, dadosCovid2, dias, posicaoCI1Total, posicaoCF1Total, posicaoCI2Total, posicaoCF2Total, posicaoCI1Acumulado, posicaoCF1Acumulado, posicaoCI2Acumulado, posicaoCF2Acumulado, ficheiroFinal, dias2) == 0) {
                        sucessoNaoInterativo = false;
                    }
                }
            }
            if (!funcaoPrevisoes(diasTotaisTotal, dias, dadosCovid, diasSeparados, matrizTransicao, dataCalcularPrevisao, ficheiroFinal, passarParaEscrever)) {
                sucessoNaoInterativo = false;
            } else {
                if (funcaoPrevisoesMorte(matrizTransicao, dataCalcularPrevisao, ficheiroFinal, passarParaEscrever)) {
                    printWriterNaoInterativo(arrayNaoUsado, naoUsada, dias, ficheiroFinal, naoUsada, passarParaEscrever, arrayNaoUsado1);
                } else {
                    sucessoNaoInterativo = false;
                }
            }
        } else {
            sucessoNaoInterativo = false;
        }
        return sucessoNaoInterativo;
    }


    public static void printWriterNaoInterativo(int[][] guardarDados, String cabecalho, String[] data, File ficheiroFinal, String resolucaoTemporal, double[] passarParaEscrever, String[] dadosComparar) throws IOException {
        FileWriter fr = new FileWriter(ficheiroFinal, true);
        BufferedWriter br = new BufferedWriter(fr);
        PrintWriter printWriter = new PrintWriter(br);
        int k = 0;
        if (passarParaEscrever[0] != 0) {
            printWriter.printf("Estimados não infetados totais: %.1f\n", passarParaEscrever[0]);
            printWriter.printf("Estimados infetados totais: %.1f\n", passarParaEscrever[1]);
            printWriter.printf("Estimados hospitalizados totais: %.1f\n", passarParaEscrever[2]);
            printWriter.printf("Estimados internados UIC totais: %.1f\n", passarParaEscrever[3]);
            printWriter.printf("Estimados obitos totais: %.1f\n", passarParaEscrever[4]);
            printWriter.println();
            printWriter.printf("Dias restantes para não infetados até à morte: %.1f\n", passarParaEscrever[5]);
            printWriter.printf("Dias restates para infetados até à morte: %.1f\n", passarParaEscrever[6]);
            printWriter.printf("Dias restantes para hosptalizdos até à morte: %.1f\n", passarParaEscrever[7]);
            printWriter.printf("Dias restantes para internados em UIC até à morte: %.1f\n", passarParaEscrever[8]);
        } else {
            if (dadosComparar[1] != null) {
                printWriter.println(cabecalho);
                while (dadosComparar[k] != null) {
                    printWriter.println(dadosComparar[k]);
                    k++;
                }
            } else {
                printWriter.println(cabecalho);
                while (data[k] != null) {
                    printWriter.print(data[k]);
                    if (guardarDados[k][1] == 0 && resolucaoTemporal.equals("2")) {
                        printWriter.print(", não existem dados do primeiro dia deste mês");
                    } else if (guardarDados[k][1] == 0 && resolucaoTemporal.equals("1")) {
                        printWriter.print(", não existem dados do primeiro dia desta semana");
                    } else if (guardarDados[k][1] == 0 && resolucaoTemporal.equals("0")) {
                        printWriter.print(", não existem dados do dia anterior");
                    } else {
                        for (int j = 1; j < 5; j++) {
                            printWriter.print("," + guardarDados[k][j]);
                        }
                    }
                    printWriter.println();
                    k++;
                }
            }
        }
        printWriter.println();
        printWriter.close();
        br.close();
        fr.close();
    }

    public static int funcaoVisualizarTotalCasosNaoInterativa(String resolucaoTemporal, int[][] dadosCovid, String[] dias, int posicao1Total, int posicao2Total, String[][] diasSeparados, int posicao1Acumulado, int posicao2Acumulado, int[][] dadosCovid2, File ficheiroFinal, String[][] diasSeparados2, String[] dias2) throws IOException {
        int controlo = 0;
        int linhas = posicao2Total - posicao1Total + 1;
        int[][] guardarDados = new int[2000][5];
        String cabecalho = "";
        String[] data = new String[2000];
        double[] arrayNaoUsado = new double[1];
        String[] arrayNaoUsado1 = new String[2];
        if (posicao1Total == -1 && posicao2Total == -1) {
            controlo = vizualizarNovosCasosNaoInterativo(resolucaoTemporal, dadosCovid2, posicao1Acumulado, posicao2Acumulado, diasSeparados2, dias2, ficheiroFinal);
        } else {
            if (resolucaoTemporal.equals("0")) {
                //diario
                cabecalho = "Data,Casos Ativos,Hospitalizados,InternadosUCI,Obitos";
                for (int i = 0; i < linhas; i++) {
                    data[i] = dias[posicao1Total];
                    for (int j = 0; j < 5; j++) {
                        guardarDados[i][j] = dadosCovid[posicao1Total][j];
                    }
                    posicao1Total++;
                }
                printWriterNaoInterativo(guardarDados, cabecalho, data, ficheiroFinal, resolucaoTemporal, arrayNaoUsado, arrayNaoUsado1);
                controlo = 1;
            } else if (resolucaoTemporal.equals("1")) {
                //semanal
                int linhaGuardar = 0;
                int inicio = getFirstMonday(diasSeparados, posicao1Total, posicao2Total) + posicao1Total;
                int ultimo = getLastSunday(diasSeparados, posicao1Total, posicao2Total) + posicao1Total;
                int semana = 0, dadosSemanais1 = 0, dadosSemanais2 = 0, dadosSemanais3 = 0, dadosSemanais4 = 0, guardarSegunda = 0, segunda = 0;
                int firstMonday1 = getFirstMonday(diasSeparados, posicao1Total, posicao2Total);
                int lastSunday1 = getLastSunday(diasSeparados, posicao1Total, posicao2Total);
                if (lastSunday1 < firstMonday1) {
                    controlo = 0;
                } else {
                    for (int i = inicio; i <= ultimo; i++) {
                        if (guardarSegunda == 0) {
                            segunda = i;
                            guardarSegunda++;
                        }
                        if (semana != 7) {
                            dadosSemanais1 = dadosSemanais1 + dadosCovid[i][1];
                            dadosSemanais2 = dadosSemanais2 + dadosCovid[i][2];
                            dadosSemanais3 = dadosSemanais3 + dadosCovid[i][3];
                            dadosSemanais4 = dadosSemanais4 + dadosCovid[i][4];
                            semana++;
                        }
                        if (semana == 7) {
                            data[linhaGuardar] = dias[segunda] + " - " + dias[segunda + 6];
                            guardarDados[linhaGuardar][1] = dadosSemanais1;
                            guardarDados[linhaGuardar][2] = dadosSemanais2;
                            guardarDados[linhaGuardar][3] = dadosSemanais3;
                            guardarDados[linhaGuardar][4] = dadosSemanais4;
                            linhaGuardar++;
                            semana = 0;
                            dadosSemanais1 = 0;
                            dadosSemanais2 = 0;
                            dadosSemanais3 = 0;
                            dadosSemanais4 = 0;
                            guardarSegunda = 0;
                        }
                    }
                    cabecalho = "Semana,Casos Ativos,Hospitalizados,InternadosUCI,Obitos";
                    printWriterNaoInterativo(guardarDados, cabecalho, data, ficheiroFinal, resolucaoTemporal, arrayNaoUsado, arrayNaoUsado1);
                    controlo = 1;
                }
            } else if (resolucaoTemporal.equals("2")) {
                //mensal
                int linhaGuardar = 0;
                int inicio = getFirstDayOfMonth(diasSeparados, posicao1Total, posicao2Total);
                int ultimo = getLastDayOfMonth(diasSeparados, posicao1Total, posicao2Total);
                //totais
                if (ultimo < inicio) {
                    controlo = 0;
                } else {
                    int firstDay = posicao1Total + inicio;
                    int lastDay = posicao1Total + ultimo;
                    int casosRegistrados1 = 0, casosRegistrados2 = 0, casosRegistrados3 = 0, casosRegistrados4 = 0, guardar = firstDay - 1, j = 0;
                    for (int i = firstDay; i <= lastDay; i++) {
                        if (diasSeparados[i + 1][1] == null) {
                            casosRegistrados1 = casosRegistrados1 + dadosCovid[i][1];
                            casosRegistrados2 = casosRegistrados2 + dadosCovid[i][2];
                            casosRegistrados3 = casosRegistrados3 + dadosCovid[i][3];
                            casosRegistrados4 = casosRegistrados4 + dadosCovid[i][4];
                            guardarDados[linhaGuardar][1] = casosRegistrados1;
                            guardarDados[linhaGuardar][2] = casosRegistrados2;
                            guardarDados[linhaGuardar][3] = casosRegistrados3;
                            guardarDados[linhaGuardar][4] = casosRegistrados4;
                            linhaGuardar++;
                        } else if (diasSeparados[i][1].compareTo(diasSeparados[i + 1][1]) == 0) {
                            //NaoMudaDeMes
                            casosRegistrados1 = casosRegistrados1 + dadosCovid[i][1];
                            casosRegistrados2 = casosRegistrados2 + dadosCovid[i][2];
                            casosRegistrados3 = casosRegistrados3 + dadosCovid[i][3];
                            casosRegistrados4 = casosRegistrados4 + dadosCovid[i][4];
                        } else if (diasSeparados[i][1].compareTo(diasSeparados[i + 1][1]) != 0) {
                            //mudaDeMes
                            casosRegistrados1 = casosRegistrados1 + dadosCovid[i][1];
                            casosRegistrados2 = casosRegistrados2 + dadosCovid[i][2];
                            casosRegistrados3 = casosRegistrados3 + dadosCovid[i][3];
                            casosRegistrados4 = casosRegistrados4 + dadosCovid[i][4];
                            guardarDados[linhaGuardar][1] = casosRegistrados1;
                            guardarDados[linhaGuardar][2] = casosRegistrados2;
                            guardarDados[linhaGuardar][3] = casosRegistrados3;
                            guardarDados[linhaGuardar][4] = casosRegistrados4;
                            linhaGuardar++;
                            data[j] = dias[guardar + 1] + " - " + dias[i];
                            j++;
                            guardar = i;
                            casosRegistrados1 = 0;
                            casosRegistrados2 = 0;
                            casosRegistrados3 = 0;
                            casosRegistrados4 = 0;
                        }
                    }
                    cabecalho = "Mês,Casos Ativos,Hospitalizados,InternadosUCI,Obitos";
                    printWriterNaoInterativo(guardarDados, cabecalho, data, ficheiroFinal, resolucaoTemporal, arrayNaoUsado, arrayNaoUsado1);
                    controlo = 1;
                }
            }
            if (controlo == 0) {
                return controlo;
            } else {
                controlo = vizualizarNovosCasosNaoInterativo(resolucaoTemporal, dadosCovid2, posicao1Acumulado, posicao2Acumulado, diasSeparados2, dias2, ficheiroFinal);
            }
        }
        return controlo;
    }

    public static String carregarDadosNaoInterativo(String nomeDoFicheiro) {
        //test
        String nome = "";
        boolean exist = false;
        while (!exist) {
            File ficheiro = new File(nomeDoFicheiro);
            if (ficheiro.exists()) {
                exist = true;
                nome = nomeDoFicheiro;
            }
        }
        return nome;
    }

    public static int vizualizarNovosCasosNaoInterativo(String resolucaoTemporal, int[][] dadosCovid2, int posicao1Acumulado, int posicao2Acumulado, String[][] diasSeparados2, String[] dias2, File ficheiroFinal) throws IOException {
        int controlo = 0;
        String cabecalho = "";
        int linhas = posicao2Acumulado - posicao1Acumulado + 1;
        int[][] guardarDadosAcumulados = new int[1000][5];
        String[] data = new String[2000];
        double[] arrayNaoUsado = new double[1];
        String[] arrayNaoUsado1 = new String[2];
        if (resolucaoTemporal.equals("0")) {
            //diario
            for (int i = 0; i < linhas; i++) {
                data[i] = dias2[posicao1Acumulado];
                for (int j = 0; j < 5; j++) {
                    if (posicao1Acumulado == 0 || posicao2Acumulado == 0) {
                        guardarDadosAcumulados[i][j] = 0;
                    } else {
                        guardarDadosAcumulados[i][j] = dadosCovid2[posicao1Acumulado][j] - dadosCovid2[posicao1Acumulado - 1][j];
                    }
                }
                posicao1Acumulado++;
            }
            cabecalho = "Data, Novos Casos, Novas Hospitalizações, Novos Internamentos, Novas Mortes";
            printWriterNaoInterativo(guardarDadosAcumulados, cabecalho, data, ficheiroFinal, resolucaoTemporal, arrayNaoUsado, arrayNaoUsado1);
            controlo = 1;
        } else if (resolucaoTemporal.equals("1")) {
            //semanal
            int linhaGuardar = 0;
            int inicio = getFirstMonday(diasSeparados2, posicao1Acumulado, posicao2Acumulado) + posicao1Acumulado;
            int ultimo = getLastSunday(diasSeparados2, posicao1Acumulado, posicao2Acumulado) + posicao1Acumulado;
            int semana = 0, dadosSemanais1 = 0, dadosSemanais2 = 0, dadosSemanais3 = 0, dadosSemanais4 = 0, guardarSegunda = 0, segunda = 0;
            int firstMonday1 = getFirstMonday(diasSeparados2, posicao1Acumulado, posicao2Acumulado);
            int lastSunday1 = getLastSunday(diasSeparados2, posicao1Acumulado, posicao2Acumulado);
            if (lastSunday1 < firstMonday1) {
                controlo = 0;
            } else {
                for (int i = inicio; i <= ultimo; i++) {
                    if (guardarSegunda == 0) {
                        segunda = i;
                        guardarSegunda++;
                    }
                    if (semana != 7) {
                        if (i == 0) {
                            semana = 7;
                            i = i + 6;
                        } else {
                            dadosSemanais1 = dadosSemanais1 + (dadosCovid2[i][1] - dadosCovid2[i - 1][1]);
                            dadosSemanais2 = dadosSemanais2 + (dadosCovid2[i][2] - dadosCovid2[i - 1][2]);
                            dadosSemanais3 = dadosSemanais3 + (dadosCovid2[i][3] - dadosCovid2[i - 1][3]);
                            dadosSemanais4 = dadosSemanais4 + (dadosCovid2[i][4] - dadosCovid2[i - 1][4]);
                            semana++;
                        }
                    }
                    if (semana == 7) {
                        data[linhaGuardar] = dias2[segunda] + " - " + dias2[segunda + 6];
                        guardarDadosAcumulados[linhaGuardar][1] = dadosSemanais1;
                        guardarDadosAcumulados[linhaGuardar][2] = dadosSemanais2;
                        guardarDadosAcumulados[linhaGuardar][3] = dadosSemanais3;
                        guardarDadosAcumulados[linhaGuardar][4] = dadosSemanais4;
                        linhaGuardar++;
                        semana = 0;
                        dadosSemanais1 = 0;
                        dadosSemanais2 = 0;
                        dadosSemanais3 = 0;
                        dadosSemanais4 = 0;
                        guardarSegunda = 0;
                    }
                }
                cabecalho = "Semana, Novos Casos, Novas Hospitalizações, Novos Internamentos, Novas Mortes";
                printWriterNaoInterativo(guardarDadosAcumulados, cabecalho, data, ficheiroFinal, resolucaoTemporal, arrayNaoUsado, arrayNaoUsado1);
                controlo = 1;
            }
        } else if (resolucaoTemporal.equals("2")) {
            //mensal
            int linhaGuardar = 0;
            int inicio = getFirstDayOfMonth(diasSeparados2, posicao1Acumulado, posicao2Acumulado);
            int ultimo = getLastDayOfMonth(diasSeparados2, posicao1Acumulado, posicao2Acumulado);
            int nrDias = 0;
            int k = 0;
            //totais
            if (ultimo < inicio) {
                controlo = 0;
            } else {
                int firstDay = posicao1Acumulado + inicio;
                int lastDay = posicao1Acumulado + ultimo;
                int casosRegistrados1 = 0, casosRegistrados2 = 0, casosRegistrados3 = 0, casosRegistrados4 = 0, guardar = 0, j = 0;
                for (int i = firstDay; i <= lastDay; i++) {
                    if (i == 0) {
                        while (diasSeparados2[i][1].compareTo(diasSeparados2[i + 1][1]) != 0) {
                            i++;
                        }
                        guardarDadosAcumulados[linhaGuardar][1] = casosRegistrados1;
                        guardarDadosAcumulados[linhaGuardar][2] = casosRegistrados2;
                        guardarDadosAcumulados[linhaGuardar][3] = casosRegistrados3;
                        guardarDadosAcumulados[linhaGuardar][4] = casosRegistrados4;
                        linhaGuardar++;
                    } else {
                        if (diasSeparados2[i + 1][1] == null) {
                            casosRegistrados1 = casosRegistrados1 + (dadosCovid2[i][1] - dadosCovid2[i - 1][1]);
                            casosRegistrados2 = casosRegistrados2 + (dadosCovid2[i][2] - dadosCovid2[i - 1][2]);
                            casosRegistrados3 = casosRegistrados3 + (dadosCovid2[i][3] - dadosCovid2[i - 1][3]);
                            casosRegistrados4 = casosRegistrados4 + (dadosCovid2[i][4] - dadosCovid2[i - 1][4]);
                            guardarDadosAcumulados[linhaGuardar][1] = casosRegistrados1;
                            guardarDadosAcumulados[linhaGuardar][2] = casosRegistrados2;
                            guardarDadosAcumulados[linhaGuardar][3] = casosRegistrados3;
                            guardarDadosAcumulados[linhaGuardar][4] = casosRegistrados4;
                            data[j] = dias2[guardar + 1] + " - " + dias2[i];
                            guardar = i;
                        } else if (diasSeparados2[i][1].compareTo(diasSeparados2[i + 1][1]) == 0) {
                            //NaoMudaDeMes
                            casosRegistrados1 = casosRegistrados1 + (dadosCovid2[i][1] - dadosCovid2[i - 1][1]);
                            casosRegistrados2 = casosRegistrados2 + (dadosCovid2[i][2] - dadosCovid2[i - 1][2]);
                            casosRegistrados3 = casosRegistrados3 + (dadosCovid2[i][3] - dadosCovid2[i - 1][3]);
                            casosRegistrados4 = casosRegistrados4 + (dadosCovid2[i][4] - dadosCovid2[i - 1][4]);
                        } else if (diasSeparados2[i][1].compareTo(diasSeparados2[i + 1][1]) != 0) {
                            //mudaDeMes
                            casosRegistrados1 = casosRegistrados1 + (dadosCovid2[i][1] - dadosCovid2[i - 1][1]);
                            casosRegistrados2 = casosRegistrados2 + (dadosCovid2[i][2] - dadosCovid2[i - 1][2]);
                            casosRegistrados3 = casosRegistrados3 + (dadosCovid2[i][3] - dadosCovid2[i - 1][3]);
                            casosRegistrados4 = casosRegistrados4 + (dadosCovid2[i][4] - dadosCovid2[i - 1][4]);
                            guardarDadosAcumulados[linhaGuardar][1] = casosRegistrados1;
                            guardarDadosAcumulados[linhaGuardar][2] = casosRegistrados2;
                            guardarDadosAcumulados[linhaGuardar][3] = casosRegistrados3;
                            guardarDadosAcumulados[linhaGuardar][4] = casosRegistrados4;
                            linhaGuardar++;
                            data[j] = dias2[guardar + 1] + " - " + dias2[i];
                            guardar = i;
                            j++;
                            casosRegistrados1 = 0;
                            casosRegistrados2 = 0;
                            casosRegistrados3 = 0;
                            casosRegistrados4 = 0;
                        }
                    }
                }
                cabecalho = "Mês, Novos Casos, Novas Hospitalizações, Novos Internamentos, Novas Mortes";
                printWriterNaoInterativo(guardarDadosAcumulados, cabecalho, data, ficheiroFinal, resolucaoTemporal, arrayNaoUsado, arrayNaoUsado1);
                controlo = 1;
            }
        }
        return controlo;
    }

    public static int funcaoCompararNaoInterativa(int[][] dadosCovid1, int[][] dadosCovid2, String[] dias, int posicaoCI1Total, int posicaoCF1Total, int posicaoCI2Total, int posicaoCF2Total, int posicaoCI1Acumulado, int posicaoCF1Acumulado, int posicaoCI2Acumulado, int posicaoCF2Acumulado, File ficheiroFinal, String[] dias2) throws IOException {
        String[] guardarDadosComparar = new String[1000];
        int linhaGuardar = 0;
        int linha1Total = (posicaoCI2Total - posicaoCI1Total);
        int linha2Total = (posicaoCF2Total - posicaoCF1Total);
        int linha1Acumulado = (posicaoCI2Acumulado - posicaoCI1Acumulado) + 1;
        int linha2Acumulado = (posicaoCF2Acumulado - posicaoCF1Acumulado) + 1;
        int copiaPosicaoInicio1Total = posicaoCI1Total;
        int copiaPosicaoInicio2Total = posicaoCI2Total;
        int copiaPosicaoInicio1Acumulado = posicaoCI1Acumulado;
        int copiaPosicaoInicio2Acumulado = posicaoCI2Acumulado;
        int[][] dadosDoIntervalo1Total = new int[linha1Total][100];
        int[][] dadosDoIntervalo2Total = new int[linha2Total][100];
        int[][] valorDaComparacaoTotal = new int[linha1Total][100];
        int[][] dadosDoIntervalo1Acumulado = new int[linha1Acumulado][100];
        int[][] dadosDoIntervalo2Acumulado = new int[linha2Acumulado][100];
        int[][] valorDaComparacaoAcumulado = new int[linha1Acumulado][100];
        String cabecalho;
        double[] arrayNaoUsado = new double[1];
        String naoUsada = "";
        int[][] arrayNaoUsado1 = new int[1][1];
        int controlo = 0;
        if (posicaoCI1Total != -1 && posicaoCF1Total != -1 && posicaoCI2Total != -1 && posicaoCF2Total != -1) {
            //comparar casos totais
            for (int t = 1; t <= 4; t++) {
                if (dadosDoIntervalo1Total.length <= dadosDoIntervalo2Total.length) {
                    for (int i = 0; i < linha1Total; i++) {
                        dadosDoIntervalo1Total[i][1] = dadosCovid1[copiaPosicaoInicio1Total][1];
                        dadosDoIntervalo1Total[i][2] = dadosCovid1[copiaPosicaoInicio1Total][2];
                        dadosDoIntervalo1Total[i][3] = dadosCovid1[copiaPosicaoInicio1Total][3];
                        dadosDoIntervalo1Total[i][4] = dadosCovid1[copiaPosicaoInicio1Total][4];
                        copiaPosicaoInicio1Total++;
                    }
                    for (int i = 0; i < linha1Total; i++) {
                        dadosDoIntervalo2Total[i][1] = dadosCovid1[copiaPosicaoInicio2Total][1];
                        dadosDoIntervalo2Total[i][2] = dadosCovid1[copiaPosicaoInicio2Total][2];
                        dadosDoIntervalo2Total[i][3] = dadosCovid1[copiaPosicaoInicio2Total][3];
                        dadosDoIntervalo2Total[i][4] = dadosCovid1[copiaPosicaoInicio2Total][4];
                        copiaPosicaoInicio2Total++;
                    }
                    for (int ii = 0; ii < linha1Total; ii++) {
                        valorDaComparacaoTotal[ii][1] = dadosDoIntervalo2Total[ii][1] - dadosDoIntervalo1Total[ii][1];
                        valorDaComparacaoTotal[ii][2] = dadosDoIntervalo2Total[ii][2] - dadosDoIntervalo1Total[ii][2];
                        valorDaComparacaoTotal[ii][3] = dadosDoIntervalo2Total[ii][3] - dadosDoIntervalo1Total[ii][3];
                        valorDaComparacaoTotal[ii][4] = dadosDoIntervalo2Total[ii][4] - dadosDoIntervalo1Total[ii][4];
                    }
                    copiaPosicaoInicio1Total = posicaoCI1Total;
                    copiaPosicaoInicio2Total = posicaoCI2Total;
                    for (int p = 0; p < linha1Total; p++) {
                        guardarDadosComparar[p] = String.format("No dia %s houveram %-4d | No dia %s houveram %-4d | Aconteceu uma variação de %d ", dias[copiaPosicaoInicio1Total], dadosDoIntervalo1Total[p][t], dias[copiaPosicaoInicio2Total], dadosDoIntervalo2Total[p][t], valorDaComparacaoTotal[p][t]);
                        copiaPosicaoInicio1Total++;
                        copiaPosicaoInicio2Total++;
                    }
                    linhaGuardar = linha1Total;
                } else {
                    for (int i = 0; i < linha2Total; i++) {
                        dadosDoIntervalo1Total[i][1] = dadosCovid1[copiaPosicaoInicio1Total][1];
                        dadosDoIntervalo1Total[i][2] = dadosCovid1[copiaPosicaoInicio1Total][2];
                        dadosDoIntervalo1Total[i][3] = dadosCovid1[copiaPosicaoInicio1Total][3];
                        dadosDoIntervalo1Total[i][4] = dadosCovid1[copiaPosicaoInicio1Total][4];
                        copiaPosicaoInicio1Total++;
                    }
                    for (int i = 0; i < linha2Total; i++) {
                        dadosDoIntervalo2Total[i][1] = dadosCovid1[copiaPosicaoInicio2Total][1];
                        dadosDoIntervalo2Total[i][2] = dadosCovid1[copiaPosicaoInicio2Total][2];
                        dadosDoIntervalo2Total[i][3] = dadosCovid1[copiaPosicaoInicio2Total][3];
                        dadosDoIntervalo2Total[i][4] = dadosCovid1[copiaPosicaoInicio2Total][4];
                        copiaPosicaoInicio2Total++;
                    }
                    for (int ii = 0; ii < linha2Total; ii++) {
                        valorDaComparacaoTotal[ii][1] = dadosDoIntervalo2Total[ii][1] - dadosDoIntervalo1Total[ii][1];
                        valorDaComparacaoTotal[ii][2] = dadosDoIntervalo2Total[ii][2] - dadosDoIntervalo1Total[ii][2];
                        valorDaComparacaoTotal[ii][3] = dadosDoIntervalo2Total[ii][3] - dadosDoIntervalo1Total[ii][3];
                        valorDaComparacaoTotal[ii][4] = dadosDoIntervalo2Total[ii][4] - dadosDoIntervalo1Total[ii][4];
                    }
                    copiaPosicaoInicio1Total = posicaoCI1Total;
                    copiaPosicaoInicio2Total = posicaoCI2Total;
                    for (int p = 0; p < linha2Total; p++) {
                        guardarDadosComparar[p] = String.format("No dia %s houveram %-4d | No dia %s houveram %-4d | Aconteceu uma variação de %d ", dias[copiaPosicaoInicio1Total], dadosDoIntervalo1Total[p][t], dias[copiaPosicaoInicio2Total], dadosDoIntervalo2Total[p][t], valorDaComparacaoTotal[p][t]);
                        copiaPosicaoInicio1Total++;
                        copiaPosicaoInicio2Total++;
                    }
                    linhaGuardar = linha2Total;
                }
                double media1 = media(dadosDoIntervalo1Total, t);
                double media2 = media(dadosDoIntervalo2Total, t);
                double media3 = media(valorDaComparacaoTotal, t);
                double desvio1 = desvioPadrao(dadosDoIntervalo1Total, media1, t);
                double desvio2 = desvioPadrao(dadosDoIntervalo2Total, media2, t);
                double desvio3 = desvioPadrao(valorDaComparacaoTotal, media3, t);
                guardarDadosComparar[linhaGuardar] = String.format("Média casos totais primeiro intervalo: %.4f_Média casos totais segundo intervalo: %.4f_Média diferença casos totais: %.4f", media1, media2, media3).replaceAll(",", ".").replaceAll("_", ",");
                linhaGuardar++;
                guardarDadosComparar[linhaGuardar] = String.format("Desvio padrão casos totais primeiro intervalo: %.4f_Desvio padrão casos totais segundo intervalo: %.4f_Desvio padrão diferença de casos totais: %.4f", desvio1, desvio2, desvio3).replaceAll(",", ".").replaceAll("_", ",");
                linhaGuardar++;
                cabecalho = String.format("%s\nPrimeiraData,TotalDadosPrimeiraData,SegundaData,TotalDadosSegundaData,Comparação", conectorArrayComOsDadosParaFuncaoPretendida(t));
                printWriterNaoInterativo(arrayNaoUsado1, cabecalho, dias, ficheiroFinal, naoUsada, arrayNaoUsado, guardarDadosComparar);
                controlo = 1;
            }
        }

        //comparar novos casos
        linhaGuardar = 0;
        for (int t = 1; t <= 4; t++) {
            if (dadosDoIntervalo1Acumulado.length <= dadosDoIntervalo2Acumulado.length) {
                if (posicaoCI1Acumulado == 0) {
                    guardarDadosComparar[linhaGuardar] = dias2[posicaoCI1Acumulado] + " : Não há dados do dia anterior ";
                    linhaGuardar++;
                } else {
                    for (int i = 0; i < linha1Acumulado; i++) {
                        dadosDoIntervalo1Acumulado[i][1] = dadosCovid2[copiaPosicaoInicio1Acumulado][1] - dadosCovid2[copiaPosicaoInicio1Acumulado - 1][1];
                        dadosDoIntervalo1Acumulado[i][2] = dadosCovid2[copiaPosicaoInicio1Acumulado][2] - dadosCovid2[copiaPosicaoInicio1Acumulado - 1][2];
                        dadosDoIntervalo1Acumulado[i][3] = dadosCovid2[copiaPosicaoInicio1Acumulado][3] - dadosCovid2[copiaPosicaoInicio1Acumulado - 1][3];
                        dadosDoIntervalo1Acumulado[i][4] = dadosCovid2[copiaPosicaoInicio1Acumulado][4] - dadosCovid2[copiaPosicaoInicio1Acumulado - 1][4];
                        copiaPosicaoInicio1Acumulado++;
                    }
                }

                if (posicaoCF2Acumulado == 0) {
                    guardarDadosComparar[linhaGuardar] = dias2[posicaoCF2Acumulado] + " : Não há dados do dia anterior ";
                    linhaGuardar++;
                } else {
                    for (int i = 0; i < linha1Acumulado; i++) {
                        dadosDoIntervalo2Acumulado[i][1] = dadosCovid2[copiaPosicaoInicio2Acumulado][1] - dadosCovid2[copiaPosicaoInicio2Acumulado - 1][1];
                        dadosDoIntervalo2Acumulado[i][2] = dadosCovid2[copiaPosicaoInicio2Acumulado][2] - dadosCovid2[copiaPosicaoInicio2Acumulado - 1][2];
                        dadosDoIntervalo2Acumulado[i][3] = dadosCovid2[copiaPosicaoInicio2Acumulado][3] - dadosCovid2[copiaPosicaoInicio2Acumulado - 1][3];
                        dadosDoIntervalo2Acumulado[i][4] = dadosCovid2[copiaPosicaoInicio2Acumulado][4] - dadosCovid2[copiaPosicaoInicio2Acumulado - 1][4];
                        copiaPosicaoInicio2Acumulado++;
                    }
                }
                for (int ii = 0; ii < linha1Acumulado; ii++) {
                    valorDaComparacaoAcumulado[ii][1] = dadosDoIntervalo2Acumulado[ii][1] - dadosDoIntervalo1Acumulado[ii][1];
                    valorDaComparacaoAcumulado[ii][2] = dadosDoIntervalo2Acumulado[ii][2] - dadosDoIntervalo1Acumulado[ii][2];
                    valorDaComparacaoAcumulado[ii][3] = dadosDoIntervalo2Acumulado[ii][3] - dadosDoIntervalo1Acumulado[ii][3];
                    valorDaComparacaoAcumulado[ii][4] = dadosDoIntervalo2Acumulado[ii][4] - dadosDoIntervalo1Acumulado[ii][4];
                }
                copiaPosicaoInicio1Acumulado = posicaoCI1Acumulado;
                copiaPosicaoInicio2Acumulado = posicaoCI2Acumulado;
                int r = 1;
                for (int p = 0; p < linha1Acumulado - 1; p++) {
                    guardarDadosComparar[p] = String.format("No dia %s houveram %-4d | No dia %s houveram %-4d | Aconteceu uma variação de %d ", dias2[copiaPosicaoInicio1Acumulado], dadosDoIntervalo1Acumulado[r][t], dias2[copiaPosicaoInicio2Acumulado], dadosDoIntervalo2Acumulado[r][t], valorDaComparacaoAcumulado[r][t]);
                    copiaPosicaoInicio1Acumulado++;
                    copiaPosicaoInicio2Acumulado++;
                    r++;
                }
                linhaGuardar = linha1Acumulado - 1;
            } else {
                if (posicaoCI1Acumulado == 0) {
                    System.out.println(dias2[posicaoCI1Acumulado] + " : Não há dados do dia anterior ");
                    guardarDadosComparar[linhaGuardar] = dias2[posicaoCI1Acumulado] + " : Não há dados do dia anterior ";
                    linhaGuardar++;

                } else {

                    for (int i = 0; i < linha2Acumulado; i++) {
                        dadosDoIntervalo1Acumulado[i][1] = dadosCovid2[copiaPosicaoInicio1Acumulado][1] - dadosCovid2[copiaPosicaoInicio1Acumulado - 1][1];
                        dadosDoIntervalo1Acumulado[i][2] = dadosCovid2[copiaPosicaoInicio1Acumulado][2] - dadosCovid2[copiaPosicaoInicio1Acumulado - 1][2];
                        dadosDoIntervalo1Acumulado[i][3] = dadosCovid2[copiaPosicaoInicio1Acumulado][3] - dadosCovid2[copiaPosicaoInicio1Acumulado - 1][3];
                        dadosDoIntervalo1Acumulado[i][4] = dadosCovid2[copiaPosicaoInicio1Acumulado][4] - dadosCovid2[copiaPosicaoInicio1Acumulado - 1][4];
                        copiaPosicaoInicio1Acumulado++;
                    }
                }
                if (posicaoCF2Acumulado == 0) {
                    guardarDadosComparar[linhaGuardar] = dias2[posicaoCF2Acumulado] + " : Não há dados do dia anterior ";
                    linhaGuardar++;
                } else {
                    for (int i = 0; i < linha2Acumulado; i++) {
                        dadosDoIntervalo2Acumulado[i][1] = dadosCovid2[copiaPosicaoInicio2Acumulado][1] - dadosCovid2[copiaPosicaoInicio2Acumulado - 1][1];
                        dadosDoIntervalo2Acumulado[i][2] = dadosCovid2[copiaPosicaoInicio2Acumulado][2] - dadosCovid2[copiaPosicaoInicio2Acumulado - 1][2];
                        dadosDoIntervalo2Acumulado[i][3] = dadosCovid2[copiaPosicaoInicio2Acumulado][3] - dadosCovid2[copiaPosicaoInicio2Acumulado - 1][3];
                        dadosDoIntervalo2Acumulado[i][4] = dadosCovid2[copiaPosicaoInicio2Acumulado][4] - dadosCovid2[copiaPosicaoInicio2Acumulado - 1][4];
                        copiaPosicaoInicio2Acumulado++;
                    }
                }
                for (int ii = 0; ii < linha2Acumulado; ii++) {
                    valorDaComparacaoAcumulado[ii][1] = dadosDoIntervalo2Acumulado[ii][1] - dadosDoIntervalo1Acumulado[ii][1];
                    valorDaComparacaoAcumulado[ii][2] = dadosDoIntervalo2Acumulado[ii][2] - dadosDoIntervalo1Acumulado[ii][2];
                    valorDaComparacaoAcumulado[ii][3] = dadosDoIntervalo2Acumulado[ii][3] - dadosDoIntervalo1Acumulado[ii][3];
                    valorDaComparacaoAcumulado[ii][4] = dadosDoIntervalo2Acumulado[ii][4] - dadosDoIntervalo1Acumulado[ii][4];
                }
                copiaPosicaoInicio1Acumulado = posicaoCI1Acumulado;
                copiaPosicaoInicio2Acumulado = posicaoCI2Acumulado;
                int r = 0;
                for (int p = 0; p < linha2Acumulado; p++) {
                    guardarDadosComparar[p] = String.format("No dia %s houveram %-4d | No dia %s houveram %-4d | Aconteceu uma variação de %d ", dias2[copiaPosicaoInicio1Acumulado], dadosDoIntervalo1Acumulado[r][t], dias2[copiaPosicaoInicio2Acumulado], dadosDoIntervalo2Acumulado[r][t], valorDaComparacaoAcumulado[r][t]);
                    copiaPosicaoInicio1Acumulado++;
                    copiaPosicaoInicio2Acumulado++;
                    r++;
                }
                linhaGuardar = linha2Acumulado - 1;
            }
            double media5 = media(dadosDoIntervalo2Acumulado, t);
            double media4 = media(dadosDoIntervalo1Acumulado, t);
            double media6 = media(valorDaComparacaoAcumulado, t);
            double desvio4 = desvioPadrao(dadosDoIntervalo1Acumulado, media4, t);
            double desvio5 = desvioPadrao(dadosDoIntervalo2Acumulado, media5, t);
            double desvio6 = desvioPadrao(valorDaComparacaoAcumulado, media6, t);

            guardarDadosComparar[linhaGuardar] = String.format("Média novos casos primeiro intervalo: %.4f_Média novos casos segundo intervalo: %.4f_Média diferença novos casos: %.4f", media4, media5, media6).replaceAll(",", ".").replaceAll("_", ",");
            linhaGuardar++;
            guardarDadosComparar[linhaGuardar] = String.format("Desvio padrão novos casos primeiro intervalo: %.4f_Desvio padrão novos casos segundo intervalo: %.4f_Desvio padrão diferença novos casos: %.4f", desvio4, desvio5, desvio6).replaceAll(",", ".").replaceAll("_", ",");
            linhaGuardar++;
            cabecalho = String.format("%s\nPrimeiraData,NovosDadosPrimeiraData,SegundaData,NovosDadosSegundaData,Comparação", conectorArrayComOsDadosParaFuncaoPretendida(t));
            printWriterNaoInterativo(arrayNaoUsado1, cabecalho, dias2, ficheiroFinal, naoUsada, arrayNaoUsado, guardarDadosComparar);
            controlo = 1;
        }
        return controlo;
    }
}