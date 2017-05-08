package com.word.count.util;

import java.util.*;
import java.util.Map.Entry;

public class MapUtil {

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> map )
    {
        List<Entry<K, V>> list =
                new LinkedList<Entry<K, V>>( map.entrySet() );
        Collections.sort( list, new Comparator<Entry<K, V>>()
        {
            @Override
            public int compare( Entry<K, V> o1, Entry<K, V> o2 )
            {
                //If needed sort by asc compare o1 -> o2
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Entry<K, V> entry : list)
        {
            result.put( entry.getKey(), entry.getValue() );
        }
        return result;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByName( Map<K, V> map ){
        Map<K,V> result = new TreeMap<>(map);
        return result;
    }
}
