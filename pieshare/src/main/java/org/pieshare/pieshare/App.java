package org.pieshare.pieshare;

import java.util.Scanner;
import org.pieshare.cloudManagement.HazelcastConnector;
import org.pieshare.cloudManagement.ICloudConnector;
import org.pieshare.common.PieceOfPie;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Welcome to pieShare!");
        
        ICloudConnector connector = new HazelcastConnector();
        connector.connectToCloud("myPieCloud", "");
        
        Scanner sc = new Scanner(System.in);
        String command = "";
        
        while(!command.equals("exit"))
        {
            System.out.println("You command, your highness?");
            command = sc.nextLine();
            
            if(command.startsWith("put"))
            {
                String[] splited = command.split(" ");
                PieceOfPie piece = new PieceOfPie();
                piece.setName(splited[2]);
                connector.getMap().put(splited[1], piece);
            }
            else if(command.startsWith("get"))
            {
                String[] splited = command.split(" ");
                System.out.println(connector.getMap().get(splited[1]).getName());
            }
        }
    }
}
