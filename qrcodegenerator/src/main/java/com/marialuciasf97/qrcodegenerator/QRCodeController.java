package com.marialuciasf97.qrcodegenerator;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.google.zxing.WriterException;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class QRCodeController {

    private final QRCodeService service = new QRCodeService();

    @GetMapping(value = "/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] qrcode(@RequestParam String url,
                         @RequestParam(defaultValue = "512") int size) throws WriterException, IOException {
        return service.generatePngBytes(url, size);
    }
}
