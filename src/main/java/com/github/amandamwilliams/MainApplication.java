package com.github.amandamwilliams;

public class MainApplication {
    public static void main(String[] args) {
        Boolean hasClientPassedInCommandLineArgument = args.length > 0;
        ApplicationMenu applicationMenu;
        if(hasClientPassedInCommandLineArgument) {
            applicationMenu = new ApplicationMenu(args[0]);
        } else {
            applicationMenu = new ApplicationMenu();
        }

        String userInput;
        do {
            userInput = applicationMenu.run();
        } while (!"quit".equalsIgnoreCase(userInput));
    }
}
