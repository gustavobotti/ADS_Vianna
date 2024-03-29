﻿import React, { useState, useEffect } from 'react';
import { Link, useParams, useHistory } from 'react-router-dom';
import axios from 'axios';

const ProdutoAlterar = () => {
    const [dados, setDados] = useState(
        {
            carregando: true,
            objeto: null,
            objetoInclusao: { insumo: '', qtd: ''}
        });

    let { id } = useParams();

    const changeInput = (e) => {
        let obj = dados.objeto;
        obj[e.target.name] = e.target.value;
        setDados({ ...dados, objeto: obj });
    };

    const changeInputDetalhe = (e) => {
        let obj = dados.objetoInclusao;
        obj[e.target.name] = e.target.value;
        setDados({ ...dados, objetoInclusao: obj });
    };

    let history = useHistory();

    const salvar = () => {
        axios.put(`/api/produto/${id}`, dados.objeto).then(resp => {
            console.log(resp);
            history.push("/produtos");
        });
    };

    useEffect(() => {
        if (dados.carregando) {
            axios.get(`/api/produto/${id}`).then(resp => {
                setDados({ objeto: resp.data, carregando: false, objetoInclusao: { insumo: '', qtd: ''} });
            });
        }
    });

    if (dados.carregando) {
        return <div>Carregando...</div>;
    }

    const incluirInsumo = () => {
        let obj = { ...dados.objeto };
        obj.insumos = [...obj.insumos, dados.objetoInclusao];
        setDados({ ...dados, objeto: obj, objetoInclusao: { insumo: '', qtd: '' } });
    };

    const excluirInsumo = (insumo) => {
        let obj = { ...dados.objeto };
        obj.insumos = obj.insumos.filter(x => x.insumo !== insumo);
        setDados({ ...dados, objeto: obj });
    };

    return (
        <div>
            <h4>Alterando produto</h4>
            <form>
                <div className="form-group">
                    <label>Nome</label>
                    <input type="text" name="descricao" className="form-control" value={dados.objeto.descricao} onChange={changeInput} />
                </div>
                <div className="form-group">
                    <label>Preço</label>
                    <input type="text" name="preco" className="form-control" value={dados.objeto.preco} onChange={changeInput} />
                </div>
            </form>
            <hr />
            <h5>Insumos</h5>
            <div className="form-group">
                <label>Insumo</label>
                <input type="text" className="form-control" name="insumo" value={dados.objetoInclusao.insumo} onChange={changeInputDetalhe} />
                <label>Quantidade</label>
                <input type="text" className="form-control" name="qtd" value={dados.objetoInclusao.qtd} onChange={changeInputDetalhe} />
                <button className="btn btn-success" style={{ width: "100px" }} onClick={incluirInsumo}>Incluir</button>
            </div>
            <table className='table table-striped' aria-labelledby="tabelLabel">
                <thead>
                    <tr>
                        <th>Insumo</th>
                        <th>Quantidade</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {dados.objeto.insumos.map(obj =>
                        <tr key={obj.id}>
                            <td>{obj.insumo}</td>
                            <td>{obj.qtd}</td>
                            <td>
                                <button className="btn btn-danger" style={{ width: "100px" }} onClick={() => excluirInsumo(obj.insumo) }>Excluir</button>
                            </td>
                        </tr>
                    )}
                </tbody>
            </table>
            <button className="btn btn-primary" style={{ width: "100px", marginRight: "5px" }} onClick={salvar}>Salvar</button>
            <Link to="/produtos" className="btn btn-secondary" style={{width: "100px"}}>Voltar</Link>
        </div>
    );
}

export default ProdutoAlterar;