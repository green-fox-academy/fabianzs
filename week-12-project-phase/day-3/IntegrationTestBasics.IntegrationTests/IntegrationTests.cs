using Microsoft.AspNetCore.Mvc.Testing;
using System;
using System.Collections.Generic;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using Xunit;

namespace IntegrationTestBasics.IntegrationTests
{
    public class IntegrationTests : IClassFixture<WebApplicationFactory<Startup>>
    {
        private readonly WebApplicationFactory<Startup> factory;

        public IntegrationTests(WebApplicationFactory<Startup> factory)
        {
            this.factory = factory;
        }

        [Fact]
        public async Task MainPageLoadsSuccessfully()
        {
            var responseMessage = await factory.CreateClient().GetAsync("/");

            responseMessage.EnsureSuccessStatusCode();
        }

        [Fact]
        public async Task Groot_ExistingParameter_Returns200()
        {
            var responseMessage = await factory.CreateClient().GetAsync("/groot?message=hi");

            Assert.Equal(HttpStatusCode.OK, responseMessage.StatusCode);
            Assert.Equal("{\"received\":\"hi\",\"translated\":\"I am Groot!\"}", responseMessage.Content.ReadAsStringAsync().Result);
        }

        [Fact]
        public async Task Groot_MissingParameter_Returns400()
        {
            var responseMessage = await factory.CreateClient().GetAsync("/groot");

            Assert.Equal(HttpStatusCode.BadRequest, responseMessage.StatusCode);
            Assert.Equal("{\"error\":\"I am Groot!\"}", responseMessage.Content.ReadAsStringAsync().Result);
        }
    }
}
