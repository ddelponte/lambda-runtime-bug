package com.genalpha;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;

import javax.annotation.Nullable;
import javax.validation.Valid;
import java.util.UUID;

@Controller
public class BookController {

  @Post
  public BookSaved save(@Valid @Body Book book) {
    BookSaved bookSaved = new BookSaved();
    bookSaved.setName(book.getName());
    bookSaved.setIsbn(UUID.randomUUID().toString());
    return bookSaved;
  }

  @Get(uri = "/search{?searchText}", produces = MediaType.TEXT_PLAIN)
  public HttpResponse<String> search(@QueryValue @Nullable String searchText) {
    return HttpResponse.ok("Your searchText = " + searchText);
  }
}
