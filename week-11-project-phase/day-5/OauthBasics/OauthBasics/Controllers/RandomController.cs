using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace OauthBasics.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class RandomController : ControllerBase
    {
    }

    //[Route("/b")]
    //public IActionResult SignIn()
    //{
    //    var authProperties = new AuthenticationProperties
    //    {
    //        RedirectUri = "/login"
    //    };
    //    return new ChallengeResult(GoogleDefaults.AuthenticationScheme, authProperties);
    //}

    //public IActionResult Login(string returnUrl) =>
    //    new ChallengeResult(
    //        GoogleDefaults.AuthenticationScheme,
    //        new AuthenticationProperties
    //        {
    //            RedirectUri = Url.Action(nameof(LoginCallback), new { returnUrl })
    //        });

    //[Route("/login")]
    //public async Task<IActionResult> LoginCallback(string returnUrl)
    //{
    //    var authenticateResult = await HttpContext.AuthenticateAsync("External");

    //    if (!authenticateResult.Succeeded)
    //        return BadRequest();

    //    var claimsIdentity = new ClaimsIdentity("Application");

    //    claimsIdentity.AddClaim(authenticateResult.Principal.FindFirst(ClaimTypes.Name));
    //    claimsIdentity.AddClaim(authenticateResult.Principal.FindFirst(ClaimTypes.Email));

    //    await HttpContext.SignInAsync(
    //        "Application",
    //        new ClaimsPrincipal(claimsIdentity),
    //        new AuthenticationProperties { IsPersistent = true }); // IsPersistent will set a cookie that lasts for two weeks (by default).

    //    return LocalRedirect(returnUrl);
    //}


    

    //[HttpGet("/ExternalLoginCallback")]
    //public IActionResult onSignIn(googleUser)
    //{
    //    var id_token = googleUser.getAuthResponse().id_token;
    //    return Ok();
    //}

    //[HttpGet]
    //    [AllowAnonymous]
    //    public IActionResult ExternalLogin(string provider, string returnUrl = null)
    //    {
    //        //var redirectUrl = Url.Action("ExternalLoginCallback", "Account", new { ReturnUrl = returnUrl });
    //        //var properties = _signInManager.ConfigureExternalAuthenticationProperties(provider, redirectUrl);
    //        return new ChallengeResult(provider);
    //    }

    //[HttpPost]
    //[Route("signin/{provider}")]
    //public IActionResult SignIn(string provider, string returnUrl = null) =>
    //Challenge(new AuthenticationProperties { RedirectUri = returnUrl ?? "/" }, provider);
}