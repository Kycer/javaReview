package com.study.a2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 *  对任何都不做反应
 * @author yk
 * @version 1.0 Date: 12/1/17
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter{

    /**
     *  收到消息时被调用, 收到的消息的类型是 ByteBuf
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        try {
            while (in.isReadable()) { // 这个低效的循环事实上可以简化 System.out.println(in.toString(io.netty.util.CharsetUtil.US_ASCII))
                System.out.print((char) in.readByte());
                System.out.flush();
            }
        } finally {
            ReferenceCountUtil.release(msg); // 你可以在这里调用 in.release()
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
