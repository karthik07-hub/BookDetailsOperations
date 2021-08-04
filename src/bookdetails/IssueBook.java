package bookdetails;

public class IssueBook {
@Override
	public String toString() {
		return "IssueBook [bookId=" + bookId + ", userId=" + userId + "]";
	}
public String getBookId() {
		return bookId;
	}
	public String getUserId() {
		return userId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
private String bookId;
public IssueBook() {
	super();
	// TODO Auto-generated constructor stub
}
public IssueBook(String bookId, String userId) {
	super();
	this.bookId = bookId;
	this.userId = userId;
}
private String userId;
}
