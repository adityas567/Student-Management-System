import { Component,OnInit} from '@angular/core';
import { FormControl,FormBuilder,Validators, FormGroup } from '@angular/forms';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {

  studentForm!:FormGroup;

  constructor(private formbuilder:FormBuilder,private api:ApiService)
  {

  }
  
  ngOnInit():void{
    this.studentForm = this.formbuilder.group({
      full_name:['',Validators.required],
      username:['',Validators.required],
      dob:['',Validators.required],
      phno:['',Validators.required],
      email:['',Validators.required],
      pname:['',Validators.required],
      address:['',Validators.required],
      bgroup:['',Validators.required],
      cid:['',Validators.required],
    })
  }
  addStudent()
  {
    console.log(this.studentForm.value);
    this.api.postStudent(this.studentForm.value).subscribe({next:(res)=>
    {
      alert('submitted');
    },
    error:()=>
    {
      alert('error');
    }
  })
  }



}
