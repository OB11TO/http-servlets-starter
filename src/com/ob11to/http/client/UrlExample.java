package com.ob11to.http.client;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class UrlExample {
    public static void main(String[] args) throws IOException {
        //extracted(); fileResult(); savePhoto();
    }


    private static void savePhoto() throws IOException {
        String bakiYandexPhoto = """
                https://yandex-images.clstorage.net/tVTZ95453/a92e8fXRqXbM/-sMVRmXdsvgnnZZ-X7b8YAyy6fItAQuK_6MOXQxX2Fz9yC8OhxA6VVl1M94D9FMOMv5JFtpbyCDiPszFFY0CWKpi4ZNx6DP4I5yRa9-yWLTJtyyn-eDuavvy-y1NVnzc-H7KSoYU_1D8c0POc5Wh_JDPrmVtON_3BcmtdUAId5xLhsDlh0mg-1Ud4axPZbuz3iB5QE43e7sOR71f3cJanv86vc9ldEzATgCXe6SygnxCjD0U_ZvtFwV5P4bximUvj5eQJUXdsIt3zOIe7zaYE65xC8Ju54s7j7U87T-Bus7uGV4-5RRd8M6gNvkGslGdk8_PxZ_rzwUUOV2UcrqFXP10gIYUbCMJBj0i7R0mqFF_4Knz38TrWM61bt0OMjnNz4jNvkY2rAEPs7XZxOAyzhL83da-qM4n13l8xlL4lx-uNaHGZF3xyIXv4v3t5ouivGEIEmx1mbhdZ99_HwO7rY_Jbtyl99wDfoCm6aTiQh1QzpxkHZrvpyWYD3fBaNRdrVSCtKedEQhWPnEebmU70S_QKvNdt1j7nLTurD4iKK_Oen8dB7avAswCdHpmMHM8Y_3std3qfXRHmQ9nMnkkXTxncPd0rxE6pD6C_m7WusNPkJkSjSSIC62mjHzOUkq_jesvPTc33XJ-UjTL1FBgbHKtjWYOqMw2BzouNmKbdu8uNqPF9R8SOwScMt4vVyoAnfKZcD3laRmvpv-P3GN4zv_LPCy2FN-jLDKV6UZwUvwB_B8mPFuN1kZo3AYTiRTtbcTCpEQ_48iEzPB9nNZp8Q7iOYNeNbspn6XvjM2xKKwdu29vVne8UL0BlelG0bGPc84-NN27jDc2-R41g8rWT5wFMLZU__NZBfzhH-50uKCd4PjwLfULeh51D40sghuvn-ttv2RnzRBvskZL1OEjniGP7hUemd3H56s-dmJIB_09hKKk1SyBSlfcY_zfhyphjtKq495XSFnu18yOY""";

        var url = new URL(bakiYandexPhoto);
        var urlConnection = url.openConnection();
        var inputStream = urlConnection.getInputStream();

        var path = Path.of("/home/obiito/c/java/full_day/java_prac/demDev/http-servlets-starter/src/com/ob11to/http/test/BakiHanma.jpg");
        Files.copy(inputStream, path);
    }

    private static void fileResult() throws IOException {
        String file = "file:/home/obiito/c/java/full_day/java_prac/demDev/http-servlets-starter/src/com/ob11to/http/client/UrlExample.java";
        var url = new URL(file);
        var result = new String(url.openConnection().getInputStream().readAllBytes());
        System.out.println(result);
    }


    /**
     * Считывает HTML страницы
     */
    private static void extracted() throws IOException {
        var url = new URL("https://google.com");
        var connection = url.openConnection();
        var bytes = connection.getInputStream().readAllBytes();
        String result = new String(bytes);
        System.out.println(result);
    }
}
