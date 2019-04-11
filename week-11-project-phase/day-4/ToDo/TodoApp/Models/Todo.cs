using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;
using TodoWebApp.Models;

namespace TodoWebApp.Models
{
    public class Todo
    {
        public long Id { get; set; }
        [Required]
        public string Title { get; set; }
        public bool IsUrgent { get; set; }
        public bool IsDone { get; set; }

        public long? AssigneeId { get; set; }
        public Assignee Assignee { get; set; } 

        public Todo()
        {
        }

        public Todo(string title)
        {
            Title = title;
        }
    }
}
