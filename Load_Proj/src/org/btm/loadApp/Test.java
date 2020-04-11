package org.btm.loadApp;
public class Test {
	public static void main(String[] args) {
		try {
			Class.forName("org.btm.loadApp.Boy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
