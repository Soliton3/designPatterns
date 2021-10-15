package com.dp.ResChainModel;

public class URLFilter implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        m.setMsg(m.getMsg().replace("github.com/Soliton3","https://github.com/Soliton3"));
        return true;
    }
}
