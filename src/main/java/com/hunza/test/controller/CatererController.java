package com.hunza.test.controller;

import com.hunza.test.document.Caterer;
import com.hunza.test.repo.CatererRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/caterer")
public class CatererController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private CatererRepository catererRepo;
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${pagesize}")
    private String pageSize;


    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSingleCaterer(@PathVariable("id") String id) {
        Optional<Caterer> caterer = catererRepo.findAll().stream().filter(p -> p.Id.equals(id)).findFirst();
        if (caterer.isPresent()) {
            LOG.info("Find {0} id", caterer.get().getId());
            return new ResponseEntity<>(caterer.get(), HttpStatus.OK);
        } else {
            LOG.info("Id not found");
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSingleCatererByName(@PathVariable("name") String name) {
        Caterer caterers = catererRepo.findByName(name);
        if(caterers == null){
            LOG.info("Find 0 records");
            return new ResponseEntity<>(null, HttpStatus.OK);
        }else{
            LOG.info("Find : {0} ", caterers.toString());
            return new ResponseEntity<>(caterers, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Caterer> getAll() {
        List<Caterer> caterers = catererRepo.findAll();
        if (caterers.size() > 0) {
            return caterers;
        } else {
            return new ArrayList<>();
        }
    }

    @GetMapping(path = "/list/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Caterer> getAllByPaginationAndSortedCityName(@PathVariable(value = "page") int page) {
        int size = Integer.parseInt(pageSize);
        Pageable requestedPage = PageRequest.of(page, size, Sort.by("city"));
        Page<Caterer> customers  = catererRepo.findAll(requestedPage);
        return customers;
    }


    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insert(@Valid @RequestBody Caterer caterer) {
        try {
            catererRepo.insert(caterer);
            LOG.info("sending message='{}'", caterer);
            jmsTemplate.convertAndSend("myqueue.caterer", caterer.toString());
            return new ResponseEntity<Caterer>(caterer, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
