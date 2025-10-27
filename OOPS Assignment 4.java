// QuizServer.java
import java.net.*;
import java.util.*;

public class QuizServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress clientAddress = InetAddress.getByName("localhost");
            Scanner sc = new Scanner(System.in);

            String[] questions = {
                "1. What is the capital of India?\nA) Mumbai\nB) Delhi\nC) Chennai\nD) Kolkata",
                "2. Which language is used for Android development?\nA) Python\nB) Java\nC) Swift\nD) C++",
                "3. Who developed Java?\nA) Microsoft\nB) Google\nC) Sun Microsystems\nD) Oracle"
            };
            char[] answers = {'B', 'B', 'C'};

            for (int i = 0; i < questions.length; i++) {
                byte[] sendData = questions[i].getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, 9876);
                socket.send(sendPacket);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String clientAnswer = new String(receivePacket.getData()).trim();
                System.out.println("Client answered: " + clientAnswer);

                if (clientAnswer.equalsIgnoreCase(String.valueOf(answers[i]))) {
                    System.out.println("Answer is correct!");
                } else {
                    System.out.println("Answer is incorrect!");
                }
                System.out.println("-------------------------");
            }

            String endMsg = "END";
            socket.send(new DatagramPacket(endMsg.getBytes(), endMsg.length(), clientAddress, 9876));
            socket.close();
            System.out.println("Quiz Finished.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}



// QuizClient.java
import java.net.*;
import java.util.*;

public class QuizClient {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);
            Scanner sc = new Scanner(System.in);

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String question = new String(receivePacket.getData()).trim();
                if (question.equals("END")) {
                    System.out.println("Quiz Completed!");
                    break;
                }

                System.out.println("\n" + question);
                System.out.print("Enter your answer (A/B/C/D): ");
                String answer = sc.nextLine();

                InetAddress serverAddress = receivePacket.getAddress();
                int serverPort = receivePacket.getPort();
                byte[] sendData = answer.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                socket.send(sendPacket);
            }

            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

