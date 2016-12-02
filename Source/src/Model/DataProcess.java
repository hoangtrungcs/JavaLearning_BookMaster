package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnection.DBConnection;

//Class for get set data to database
public class DataProcess {

	DBConnection _connection = new DBConnection();

	public DataProcess() {

	}

	// Get all the list books (use when show the list of book that inserted)
	public ArrayList<BookModelForm> GetAllBooks() throws SQLException {

		if (_connection.OpenConnection()) {
			ResultSet rs = _connection.GetData("SELECT * FROM " + '"'
					+ "public" + '"' + "." + '"' + "TBL_BOOK" + '"' + "");
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

	//Check book is exists when update or insert
	public boolean BookIsExists(String bookId) throws SQLException {
		try {
			if (bookId != null) {
				if (_connection.OpenConnection()) {
					
					String sql = "SELECT * FROM " + '"'
							+ "public" + '"' + "." + '"' + "TBL_BOOK" + '"'
							+ " where book_id=?";
					
					PreparedStatement ps =DBConnection.conn.prepareStatement(sql);
					ps.setString(1, bookId);
					ResultSet rs = ps.executeQuery();
					
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
				String sql = "SELECT * FROM " + '"'
						+ "public" + '"' + "." + '"' + "TBL_BOOK" + '"'
						+ " where book_id=?";
				
				PreparedStatement ps =DBConnection.conn.prepareStatement(sql);
				ps.setString(1, bookId);
				ResultSet rs = ps.executeQuery();
				
				/*ResultSet rs = _connection.GetData("SELECT * FROM " + '"'
						+ "public" + '"' + "." + '"' + "TBL_BOOK" + '"'
						+ " where book_id='" + bookId + "' ");*/
				while (rs.next()) {
					book.setBookid(rs.getString("book_id"));
					book.setBookTitle(rs.getString("book_title"));
					book.setAuthorName(rs.getString("author_name"));
					book.setPublisher(rs.getString("publisher"));
					book.setPublicationDay(rs.getDate("publication_day").toString());
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
					String sql = "UPDATE "+ '"'+ "public" + '"' + "." + '"'+ "TBL_BOOK" +'"' +" SET book_title=?, author_name=?, publisher=?, publication_day=? WHERE book_id=?";
					PreparedStatement ps =DBConnection.conn.prepareStatement(sql);
					ps.setString(1, book.getBookTitle());
					ps.setString(2, book.getAuthorName());
					ps.setString(3, book.getPublisher());
					ps.setDate(4,new java.sql.Date(book.getPublicationDay().getTime()));
					ps.setString(5, book.getBookid());
					int rs = ps.executeUpdate();
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
			_connection.CloseConnection();
			System.out.println(ex);
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
					String sql = "INSERT INTO "+ '"'+ "public" + '"' + "." + '"' + "TBL_BOOK"+ '"' +"VALUES(?,?,?,?,?)";
					
					PreparedStatement ps =DBConnection.conn.prepareStatement(sql);
					ps.setString(1, book.getBookid());
					ps.setString(2, book.getBookTitle());
					ps.setString(3, book.getAuthorName());
					ps.setString(4, book.getPublisher());
					ps.setDate(5,new java.sql.Date(book.getPublicationDay().getTime()));
					
					int rs = ps.executeUpdate();
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
			_connection.CloseConnection();
			return Enums.ErrorsManage.DB_ERROR.getErrorNumber();
		}
	}

	// Delete the book
	public int DeleteBook(String bookId) throws SQLException {
		try {
			if (bookId != null) {
				if (_connection.OpenConnection()) {
					String sql = "DELETE FROM " + '"'
							+ "public" + '"' + "." + '"' + "TBL_BOOK" + '"'
							+ " where book_id=?";
					PreparedStatement ps =DBConnection.conn.prepareStatement(sql);
					ps.setString(1, bookId);
					int rs=ps.executeUpdate();
					
					_connection.CloseConnection();
					if(rs==1)
						return Enums.ErrorsManage.DELETE_SUCCESSFULL.getErrorNumber();
					else if(rs==-1)
						return Enums.ErrorsManage.DELETE_FAIL.getErrorNumber();
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
