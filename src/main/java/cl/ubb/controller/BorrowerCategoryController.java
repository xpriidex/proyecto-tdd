package cl.ubb.controller;

import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.BorrowerCategory;
import cl.ubb.service.BorrowerCategoryService;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

/**
 * Created by Felipe Cifuentes on 05-07-2017.
 */
@RestController
@RequestMapping("/borrowerCategory")
public class BorrowerCategoryController {
    @Autowired
    private BorrowerCategoryService borrowerCategoryService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<BorrowerCategory> getBorrowerCategoryById(@PathVariable("id") String id) throws ReadErrorException {
        return new ResponseEntity<BorrowerCategory>(borrowerCategoryService.get(id),OK);
    }

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<BorrowerCategory>> getAllBorrowerCategory() throws EmptyListException {
        return new ResponseEntity<List <BorrowerCategory>>(borrowerCategoryService.getAll(),OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<BorrowerCategory> createBorrowerCategory(@RequestBody BorrowerCategory borrowerCategory) throws CreateException {
        borrowerCategoryService.create(borrowerCategory);
        return new ResponseEntity<BorrowerCategory>(borrowerCategory,CREATED);
    }

    @ExceptionHandler(ReadErrorException.class)
    public ResponseEntity borrowerCategoryNotFoundError() {
        return ResponseEntity.status(NOT_FOUND).body("Borrower Category no encontrado");
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity emptyListExceptionError() {
        return ResponseEntity.status(NOT_FOUND).body("No existen Borrower Category");
    }

    @ExceptionHandler(CreateException.class)
    public ResponseEntity createExceptionError() {
        return ResponseEntity.status(CONFLICT).body("Existen conflictos");
    }

}
