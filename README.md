# BOOKS SUGGESTION SERVICE 

The service suggests books to readers based on the book's ratings, reader's favourite genres, book's author and the 
preferences of other readers of the same age.

Your job is to fulfill all requirements, which are described below. There are several unit tests that will help you to verify your solution.
Please feel free to use any external dependencies by including them in `pom.xml` descriptor.

Your job is to correctly implement all the methods in the `BookSuggestionService` class, so that they meet the following requirements:

The method `Set<String> suggestBooks(Reader reader)` should return titles of all the  books that meet all the following criteria:
 1. Have a rating of four or higher
 2. Belong to one of the reader's favourite genres
 3. Belong to favourite books' list of at least one different reader of the same age

 The method `Set<String> suggestBooks(Reader reader, Author author)` should return titles of all the  books that meet all the following criteria:
  1. Have a rating of four or higher
  2. Belong to one of the reader's favourite genres
  3. Belong to favourite books' list of at least one different reader of the same age
  4. Have been written by the author specified in the method argument
  
 The method `Set<String> suggestBooks(Reader reader, int rating)` should return titles of all the  books that meet all the following criteria:
   1. Have exactly the rating specified in the method argument
   2. Belong to one of the reader's favourite genres
   3. Belong to favourite books' list of at least one different reader of the same age
