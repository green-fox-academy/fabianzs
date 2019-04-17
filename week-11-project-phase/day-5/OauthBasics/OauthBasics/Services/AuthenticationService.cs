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
    public class AuthenticationService
    {

        public static async Task<GoogleToken> PostTo(string code)
        {
            var dict = new List<KeyValuePair<string, string>>();
            dict.Add(new KeyValuePair<string, string>("code", code));
            dict.Add(new KeyValuePair<string, string>("client_id", "605865129946-9dh1mjotllviruol1b4tcrlad178io4h.apps.googleusercontent.com"));
            dict.Add(new KeyValuePair<string, string>("client_secret", "l3GY_8FhXxsMcSeWh8NUdlb3"));
            dict.Add(new KeyValuePair<string, string>("redirect_uri", "https://localhost:5001/auth"));
            dict.Add(new KeyValuePair<string, string>("grant_type", "authorization_code"));
            var client = new HttpClient();
            var req = new HttpRequestMessage(HttpMethod.Post, "https://accounts.google.com/o/oauth2/v4/token/");
            req.Content = new FormUrlEncodedContent(dict);
            HttpContent content = new FormUrlEncodedContent(dict);
            HttpResponseMessage response = client.SendAsync(req).Result;
            //string res = await response.Content.ReadAsStringAsync();
            HttpResponseMessage resp = client.PostAsync("https://accounts.google.com/o/oauth2/v4/token", content).Result;
            string result = await content.ReadAsStringAsync();
            Console.WriteLine(result);
            string res = await resp.Content.ReadAsStringAsync();
            GoogleToken token = JsonConvert.DeserializeObject<GoogleToken>(res);
            return token;
         
        }

        public static void CreateToken()
        {
            var tokenHandler = new JwtSecurityTokenHandler();
            var key = Encoding.ASCII.GetBytes("secretcode");
            var tokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new ClaimsIdentity(new Claim[]
                {
                    
                }),
                Expires = DateTime.UtcNow.AddSeconds(10),

                SigningCredentials = new SigningCredentials(new SymmetricSecurityKey(key), SecurityAlgorithms.HmacSha256Signature)
            };
            var token = tokenHandler.CreateToken(tokenDescriptor);
            //user.Token = tokenHandler.WriteToken(token);
        }

        

    }
}
