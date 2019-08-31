import {Component, OnInit} from '@angular/core';
import {MenuItem} from 'primeng/api';
import {CrumbsService} from './crumbs.service';

@Component({
  selector: 'app-crumbs',
  templateUrl: './crumbs.component.html',
  styleUrls: ['./crumbs.component.css']
})
export class CrumbsComponent implements OnInit {
  items: MenuItem[];
  home: MenuItem;

  constructor() {
  }

  ngOnInit(): void {
    this.items = [];
    CrumbsService.getCrumbObservable().subscribe(value => {
      if (!value) {
        return;
      }
      if (value.operation === 'add') {
        value.items.forEach(item => {
          item.command = (event) => {
            CrumbsService.clickCrumbsItem(event.item);
          };
          this.items.push(item);
        });
      } else if (value.operation === 'click') {
        while (this.items.length > 0) {
          const menuItems: MenuItem = this.items.slice(this.items.length - 1, this.items.length)[0];
          if (menuItems.label === value.items[0].label) {
            break;
          }
          this.items.pop();
        }
      }
    });
  }

}
