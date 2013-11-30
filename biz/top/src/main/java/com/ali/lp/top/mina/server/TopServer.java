package com.ali.lp.top.mina.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.ali.lp.top.mina.server.handler.SimpleMinaServerHandler;


public class TopServer {

    private SocketAcceptor acceptor;

    @PostConstruct
    public void init() {
        SocketAcceptor  acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        acceptor.getFilterChain().addLast("codec",
                new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        acceptor.setHandler(new SimpleMinaServerHandler());
        acceptor.getSessionConfig().setReadBufferSize(2048);
        
        this.start();
    }

    @PreDestroy
    public void dostory() {
        this.stop();
    }

    public void start() {
        try {
            acceptor.bind(new InetSocketAddress(5080));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        acceptor.dispose();
    }
}
