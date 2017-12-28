package com.socialappmiddleware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.SocialNetworkBackEnd.Dao.BlogDao;
import com.socialappbackend.dao.userdao;
//import com.SocialNetworkBackEnd.Model.Blog;
import com.socialappbackend.model.userdetail;

@RestController
public class UserController {
	@Autowired
    userdao userdao;
   
	@PostMapping(value="/adduser")
    public ResponseEntity<String> saveblog(@RequestBody userdetail b)
    {
      if(userdao.adduser(b))
      {
	    System.out.println(b);
        return new ResponseEntity<String>("user added",HttpStatus.OK);
      }
      else
      {
	   return new ResponseEntity<String>(" error user added",HttpStatus.INTERNAL_SERVER_ERROR);	
      }
    }
}
