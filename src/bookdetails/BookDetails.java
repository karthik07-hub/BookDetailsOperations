package bookdetails;

import java.io.Serializable;

public class BookDetails implements Serializable{
	@Override
	public String toString() {
		return "BookDetails [bookId=" + bookId + ", bookName=" + bookName + ", writerName=" + writerName + ", price="
				+ price + ", quantity=" + quantity + "]";
	}
	public String getBookId() {
		return bookId;
	}
	public BookDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookDetails(String bookId, String bookName, String writerName, int price, int quantity) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.writerName = writerName;
		this.price = price;
		this.quantity = quantity;
	}
	public String getBookName() {
		return bookName;
	}
	public String getWriterName() {
		return writerName;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	private String bookId;
	private String bookName;
	private String writerName;
	private int price;
	private int quantity;
	

}
