package com.exito.test.automation.e2e.models.scena.screenplay;

//import net.serenitybdd.core.collect.NewList;
import net.serenitybdd.model.collect.NewList;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static java.util.Arrays.asList;

/**
 * Copy de clase Cast
 */
public class Camerino extends Cast {

    private final List<Ability> standardAbilities;
    private final List<Consumer<Actor>> abilityProviders;
    Map<String, Actor> elenco = new HashMap<>();

    private Camerino() {
        this(new Ability[]{});
    }

    private Camerino(Ability[] abilities) {
        this.standardAbilities = asList(abilities);
        this.abilityProviders = new ArrayList<>();
    }

    @Override
    public Actor actorNamed(String actorName, Ability... abilities) {

        if (! elenco.containsKey(actorName)) {
            Actor newActor = Actor.named(actorName);

            for(Ability doSomething : abilities) {
                newActor.can(doSomething);
            }

            assignGeneralAbilitiesTo(newActor);

            elenco.put(actorName, newActor);
        }
        return elenco.get(actorName);
    }

    @Override
    public List<Actor> getActors() {
        return NewList.copyOf(elenco.values());
    }

    @Override
    public void dismissAll() {
        for (Actor actor : elenco.values()) {
            actor.wrapUp();
        }
        elenco.clear();
    }

    @Override
    protected void assignGeneralAbilitiesTo(Actor newActor) {
        standardAbilities.forEach(newActor::whoCan);
        abilityProviders.forEach(
            ability -> ability.accept(newActor)
        );
    }

    /**
     * Comportamientos adicionales/personalizados
     */

    private static Camerino camerino;

    public static Camerino delElenco()
    {
        if  (   Camerino.camerino==null )
        {
            Camerino.camerino = new Camerino();
            OnStage.setTheStage(camerino);
        }
        return Camerino.camerino;
    }

    public Map<String, Actor> getHmActors() {
        return elenco;
    }

    public Camerino preparaAlProtagonista(String enSuPapel, Actor protagonico)
    {
        Map<String, Actor> hmActors = Camerino.delElenco().getHmActors();

        hmActors.computeIfAbsent(enSuPapel, k -> protagonico);

        //if !hmActors.containsKey(enSuPapel)
        //  hmActors.put(enSuPapel,protagonico)

        return Camerino.delElenco();
    }
}
