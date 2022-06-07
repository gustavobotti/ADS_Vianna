import React, { useState, useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import axios from 'axios';

const ProdutoConsultar = () => {
    const [ dados, setDados ] = useState(
        {
            carregando: true,
            objeto: null,
            objetoInclusao: { insumo: '', qtd: '' }
        });

    let { id } = useParams();

    useEffect(() => {
        if (dados.carregando) {
            axios.get(`/api/produto/${id}`).then(resp => {
                setDados({ objeto: resp.data, carregando: false });
                console.log(resp.data);
            });
        }
    });

    if (dados.carregando) {
        return <div>Carregando...</div>;
    }

    return (
        <div>
            <h4>Consultando produto</h4>
            <form>
                <div className="form-group">
                    <label>Nome</label>
                    <input type="text" readOnly={true} className="form-control" value={dados.objeto.descricao} />
                </div>
                <div className="form-group">
                    <label>Preço</label>
                    <input type="text" readOnly={true} className="form-control" value={dados.objeto.preco} />
                </div>
                <hr />
                <h5>Insumos</h5>
                <table className='table table-striped' aria-labelledby="tabelLabel">
                    <thead>
                        <tr>
                            <th>Insumo</th>
                            <th>Quantidade</th>
                        </tr>
                    </thead>
                    <tbody>
                        {dados.objeto.insumos.map(obj =>
                            <tr key={obj.id}>
                                <td>{obj.insumo}</td>
                                <td>{obj.qtd}</td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </form>
            <Link to="/produtos" className="btn btn-secondary" style={{width: "100px"}}>Voltar</Link>
        </div>
    );
}

export default ProdutoConsultar;