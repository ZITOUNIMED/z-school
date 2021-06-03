import { Component, OnInit } from '@angular/core';
import { Book } from '../models/book.model';
import { LibraryService } from '../services/library.service';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.scss']
})
export class LibraryComponent implements OnInit {
  books: Book[];
  constructor(private libraryUservice: LibraryService) { }

  ngOnInit(): void {
    this.libraryUservice.findAllBooks()
    .subscribe(books => (this.books = books));
  }

}
