/**
 *
 *  @author Gazi Ataberkan S28457
 *
 */

package zad1;

import java.util.*;
import java.util.stream.Collectors;

public class ListCreator<T> {
    private List<T> sourceList;

    private ListCreator(List<T> src) {
        this.sourceList = src;
    }

    public static <T> ListCreator<T> collectFrom(List<T> src) {
        return new ListCreator<>(src);
    }

    public ListCreator<T> when(Selector<T> selector) {
        sourceList = sourceList.stream()
                               .filter(selector::select)
                               .collect(Collectors.toList());
        return this;
    }

    public <R> List<R> mapEvery(Mapper<T, R> mapper) {
        return sourceList.stream()
                         .map(mapper::map)
                         .collect(Collectors.toList());
    }
}