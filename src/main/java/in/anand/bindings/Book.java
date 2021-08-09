package in.anand.bindings;

public class Book {
	
	private Integer bookId;
	private String bookname;
	private Double bookprice;
	
	public Book(Integer bookId, String bookname, Double bookprice) {
		super();
		this.bookId = bookId;
		this.bookname = bookname;
		this.bookprice = bookprice;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Double getBookprice() {
		return bookprice;
	}
	public void setBookprice(Double bookprice) {
		this.bookprice = bookprice;
	}
	
	

}
