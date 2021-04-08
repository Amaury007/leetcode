package Netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author sannian
 * 自定义Handler需要继承netty规定好的某个HandlerAdapter(规范)
 */

public class NettyServerHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 当客户端连接服务器完成就会触发该方法
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[客户端]"+channel.remoteAddress()+"上线了"+simpleDateFormat.format(new Date())+"\n");
        channelGroup.add(channel);
        System.out.println(ctx.channel().remoteAddress()+"上线了"+"\n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[客户端]"+channel.remoteAddress()+"下线了"+"\n");
        System.out.println(ctx.channel().remoteAddress()+"下线了");
        System.out.println("channelGroup size =" +channelGroup.size());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch -> {
            if (channel != ch){
                ch.writeAndFlush("[ 客户端 ]"+channel.remoteAddress()+"发送了消息："+msg+"\n");
            }else {
                ch.writeAndFlush("[ 自己 ]发送了消息："+msg +"\n");
            }
        });
//        ByteBuf buf = (ByteBuf) msg;
//        System.out.println("收到服务端的消息:" + buf.toString(CharsetUtil.UTF_8));
//        System.out.println("服务端的地址： " + ctx.channel().remoteAddress());
    }

}
