package com.aneesh.aop;

import java.io.File;
import java.io.IOException;

public class filer {


    public static void main(String[] args) throws IOException {
        String x = "Resources";
        File myfile = new File(x);
        myfile.mkdir();
        File s = new File("Resources/hi.txt");
        s.createNewFile();
    }
}