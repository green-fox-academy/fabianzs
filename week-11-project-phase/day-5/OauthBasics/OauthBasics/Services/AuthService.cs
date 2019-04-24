using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Options;
using Microsoft.IdentityModel.Tokens;
using Newtonsoft.Json;
using OauthBasics.Models;
using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Security.Claims;
using System.Text;
using System.Text.Encodings.Web;
using System.Threading.Tasks;

namespace OauthBasics.Services
{

    public class AuthService : IAuthService
    {
        private readonly AppSettings appSettings;
        private readonly IConfiguration configuration;

        public AuthService(IOptions<AppSettings> appSettings, IConfiguration configuration)
        {
            this.appSettings = appSettings.Value;
            this.configuration = configuration;
        }

        public GoogleToken GetToken(string code)
        {
            var dict = new List<KeyValuePair<string, string>>();
            dict.Add(new KeyValuePair<string, string>("code", code));
            dict.Add(new KeyValuePair<string, string>("client_id", "605865129946-9dh1mjotllviruol1b4tcrlad178io4h.apps.googleusercontent.com"));
            dict.Add(new KeyValuePair<string, string>("client_secret", "l3GY_8FhXxsMcSeWh8NUdlb3"));
            dict.Add(new KeyValuePair<string, string>("redirect_uri", "https://localhost:5001/auth"));
            dict.Add(new KeyValuePair<string, string>("grant_type", "authorization_code"));
            var client = new HttpClient();
            var req = new HttpRequestMessage(HttpMethod.Post, "https://www.googleapis.com/oauth2/v4/token");
            req.Content = new FormUrlEncodedContent(dict);
            HttpResponseMessage response = client.SendAsync(req).Result;
            string res = response.Content.ReadAsStringAsync().Result;
            GoogleToken token = JsonConvert.DeserializeObject<GoogleToken>(res);
            return token;
        }

        public bool ValidateToken(string id_token)
        {
            var client = new HttpClient();
            var req = new HttpRequestMessage(HttpMethod.Get, "https://oauth2.googleapis.com/tokeninfo?id_token=" + id_token);
            HttpResponseMessage response = client.SendAsync(req).Result;
            string res = response.Content.ReadAsStringAsync().Result;
            TokenInfo token = JsonConvert.DeserializeObject<TokenInfo>(res);
            return token.email_verified;
        }

        public string CreateJwtToken()
        {
            var tokenHandler = new JwtSecurityTokenHandler();
            var tokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new ClaimsIdentity(new Claim[]
                {
                    
                }),
                Expires = DateTime.UtcNow.AddSeconds(10),

                SigningCredentials = new SigningCredentials(new SymmetricSecurityKey(Encoding.ASCII.GetBytes(appSettings.Secret)), SecurityAlgorithms.HmacSha256Signature)
            };
            var token = tokenHandler.CreateToken(tokenDescriptor);
            var securetoken = tokenHandler.WriteToken(token);
            return securetoken;
        }

        public string GetGoogleLogin()
        {
            string base_url = "https://accounts.google.com/o/oauth2/v2/auth";
            string scope = "email+openid";
            string redirect_uri = "https://localhost:5001/auth";
            string response_type = "code";
            string client_id = configuration["Authentication:Google:ClientId"];
            return $"{base_url}?scope={scope}&redirect_uri={redirect_uri}&response_type={response_type}&client_id={client_id}";
        }
    }
}
