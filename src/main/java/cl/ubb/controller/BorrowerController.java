package cl.ubb.controller;

import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.Borrower;
import cl.ubb.service.BorrowerService;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

/**
 * Created by Felipe on 6/19/2017.
 */
@RestController
@RequestMapping("/borrower")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Borrower> getBorrowerByRut(@PathVariable ("id") String rut) throws ReadErrorException {
        return  new ResponseEntity<Borrower>(borrowerService.get(rut),OK);
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<Borrower>> getAllBorrower() throws EmptyListException {
        return new ResponseEntity<List <Borrower>>(borrowerService.getAll(),OK);
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<Borrower> createBorrower(@RequestBody Borrower borrower) throws CreateException {
        borrowerService.create(borrower);
        return new ResponseEntity<Borrower>(borrower,CREATED);
    }

    @ExceptionHandler(ReadErrorException.class)
    public ResponseEntity borrowerNotFoundError() {
        return ResponseEntity.status(NOT_FOUND).body("Borrower no encontrado");
    }
    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity borrowerEmptyListException() {
        return ResponseEntity.status(NOT_FOUND).body("Borrower List vacia");
    }



}
