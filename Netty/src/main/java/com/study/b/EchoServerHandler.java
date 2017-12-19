package com.study.b;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 *  对任何都不做反应
 * @author yk
 * @version 1.0 Date: 12/1/17
 */
@SuppressWarnings("Duplicates")
public class EchoServerHandler extends ChannelInboundHandlerAdapter{

    /**
     *  收到消息时被调用, 收到的消息的类型是 ByteBuf
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.writeAndFlush(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
