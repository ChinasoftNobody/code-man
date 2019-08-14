import {MAT_BOTTOM_SHEET_DATA, MatBottomSheetConfig, MatBottomSheetRef} from '@angular/material';
import {Component, Inject, Input} from '@angular/core';
import {ErrorMsg} from '../model/response.model';

@Component({
  selector: 'app-bottom-sheet-error',
  templateUrl: './common-error.component.html',
})
export class BottomSheetErrorComponent {

  constructor(private bottomSheetRef: MatBottomSheetRef<BottomSheetErrorComponent>, @Inject(MAT_BOTTOM_SHEET_DATA) public data: ErrorMsg) {
  }
}
