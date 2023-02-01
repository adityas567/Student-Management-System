import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http:HttpClient) { }

  postStudent(data:any)
  {
    return this.http.post<any>("http://localhost:8080/students/new",data);
  }
  getStudent()
  {
    return this.http.get<any>("http://localhost:5050/students");
  }
  updateStudents(data:any,id:number)
  {
    return this.http.put<any>("http://localhost:8080/students/"+id,data);
  }
  getStudentsById(id:any)
  {
    return this.http.get<any>("http://localhost:5050/students/"+id);
  }

}
