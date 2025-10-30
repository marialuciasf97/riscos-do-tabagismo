package com.marialuciasf97.qrcodegenerator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Path;

@SpringBootApplication
public class QrcodegeneratorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(QrcodegeneratorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String siteUrl = "https://marialuciasf97.github.io/riscos-do-tabagismo/";
        Path out = Path.of("../docs/assets/qrcode.png"); // relativo ao módulo
        QRCodeService service = new QRCodeService();
        service.generatePngFile(siteUrl, 512, out); // 512px = bom p/ impressão e slides
        System.out.println("QR Code gerado em: " + out.toAbsolutePath());
    }
}
