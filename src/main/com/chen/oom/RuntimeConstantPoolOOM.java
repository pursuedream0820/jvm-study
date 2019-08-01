package com.chen.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2019-07-31 07:34
 * Desc   :
 **/
public class RuntimeConstantPoolOOM {
//    public static void main(String[] args) {
//        // 使用List保持着常量池引用，避免Full GC回收常量池行为
//        List<String> list = new ArrayList<>();
//        int i = 1;
//        while (true){
//            list.add(String.valueOf(i++).intern());
//        }
//    }


    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
