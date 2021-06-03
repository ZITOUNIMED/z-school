import { Component, OnInit } from '@angular/core';
import { Classe } from '../models/classe.model';
import { Section } from '../models/section.model';
import { AdministrationService } from '../services/administration.service';

@Component({
  selector: 'app-administration',
  templateUrl: './administration.component.html',
  styleUrls: ['./administration.component.scss']
})
export class AdministrationComponent implements OnInit {

  sections: Section[];
  classes: Classe[];

  constructor(private administrationUservice: AdministrationService) { }

  ngOnInit(): void {
    this.administrationUservice.findStaticSectionsData()
    .subscribe(sections => (this.sections = sections));

    this.administrationUservice.findStaticClassesData()
    .subscribe(classes => (this.classes = classes));
  }

}
