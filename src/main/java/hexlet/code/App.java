package hexlet.code;

import picocli.CommandLine.*;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import hexlet.code.Differ;
import java.io.File;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
         description = "Compares two configuration files and shows a difference.")

class App implements Callable<Integer> {

    @Parameters(index = "0", description = "path to first file")
    private File filepath1;
    @Parameters(index = "1", description = "path to second file")
    private File filepath2;

    @Option(names = {"-f", "--format=format"}, description = "output format [default: stylish]")
    private String format;

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        System.out.println(Differ.generate(format, filepath1, filepath2));
        return null;
    }


    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

