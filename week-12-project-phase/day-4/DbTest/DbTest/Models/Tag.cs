using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DbTest.Models
{
    public class Tag
    {
        public string TagId { get; set; }

        public virtual List<Post> Posts { get; set; }
    }
}
