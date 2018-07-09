package socketgame.battleship.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	static final int PORT = 9999;
	private static ExecutorService executorService;

	public static void main(String[] args) {
		try (
			ServerSocket serverSocket = new ServerSocket(PORT);
		) {
			executorService = Executors.newCachedThreadPool();
			while(true) {
				try (
					Socket clientSocket = serverSocket.accept();
				) {
					ClientHandler handler = new ClientHandler(clientSocket);
					executorService.submit(handler);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}				
	}
}
