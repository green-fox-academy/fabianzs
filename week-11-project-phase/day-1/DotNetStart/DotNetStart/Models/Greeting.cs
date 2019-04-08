using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DotNetStart.Models
{
    public class Greeting
    {
        public Greeting(long id, string content)
        {
            Id = id;
            Content = content;
        }

        public long Id { get; set; }
        public string Content { get; set; }
    }
}
