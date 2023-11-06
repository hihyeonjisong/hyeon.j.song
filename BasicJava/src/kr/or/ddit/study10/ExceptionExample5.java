package kr.or.ddit.study10;

import java.io.IOException;
import java.nio.file.Files;

public class ExceptionExample5 {
	public static void main(String[] args) {
		try {
			Files.readAllLines(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
