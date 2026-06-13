package com.leonardobarbosa.javastudy.utils.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathManipulationExample {
    public static void main(String[] args) {

        /*
        Path manipulation

        normalize()
        - remove elementos desnecessários do caminho    -> ./ e ../

        resolve()
        - junta caminhos
        - cria um novo Path

        relativize()
        - cria o caminho relativo entre dois Paths
         */

        // normalize()  -> limpa o caminho
        Path path = Paths.get("/home/user/./folder/../folder/file.txt"); //   ./ -> diretório atual     ../ -> volta um diretório

        System.out.println("Original: " + path);
        System.out.println("Normalized: " + path.normalize());

        // resolve()    -> entra em um caminho / adiciona algo
        Path absolute = Paths.get("/home/user/DirectoryNIO/files");    // /home -> absoluto
        Path relative = Paths.get("dev/file.txt");   // dev/ -> relativo
        System.out.println("Resolved: " + absolute.resolve(relative));

        // relativize   -> calcula o caminho para chegar de A até B
        Path pathOne = Paths.get("/home/user");
        Path pathTwo = Paths.get("/home/user/projects/java/HelloWorld.java");
        Path relativizePath = pathOne.relativize(pathTwo);  // ambos os Paths precisam ser do mesmo tipo, ambos absolutos ou ambos relativos
        System.out.println("Relativized: " + relativizePath);
    }
}
