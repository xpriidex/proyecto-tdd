package cl.ubb.controller;


import cl.ubb.dao.exceptions.ReadErrorException;

import cl.ubb.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

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
    public void ResponseEntity<Subject> getSubject(@PathVariable("id") String id) throws ReadErrorException {
        return new ResponseEntity<Subject>(subjectService.get(id),OK);
    }

}
