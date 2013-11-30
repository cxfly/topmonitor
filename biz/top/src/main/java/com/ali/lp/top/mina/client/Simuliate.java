package com.ali.lp.top.mina.client;

import java.util.Random;

import org.springframework.stereotype.Service;


@Service
public class Simuliate {
    
    public boolean simuliateInvoke() {
        boolean result = false;
        Random r = new Random();
        int randomValue= Math.round(r.nextInt(100));
        result = (randomValue != 59);
        try {
            Thread.sleep(Math.round((new Random()).nextInt(1)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        
        
        
        return result;
    }
}
