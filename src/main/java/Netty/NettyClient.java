package Netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @Author sannian
 * @Date 2021/1/18 13:59
 * @Version 1.0
 */

public class NettyClient {
    public static void main(String[] args) throws Exception {
        //客户端需要一个事件循环组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //创建客户端启动对象
            //注意客户端使用的不是 ServerBootstrap 而是 Bootstrap
            Bootstrap bootstrap = new Bootstrap();
            //设置相关参数
            //设置线程组
            bootstrap.group(group)
                    // 使用 NioSocketChannel 作为客户端的通道实现
                    .channel(NioSocketChannel.class)
                    .handler(
                            new ChannelInitializer<NioSocketChannel>() {
                                 @Override
                                 protected void initChannel(NioSocketChannel ch)
                                         throws Exception {
                                     ChannelPipeline pipeline = ch.pipeline();
                                     pipeline.addLast("encoder",new StringEncoder());
                                     pipeline.addLast("decoder",new StringDecoder());
                                     pipeline.addLast(new NettyClientHandler());
                                 }
                             }

//                        (ChannelInitializer)(ch) ->{
//                        ChannelPipeline pipeline = ch.pipeline();
//                        pipeline.addLast(new StringEncoder());
//                        pipeline.addLast(new StringDecoder());
//                        pipeline.addLast(new NettyClientHandler());
//                        }
                    );
            //启动客户端去连接服务器端
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9000).sync();
            Channel channel = channelFuture.channel();
            System.out.println("==========="+channel.localAddress()+"===========");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                String msg = scanner.nextLine();
                channel.writeAndFlush(msg);
            }
            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
