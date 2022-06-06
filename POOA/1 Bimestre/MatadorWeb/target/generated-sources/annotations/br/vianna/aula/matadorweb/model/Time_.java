package br.vianna.aula.matadorweb.model;

import br.vianna.aula.matadorweb.model.Jogador;
import br.vianna.aula.matadorweb.model.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-10T23:17:46")
@StaticMetamodel(Time.class)
public class Time_ { 

    public static volatile SingularAttribute<Time, String> nome;
    public static volatile SingularAttribute<Time, Usuario> usuario;
    public static volatile SingularAttribute<Time, Integer> idtime;
    public static volatile ListAttribute<Time, Jogador> jogadorList;
    public static volatile SingularAttribute<Time, Date> dataFundacao;

}