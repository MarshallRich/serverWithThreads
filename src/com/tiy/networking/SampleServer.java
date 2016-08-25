package com.tiy.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by MacLap on 8/25/16.
 */
public class SampleServer /*implements Runnable*/ {
    public SampleServer() {
    }

    Socket clientSocket = null;

    public SampleServer(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

//    public void run() {
//        try {
//            handleIncomingConnection(clientSocket);
//        }
//        catch (IOException exception){
//            exception.printStackTrace();
//        }
//    }

    public void startServer() {

        try {
            System.out.println("starting server...");
            ServerSocket serverListener = new ServerSocket(8080);
            System.out.println("Listener ready to accept connections ...");

            while (true) {
                Socket incomingConnection = serverListener.accept();
//                SampleServer handlingServer = new SampleServer(clientSocket);
//                // use a new thread to hand the socket to
//                Thread handlingThread = new Thread(handlingServer);
//                handlingThread.start();
//                handleIncomingConnection(incomingConnection);

                ConnectionHandler handler = new ConnectionHandler(incomingConnection);
                Thread handlerThread = new Thread(handler);
                handlerThread.start();
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


}