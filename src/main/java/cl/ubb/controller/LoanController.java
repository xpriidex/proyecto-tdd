package cl.ubb.controller;

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
public class LoanController {
    @Autowired
    private LoanService loanService;

    @GetMapping("getAll")
    @ResponseBody
    public ResponseEntity<List<Loan>> readAll() throws EmptyListException {
        return new ResponseEntity<List<Loan>>(loanService.getAll(), OK);
    }

}
