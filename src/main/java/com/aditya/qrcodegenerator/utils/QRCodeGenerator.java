package com.aditya.qrcodegenerator.utils;

import com.aditya.qrcodegenerator.entity.UsersInfo;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Random;


public class QRCodeGenerator {

    public static void generateQRCode(UsersInfo usersInfo) throws WriterException, IOException {
    String qrCodePath="C:\\Java\\QRCodeGenerator\\QRCodeGenerator\\GeneratedQR\\";
    String QrCodeImageName = qrCodePath + usersInfo.getFirstName()+generateRandomStr() +"-" +"QRCODE.png";
        var QrcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = QrcodeWriter.encode(createDocument(usersInfo), BarcodeFormat.QR_CODE, 200,400 );

        Path path = FileSystems.getDefault().getPath(QrCodeImageName);
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
    }

    private static String createDocument(UsersInfo userData){
        StringBuilder sb = new StringBuilder();
        sb.append("ID");
        sb.append(userData.getId());
        sb.append("\n");
        sb.append("first Name");
        sb.append(userData.getFirstName());
        sb.append("\n");
        sb.append(userData.getLastName());
        sb.append("\n");
        sb.append(userData.getEmail());
        sb.append("\n");
        sb.append(userData.getMobile());
        return sb.toString();

    }
    public static String generateRandomStr() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
        return generatedString;
    }
}
