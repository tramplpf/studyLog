package config.proxybeanmethod;


public class MyBean02 {

    private MyBean01 myBean01;

    public MyBean02(MyBean01 myBean01) {
        System.out.println("调用MyBean02的构造方法");
        this.myBean01 = myBean01;
    }

    public MyBean01 getMyBean01() {
        return myBean01;
    }

    public void setMyBean01(MyBean01 myBean01) {
        this.myBean01 = myBean01;
    }
}
