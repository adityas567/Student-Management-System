import { AfterViewInit,Component, OnInit ,ViewChild} from '@angular/core';
import { ApiService } from '../services/api.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {MatDialog} from '@angular/material/dialog';
import { UformComponent } from '../uform/uform.component';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit{

  displayedColumns: string[] = ['full_name', 'age','phno','email','address','course_id','update'];
  dataSource = new MatTableDataSource<any>;

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  studentForm!:FormGroup;

  constructor(private formbuilder:FormBuilder,private api:ApiService,private dialog:MatDialog){}
  ngOnInit(): void {
    this.getAllStudents(),
    this.studentForm = this.formbuilder.group({
      name:'',
    })
  }

  getAllStudents()
  {
    this.api.getStudent().subscribe({
      next:(res)=>
      {
        this.dataSource=new MatTableDataSource(res);
        this.dataSource.paginator=this.paginator;
        console.log(res);
      },
      error:(err)=>
      {
        alert('error while fetching data');
      }
    })
  }

  getOneStudent()
  {
    this.api.getStudentsById((this.studentForm.value).name).subscribe({
      next:(res)=>
      {
        this.dataSource=new MatTableDataSource(res);
        this.dataSource.paginator=this.paginator;
        console.log(res);
        
      },
      error:(err)=>
      {
        alert('error while fetching data');
      }
    })
  }
  
  openDialog(row:any) {
    const dialogRef = this.dialog.open(UformComponent,{
      width:"40%",
      height:"80%",
      data:row,

    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }
}
