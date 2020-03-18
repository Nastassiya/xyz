package com.xyz;

import com.xyz.service.OptionsService;

import java.io.IOException;

public class Start {
    public static String filename;

    public static void main(String[] args) {
        if (args.length > 0 && args.length <= 2) {
            OptionsService optionsService = new OptionsService();
            filename = args[args.length - 1];

            if (!optionsService.isReadableFile(filename)) {
                System.out.println("file is empty or not correctly name of file!");
            }
            optionsService.validateOptions(args[0]);

        } else System.out.println("input correct parameters!");
    }
}
