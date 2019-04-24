using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;
using TodoWebApp.Models;

namespace TodoWebApp.Models
{
    public class Assignee
    {
        public long Id { get; set; }
        [Required]
        public string Name { get; set; }
        [Required]
        public string Email{ get; set; }

        public virtual List<Todo> Todos { get; set; }
    }
}
