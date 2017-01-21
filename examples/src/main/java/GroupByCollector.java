import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author victorp
 */
public class GroupByCollector<F,R> implements Collector<R, Map<F,List<R>>, Map<F,List<R>>>{
    private final Function<R,F> groupBy;

    public GroupByCollector(Function<R, F> groupBy) {
        this.groupBy = groupBy;
    }


    @Override
    public Supplier<Map<F, List<R>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<F, List<R>>, R> accumulator() {
        return (map,element)-> {
            F gBy = groupBy.apply(element);
            List<R> list = map.get(gBy);
            if (list == null){
                list = new LinkedList<>();
                map.put(gBy,list);
            }
            list.add(element);
        };
    }

    @Override
    public BinaryOperator<Map<F, List<R>>> combiner() {
        return (a,b) -> b ;
    }

    @Override
    public Function<Map<F, List<R>>, Map<F, List<R>>> finisher() {
        return a -> a;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
    }
}
