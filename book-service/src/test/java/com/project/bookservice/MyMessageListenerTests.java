package com.project.bookservice;

import com.project.bookservice.service.MyMessageListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMessageListenerTests {

    @Test
    @DisplayName("Print the received message to output stream")
    public void receiveMsgTest() {
        MyMessageListener myMessageListener = new MyMessageListener();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        myMessageListener.receiveMsg("test");

        assertEquals("Received: test\r\n",  out.toString());
    }
}
