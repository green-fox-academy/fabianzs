using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.AspNetCore.Authentication.OpenIdConnect;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc.Authorization;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.IdentityModel.Protocols.OpenIdConnect;
using Microsoft.IdentityModel.Tokens;
using OauthBasics.Services;

namespace OauthBasics
{
    public class Startup
    {

        private readonly IConfiguration configuration;


        public Startup(IConfiguration configuration)
        {
            this.configuration = configuration;
        }

        public void ConfigureServices(IServiceCollection services)
        {
            services.AddCors();
            services.AddMvc();
            //services.AddDefaultIdentity<IdentityUser>()
            //    .AddDefaultUI(UIFramework.Bootstrap4)
            //    .AddEntityFrameworkStores<ApplicationDbContext>();
            //services.AddAuthentication(o =>
            //{
            //    o.DefaultScheme = "Application";
            //    o.DefaultSignInScheme = "External";
            //})
            //    .AddCookie("Application")
            //    .AddCookie("External")
            //    .AddGoogle("Google", googleOptions =>
            //{
            //    googleOptions.ClientId = configuration["Authentication:Google:ClientId"];
            //    googleOptions.ClientSecret = configuration["Authentication:Google:ClientSecret"];
            //    googleOptions.UserInformationEndpoint = "https://www.googleapis.com/oauth2/v2/userinfo";
            //    googleOptions.ClaimActions.Clear();
            //    googleOptions.ClaimActions.MapJsonKey(ClaimTypes.NameIdentifier, "id");
            //    googleOptions.ClaimActions.MapJsonKey(ClaimTypes.Name, "name");
            //    googleOptions.ClaimActions.MapJsonKey(ClaimTypes.GivenName, "given_name");
            //    googleOptions.ClaimActions.MapJsonKey(ClaimTypes.Surname, "family_name");
            //    googleOptions.ClaimActions.MapJsonKey("urn:google:profile", "link");
            //    googleOptions.ClaimActions.MapJsonKey(ClaimTypes.Email, "email");
            //})
            //.AddOpenIdConnect(o =>
            //{
            //    o.AuthenticationMethod = "oidc";
            //    o.SignInScheme = "Cookies";
            //    o.Authority = "https://{yourOktaDomain}";
            //    o.ResponseType = OpenIdConnectResponseType.Code;
            //    o.ClientId = "{clientId}";
            //    o.ClientSecret = "{clientSecret}";
            //    o.GetClaimsFromUserInfoEndpoint = true;
            //    o.TokenValidationParameters = new TokenValidationParameters
            //    {
            //        ValidateIssuer = true
            //    };
            //    o.SaveTokens = true;
            //})
            //;

            services.Configure<AppSettings>(configuration.GetSection("AppSettings"));
            services.AddAuthorization(auth =>
            {
                auth.AddPolicy("Bearer", new AuthorizationPolicyBuilder()
                    .AddAuthenticationSchemes(JwtBearerDefaults.AuthenticationScheme‌​)
                    .RequireAuthenticatedUser().Build());
            });

            services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme).AddJwtBearer(options =>
            {
                options.TokenValidationParameters = new TokenValidationParameters
                {
                    ValidateIssuer = false,
                    ValidateAudience = false,
                    ValidateIssuerSigningKey = true,
                    ValidateLifetime = true,
                    IssuerSigningKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(configuration.GetSection("AppSettings").Get<AppSettings>().Secret)),
                    ClockSkew = TimeSpan.Zero
                };
            });



            services.AddMvc();
            services.AddSingleton<IAuthService, AuthService>();

        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }

            app.UseMvc(routes =>
            {
                routes.MapRoute(
                    name: "default",
                    template: "{controller=Oauth}/{action=Index}");
            });
            app.UseAuthentication();
            app.UseCors(x => x
                .AllowAnyOrigin()
                .AllowAnyMethod()
                .AllowAnyHeader());

            app.Run(async (context) =>
            {
                await context.Response.WriteAsync("Hello World!");
            });
        }
    }
}
