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
    [Route("todo")]
    public class TodoController : Controller
    {
        private readonly ApplicationContext applicationContext;

        public TodoController(ApplicationContext app)
        {
            applicationContext = app;
        }

        [HttpGet]
        [Route("simple")]
        [Route("simple/list")]
        public IActionResult SimpleList()
        {
            List<Todo> todoList = new List<Todo>()
            {
                new Todo("Start the day"),
                new Todo("Finish H2 workshop1"),
                new Todo("Finish JPA workshop2"),
                new Todo("Create a CRUD project")
            };
            return View(todoList);
            //return Content("This is my first todo");
        }

        [HttpGet]
        [Route("")]
        [Route("list")]
        public IActionResult List([FromQuery] string isActive)
        {
            // Create a SQL query in the background
            var todos = new List<Todo>();
            if (isActive == null)
            {
                todos = applicationContext.Todos.Include(todo => todo.Assignee).ToList();
            }
            else
            {
                if (isActive.Equals("true"))
                {
                    todos = applicationContext.Todos.Where(t => !t.IsDone).ToList();
                }
                if (isActive.Equals("false"))
                {
                    todos = applicationContext.Todos.Where(t => t.IsDone).ToList();
                }
            }
            return View(todos);
        }

        [HttpGet]
        [Route("add")]
        public IActionResult GetAddPage()
        {
            return View("Add");
        }

        [HttpPost]
        [Route("add")]
        public IActionResult Add(Todo todo)
        {
            applicationContext.Add(todo);
            applicationContext.SaveChanges();
            return Redirect("list");
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
            ViewData["assignees"] = applicationContext.Assignees.ToList();
            return View("Update", editableTodo);
        }

        [HttpPost]
        [Route("{id}/update")]
        public IActionResult Update(long assigneeId, Todo todo)
        {
            if (assigneeId != 0)
            {
                todo.Assignee = (applicationContext.Assignees.Find(assigneeId));
            }
            applicationContext.Update(todo);
            applicationContext.SaveChanges();
            return RedirectToAction("List");
        }

        [HttpPut]
        [Route("{id}/update")]
        public IActionResult UpdateWithPostman([FromRoute]long id,Todo todo)
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
