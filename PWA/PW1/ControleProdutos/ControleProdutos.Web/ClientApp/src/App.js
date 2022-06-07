import React, { Component } from 'react';
import { Route } from 'react-router';
import { Layout } from './components/Layout';
import { Home } from './components/Home';
import ProdutoLista from './components/Produtos/ProdutoLista';
import ProdutoConsultar from './components/Produtos/ProdutoConsultar';
import ProdutoAlterar from './components/Produtos/ProdutoAlterar';
import ProdutoIncluir from './components/Produtos/ProdutoIncluir';
import AuthorizeRoute from './components/api-authorization/AuthorizeRoute';
import ApiAuthorizationRoutes from './components/api-authorization/ApiAuthorizationRoutes';
import { ApplicationPaths } from './components/api-authorization/ApiAuthorizationConstants';

import './custom.css'

export default class App extends Component {
    static displayName = App.name;

    render() {
        return (
            <Layout>
                <Route exact path='/' component={Home} />
                {/*<AuthorizeRoute path='/produtos' component={ProdutoLista} />*/}
                <Route exact path='/produtos' component={ProdutoLista} />
                <Route exact path='/produtos/incluir' component={ProdutoIncluir} />
                <Route exact path='/produtos/consultar/:id' component={ProdutoConsultar} />
                <Route exact path='/produtos/alterar/:id' component={ProdutoAlterar} />
                <Route path={ApplicationPaths.ApiAuthorizationPrefix} component={ApiAuthorizationRoutes} />
            </Layout>
        );
    }
}
