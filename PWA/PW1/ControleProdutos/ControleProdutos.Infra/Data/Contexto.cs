using ControleProdutos.Entidades.Entidades;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Text;

namespace ControleProdutos.Infra.Data
{
    public class Contexto : DbContext
    {
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
            modelBuilder.Entity<Produto>().HasMany(x => x.Insumos).WithOne().HasForeignKey(y => y.ProdutoId).OnDelete(DeleteBehavior.Cascade);
            modelBuilder.Entity<Produto>().Property(x => x.Id).ValueGeneratedOnAdd();
            modelBuilder.Entity<ProdutoInsumo>().Property(x => x.Id).ValueGeneratedOnAdd();
        }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(RetornarStringConexao(), b => b.MigrationsAssembly("ControleProdutos.Infra"));
        }

        private static string RetornarStringConexao()
        {
            return "Integrated Security=SSPI;Persist Security Info=False;" +
                "Initial Catalog=Trabalho_001;" +
                @"Data Source=localhost\SQLEXPRESS";
        }

        public DbSet<Produto> Produto { get; set; }
        public DbSet<ProdutoInsumo> ProdutoInsumo { get; set; }
    }
}
