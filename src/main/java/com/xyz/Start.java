package com.xyz;

import com.xyz.service.OptionsService;

import java.io.IOException;

public class Start {
    public static String filename;

    public static void main(String[] args) throws IOException {
        int secondArgument = args.length - 1;
        int firstArgument = args.length - 2;
        if (args.length > 0) {
            OptionsService optionsService = new OptionsService();
            filename = args[secondArgument];
            if (!optionsService.isReadableFile(filename)) { throw new IOException("input name file with extension!"); }

            if (args.length == 1) { optionsService.validateOptions(args[secondArgument]); }

            if (args.length == 2) {
                for (int i = 0; i < args.length - 1; i++) {
                    optionsService.validateOptions(args[firstArgument]);
                }
            }
        }
        else System.out.println("input correct parameters!");
    }
}
