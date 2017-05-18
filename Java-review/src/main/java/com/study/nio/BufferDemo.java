package com.study.nio;

import java.nio.ByteBuffer;

/**
 * 缓冲区中的四个核心属性
 *
 * capacity: 容量，表示缓冲区中最大的存储数据容量。一般申明就不能改变
 * limit: 界限，表示缓冲区中可以操作的数据大小
 * position: 位置，表示缓冲区中正在操作数据的位置
 *
 * mark: 标记
 *
 * 0 <= mark <= position <= limit  <= capacity
 * @author yksoul
 * @date 2017/2/23
 */
public class BufferDemo {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("-----------------allocate()--------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.put("abcde".getBytes());

        System.out.println("-----------------put()--------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.flip();

        System.out.println("-----------------flip()--------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());


        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println(new String(dst, 0 , dst.length));
        System.out.println("-----------------get()--------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());


        buffer.rewind();// 重复读取数据

        System.out.println("-----------------rewind()--------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.clear();// 清空缓冲区， 缓冲区的数据依然存在

        System.out.println("-----------------clear()--------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

    }
}
