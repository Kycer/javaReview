package com.study.c;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 在这个部分被实现的协议是 TIME 协议。
 * 和之前的例子不同的是在不接受任何请求时他会发送一个含32位的整数的消息，
 * 并且一旦消息发送就会立即关闭连接。在这个例子中，你会学习到如何构建和发送一个消息，
 * 然后在完成时关闭连接
 *
 * @author yk
 * @version 1.0 Date: 12/1/17
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    /**
     *  channelActive() 方法将会在连接被建立并且准备进行通信时被调用。
     *  因此让我们在这个方法里完成一个代表当前时间的32位整数消息的构建工作
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        /*
        * 为了发送一个新的消息，我们需要分配一个包含这个消息的新的缓冲。
        * 因为我们需要写入一个32位的整数，因此我们需要一个至少有4个字节的 ByteBuf。
        * 通过 ChannelHandlerContext.alloc() 得到一个当前的ByteBufAllocator，
        * 然后分配一个新的缓冲
        * */
        final ByteBuf time = ctx.alloc().buffer(4);
        time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

        final ChannelFuture f = ctx.writeAndFlush(time);
        /*f.addListener((ChannelFutureListener) future -> {
            assert f == future;
            ctx.close();
        });*/
        f.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
