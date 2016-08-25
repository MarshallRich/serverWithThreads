package com.tiy.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by MacLap on 8/25/16.
 */
public class SampleClient {
    public static void main(String[] args) {
        try {
            // connect to the server on the target port
            Socket clientSocket = new Socket("10.0.0.141", 8005);

            // once we connect to the server, we also have an input and output stream
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // send the server an arbitrary message
            out.println("Hello, I am a Nigerian prince from Nigeria. I need a small loan of american money to sell my oil. I need CC Information, Social Security Number, Bank Account Info as a show of good will. I will reward you with much wealth.");
            // read what the server returns
            String serverResponse = in.readLine();

            // close the connection
            clientSocket.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
