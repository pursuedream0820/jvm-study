package com.chen.gc;

/**
 * @author : chenDeHua
 * Time   : 2019-08-01 08:07
 * Desc   :
 * 此代码演示了两点：
 * 1.对象可以在被GC时自我拯救
 * 2.这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统调用一次
 *
 **/
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes, i'm alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize执行优先级很低，所以暂定0.5秒以等待他执行
        Thread.sleep(500);

        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i'm dead");
        }

        // 与上边代码一致，但这次却自救失败了
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);

        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i'm dead");
        }
    }
}
