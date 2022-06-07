using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Text;
using TesteEntity.Models;

namespace TesteEntity.Data
{
    public class Contexto : DbContext
    {
        public DbSet<Pessoa> Pessoa { get; set; }
        public DbSet<PessoaContato> PessoaContato { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Pessoa>().HasMany(x => x.Contatos).WithOne().HasForeignKey(x => x.PessoaId).OnDelete(DeleteBehavior.Cascade);
            modelBuilder.Entity<Pessoa>().Property(x => x.Id).ValueGeneratedOnAdd();
            modelBuilder.Entity<PessoaContato>().Property(x => x.Id).ValueGeneratedOnAdd();
        }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(RetornarStringConexao());
        }

        private static string RetornarStringConexao()
        {
            return "Integrated Security=SSPI;Persist Security Info=False;" +
                "Initial Catalog=Teste_EF;" +
                @"Data Source=localhost\SQLEXPRESS";
        }
    }
}
