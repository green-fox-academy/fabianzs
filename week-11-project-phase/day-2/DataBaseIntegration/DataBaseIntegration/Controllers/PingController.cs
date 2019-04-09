using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using DataBaseIntegration.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Options;

// For more information on enabling MVC for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace DataBaseIntegration.Controllers
{
    public class PingController : Controller
    {
        private readonly AppSettings _appSettings;

        public PingController(IOptions<AppSettings> appsettings)
        {
            _appSettings = appsettings.Value;
        }

        [HttpGet]
        [Route("ping")]
        public IActionResult Ping()
        {
            var env = _appSettings.Environment;
            return Ok();
        }
    }
}
