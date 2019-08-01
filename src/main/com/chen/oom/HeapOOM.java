package com.chen.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * vm Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 将堆的最小值-Xms 参数与最大值-Xmx参数设置为一样即可避免堆自动扩展
 * 通过参数-XX:+HeapDumpOnOutOfMemoryError可以让虚拟机在出现内存溢出异常时dump出当前的内存堆
 * 转储快照以便时候进行分析
 *
 *
 * @author : chenDeHua
 * Time   : 2019-07-30 08:28
 * Desc   :
 **/
public class HeapOOM {
    private static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
