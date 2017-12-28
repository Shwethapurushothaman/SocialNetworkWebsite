package com.socialappmiddleware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialappbackend.dao.forumdao;
import com.socialappbackend.model.forum;



@RestController
public class ForumController {
	@Autowired
   forumdao forumdao;
   
	@PostMapping(value="/addforum")
    public ResponseEntity<String> saveblog(@RequestBody forum b)
    {
      if(forumdao.addforum(b))
      {
	    System.out.println(b);
        return new ResponseEntity<String>("Forum added",HttpStatus.OK);
      }
      else
      {
	   return new ResponseEntity<String>(" error Forum added",HttpStatus.INTERNAL_SERVER_ERROR);	
      }
    }
}
