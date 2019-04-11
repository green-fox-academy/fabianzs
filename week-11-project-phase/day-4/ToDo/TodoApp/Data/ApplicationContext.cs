using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TodoWebApp.Models;
using TodoWebApp.Models;

namespace TodoWebApp.Data
{
    public class ApplicationContext : DbContext
    {
        public DbSet<Todo> Todos { get; set; }
        public DbSet<Assignee> Assignee { get; set; }

        public ApplicationContext(DbContextOptions options) : base(options)
        {
        }
    }
}
