import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

const ProdutoLista = () => {
    const [dados, setDados] = useState({ carregando: true, objetos: [] });

    useEffect(() => {
        if(dados.carregando) {
            axios.get('/api/produto').then(resp => {
                setDados({ objetos: resp.data, carregando: false });
            });
        }
    });

    const deletar = (id) => {
        axios.delete(`/api/produto/${id}`).then(resp => {
            console.log(resp);
            setDados({ objetos: dados.objetos, carregando: true });
        });
    };

    if (dados.carregando) {
        return <div>Carregando...</div>;
    }

    return (
        <div>
            <Link to="/produtos/incluir" className="btn btn-success" style={{ width: "100px" }}>Incluir</Link>
            <table className='table table-striped' aria-labelledby="tabelLabel">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                    </tr>
                </thead>
                <tbody>
                    {dados.objetos.map(obj =>
                        <tr key={obj.id}>
                            <td>{obj.id}</td>
                            <td>{obj.descricao}</td>
                            <td>
                                <Link to={`/produtos/consultar/${obj.id}`} className="btn btn-secondary" style={{ width: "100px", marginRight: "5px" }}>Consultar</Link>
                                <Link to={`/produtos/alterar/${obj.id}`} className="btn btn-warning" style={{ width: "100px", marginRight: "5px" }}>Alterar</Link>
                                <button className="btn btn-danger" style={{ width: "100px" }} onClick={ () => deletar(obj.id) }>Excluir</button>
                            </td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    );
}

export default ProdutoLista;