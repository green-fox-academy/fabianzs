using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;


namespace WebAppFirstTry.Controllers
{
    [Route("[controller]")]
    public class TestController : Controller
    {
        // GET: /<controller>/
        [HttpGet("index")]
        public IActionResult Index()
        {
            ViewData["test"] = "I am passing data from controller to view";
            return View();
        }
    }
}
