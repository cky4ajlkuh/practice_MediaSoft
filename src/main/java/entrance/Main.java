package entrance;

import command.CommandReader;

public class Main {
    public static void main(String[] args) {
        Authentication.authenticate();
        CommandReader.startReadCommand();
    }
}
