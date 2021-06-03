import { Component, OnInit } from '@angular/core';
import { User } from '../models/user.model';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {
  users: User[];
  constructor(private usersService: UsersService) { }

  ngOnInit(): void {
    this.usersService.findAllUsers()
    .subscribe(users => (this.users = users));
  }

}
