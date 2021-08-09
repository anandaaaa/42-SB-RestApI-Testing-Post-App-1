package in.anand.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.anand.bindings.Book;
import in.anand.service.BookService;

@RestController
public class BookRestControlleer {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping(value="/book",consumes= {"application/json"})
	public ResponseEntity<String> getBook(@RequestBody Book book)
	{
		String msg=null;
		Boolean isSaved=bookService.saveBook(book);
		
		if(isSaved)
		{
			msg="Book saved";
			return new ResponseEntity<>(msg,HttpStatus.CREATED);
		}else {
			msg="Book not saved";
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);

			
		}
		
	}

}
