package ar.edu.itba.paw.webapp.controller;

import ar.edu.itba.paw.interfaces.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
public class HelloWorldController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public ModelAndView helloWorld() {
        return new ModelAndView("screenInfo");
    }

    @RequestMapping("/users")
    public ModelAndView users(@RequestParam("id") String id){
        final ModelAndView mav = new ModelAndView("screenInfo");
        mav.addObject("greeting", userService.findById(id).getName());
        return mav;
    }


    @RequestMapping(value = "/image/{coordDest}")
    public ResponseEntity<byte[]> getImage(@PathVariable("coordDest") String coordDest ) throws Exception {
        BufferedImage image = generateQRCodeImage("https://www.google.com/maps/dir//"+coordDest);
        return ResponseEntity.ok().body(toByteArray(image, "png"));
    }


    //GENERATE QR CODES

    private BufferedImage generateQRCodeImage(String barcodeText) throws Exception {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =
                barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 400, 400);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }


    // convert BufferedImage to byte[]
    public byte[] toByteArray(BufferedImage bi, String format)
            throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, format, baos);
        byte[] bytes = baos.toByteArray();
        return bytes;

    }


}