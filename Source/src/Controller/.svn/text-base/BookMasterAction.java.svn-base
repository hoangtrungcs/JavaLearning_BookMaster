package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import Model.BookModelForm;
import Model.DataProcess;
import Utility.Util;

public class BookMasterAction extends DispatchAction {

	Util utils=new Util(); 
	private String _success = "success";

	//Find the book by book id
	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		if (getErrors(request) == null || getErrors(request).size() == 0) {
			Model.BookModelForm bookModel = (BookModelForm) form;
			DataProcess process = new DataProcess();
			String bookid = request.getParameter("bookid");
			bookModel = process.GetBookById(bookid);
			
			if(bookModel.getBookid()==null)
			{
				bookModel.setMessage(utils.getProperties("notfound.book.message"));
			}
			request.setAttribute("book", bookModel);
			
			return mapping.findForward(_success);
		} else {
			return mapping.getInputForward();
		}
	}

	//Insert book 
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (getErrors(request) == null || getErrors(request).size() == 0) {
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String day = request.getParameter("day");
			String publicationday = year + "-" + month + "-" + day;

			DataProcess process = new DataProcess();
			
			Model.BookModelForm bookModelForm = (BookModelForm) form;
			bookModelForm.setBookid(request.getParameter("bookid"));
			bookModelForm.setBookTitle(request.getParameter("bookTitle"));
			bookModelForm.setAuthorName(request.getParameter("authorName"));
			bookModelForm.setPublisher(request.getParameter("publisher"));
			bookModelForm.setYear(year);
			bookModelForm.setMonth(month);
			bookModelForm.setDay(day);
			bookModelForm.setPublicationDay(publicationday);
			int result = process.InsertBook(bookModelForm);
			
			//Set message for book
			bookModelForm=new BookModelForm();
			bookModelForm.setMessage(utils.MessageShow(result));
			request.setAttribute("book", bookModelForm);
			
			return mapping.findForward(_success);
		} else {
			return mapping.getInputForward();
		}
	}

	//Update book
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (getErrors(request) == null || getErrors(request).size() == 0) {
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String day = request.getParameter("day");
			String publicationday = year + "-" + month + "-" + day;

			DataProcess process = new DataProcess();

			Model.BookModelForm bookModelForm = (BookModelForm) form;
			bookModelForm.setBookid(request.getParameter("bookid"));
			bookModelForm.setBookTitle(request.getParameter("bookTitle"));
			bookModelForm.setAuthorName(request.getParameter("authorName"));
			bookModelForm.setPublisher(request.getParameter("publisher"));
			bookModelForm.setYear(year);
			bookModelForm.setMonth(month);
			bookModelForm.setDay(day);
			bookModelForm.setPublicationDay(publicationday);
			int result = process.UpdateBook(bookModelForm);

			bookModelForm.setMessage(utils.MessageShow(result));
			return mapping.findForward(_success);
		} else {
			return mapping.getInputForward();
		}
	}

	//Delete book
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (getErrors(request) == null || getErrors(request).size() == 0) {
			
			Model.DataProcess process = new DataProcess();
			
			String bookid = request.getParameter("bookid");
			int result=process.DeleteBook(bookid);

			BookModelForm bookModelForm=new BookModelForm();
			bookModelForm.setMessage(utils.MessageShow(result));
			request.setAttribute("book", bookModelForm);
			
			return mapping.findForward(_success);
		} else {
			return mapping.getInputForward();
		}
	}

	//Clear value in form and set date as today
	public ActionForward clear(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Model.BookModelForm bookModelForm = (BookModelForm) form;
		bookModelForm.reset(mapping, request);
		request.setAttribute("book", bookModelForm);
		return mapping.findForward(_success);
	}
}
