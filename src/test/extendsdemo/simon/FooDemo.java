package extendsdemo.simon;

/**
 * Created by xiaotao on 2017/5/23.
 */
public class FooDemo {

    public void testFoo(){
        this.fun();
    }
    public void fun(){
        System.out.println("foo  "+this.getClass().getSimpleName());
    }
}
