package com.chen.oom;

/**
 * VM Args : -Xss128k
 * 将栈内存容量设置为128k
 * @author : chenDeHua
 * Time   : 2019-07-30 09:06
 * Desc   :
 **/
public class JavaVMStacksOF {
    private  int stackLength = 1;

    public void stackLeak(){
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStacksOF oom = new JavaVMStacksOF();
//        try {
//            oom.stackLeak();
            oom.stackLeakByThread();
//        } catch (Throwable e) {
//            System.out.println("stack length: "+ oom.stackLength);
//            throw e;
//        }
    }

    private void donStop(){
        while (true){

        }
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    donStop();
                }
            });
            thread.start();
        }
    }
}
