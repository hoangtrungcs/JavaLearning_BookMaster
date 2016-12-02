package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class BookModelForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String message;

	private String bookid;
	private String bookTitle;
	private String authorName;
	private String publisher;
	private Date publicationDay;
	private String year;
	private String month;
	private String day;

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublicationDay() {
		return publicationDay;
	}

	public void setPublicationDay(String publicationDay) {
		String[] dates = publicationDay.split("-");
		if (dates != null) {
			year = dates[0];
			month = dates[1];
			day = dates[2];
		}
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		   
		try {
			this.publicationDay = formatter.parse(publicationDay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		String actionName = request.getParameter("method");

		if (actionName.equals(Enums.ActionName.SEARCH.getActionName())) {
			if (this.bookid == null || this.bookid.trim().equals(""))
				errors.add("bookid", new ActionMessage(
						"err.book.bookid.required", "BookId"));
		} else if (actionName.equals(Enums.ActionName.ADD.getActionName())) {
			CheckInput(errors);
		} else if (actionName.equals(Enums.ActionName.UPDATE.getActionName())) {
			CheckInput(errors);
		} else if (actionName.equals(Enums.ActionName.DELETE.getActionName())) {
			CheckInput(errors);
		}
		if (!errors.isEmpty())
			request.setAttribute("book", this);
		return errors;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// If Clear button clicked will set date as today
		// If update with validation as failure than not reset value
		String actionName = request.getParameter("method");
		if (actionName != null) {
			if (actionName.equals(Enums.ActionName.CLEAR.getActionName())) {
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				this.setPublicationDay(dateFormat.format(date));
			}
			if (actionName.equals(Enums.ActionName.UPDATE.getActionName())) {
				request.setAttribute("book", this);
			}
		}
		super.reset(mapping, request);
	}

	public void CheckInput(ActionErrors errors) {

		if (this.bookid == null || this.bookid.trim().equals(""))
			errors.add("bookid", new ActionMessage("err.book.bookid.required",
					"BookId"));
		if (this.bookTitle == null || this.bookTitle.trim().equals(""))
			errors.add("bookTitle", new ActionMessage(
					"err.book.bookTitle.required", "bookTitle"));
		if (this.authorName == null || this.authorName.trim().equals(""))
			errors.add("authorName", new ActionMessage(
					"err.book.authorName.required", "authorName"));
		if (this.publisher == null || this.publisher.trim().equals(""))
			errors.add("publisher", new ActionMessage(
					"err.book.publisher.required", "publisher"));
		if (this.day == null || this.day.trim().equals("")
				|| Integer.parseInt(this.day) <= 0
				|| Integer.parseInt(this.day) > 31 || this.month == null
				|| this.month.trim().equals("")
				|| Integer.parseInt(this.month) <= 0
				|| Integer.parseInt(this.month) > 12 || this.year == null
				|| this.year.trim().equals("")
				|| Integer.parseInt(this.year) <= 0)
			errors.add("publicationdate", new ActionMessage(
					"err.book.publicationday.required", "day"));
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
