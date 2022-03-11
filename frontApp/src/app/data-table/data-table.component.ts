import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable } from '@angular/material/table';
import { Observable } from 'rxjs';
import { deal } from '../interface/deal';
import { DealService } from '../service/deal.service';
import { DataTableDataSource, DataTableItem } from './data-table-datasource';

@Component({
  selector: 'app-data-table',
  templateUrl: './data-table.component.html',
  styleUrls: ['./data-table.component.scss']
})
export class DataTableComponent implements AfterViewInit {
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatTable) table!: MatTable<DataTableItem>;
  // dataSource: Observable<deal[]>;


  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['id', 'from','to','date','amount','accpet'];
  // dataList: Observable<deal[]>;
  dataSource: DataTableDataSource;
  deal: any;
  selecetedFile: any;

  constructor(private dealService: DealService, private http:HttpClient) {
    this.dataSource = new DataTableDataSource();
    console.log(this.dataSource);
    this.dealService.getDeals().subscribe((response:deal[])=>{
      this.deal = response;
      this.dataSource.data=response;
      console.log(this.deal);
    },(error:HttpErrorResponse)=>{
      console.log(error);
    });

  }
  

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.table.dataSource = this.dataSource;
    this.dataSource.sort
  }

}
