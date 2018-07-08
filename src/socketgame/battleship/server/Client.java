package socketgame.battleship.server;

import java.net.Socket;

public class Client {
	private Socket socket;
	private String userName;
	private int uid;
	
	public Socket getSocket() {
		return socket;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public int getUid() {
		return uid;
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
}
