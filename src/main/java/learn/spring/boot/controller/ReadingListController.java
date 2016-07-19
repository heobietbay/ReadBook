package learn.spring.boot.controller;

import learn.spring.boot.config.AmazonProperties;
import learn.spring.boot.model.Book;
import learn.spring.boot.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Administrator on 7/19/2016.
 */
@Controller
@RequestMapping("/")
public class ReadingListController {

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository,AmazonProperties amazonProperties)
    {
        this.readingListRepository = readingListRepository;
        this.amazonProperties = amazonProperties;
    }

    @RequestMapping(value="/{reader}",method = RequestMethod.GET)
    public String readerBooks(@PathVariable String reader, Model model){
        List<Book> readingList = readingListRepository.findByReader(reader);
        if(readingList != null && !readingList.isEmpty())
        {
            model.addAttribute("books",readingList);
            model.addAttribute("amazonID", amazonProperties.getAssociateId());
        }
        return "readingList";
    }

    @RequestMapping(value="/{reader}",method = RequestMethod.POST)
    public String addToReaderList(@PathVariable String reader,Book book){
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }

    private ReadingListRepository readingListRepository;
    private AmazonProperties amazonProperties;
}
