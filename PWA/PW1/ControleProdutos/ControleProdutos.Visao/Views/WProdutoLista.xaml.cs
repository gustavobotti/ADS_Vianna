using ControleProdutos.Entidades.Entidades;
using ControleProdutos.Visao.ViewModels;
using System;
using System.Collections.Generic;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace ControleProdutos.Visao.Views
{
    /// <summary>
    /// Interaction logic for WProdutoLista.xaml
    /// </summary>
    public partial class WProdutoLista : Window
    {
        public WProdutoLista()
        {
            InitializeComponent();

            DataContext = new ProdutoViewModel();
        }
    }
}
