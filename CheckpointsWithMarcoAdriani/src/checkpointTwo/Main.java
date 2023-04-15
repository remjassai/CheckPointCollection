package checkpointTwo;
import java.io.IOException;
import java.util.*;

import static checkpointTwo.checkpointTwo.*;


public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = processFile("CheckpointsWithMarcoAdriani/src/resources/ChelseaManning.txt");
        Map<Character,Integer> firstChar = processLines(lines);
        System.out.println(firstChar);
        writeResult("CheckpointsWithMarcoAdriani/src/resources/recreatedFromMapOutput.txt",firstChar);
    }
}

