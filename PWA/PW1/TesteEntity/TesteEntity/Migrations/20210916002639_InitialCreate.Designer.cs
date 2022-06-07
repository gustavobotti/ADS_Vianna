﻿// <auto-generated />
using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using TesteEntity.Data;

namespace TesteEntity.Migrations
{
    [DbContext(typeof(Contexto))]
    [Migration("20210916002639_InitialCreate")]
    partial class InitialCreate
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("Relational:MaxIdentifierLength", 128)
                .HasAnnotation("ProductVersion", "5.0.10")
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("TesteEntity.Models.Pessoa", b =>
                {
                    b.Property<Guid>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("uniqueidentifier");

                    b.Property<string>("Nome")
                        .HasColumnType("nvarchar(max)");

                    b.HasKey("Id");

                    b.ToTable("Pessoa");
                });

            modelBuilder.Entity("TesteEntity.Models.PessoaContato", b =>
                {
                    b.Property<Guid>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("uniqueidentifier");

                    b.Property<string>("Contato")
                        .HasColumnType("nvarchar(max)");

                    b.Property<Guid>("PessoaId")
                        .HasColumnType("uniqueidentifier");

                    b.HasKey("Id");

                    b.HasIndex("PessoaId");

                    b.ToTable("PessoaContato");
                });

            modelBuilder.Entity("TesteEntity.Models.PessoaContato", b =>
                {
                    b.HasOne("TesteEntity.Models.Pessoa", null)
                        .WithMany("Contatos")
                        .HasForeignKey("PessoaId")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();
                });

            modelBuilder.Entity("TesteEntity.Models.Pessoa", b =>
                {
                    b.Navigation("Contatos");
                });
#pragma warning restore 612, 618
        }
    }
}
