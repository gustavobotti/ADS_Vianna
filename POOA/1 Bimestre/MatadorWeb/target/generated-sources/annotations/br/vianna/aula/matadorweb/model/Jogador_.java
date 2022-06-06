package br.vianna.aula.matadorweb.model;

import br.vianna.aula.matadorweb.model.Time;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-04-10T23:17:46")
@StaticMetamodel(Jogador.class)
public class Jogador_ { 

    public static volatile SingularAttribute<Jogador, Integer> idJogador;
    public static volatile SingularAttribute<Jogador, String> nome;
    public static volatile SingularAttribute<Jogador, Integer> numeroGols;
    public static volatile SingularAttribute<Jogador, Time> time;

}