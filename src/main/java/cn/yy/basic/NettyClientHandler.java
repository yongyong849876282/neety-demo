package cn.yy.basic;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;


//客户端的业务处理类
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    //通道就绪事件
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client:"+ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("老板，还钱吧", CharsetUtil.UTF_8));
    }

    //读取数据事件
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("服务器端发来的消息："+buf.toString(CharsetUtil.UTF_8));
    }
}
