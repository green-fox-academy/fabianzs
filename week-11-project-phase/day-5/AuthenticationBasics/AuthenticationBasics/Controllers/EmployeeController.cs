using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Linq;
using System.Security.Claims;
using System.Text;
using System.Threading.Tasks;
using AuthenticationBasics.Data;
using AuthenticationBasics.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;

namespace AuthenticationBasics.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EmployeeController : ControllerBase
    {
        private readonly ApplicationContext applicationContext;

        public EmployeeController(ApplicationContext app)
        {
            applicationContext = app;
        }

        [HttpPost("token")]
        public IActionResult Token()
        {
            var header = Request.Headers["Authorization"];
            if(header.ToString().StartsWith("Basic"))
            {
                //Using Postman authorization header 
                var credValue = header.ToString().Substring("Basic ".Length).Trim();
                var usernameAndPassEnc = Encoding.UTF8.GetString(Convert.FromBase64String(credValue));
                var usernameAndPass = usernameAndPassEnc.Split(":");

                if(applicationContext.Employees.Where(x => x.Email == usernameAndPass[0] && x.Password == usernameAndPass[1]).FirstOrDefault() != null)
                {
                    Claim[] claimData = new Claim[] { new Claim(ClaimTypes.Name, "username") };
                    SymmetricSecurityKey key = new SymmetricSecurityKey(Encoding.UTF8.GetBytes("thisisthesecretkey"));
                    var signingCred = new SigningCredentials(key, SecurityAlgorithms.HmacSha256Signature);
                    JwtSecurityToken token = new JwtSecurityToken(
                        issuer: "mysite.com",
                        audience: "mysite.com",
                        expires: DateTime.Now.AddSeconds(20),
                        claims: claimData,
                        signingCredentials: signingCred
                        );
                    var tokenString = new JwtSecurityTokenHandler().WriteToken(token);
                    return Ok(tokenString);
                }
            }
            return BadRequest();
        }

        [HttpGet]
        [Route("")]
        [Route("list")]
        public IActionResult List()
        {
            var employees = applicationContext.Employees.ToList();
            return Ok(employees);
        }

        [Authorize]
        [HttpPost]
        [Route("add")]
        public IActionResult Add(Employee employee)
        {
            applicationContext.Add(employee);
            applicationContext.SaveChanges();
            return Redirect("list");
        }
    }
}