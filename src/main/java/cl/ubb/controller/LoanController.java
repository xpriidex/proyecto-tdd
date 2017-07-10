package cl.ubb.controller;

import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.Loan;
import cl.ubb.service.LoanService;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

/**
 * Created by Felipe on 7/5/2017.
 */
@RestController
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Loan> getLoanById(@PathVariable("id") String id) throws ReadErrorException {
        return new ResponseEntity<Loan>(loanService.getId(id),OK);
    }

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Loan>> getAllLoans() throws EmptyListException {
        return new ResponseEntity<List <Loan>>(loanService.getAll(),OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) throws CreateException {
        loanService.create(loan);
        return new ResponseEntity<Loan>(loan,CREATED);
    }

    @ExceptionHandler(ReadErrorException.class)
    public ResponseEntity loanNotFoundError() {
        return ResponseEntity.status(NOT_FOUND).body("Loan no encontrado");
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity emptyListExceptionError() {
        return ResponseEntity.status(NOT_FOUND).body("No existen loans");
    }

    @ExceptionHandler(CreateException.class)
    public ResponseEntity createExceptionError() {
        return ResponseEntity.status(CONFLICT).body("Existen conflictos");
    }


}
