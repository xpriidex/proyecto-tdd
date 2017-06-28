package cl.ubb.controller;

import cl.ubb.service.SuspensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Felipe on 6/28/2017.
 */
@RestController
@RequestMapping("/suspension")
public class SuspensionController {
    @Autowired
    private SuspensionService suspensionService;
}
