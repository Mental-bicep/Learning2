package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class MyBusinessService {
    
    public String doBusinessLogic() {
        return "Business logic executed successfully!";
    }
}