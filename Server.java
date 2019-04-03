/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author evief
 */
public class Server {
    
    private ServerSocket serverSocket;
    private Socket acceptSocket;
    private PrintStream output;
    private BufferedReader input;
    private Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args){
        Server server = new Server();
        server.run();
    }
    
    public void run(){
        try {
            serverSocket = new ServerSocket(9999);
            
            acceptSocket = serverSocket.accept();
            
            output = new PrintStream(acceptSocket.getOutputStream());
            
            input = new BufferedReader(new InputStreamReader(acceptSocket.getInputStream()));
            
            while(acceptSocket.isConnected()){
                String message = input.readLine();
                System.out.println("Client: " + message);
                
                String reply = scan.nextLine();
                output.println(reply);
            }
         
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}