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


    @RequestMapping(value = "/image/{lat}/{long}/qr")
    public ResponseEntity<byte[]> getImage(@PathVariable("lat") String lat,@PathVariable("long") String longitude ) throws Exception {
        System.out.println("[" + lat + "],["+longitude+"]");
        BufferedImage image = generateQRCodeImage("https://www.google.com/maps/dir//"+lat+","+longitude);
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

    @RequestMapping("/")
    public ModelAndView root(){
        return new ModelAndView("screenInfo");
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
    @RequestMapping("/track/{period}/{vehicleId}")
    public ModelAndView track(@PathVariable("vehicleId") Long vehicleId , @PathVariable("period") Long period) {
        final ModelAndView mav = new ModelAndView("track");
        Optional<Vehicle> maybeVehicle = vehicleService.getNearbyLocations(vehicleId);
        if(!maybeVehicle.isPresent()) {
            System.out.println("Hubo un error en el servicio!");
            return new ModelAndView("redirect:/error");
        }
        mav.addObject("period" , period *1000);
        mav.addObject("vehicle", maybeVehicle.get());
        return mav;
    }

    @RequestMapping("/error")
    public ModelAndView error(){
        final ModelAndView mav = new ModelAndView("error");
        return mav;
    }
}