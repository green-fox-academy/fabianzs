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
        public DbSet<Assignee> Assignees { get; set; }

        public ApplicationContext(DbContextOptions options) : base(options)
        {
        }

        //protected override void OnModelCreating(ModelBuilder modelBuilder)
        //{
        //    modelBuilder.Entity<Assignee>().HasMany(i => i.Todos).WithOne(i => i.Assignee).HasForeignKey(i => i.AssigneeId);
        //    modelBuilder.Entity<Todo>().Property(i => i.AssigneeId).HasColumnName("Idegenkulcs");
        //}
    }
}
