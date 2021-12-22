package ar.edu.itba.paw.webapp.controller;

import ar.edu.itba.paw.interfaces.services.VehicleService;
import ar.edu.itba.paw.models.Vehicle;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

@Controller
public class VehicleController {
    @Autowired
    VehicleService vehicleService;


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

    @RequestMapping("/test/{vehicleId}")
    public ModelAndView main(@PathVariable("vehicleId") Long vehicleId) {
        final ModelAndView mav = new ModelAndView("test");
        Optional<Vehicle> maybeVehicle = vehicleService.getNearbyLocations(vehicleId);

        if(!maybeVehicle.isPresent()) {
            System.out.println("Hubo un error en el servicio!");
            return new ModelAndView("redirect:/error");
        }

        mav.addObject("vehicle", maybeVehicle.get());
        return mav;
    }

    @RequestMapping("/error")
    public ModelAndView error(){
        final ModelAndView mav = new ModelAndView("error");
        return mav;
    }
}