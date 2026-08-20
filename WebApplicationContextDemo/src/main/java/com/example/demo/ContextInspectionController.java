package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ContextInspectionController {

    // Here we inject the WebApplicationContext directly to inspect what it holds!
    @Autowired
    private WebApplicationContext webContext;

    @Autowired
    private MyBusinessService businessService;

    @GetMapping("/api/inspect-context")
    public Map<String, Object> inspectContext() {
        Map<String, Object> contextDetails = new HashMap<>();

        // 1. Get the actual implementation class Spring Boot is using
        contextDetails.put("contextClassName", webContext.getClass().getSimpleName());

        // 2. See how many beans the container is currently managing
        contextDetails.put("totalBeansManaged", webContext.getBeanDefinitionCount());

        // 3. Verify that it holds our business logic (@Service)
        contextDetails.put("hasMyBusinessService", webContext.containsBean("myBusinessService"));

        // 4. Verify that it holds the DispatcherServlet (The Front Controller)
        contextDetails.put("hasDispatcherServlet", webContext.containsBean("dispatcherServlet"));

        // 5. Verify that it holds THIS very controller (@RestController)
        contextDetails.put("hasContextInspectionController", webContext.containsBean("contextInspectionController"));
        
        // 6. Test the service logic
        contextDetails.put("serviceOutput", businessService.doBusinessLogic());

        return contextDetails;
    }
}