import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { LibraryComponent } from './library/library.component';
import { HomeComponent } from './home/home.component';
import { AdministrationComponent } from './administration/administration.component';

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    LibraryComponent,
    HomeComponent,
    AdministrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
