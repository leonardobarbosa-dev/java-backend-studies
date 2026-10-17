package com.leonardobarbosa.javastudy.utils.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamExample {
    public static void main(String[] args) {

        /*
        ZipOutputStream
        - cria arquivos compactados (.zip)

        Fluxo:
        ZipOutputStream
        ZipEntry        ->  representa um arquivo dentro do zip
        putNextEntry()  ->  após chamar, os arquivos escritos pertencem a esse arquivo
        Files.copy()    ->  copia os bytes do arquivo para dentro do ZIP
        closeEntry()    ->  finaliza o arquivo atual dentro do ZIP
         */

        Path zipPath = Paths.get("Files/Files.zip");
        Path zipFiles = Paths.get("Files/com/leonardobarbosa/txt_files");

        try(ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipPath));
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(zipFiles)) {

            for (Path file : directoryStream) {
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                zos.putNextEntry(zipEntry);
                Files.copy(file, zos);
                zos.closeEntry();
            }

            System.out.println(".zip created!");

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
