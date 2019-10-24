package com.hcl.library;

public class Library {
	private int id;
	private String bookname;
	private String authorname;
	private String dept;
	private int TotalBooks;
	private String edition;
	/**
	 * @return the id
	 */
	public  int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the bookname
	 */
	public String getBookname() {
		return bookname;
	}
	/**
	 * @param bookname the bookname to set
	 */
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	/**
	 * @return the authorname
	 */
	public String getAuthorname() {
		return authorname;
	}
	/**
	 * @param authorname the authorname to set
	 */
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	/**
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	/**
	 * @return the totalBooks
	 */
	public int getTotalBooks() {
		return TotalBooks;
	}
	/**
	 * @param totalBooks the totalBooks to set
	 */
	public void setTotalBooks(int totalBooks) {
		TotalBooks = totalBooks;
	}
	public String getEdition() {
		return edition;
	}
	/**
	 * @param edition the edition to set
	 */
	public void setEdition(String edition) {
		this.edition = edition;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Library [id=" + id + ", bookname=" + bookname + ", authorname=" + authorname + ", dept=" + dept
				+ ", TotalBooks=" + TotalBooks + ", edition=" + edition + "]";
	}

	
	
}
