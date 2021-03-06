/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author evief
 */
public class Client {
    private Socket clientSocket;
    private BufferedReader input;
    private PrintStream output;
    private Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args){
        Client client = new Client();
        client.run();
    }
    
    public void run(){
        try {
            clientSocket = new Socket("localhost", 9999);
            
            output = new PrintStream(clientSocket.getOutputStream());
            
            output.println("Hello Server");
            
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            while(clientSocket.isConnected()){
            String message = input.readLine();
            System.out.println("Server: " +message);
            
            String reply = scan.nextLine();
            output.println(reply);
                    
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}