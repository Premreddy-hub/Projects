package com.hcl.library;

import java.util.List;

public class LibraryBAL {
public static List<Library> searchLibraryBal(String text,String type) {
	return new LibraryDAO().SearchLibrary(text, type);
}
public static String IssueLibraryBal(String[] id,String username) {
	return new LibraryDAO().IssueLibrary(id, username);
}
public static String ReturnLibraryBal(String[] id,String username) {
	return new LibraryDAO().ReturnLibraryDao(id, username);
}
}
