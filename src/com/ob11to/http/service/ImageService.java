package com.ob11to.http.service;

import com.ob11to.http.util.PropertiesUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageService {

    private final String basePath = PropertiesUtil.get("image.base.url");

    private static final ImageService IMAGE_SERVICE = new ImageService();

    public static ImageService getInstance(){
        return IMAGE_SERVICE;
    }

    @SneakyThrows
    public void upload(String imagePath, InputStream imageContent){
        var fullPath = Path.of(basePath, imagePath);
        try(imageContent){
            Files.createDirectories(fullPath.getParent()); //создать директории, если их нет
            Files.write(fullPath,imageContent.readAllBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }

}
