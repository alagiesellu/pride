package com.filter.iguru;

import java.io.FileNotFoundException;

public interface SpamScanner{

	void scan(String subject, String msg) throws FileNotFoundException;
	String result();
}
