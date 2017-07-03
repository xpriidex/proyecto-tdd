package cl.ubb.controller;

import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.Title;
import cl.ubb.service.TitleService;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

/**
 * Created by Felipe Cifuentes on 03-07-2017.
 */
@RestController
@RequestMapping("/title")
public class TitleController {
    @Autowired
    private TitleService titleService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Title> getTitleById(@PathVariable("id") String id) throws ReadErrorException {
        return new ResponseEntity<Title>(titleService.get(id),OK);
    }
    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Title>> getAllTitle() throws EmptyListException {
        return new ResponseEntity<List<Title>>(titleService.getAll(),OK);
    }
    @GetMapping("/create")
    @ResponseBody
    public ResponseEntity<Title> createTitle(@RequestBody Title title) throws CreateException {
        titleService.create(title);
        return new ResponseEntity<Title>(title,CREATED);

    }
    @ExceptionHandler(ReadErrorException.class)
    public ResponseEntity titleNotFoundError() {
        return ResponseEntity.status(NOT_FOUND).body("Title no encontrado");
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity emptyListExceptionError() {
        return ResponseEntity.status(NOT_FOUND).body("No existen titles");
    }

    @ExceptionHandler(CreateException.class)
    public ResponseEntity createExceptionError() {
        return ResponseEntity.status(CONFLICT).body("Existen conflictos");
    }
}
