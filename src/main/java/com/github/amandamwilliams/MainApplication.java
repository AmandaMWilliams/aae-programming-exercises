package com.github.amandamwilliams;

public class MainApplication {
    public static void main(String[] args) {
        String firstCommandLineArgument = args[0];
        Boolean hasClientPassedInCommandLineArgument = firstCommandLineArgument != null;
        ApplicationMenu applicationMenu;
        if(hasClientPassedInCommandLineArgument) {
            applicationMenu = new ApplicationMenu(firstCommandLineArgument);
        } else {
            applicationMenu = new ApplicationMenu();
        }

        String userInput;
        do {
            userInput = applicationMenu.run();
        } while (!"quit".equalsIgnoreCase(userInput));
    }
}
