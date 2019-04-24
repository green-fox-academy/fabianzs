using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OauthBasics.Models
{
    public class TokenInfo
    {
        public string iss { get; set; }
        public string azp { get; set; }
        public string aud { get; set; }
        public string sub { get; set; }
        public string email { get; set; }
        public bool email_verified { get; set; }
        public string at_hash { get; set; }
        public string iat { get; set; }
        public string exp { get; set; }
        public string alg { get; set; }
        public string kid { get; set; }
        public string typ { get; set; }
    }
}
