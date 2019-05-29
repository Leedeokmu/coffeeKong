package com.coffeekong;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class TestClass {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C://");
        ByteBuffer byteBuffer = ByteBuffer.allocate(8 * 1024);
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        Future future = channel.read(byteBuffer, 0);
        if(future.isDone()){

        }




    }
}
