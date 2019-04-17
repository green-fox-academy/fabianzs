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
using OauthBasics.Models;

namespace OauthBasics.Controllers
{
    //[Route("api/[controller]")]
    //[ApiController]
    public class OauthController : Controller
    {

        [HttpGet("")]
        public IActionResult Index()
        {
            string googleAuth = "https://accounts.google.com/o/oauth2/v2/auth?scope=email+openid&redirect_uri=https://localhost:5001/auth&response_type=code&client_id=605865129946-9dh1mjotllviruol1b4tcrlad178io4h.apps.googleusercontent.com";
            return Redirect(googleAuth);
        }

        [HttpGet("/auth")]
        public async Task<IActionResult> Auth(string code)
        {

            string request = "";
            if (code != null)
            {
                request = "https://accounts.google.com/o/oauth2/v2/token?code=" + code + "&client_id=605865129946-9dh1mjotllviruol1b4tcrlad178io4h.apps.googleusercontent.com&client_secret=l3GY_8FhXxsMcSeWh8NUdlb3&redirect_uri=https://localhost:5001/auth&grant_type=authorization_code";
            }

            GoogleToken token = await Services.AuthenticationService.PostTo(code);


            return RedirectToAction("VerifyToken"/*, token.id_token*/);
            //return Redirect(request);
        }

        [HttpGet]
        public IActionResult VerifyToken(string token)
        {
            string request = "https://oauth2.googleapis.com/tokeninfo?id_token=" + token;
            return Redirect(request);
        }

    }
}