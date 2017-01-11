import org.junit.Test;

import java.nio.file.Paths;

/**
 * @author victorp
 */
public class Ex3Test {


    @Test
    public void wordCountInJavaFilesTest() throws Exception {
        System.out.println(Ex3.wordCountInJavaFiles(Paths.get("your full path")));
    }
}
