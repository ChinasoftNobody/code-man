import {Component, OnInit} from '@angular/core';
import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-crumbs',
  templateUrl: './crumbs.component.html',
  styleUrls: ['./crumbs.component.css']
})
export class CrumbsComponent implements OnInit {
  items: MenuItem[];

  ngOnInit(): void {
    this.items = [
      {label: 'Categories', routerLink: '.'},
      {label: 'Sports', routerLink: '.'}
    ];
  }

}
