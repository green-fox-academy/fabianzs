using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Security.Claims;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Authentication.Google;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.Extensions.Configuration;
using OauthBasics.Models;
using OauthBasics.Services;

namespace OauthBasics.Controllers
{
    //[Route("api/[controller]")]
    //[ApiController]
    public class OauthController : ControllerBase
    {
        private readonly IAuthService _authService;

        public OauthController(IAuthService authService, IConfiguration configuration)
        {
            _authService = authService;
        }

        [HttpGet("")]
        public IActionResult Index()
        {
            return Redirect(_authService.GetGoogleLogin());
        }

        [HttpGet("/auth")]
        public IActionResult Auth(string code)
        {
            GoogleToken token = _authService.GetToken(code);
            string id_token = token.id_token;
            bool isValid = _authService.ValidateToken(token.id_token);

            if(isValid)
            {
                var tokenstring = _authService.CreateJwtToken();

                return Ok(tokenstring);
            }
            else
            {
                return BadRequest();
            }
        }

        [Authorize]
        [HttpGet("/test")]
        public IActionResult TestMethod()
        {
            return Ok();
        }
    }
}