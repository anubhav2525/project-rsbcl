package org.excise.rsbcl.controllers.newsUpdates;

import org.bson.types.ObjectId;
import org.excise.rsbcl.dao.newsUpdates.NewsUpdatesDAO;
import org.excise.rsbcl.services.newsUpdates.NewsUpdatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class NewsUpdatesController {
    @Autowired
    private final NewsUpdatesService newsUpdatesService;

    @Autowired
    public NewsUpdatesController(NewsUpdatesService newsUpdatesService) {
        this.newsUpdatesService = newsUpdatesService;
    }

    // Endpoint to get paginated data
    @GetMapping("/public/news-updates")
    public ResponseEntity<?> getPaginatedNewsUpdates(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        // Call the service to get paginated data wrapped in a Response object
        return createResponseEntity(newsUpdatesService.getPaginatedNewsUpdates(page, size));
    }

    @GetMapping("/public/news-updates/latest-five/{department}")
    public ResponseEntity<?> getLatestFiveNewsUpdates(@PathVariable String department) {
        return createResponseEntity(newsUpdatesService.getNewsUpdatesFive(department));
    }

    @GetMapping("/auth/news-updates/id/{id}")
    public ResponseEntity<?> getNewsUpdatesById(@PathVariable ObjectId id){
        return createResponseEntity(newsUpdatesService.getNewsUpdatesById(id));
    }

    @PostMapping(value = "/auth/news-updates", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveNewsUpdates(@ModelAttribute NewsUpdatesDAO newsUpdatesDAO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return createResponseEntity(newsUpdatesService.saveNewsUpdates(newsUpdatesDAO));
    }

    @PutMapping("/auth/news-updates/id/{id}")
    public ResponseEntity<?> updateNewsUpdates(@PathVariable ObjectId id, @ModelAttribute NewsUpdatesDAO newsUpdatesDAO) {
        return createResponseEntity(newsUpdatesService.updateNewsUpdates(id, newsUpdatesDAO));
    }

    @DeleteMapping("/auth/news-updates/id/{id}")
    public ResponseEntity<?> deleteNewsUpdates(@PathVariable ObjectId id) {
        return createResponseEntity(newsUpdatesService.deleteNewsUpdates(id));
    }

    private <T> ResponseEntity<?> createResponseEntity(NewsUpdatesService.Response<T> response) {
        return switch (response.getStatus()) {
            case "Error" -> new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            case "Success" -> new ResponseEntity<>(response, HttpStatus.OK);
            case "Saved" -> new ResponseEntity<>(response, HttpStatus.CREATED);
            case "Error404" -> new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            case "Error208" -> new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
            default ->
                    new ResponseEntity<>("Unknown status" + response.getMessage() + " /// " + response.getData(), HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }
}
