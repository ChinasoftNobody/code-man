import {BehaviorSubject, Subject} from 'rxjs';
import {MenuItem} from 'primeng/api';

export class AppCrumbModel<T> {
  operation?: string;
  items: T[];
}

export class CrumbsService {
  private static crumbItemObservable: Subject<AppCrumbModel<MenuItem>> = new BehaviorSubject<AppCrumbModel<MenuItem>>(null);

  public static addCrumbItems(menuItem: MenuItem): void {
    this.crumbItemObservable.next({operation: 'add', items: [menuItem]});
  }

  public static getCrumbObservable(): Subject<AppCrumbModel<MenuItem>> {
    return this.crumbItemObservable;
  }

  public static clickCrumbsItem(item: MenuItem): void {
    this.crumbItemObservable.next({operation: 'click', items: [item]});
  }
}
