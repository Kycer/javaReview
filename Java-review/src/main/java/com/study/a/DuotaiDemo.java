package com.study.a;

/**
 * @author yksoul
 * @date 2017/2/23
 */
class duoTaiFu{
    public void show(){
        System.out.println("show Fu");
    }
}

class  duoTaiZi1 extends  duoTaiFu{

    @Override
    public void show() {
        System.out.println("show zi1");
    }
}

class  duoTaiZi2 extends duoTaiFu{
    @Override
    public void show() {
        System.out.println("show zi2");
    }
}
public class DuotaiDemo {
    public static void main(String[] args) {
        duoTaiZi1 zi1 = new duoTaiZi1();
        duoTaiFu zi2 = new duoTaiZi2();
        duoTaiZi2 zi = (duoTaiZi2) zi2;
        zi1.show();
        zi2.show();
        zi.show();
    }
}
