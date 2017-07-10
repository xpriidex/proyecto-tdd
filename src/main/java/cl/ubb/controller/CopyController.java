package cl.ubb.controller;

import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.Copy;
import cl.ubb.service.CopyService;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

/**
 * Created by Felipe Cifuentes on 10-07-2017.
 */
@RestController
@RequestMapping("/copy")
public class CopyController {

    @Autowired
    private CopyService copyService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Copy> getCopyById(@PathVariable("id") String id) throws ReadErrorException {
        return new ResponseEntity<Copy>(copyService.get(id),OK);
    }

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Copy>> getAllCopy() throws EmptyListException {
        return new ResponseEntity<List <Copy>>(copyService.getAll(),OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Copy> createCopy(@RequestBody Copy copy) throws CreateException {
        copyService.create(copy);
        return new ResponseEntity<Copy>(copy,CREATED);
    }

    @ExceptionHandler(ReadErrorException.class)
    public ResponseEntity copyNotFoundError() {
        return ResponseEntity.status(NOT_FOUND).body("Copy no encontrado");
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity emptyListExceptionError() {
        return ResponseEntity.status(NOT_FOUND).body("No existen suspensiones");
    }

    @ExceptionHandler(CreateException.class)
    public ResponseEntity createExceptionError() {
        return ResponseEntity.status(CONFLICT).body("Existen conflictos");
    }

}
