package br.edu.vianna.projetoaula.model;

import br.edu.vianna.projetoaula.model.Categoria;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-05T20:30:33")
@StaticMetamodel(Tarefa.class)
public class Tarefa_ { 

    public static volatile SingularAttribute<Tarefa, String> Descricao;
    public static volatile SingularAttribute<Tarefa, Date> dataPlanejada;
    public static volatile SingularAttribute<Tarefa, Categoria> Categoria;
    public static volatile SingularAttribute<Tarefa, Integer> horasGastas;
    public static volatile SingularAttribute<Tarefa, Integer> Id;
    public static volatile SingularAttribute<Tarefa, Boolean> Concluida;
    public static volatile SingularAttribute<Tarefa, Date> dataFinalizada;

}