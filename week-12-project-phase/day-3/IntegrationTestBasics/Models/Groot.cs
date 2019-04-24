using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace IntegrationTestBasics.Models
{
    public class Groot
    {
        public string Received { get; set; }
        public string Translated { get; set; }

        public Groot(string received)
        {
            Received = received;
            Translated = "I am Groot!";
        }
    }
}
