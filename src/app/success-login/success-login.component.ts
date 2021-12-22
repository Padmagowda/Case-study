import { Component, OnInit } from '@angular/core';
import { TaskServices } from '../task.service';
import { Task } from '../Task';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-success-login',
  templateUrl: './success-login.component.html',
  styleUrls: ['./success-login.component.css']
})
export class SuccessLoginComponent implements OnInit {
  tasdata!: Task;
  constructor(private route: ActivatedRoute,private router: Router,private taskServices: TaskServices) { }

  ngOnInit(): void {
  }


  list() {
    this.router.navigate(['/tasks'])
  }

  list1() {
    this.router.navigate(['/save'])
  }
  
  logout() {
    alert("logout sucessfull");
    this.router.navigate(['/login'])
  }
  

}
