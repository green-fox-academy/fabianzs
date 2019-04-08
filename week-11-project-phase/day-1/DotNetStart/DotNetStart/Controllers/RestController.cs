using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using DotNetStart.Models;
using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace DotNetStart.Controllers
{
    [Route("api")]
    public class RestController : Controller
    {
        [HttpGet("greeting")]
        public Greeting Greet(string name)
        {
            return new Greeting(1, $"Hello, {name}!");
        }

        // GET api/<controller>/5
        [HttpGet("{id}")]
        public string Get(int id)
        {
            return "value";
        }

        // POST api/<controller>
        [HttpPost]
        public void Post([FromBody]string value)
        {
        }

        // PUT api/<controller>/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE api/<controller>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
