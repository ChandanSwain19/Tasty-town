package com.tastytown.backend.service.impl;

import java.io.IOException;



public interface IImageService {
   byte[] extractFoodImage(String foodImageName)throws IOException;
    
}
