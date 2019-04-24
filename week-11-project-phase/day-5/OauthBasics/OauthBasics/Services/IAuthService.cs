using OauthBasics.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OauthBasics.Services
{
    public interface IAuthService
    {
        string GetGoogleLogin();
        GoogleToken GetToken(string code);
        bool ValidateToken(string id_token);
        string CreateJwtToken();

    }
}
