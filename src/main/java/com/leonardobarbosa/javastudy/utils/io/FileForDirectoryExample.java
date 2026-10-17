package com.leonardobarbosa.javastudy.utils.io;

import java.io.File;
import java.io.IOException;

public class FileForDirectoryExample {
    public static void main(String[] args) {

        /*
         File para diretórios

         - mkdir() cria um único diretório
         - mkdirs() cria toda a estrutura de diretórios necessária

         - renameTo() pode ser usado para renomear
           arquivos ou diretórios

         - a maioria dos métodos retorna boolean
           indicando sucesso ou falha da operação
         */

        // Criar diretório
        File directory = new File("Directory");

        boolean isDirectoryCreated = directory.mkdir();
        if (isDirectoryCreated) {
            System.out.println("Directory created");
        }
        if (directory.exists()) {
            System.out.println("Directory exists");
        }

        // Criar arquivo dentro do diretório
        File file = new File(directory, "file.txt");
        try {
            if (!file.exists()) {
                boolean newFile = file.createNewFile();
                System.out.println("File created: " + newFile);
            } else {
                System.out.println("File already exists: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Renomear arquivo
        File fileRenamed = new File(directory, "file_renamed.txt");
        boolean isFileRenamed = file.renameTo(fileRenamed);
        System.out.println("File renamed: " + isFileRenamed);

        // Renomear diretório
        File directoryRenamed = new File("DirectoryRenamed");
        boolean isDirectoryRenamed = directory.renameTo(directoryRenamed);
        System.out.println("Directory renamed: " + isDirectoryRenamed);

        /*
        Comportamento do programa:

         Primeira execução:
         - cria o diretório "Directory"
         - cria o arquivo "file.txt"
         - renomeia para "file_renamed.txt"
         - renomeia o diretório para "DirectoryRenamed"

         Resultado final:
         DirectoryRenamed/
         └── file_renamed.txt

         Execuções posteriores:
         - um novo diretório "Directory" é criado
         - um novo arquivo "file.txt" é criado
         - alguns renameTo() podem falhar se o arquivo
           ou diretório de destino já existir

         Observação:
         - File representa um caminho, não o arquivo físico
         - renameTo() altera o arquivo/diretório no disco,
           mas os objetos File antigos continuam apontando
           para os caminhos originais
         */
    }
}
