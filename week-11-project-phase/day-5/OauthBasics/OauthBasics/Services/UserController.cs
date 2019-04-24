using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace OauthBasics.Services
{
    
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        [HttpGet("unauthorized")]
        public IActionResult Unauth()
        {
            return Ok("You are not");

        }

        [Authorize("Bearer")]
        [HttpGet("try")]
        public IActionResult Try()
        {
            return Ok("You are authorized");

        }
    }
}