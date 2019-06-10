package com.bookstore.bookstore.util;

/**
 * @program: bookstore
 * @author: xuan
 * @create: 2019-06-08 15:23
 **/
public class RecordNoUtils {
    //这里的0，0分别是      * @param workerId 工作ID (0~31)     * @param datacenterId 数据中心ID (0~31)，可以写在配置文件中。
    private static UniqueOrderGenerate idWorker = new UniqueOrderGenerate(0, 0);

    public static RecordNoUtils getInstance() {
        return new RecordNoUtils();
    }

    public String get() {
        return String.valueOf(idWorker.nextId());
    }

}