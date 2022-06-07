//using System;
//using Microsoft.EntityFrameworkCore.Migrations;

//namespace ControleProdutos.Infra.Migrations
//{
//    public partial class InitialCreate : Migration
//    {
//        protected override void Up(MigrationBuilder migrationBuilder)
//        {
//            migrationBuilder.CreateTable(
//                name: "Produto",
//                columns: table => new
//                {
//                    Id = table.Column<Guid>(type: "uniqueidentifier", nullable: false),
//                    Descricao = table.Column<string>(type: "nvarchar(max)", nullable: true)
//                },
//                constraints: table =>
//                {
//                    table.PrimaryKey("PK_Produto", x => x.Id);
//                });

//            migrationBuilder.CreateTable(
//                name: "ProdutoInsumo",
//                columns: table => new
//                {
//                    Id = table.Column<Guid>(type: "uniqueidentifier", nullable: false),
//                    ProdutoId = table.Column<Guid>(type: "uniqueidentifier", nullable: false),
//                    Insumo = table.Column<string>(type: "nvarchar(max)", nullable: true)
//                },
//                constraints: table =>
//                {
//                    table.PrimaryKey("PK_ProdutoInsumo", x => x.Id);
//                    table.ForeignKey(
//                        name: "FK_ProdutoInsumo_Produto_ProdutoId",
//                        column: x => x.ProdutoId,
//                        principalTable: "Produto",
//                        principalColumn: "Id",
//                        onDelete: ReferentialAction.Cascade);
//                });

//            migrationBuilder.CreateIndex(
//                name: "IX_ProdutoInsumo_ProdutoId",
//                table: "ProdutoInsumo",
//                column: "ProdutoId");
//        }

//        protected override void Down(MigrationBuilder migrationBuilder)
//        {
//            migrationBuilder.DropTable(
//                name: "ProdutoInsumo");

//            migrationBuilder.DropTable(
//                name: "Produto");
//        }
//    }
//}
