using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using TodoApp.Models;

// For more information on enabling MVC for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace TodoApp.Controllers
{
    [Route("todo")]
    public class TodoController : Controller
    {
        [HttpGet]
        [Route("")]
        [Route("list")]
        public IActionResult List()
        {
            List<Todo> todoList = new List<Todo>()
            {
                new Todo("Start the day"),
                new Todo("Finish H2 workshop1"),
                new Todo("Finish JPA workshop2"),
                new Todo("Create a CRUD project")
            };
            return View(todoList);
        }
    }
}
