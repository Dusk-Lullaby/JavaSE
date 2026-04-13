package com.Sonnet.File;
import java.io.File;

public class Example1 {
    public static void main(String[] args) {
        File file1 = new File("D:\\idea_code\\develop\\code\\test\\javaSE-01\\chapter17\\File - test\\file - test.txt");
        File file2 = new File("D:\\idea_code\\develop\\code\\test\\javaSE-01\\chapter17\\File - test", "file - test.txt");
        File parent = new File("D:\\idea_code\\develop\\code\\test\\javaSE-01\\chapter17\\File - test");
        File file3 = new File(parent, "file - test.txt");
    }
}
