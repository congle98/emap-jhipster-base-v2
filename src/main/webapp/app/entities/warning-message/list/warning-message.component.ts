import { Component, OnInit } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IWarningMessage } from '../warning-message.model';

import { ASC, DESC, ITEMS_PER_PAGE } from 'app/config/pagination.constants';
import { WarningMessageService } from '../service/warning-message.service';
import { WarningMessageDeleteDialogComponent } from '../delete/warning-message-delete-dialog.component';
import { ParseLinks } from 'app/core/util/parse-links.service';

@Component({
  selector: 'jhi-warning-message',
  templateUrl: './warning-message.component.html',
})
export class WarningMessageComponent implements OnInit {
  warningMessages: IWarningMessage[];
  isLoading = false;
  itemsPerPage: number;
  links: { [key: string]: number };
  page: number;
  predicate: string;
  ascending: boolean;

  constructor(protected warningMessageService: WarningMessageService, protected modalService: NgbModal, protected parseLinks: ParseLinks) {
    this.warningMessages = [];
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.page = 0;
    this.links = {
      last: 0,
    };
    this.predicate = 'id';
    this.ascending = true;
  }

  loadAll(): void {
    this.isLoading = true;

    this.warningMessageService
      .query({
        page: this.page,
        size: this.itemsPerPage,
        sort: this.sort(),
      })
      .subscribe({
        next: (res: HttpResponse<IWarningMessage[]>) => {
          this.isLoading = false;
          this.paginateWarningMessages(res.body, res.headers);
        },
        error: () => {
          this.isLoading = false;
        },
      });
  }

  reset(): void {
    this.page = 0;
    this.warningMessages = [];
    this.loadAll();
  }

  loadPage(page: number): void {
    this.page = page;
    this.loadAll();
  }

  ngOnInit(): void {
    this.loadAll();
  }

  trackId(_index: number, item: IWarningMessage): number {
    return item.id!;
  }

  delete(warningMessage: IWarningMessage): void {
    const modalRef = this.modalService.open(WarningMessageDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.warningMessage = warningMessage;
    // unsubscribe not needed because closed completes on modal close
    modalRef.closed.subscribe(reason => {
      if (reason === 'deleted') {
        this.reset();
      }
    });
  }

  protected sort(): string[] {
    const result = [this.predicate + ',' + (this.ascending ? ASC : DESC)];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  protected paginateWarningMessages(data: IWarningMessage[] | null, headers: HttpHeaders): void {
    const linkHeader = headers.get('link');
    if (linkHeader) {
      this.links = this.parseLinks.parse(linkHeader);
    } else {
      this.links = {
        last: 0,
      };
    }
    if (data) {
      for (const d of data) {
        this.warningMessages.push(d);
      }
    }
  }
}
