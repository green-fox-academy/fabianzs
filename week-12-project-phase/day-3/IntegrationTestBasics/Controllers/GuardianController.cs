using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using IntegrationTestBasics.Models;
using Microsoft.AspNetCore.Mvc;

namespace IntegrationTestBasics.Controllers
{
    public class GuardianController : Controller
    {
        [HttpGet("groot")]
        public IActionResult Groot(string message)
        {
            if(message != null)
            {
                return Ok(new Groot(message));
            }
            else
            {
                return BadRequest(new Dictionary<string, string> { { "error", "I am Groot!" } });
            }
        }
    }
}