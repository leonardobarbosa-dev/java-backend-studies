package com.leonardobarbosa.javastudy.utils.resourcebundle;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceBundleExample {
    public static void main(String[] args) {

        /*
        ResourceBundle - Internacionalização de mensagens
        externaliza textos do código em arquivos .properties

        Conversão de nomes dos arquivos:
        - messages_en_US.properties    - idioma + país
        - message_en.properties    - só o idioma (sem país)
        - message.properties   - fallback (usado quando nenhum bate)

        Ordem de busca = (idioma + país) -> (só idioma) -> (fallback)

        - criar o arquivo .properties na pasta src do projeto
        */

        // Locale padrão do sistema
        ResourceBundle bundleDefault = ResourceBundle.getBundle("messages", Locale.getDefault());

        // Locale explícito (pt-BR)
        ResourceBundle bundlePtBR = ResourceBundle.getBundle("messages", Locale.of("pt", "BR"));

        // Locale explícito (en-US)
        ResourceBundle bundleEnUS = ResourceBundle.getBundle("messages", Locale.of("en", "US"));

        // Uso básico: leitura de chave
        System.out.println(bundlePtBR.getString("app.name"));

        // Uso com fallback do sistema de escolha de Locale
        String welcomeTemplate = bundleEnUS.getString("app.welcome");

        // MessageFormat: substituição de placeholders {0}, {1}
        String welcome = MessageFormat.format(welcomeTemplate, "Leonardo", "Skywalker");
        System.out.println(welcome);

        // Exemplo de fallback de chave inexistente
        printSafe(bundleDefault, "app.name");

        // Exemplo de tratamento de erro ao acessar chave inexistente
        printMissingKeyExample(bundleDefault, "app.hello");
    }

    // Verifica se a key existe
    private static void printSafe(ResourceBundle bundle, String key) {
        if (bundle.containsKey(key)) {
            System.out.println(bundle.getString(key));
        }
    }

    // Demonstração controlada de exceção (didática)
    private static void printMissingKeyExample(ResourceBundle bundle, String key) {
        try {
            System.out.println(bundle.getString(key));
        } catch (MissingResourceException e) {
            System.out.println("Chave não encontrada: " + e.getKey());
        }
    }
}