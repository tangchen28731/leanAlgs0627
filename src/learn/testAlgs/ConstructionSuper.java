package learn.testAlgs;

public class ConstructionSuper {
    public ConstructionSuper(){
        System.out.println("base");
    }
    public ConstructionSuper(int i){
        this();
    }
/*调用同类的其他构造方法 用this
    public test.ConstructionSuper(int i){
        test.ConstructionSuper();
    }*/
}
