 
package com.socialappmiddleware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialappbackend.dao.jobdao;
import com.socialappbackend.model.job;


@RestController
public class JobController {

	@Autowired
    jobdao jobdao;
   
	@PostMapping(value="/addjob")
    public ResponseEntity<String> saveblog(@RequestBody job b)
    {
      if(jobdao.addjob(b))
      {
	    System.out.println(b);
        return new ResponseEntity<String>("Job added",HttpStatus.OK);
      }
      else
      {
	   return new ResponseEntity<String>(" error job added",HttpStatus.INTERNAL_SERVER_ERROR);	
      }
    }
}


