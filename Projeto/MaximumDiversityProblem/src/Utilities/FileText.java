/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author douglas
 */
public class FileText {

    private final String CAMINHO = "/home/usuario/Repositorios/Github/Maximum-Diversity-Problem/";
    private final String NOME_ARQUIVO1 = "LogDeResultados1.csv";
    private final String NOME_ARQUIVO2 = "LogDeResultados2.csv";

    public void escrever(String dados, int opcao) {

        try {
            FileWriter writer;
            if (opcao == 1) {
                writer = new FileWriter(NOME_ARQUIVO1, true);
                writer.write(dados + "\n");
            } else {
                writer = new FileWriter(NOME_ARQUIVO2, true);
                writer.write(dados + "\n");
            }

            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
