package com.dp.ResChainModel;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter f){
        filters.add(f);
        return this;
    }

    public boolean doFilter(Msg m){
        for (Filter f : filters){
            if (!f.doFilter(m))
                return false;
        }
        return true;
    }
}
