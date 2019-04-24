using Microsoft.Owin.Security.Google;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OauthBasics.Services
{
    public class RandomService
    {
        private GoogleOAuth2AuthenticationOptions options;

        //public bool ValidateToken(string url)
        //{
        //    using (var client = new HttpClient(new HttpClientHandler() { AutomaticDecompression = DecompressionMethods.Deflate | DecompressionMethods.GZip }) { Timeout = _timeout })
        //    {
        //        var request = new HttpRequestMessage()
        //        {
        //            RequestUri = new Uri(url),
        //            Method = HttpMethod.Get
        //        };

        //        HttpResponseMessage response = client.SendAsync(request).Result;
        //        var statusCode = (int)response.StatusCode;

        //        // We want to handle redirects ourselves so that we can determine the final redirect Location (via header)
        //        if (statusCode >= 300 && statusCode <= 399)
        //        {
        //            var redirectUri = response.Headers.Location;
        //            if (!redirectUri.IsAbsoluteUri)
        //            {
        //                redirectUri = new Uri(request.RequestUri.GetLeftPart(UriPartial.Authority) + redirectUri);
        //            }
        //            _status.AddStatus(string.Format("Redirecting to {0}", redirectUri));
        //            return ValidateToken(redirectUri);
        //        }
        //        else if (!response.IsSuccessStatusCode)
        //        {
        //            throw new Exception();
        //        }

        //        return true;
        //    }
        //}
    }
}
