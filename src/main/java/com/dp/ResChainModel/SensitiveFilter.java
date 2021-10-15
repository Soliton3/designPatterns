package com.dp.ResChainModel;

public class SensitiveFilter implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        m.setMsg(m.getMsg().replaceAll("996","955"));
        return false;
    }
}
