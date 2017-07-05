package cl.ubb.controller;


import cl.ubb.dao.exceptions.CreateException;
import cl.ubb.dao.exceptions.ReadErrorException;

import cl.ubb.model.Subject;
import cl.ubb.service.SubjectService;
import cl.ubb.service.exceptions.EmptyListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

/**
 * Created by Felipe Cifuentes on 12-06-2017.
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Subject> getSubjectById(@PathVariable("id") String id) throws ReadErrorException {
        return new ResponseEntity<Subject>(subjectService.get(id),OK);
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List <Subject>> getAllSubject() throws ReadErrorException, EmptyListException {
        return new ResponseEntity<List <Subject>>(subjectService.getAll(),OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) throws CreateException {
        subjectService.create(subject);
        return  new ResponseEntity<Subject>(subject,CREATED);

    }
    @ExceptionHandler(ReadErrorException.class)
    public ResponseEntity subjectNotFoundError() {
        return ResponseEntity.status(NOT_FOUND).body("Subject no encontrado");
    }
    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity subjectEmptyListException() {
        return ResponseEntity.status(NOT_FOUND).body("Subject List vacia");
    }
    @ExceptionHandler(CreateException.class)
    public ResponseEntity createExceptionError() {
        return ResponseEntity.status(CONFLICT).body("Existen conflictos");
    }

}
