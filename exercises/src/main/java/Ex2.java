import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex2 {

    /**
     * @return  all strings in msgs that DON't start with any from prefixes
     */
    public static Set<String> filterPrefixes(List<String> prefixes,List<String> msgs){
        return msgs.stream()
                .filter(msg -> prefixes.stream().noneMatch(msg::startsWith))
                .collect(Collectors.toSet());
    }
}
