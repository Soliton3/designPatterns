package com.dp.ResChainModel;

public class FaceFilter implements Filter{
    @Override
    public boolean doFilter(Msg m) {
        m.setMsg(m.getMsg().replace("~","^.^"));
        return true;
    }
}
