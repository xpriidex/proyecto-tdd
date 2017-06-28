package cl.ubb.controller;

import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;
import cl.ubb.model.Suspension;
import cl.ubb.service.SuspensionService;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

/**
 * Created by Felipe on 6/28/2017.
 */
@RestController
@RequestMapping("/suspension")
public class SuspensionController {
    @Autowired
    private SuspensionService suspensionService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Suspension> getSuspensionById(@PathVariable("id") String id) throws ReadErrorException {
        return new ResponseEntity<Suspension>(suspensionService.get(id),OK);
    }

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Suspension>> getAllSuspension() throws EmptyListException {
        return new ResponseEntity<List <Suspension>>(suspensionService.getAll(),OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Suspension> createSuspension(@RequestBody Suspension suspension) throws CreateException {
        suspensionService.create(suspension);
        return new ResponseEntity<Suspension>(suspension,CREATED);
    }

    @ExceptionHandler(ReadErrorException.class)
    public ResponseEntity suspensionNotFoundError() {
        return ResponseEntity.status(NOT_FOUND).body("Suspension no encontrado");
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
