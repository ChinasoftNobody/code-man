import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {MatBottomSheet} from '@angular/material';
import {BottomSheetErrorComponent} from '../common/common-error.component';
import {ErrorMsg, ErrorType} from '../model/response.model';


@Injectable()
export class ErrorService {
  private errorQueue = new BehaviorSubject<ErrorMsg>(null);

  constructor(private msb: MatBottomSheet) {
    this.startReadMessage();
  }

  /**
   * 添加一条新的业务错误消息
   * @param errorMsg errorMsg
   */
  public newBusinessError(errorMsg: any): void {
    const msgStr = JSON.stringify(errorMsg);
    this.errorQueue.next({msg: msgStr, type: ErrorType.BUSINESS});
  }

  /**
   * 添加一条新的系统错误消息
   * @param errorMsg errorMsg
   */
  public newSystemError(errorMsg: any): void {
    const msgStr = JSON.stringify(errorMsg);
    this.errorQueue.next({msg: msgStr, type: ErrorType.SYSTEM});
  }

  /**
   * 开始错误消息队列
   */
  private startReadMessage() {
    this.errorQueue.subscribe(msg => {
      if (msg !== null) {
        const matBottomSheetRef = this.msb.open(BottomSheetErrorComponent, {data: msg});
        if (msg.type === ErrorType.BUSINESS) {
          setTimeout(() => {
            matBottomSheetRef.dismiss();
          }, 2000);
        }

      }
    });
  }

}
