using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using TodoWebApp.Data;
using TodoWebApp.Models;

namespace TodoWebApp.Controllers
{
    [Route("assignee")]
    public class AssigneeController : Controller
    {
        private readonly ApplicationContext applicationContext;

        public AssigneeController(ApplicationContext app)
        {
            applicationContext = app;
        }

        [HttpGet]
        [Route("")]
        [Route("list")]
        public IActionResult List()
        {
            // Create a SQL query in the background
            var assignees = applicationContext.Assignee.ToList();
            
            return View(assignees);
        }

        [HttpGet]
        [Route("add")]
        public IActionResult GetAddPage()
        {
            return View("Add");
        }

        [HttpPost]
        [Route("add")]
        public IActionResult Add(Assignee assignee)
        {
            applicationContext.Add(assignee);
            applicationContext.SaveChanges();
            return Redirect("list");
        }

        [HttpGet]
        [Route("{id}/todos")]
        public IActionResult ListTodos([FromRoute] long Id)
        {
            Assignee assignee = applicationContext.Assignee.Include(a => a.Todos).FirstOrDefault(a => a.Id == Id);
            List<Todo> todos = assignee.Todos;
            return View("Todos", todos);
        }

        [HttpGet]
        [Route("{id}/delete")]
        public IActionResult Delete([FromRoute] long Id)
        {
            Todo deletedTodo = applicationContext.Todos.FirstOrDefault(t => t.Id == Id);
            applicationContext.Remove(deletedTodo);
            applicationContext.SaveChanges();
            return RedirectToAction("List");
        }

        [HttpDelete]
        [Route("{id}/delete")]
        public IActionResult DeleteWithPostman([FromRoute] long Id)
        {
            Todo deletedTodo = applicationContext.Todos.FirstOrDefault(t => t.Id == Id);
            applicationContext.Remove(deletedTodo);
            applicationContext.SaveChanges();
            return Ok();
        }

        [HttpGet]
        [Route("{id}/update")]
        public IActionResult GetUpdatePage([FromRoute] long Id)
        {
            Todo editableTodo = applicationContext.Todos.FirstOrDefault(t => t.Id == Id);
            return View("Update", editableTodo);
        }

        [HttpPost]
        [Route("{id}/update")]
        public IActionResult Update(Todo todo)
        {
            applicationContext.Update(todo);
            applicationContext.SaveChanges();
            return RedirectToAction("List");
        }

        [HttpPut]
        [Route("{id}/update")]
        public IActionResult UpdateWithPostman([FromRoute]long id, Todo todo)
        {
            todo.Id = id;
            applicationContext.Update(todo);
            applicationContext.SaveChanges();
            return RedirectToAction("List");
        }

        [HttpPut]
        [Route("update")]
        public IActionResult UpdateWithPostmanWithAPI([FromBody] Todo todo)
        {
            applicationContext.Update(todo);
            applicationContext.SaveChanges();
            return RedirectToAction("List");
        }
    }
}