import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


public class Ex3 {


    /**
     * @return all files under the given directory that end with the given suffix
     */
    public static Stream<Path> findAllFilesEndsWith(Path directory,String suffix) throws IOException {
        return Files.find(directory, Integer.MAX_VALUE, (path, atts) -> path.toString().endsWith(suffix));
    }

    /**
     * @return all words that appear in the given textFile (without deduplication)
     */
    private static Stream<String> findAllWords(Stream<Path> textFiles) throws IOException {
        return textFiles
                .flatMap(rethrow(p -> Files.lines(p.toAbsolutePath())))
                .flatMap(line -> Arrays.stream(line.split(" ")));
    }


    /**
     * @return the number of appearances of each unique word in the given 'words'
     */
    public static Map<String, Long> wordCount(Stream<String> words) {
        return words.collect(groupingBy(identity(), counting()));
    }

    /**
     * @return the number of appearances of each unique word in all java files under the given directory
     */
    public static Map<String, Long> wordCountInJavaFiles(Path directory) throws Exception{

        Stream<Path> allJavaFiles = findAllFilesEndsWith(directory, ",java");

        Stream<String> words = findAllWords(allJavaFiles);

        return wordCount(words);

    }



    public static  <T,R> Function<T,R> rethrow(final FunThrowsChecked<T,R> fThrows ){
        return (T t) -> {
            try {
                return fThrows.apply(t);
            }catch (Exception e){
              throw new RuntimeException("",e);
            }
        };
    }



    interface FunThrowsChecked<T,R> {
        R apply(T t) throws Exception;
    }

}
