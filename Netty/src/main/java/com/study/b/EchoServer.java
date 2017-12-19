package com.study.b;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * DISCARD 服务启动
 *
 * @author yk
 * @version 1.0 Date: 12/1/17
 */
@SuppressWarnings("Duplicates")
public class EchoServer {
    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        // NioEventLoopGroup 用来处理I/O操作的多线程事件循环器
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // 用来接收进来的连接
        EventLoopGroup workerGroup = new NioEventLoopGroup(); // 用来处理已经被接收的连接
        try {
            //启动 NIO 服务的辅助启动类
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // 指定使用 NioServerSocketChannel 类来举例说明一个新的 Channel 如何接收进来的连接
                    .childHandler(new ChannelInitializer<SocketChannel>() { // ChannelInitializer 是一个特殊的处理类，他的目的是帮助使用者配置一个新的 Channel
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoServerHandler());
                        }
                    })

                    /*
                    * option() 是提供给NioServerSocketChannel 用来接收进来的连接。
                    * childOption() 是提供给由父管道 ServerChannel 接收到的连接，
                    * 在这个例子中也是 NioServerSocketChannel
                    * */
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            // 绑定端口，开始接收进来的连接
            ChannelFuture f = b.bind(port).sync();
            // 等待服务器  socket 关闭 。
            // 在这个例子中，这不会发生，但你可以优雅地关闭你的服务器。
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        System.out.println(port);
        new EchoServer(port).run();
    }
}
