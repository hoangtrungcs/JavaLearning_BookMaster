package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnection.DBConnection;

//Class for get set data to database
public class SqlDataProcess {

	DBConnection _connection = new DBConnection();

	public SqlDataProcess() {

	}

	// Get all the list books
	public ArrayList<BookModelForm> GetAllBooks() throws SQLException {

		if (_connection.OpenConnection()) {
			ResultSet rs = _connection.GetData("SELECT * FROM " + '"'
					+ "dbo" + '"' + "." + '"' + "TBL_BOOK" + '"' + "");
			ArrayList<BookModelForm> listBook = new ArrayList<BookModelForm>();
			while (rs.next()) {
				BookModelForm book = new BookModelForm();
				book.setBookid(rs.getString("book_id"));
				book.setBookTitle(rs.getString("book_title"));
				book.setAuthorName(rs.getString("author_name"));
				book.setPublisher(rs.getString("publisher"));
				book.setPublicationDay(rs.getDate("publication_day").toString());
				listBook.add(book);
			}
			_connection.CloseConnection();
			return listBook;
		}
		_connection.CloseConnection();
		return new ArrayList<BookModelForm>();
	}

	public boolean BookIsExists(String bookId) throws SQLException {
		try {
			if (bookId != null) {
				if (_connection.OpenConnection()) {
					ResultSet rs = _connection.GetData("SELECT * FROM " + '"'
							+ "dbo" + '"' + "." + '"' + "TBL_BOOK" + '"'
							+ " where book_id='" + bookId + "' ");
					while (rs.next()) {
						return true;
					}
				}
				return false;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

	// Get book by book id
	public BookModelForm GetBookById(String bookId) throws SQLException {
		BookModelForm book = new BookModelForm();
		if (bookId != null) {
			if (_connection.OpenConnection()) {
				ResultSet rs = _connection.GetData("SELECT * FROM " + '"'
						+ "dbo" + '"' + "." + '"' + "TBL_BOOK" + '"'
						+ " where book_id='" + bookId + "' ");
				while (rs.next()) {
					book.setBookid(rs.getString("book_id"));
					book.setBookTitle(rs.getString("book_title"));
					book.setAuthorName(rs.getString("author_name"));
					book.setPublisher(rs.getString("publisher"));
					book.setPublicationDay(rs.getDate("publication_day")
							.toString());
				}
			}
			_connection.CloseConnection();
			return book;
		}
		_connection.CloseConnection();
		return book;
	}

	// Update the book
	public int UpdateBook(BookModelForm book) throws SQLException {
		try {
			if (book != null) {
				if (_connection.OpenConnection()) {
					if (!BookIsExists(book.getBookid())) {
						return Enums.ErrorsManage.BOOKID_NOTFOUND.getErrorNumber();
					}

					int rs = _connection.ExcuteUpdate("UPDATE " + '"'
							+ "dbo" + '"' + "." + '"' + "TBL_BOOK" + '"'
							+ "SET book_title='" + book.getBookTitle()
							+ "',author_name='" + book.getAuthorName()
							+ "',publisher='" + book.getPublisher()
							+ "',publication_day='" + book.getPublicationDay()
							+ "' " + " where book_id='" + book.getBookid()
							+ "' ");
					_connection.CloseConnection();
					if(rs==1)
						return Enums.ErrorsManage.UPDATE_SUCCESSFULL.getErrorNumber();
					else if(rs==-1)
						return Enums.ErrorsManage.UPDATE_FAIL.getErrorNumber();
					else
						return Enums.ErrorsManage.DB_ERROR.getErrorNumber();
				}
				_connection.CloseConnection();
				return Enums.ErrorsManage.DB_ERROR.getErrorNumber();
			}
			_connection.CloseConnection();
			return Enums.ErrorsManage.DB_ERROR.getErrorNumber();
		} catch (Exception ex) {
			System.out.println("######################" + ex.toString());
			_connection.CloseConnection();
			return Enums.ErrorsManage.DB_ERROR.getErrorNumber();
		}
	}

	// Insert the book
	public int InsertBook(BookModelForm book) throws SQLException {
		try {
			if (book != null) {
				if (_connection.OpenConnection()) {
					
					if (BookIsExists(book.getBookid())) {
						System.out.println("insert exists");
						return Enums.ErrorsManage.BOOKID_EXISTS.getErrorNumber();
					}
					int rs = _connection.ExcuteUpdate("INSERT INTO " + '"'
							+ "dbo" + '"' + "." + '"' + "TBL_BOOK" + '"'
							+ "VALUES ('" + book.getBookid() + "', '"
							+ book.getBookTitle() + "','"
							+ book.getAuthorName() + "','"
							+ book.getPublisher() + "','"
							+ book.getPublicationDay() + "') ");

					_connection.CloseConnection();
					if(rs==1)
						return Enums.ErrorsManage.INSERT_SUCCESSFULL.getErrorNumber();
					else if(rs==-1)
						return Enums.ErrorsManage.INSERT_FAIL.getErrorNumber();
					else
						return Enums.ErrorsManage.DB_ERROR.getErrorNumber();
				}
				_connection.CloseConnection();
				return Enums.ErrorsManage.DB_ERROR.getErrorNumber();
			}
			_connection.CloseConnection();
			return Enums.ErrorsManage.DB_ERROR.getErrorNumber();
		} catch (Exception ex) {
			System.out.println("######################" + ex.toString());
			_connection.CloseConnection();
			return Enums.ErrorsManage.DB_ERROR.getErrorNumber();
		}
	}

	// Delete the book
	public int DeleteBook(String bookId) throws SQLException {
		try {
			if (bookId != null) {
				if (_connection.OpenConnection()) {
					int rs = _connection.ExcuteUpdate("DELETE FROM " + '"'
							+ "dbo" + '"' + "." + '"' + "TBL_BOOK" + '"'
							+ " where book_id='" + bookId + "' ");
					_connection.CloseConnection();
					if(rs==1)
						return Enums.ErrorsManage.UPDATE_SUCCESSFULL.getErrorNumber();
					else if(rs==-1)
						return Enums.ErrorsManage.UPDATE_FAIL.getErrorNumber();
					else
						return Enums.ErrorsManage.DB_ERROR.getErrorNumber();
				}
				_connection.CloseConnection();
				return Enums.ErrorsManage.DB_ERROR.getErrorNumber();
			}
			_connection.CloseConnection();
			return Enums.ErrorsManage.DB_ERROR.getErrorNumber();
		} catch (Exception ex) {
			System.out.println("######################" + ex.toString());
			_connection.CloseConnection();
			return Enums.ErrorsManage.DB_ERROR.getErrorNumber();
		}
	}
}
