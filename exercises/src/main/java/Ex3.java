import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Stream;


public class Ex3 {


    /**
     * @return all files under the given directory that end with the given suffix
     */
    public static Stream<Path> findAllFilesEndsWith(Path directory,String suffix) throws IOException {
        return null;
    }

    /**
     * @return all words that appear in the given textFile (without deduplication)
     */
    private static Stream<String> findAllWords(Stream<Path> textFiles) throws IOException {
        return null;
    }


    /**
     * @return the number of appearances of each unique word in the given 'words'
     */
    public static Map<String, Long> wordCount(Stream<String> words) {
        return null;
    }

    /**
     * @return the number of appearances of each unique word in all java files under the given directory
     */
    public static Map<String, Long> wordCountInJavaFiles(Path directory) throws Exception{
        return null;
    }


}
