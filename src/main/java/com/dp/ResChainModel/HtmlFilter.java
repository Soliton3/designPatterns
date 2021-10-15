package com.dp.ResChainModel;

public class HtmlFilter implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        m.setMsg(m.getMsg().replaceAll("<","["));
        m.setMsg(m.getMsg().replaceAll(">","]"));
        return true;
    }
}
