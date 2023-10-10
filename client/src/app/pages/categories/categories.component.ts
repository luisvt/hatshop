import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Page } from '../../models/page';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { MatxPromptService } from 'matx-core';
import { map, switchMap } from 'rxjs/operators';
import { PageEvent } from '@angular/material/paginator';
import { debounceFn } from 'debounce-decorator-ts';
import { Category } from '../../models/category';
import { CategoriesService } from '../../services/categories.service';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.scss']
})
export class CategoriesComponent implements OnInit {

  columns = ['name', 'actions'];

  dataSource$: Observable<Category[]>;

  params: any = {};

  page: Page<Category> = {
    size: 20,
    number: 0
  };

  constructor(private router: Router,
              private route: ActivatedRoute,
              private svc: CategoriesService,
              private promptCtrl: MatxPromptService) {
    this.dataSource$ = route.queryParams.pipe(switchMap(params => {
      this.params = {...params};
      delete this.params._refresh;
      const page = Number(params['page']);
      const size = Number(params['size']);
      const _params = {
        search: `name==*${params['search'] || ''}*`,
        page: page && page > 0 ? page : 0,
        size: size && size > 0 ? size : 20
      };
      return this.svc.find(_params).pipe(map(_page => {
        this.page = _page;
        return _page.content ?? [];
      }));
    }));
  }

  ngOnInit() {
  }

  navigate(params: Params) {
    this.router.navigate([], {relativeTo: this.route, queryParams: params});
  }

  handlePageChange(event: PageEvent) {
    this.navigate({...this.params, page: event.pageIndex + 1, size: event.pageSize});
  }

  @debounceFn(500)
  search(search: string) {
    this.navigate({search: search || null});
  }

  refresh() {
    this.router.navigate([], {
      relativeTo: this.route,
      queryParams: {_refresh: new Date().getTime()},
      skipLocationChange: true
    });
  }

  deleteById(id: any) {
    this.promptCtrl.prompt({
      message: 'Are you sure you want to delete this item?',
      actions: [{text: 'No', color: undefined}, {
        text: 'Yes',
        color: 'warn',
        showLoading: true,
        callback: () => this.svc.deleteById(id).toPromise().then(() => this.refresh())
      }]
    })
  }

}
