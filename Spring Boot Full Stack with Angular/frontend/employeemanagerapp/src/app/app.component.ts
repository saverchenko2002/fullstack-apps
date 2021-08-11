import { Component, OnInit } from '@angular/core';
import { Employee } from './employee';
import { EmployeeService } from './employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public employees: Employee[];
  

  constructor(private employeeService: EmployeeService){}

  ngOnInit() {
    this.getEmployees();
  }
  
  public getEmployees() :void {
    this.employeeService.getEmployees().subscribe(data=>{
      this.employees=data;
    }, error => console.log(error));
  }

}
