package com.strategy.pattern.conversion.strategy;

import java.io.File;

public class Gif2WebpConvertService implements ImageConversionStrategy {

    @Override
    public boolean identify(ImageType from, ImageType to) {
        return from == ImageType.JPG && to == ImageType.WEBP;
    }

    @Override
    public File convert(File origin) {
        return null;
    }
}
