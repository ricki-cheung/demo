package com.example.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.util.Date;
import java.util.Iterator;

public class NioClient {
	//管道管理器
    private Selector selector;
    public static  AbstractSelectableChannel tempChannel;
    
    public NioClient init(String serverIp, int port) throws IOException{
        //获取socket通道
        SocketChannel channel = SocketChannel.open();
        tempChannel = channel;
        System.out.println("tempChannel:"+tempChannel);
        
        channel.configureBlocking(false);
        //获得通道管理器
        selector=Selector.open();
        
        //客户端连接服务器，需要调用channel.finishConnect();才能实际完成连接。
        channel.connect(new InetSocketAddress(serverIp, port));
        //为该通道注册SelectionKey.OP_CONNECT事件
        channel.register(selector, SelectionKey.OP_CONNECT);
        return this;
    }
    
    public void listen() throws IOException{
        System.out.println("客户端启动");
        //轮询访问selector
        while(true){
            //选择注册过的io操作的事件(第一次为SelectionKey.OP_CONNECT)
            selector.select();
            Iterator<SelectionKey> ite = selector.selectedKeys().iterator();
            while(ite.hasNext()){
                SelectionKey key = ite.next();
                //删除已选的key，防止重复处理
                ite.remove();
                if(key.isConnectable()){
                	printKeyInfo("Connectable",key);
                    SocketChannel channel=(SocketChannel)key.channel();
                    System.out.println("connectable channel:"+channel);
                    System.out.println("connectable channel==tempChannel:"+(channel==tempChannel));
                    
                    //如果正在连接，则完成连接
                    if(channel.isConnectionPending()){
                        channel.finishConnect();
                    }
                    
                    channel.configureBlocking(false);
                    //向服务器发送消息
                    channel.write(ByteBuffer.wrap(new String("send message to server.").getBytes()));
                    
                    //连接成功后，注册接收服务器消息的事件
                    channel.register(selector, SelectionKey.OP_READ);
                    System.out.println("客户端连接成功");
                }else if(key.isReadable()){ //有可读数据事件。
                	printKeyInfo("Readable",key);
                	try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
                    SocketChannel channel = (SocketChannel)key.channel();
                    System.out.println("readable channel==tempChannel:"+(channel==tempChannel));
                    
                    ByteBuffer buffer = ByteBuffer.allocate(10);
                    channel.read(buffer);
                    byte[] data = buffer.array();
                    String message = new String(data);
                    
                    System.out.println("recevie message from server:, size:" + buffer.position() + " msg: " + message);
//                    ByteBuffer outbuffer = ByteBuffer.wrap(("client.".concat(msg)).getBytes());
//                    channel.write(outbuffer);
                    //channel.write(ByteBuffer.wrap("i am so sorry!".getBytes()));
                }
            }
        }
    }
    
    private static void printKeyInfo(String tag,SelectionKey sk)
    {
       String s = new String("tag:"+tag);
       s += ",Att: " + (sk.attachment() == null ? "no" : "yes");
       s += ", Read: " + sk.isReadable();
       s += ", Acpt: " + sk.isAcceptable();
       s += ", Cnct: " + sk.isConnectable();
       s += ", Wrt: " + sk.isWritable();
       s += ", Valid: " + sk.isValid();
       s += ", Ops: " + sk.interestOps();
       System.out.println(s);
    }
    
    public static void main(String[] args) throws IOException {
        new NioClient().init("127.0.0.1", 9981).listen();
    }
}
