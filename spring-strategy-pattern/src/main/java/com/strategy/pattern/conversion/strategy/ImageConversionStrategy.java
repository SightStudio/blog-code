package com.strategy.pattern.conversion.strategy;

import java.io.File;

public interface ImageConversionStrategy {
    boolean identify(ImageType from, ImageType to);
    File    convert(File origin);
}
