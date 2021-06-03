import { Component, OnInit } from '@angular/core';
import { Section } from '../models/section.model';
import { AdministrationService } from '../services/administration.service';

@Component({
  selector: 'app-administration',
  templateUrl: './administration.component.html',
  styleUrls: ['./administration.component.scss']
})
export class AdministrationComponent implements OnInit {

  sections: Section[];
  constructor(private administrationUservice: AdministrationService) { }

  ngOnInit(): void {
    this.administrationUservice.findAllSections()
    .subscribe(sections => (this.sections = sections));
  }

}
