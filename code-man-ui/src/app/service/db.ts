import {BaseModel} from '../model/base.model';
import {Injectable} from '@angular/core';
import {CodeModel} from '../model/code.model';

@Injectable()
export class Db {
  db: Storage;

  constructor() {
    if (!localStorage) {
      throw new Error('ent browser does not support Local Storage');
    }
    this.db = localStorage;
    if (!this.db.getItem('t_init')) {
      this.init();
    }
  }

  getDb(): Storage {
    return this.db;
  }

  getData<T>(tableName: string): (T[]) {
    return JSON.parse(this.db.getItem(tableName));
  }

  saveData<T extends BaseModel>(tableName: string, data: T[]): T[] {
    const dataStr = this.db.getItem(tableName);
    const nowDate = new Date().getTime();
    let items: T[] = [];
    if (dataStr) {
      items = JSON.parse(dataStr);
    }
    data.forEach(item => {
      item.id = nowDate + '';
      item.createdOn = nowDate;
      item.updatedOn = nowDate;
      item.creator = 'Maysham';
      item.updater = 'Maysham';
      item.deleted = false;
      items.push(item);
    });
    this.db.setItem(tableName, JSON.stringify(items));
    return data;
  }

  private init() {
    this.db.setItem('t_init', 'true');
    this.saveData<CodeModel>('t_code', [{name: 'Code1', description: 'Code1'},
      {name: 'Code2', description: 'Code2'}]);
  }
}
