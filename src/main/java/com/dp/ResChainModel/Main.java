package com.dp.ResChainModel;

public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("~ Hello everyone, <script> 大家好 </script>,do you want to 996!,join in github.com/Soliton3");


        FilterChain filterChain = new FilterChain();
        filterChain.add(new SensitiveFilter())
                .add(new HtmlFilter());

        FilterChain fc = new FilterChain();
        fc.add(new FaceFilter()).add(new URLFilter());

        filterChain.add(fc);
        filterChain.doFilter(msg);

        System.out.println(msg);
    }
}
