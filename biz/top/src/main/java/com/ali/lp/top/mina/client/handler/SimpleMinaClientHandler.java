package com.ali.lp.top.mina.client.handler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleMinaClientHandler extends IoHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(SimpleMinaClientHandler.class);

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        logger.info("sessionCreated: " + session);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        logger.info("sessionOpened: " + session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        logger.info("sessionClosed: " + session);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        logger.info("sessionIdle: " + session);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        logger.info("messageReceived: " + session + ", message=" + message);
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        super.exceptionCaught(session, cause);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        logger.info("messageSent: " + session + ", message=" + message);
    }

}
