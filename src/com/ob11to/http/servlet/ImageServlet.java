package com.ob11to.http.servlet;

import com.ob11to.http.service.ImageService;
import com.ob11to.http.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;

@WebServlet(UrlPath.IMAGES + "/*")
public class ImageServlet extends HttpServlet {

    private final ImageService imageService = ImageService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var requestURI = req.getRequestURI();
        var imagePath = requestURI.replace(UrlPath.IMAGES, ""); // /user/baki.jpg

        imageService.get(imagePath) //получаем изображение по абсолютному адресу
                .ifPresentOrElse(image -> {
                    resp.setContentType("application/octet-stream");
                    writeImage(image, resp);
                },() -> resp.setStatus(404)); //иначе ошибка
    }

    @SneakyThrows
    private void writeImage(InputStream image, HttpServletResponse resp) {
        try(image; var outputStream = resp.getOutputStream()){
            int currentByte;
            while ((currentByte = image.read()) != -1 ){ //считываем кусками, пока байты не закончатся
                outputStream.write(currentByte);
            }
        }

    }
}
