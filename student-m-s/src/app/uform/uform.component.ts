import { Component,Inject, OnInit } from '@angular/core';
import { FormControl,FormBuilder,Validators, FormGroup } from '@angular/forms';
import { ApiService } from '../services/api.service';
import { MatDialogRef,MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-uform',
  templateUrl: './uform.component.html',
  styleUrls: ['./uform.component.css']
})
export class UformComponent implements OnInit {
  updateStudentForm!:FormGroup;
  constructor(private formbuilder:FormBuilder,private api:ApiService,
    @Inject(MAT_DIALOG_DATA) public editData:any,
    private dialogRef: MatDialogRef<any>)
  {

  }
  ngOnInit():void{
    this.updateStudentForm = this.formbuilder.group({
      full_name:['',Validators.required],
      age:['',Validators.required],
      dob:['',Validators.required],
      phno:['',Validators.required],
      email:['',Validators.required],
      pname:['',Validators.required],
      address:['',Validators.required],
      bgroup:['',Validators.required],
      cid:['',Validators.required],
    })
    if(this.editData)
    {
      this.updateStudentForm.controls['full_name'].setValue(this.editData.full_name);
      this.updateStudentForm.controls['age'].setValue(this.editData.age);
      this.updateStudentForm.controls['phno'].setValue(this.editData.phno);
      this.updateStudentForm.controls['email'].setValue(this.editData.email);
      this.updateStudentForm.controls['pname'].setValue(this.editData.pname);
      this.updateStudentForm.controls['address'].setValue(this.editData.address);
      this.updateStudentForm.controls['bgroup'].setValue(this.editData.bgroup);
      this.updateStudentForm.controls['cid'].setValue(this.editData.cid);
      console.log(this.editData.cid);
      console.log(this.editData.full_name);
      console.log(this.editData.bgroup);
    }
  }
  updateStudents()
  {
    console.log(this.updateStudentForm.value);
    console.log(this.editData.student_id);
    this.api.updateStudents(this.updateStudentForm.value,this.editData.student_id).subscribe({next:(res)=>
      {
        alert('updated successfully');
        this.updateStudentForm.reset();
        this.dialogRef.close();
      },
      error:()=>
      {
        alert('error');
      }
    })
  }
}
