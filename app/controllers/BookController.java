package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Book;
import models.responses.BookResponse;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import java.util.stream.Collectors;
public class BookController extends Controller {

    private static Set<Book> books = new HashSet<Book>();

    /*
    * curl 'http://localhost:9000/books' -H 'Content-Type: application/json' -X POST -d '{"id":1,"title":"java","author":"Kathy", "price":44.10}'
    * */
    public Result save(Http.Request request) {
        Book book = Json.fromJson(request.body().asJson(), Book.class);
        books.add(book);
        return ok("saved:" + book.getTitle());
    }

    public Result listBooks() {
        if(!books.isEmpty()) {
            List<JsonNode> booksList = books.stream().map(book -> Json.toJson(book)).collect(Collectors.toList());
            BookResponse response = new BookResponse(booksList);
            return ok(Json.toJson(response));
        } else {
            return ok("no books available");
        }
    }


}
