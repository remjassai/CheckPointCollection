package CheckpointTwo.txt;
import java.io.IOException;
import java.util.*;

import static CheckpointTwo.txt.checkpointTwo.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = processFile("src/resources/ChelseaManning.txt");
        Map<Character,Integer> firstChar = processLines(lines);
        System.out.println(firstChar);
        writeResult("src/resources/recreatedFromMapOutput.txt",firstChar);
    }
}

