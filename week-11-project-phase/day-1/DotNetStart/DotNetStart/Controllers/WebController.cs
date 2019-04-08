using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Threading.Tasks;
using DotNetStart.Models;
using Microsoft.AspNetCore.Mvc;

// For more information on enabling MVC for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace DotNetStart.Controllers
{
    [Route("web")]
    public class WebController : Controller
    {
        [DefaultValue(1)]
        private static int PageCounter { get; set; }

        [HttpGet("greeting")]
        public IActionResult Greeting(string name)
        {
            PageCounter++;
            var greeting = new Greeting(PageCounter, name);

            return View(greeting);
        }
    }
}
