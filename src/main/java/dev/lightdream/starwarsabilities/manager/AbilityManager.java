package dev.lightdream.starwarsabilities.manager;

import dev.lightdream.starwarsabilities.ability.Ability;

import java.util.ArrayList;
import java.util.List;

public class AbilityManager {

    public List<Ability> abilityList = new ArrayList<>();

    public void registerAbility(Ability ability) {
        abilityList.add(ability);
    }

    @SuppressWarnings("unchecked")
    public <T> T getAbility(Class<T> clazz) {
        for (Ability ability : abilityList) {
            if (ability.getClass() == clazz) {
                return (T) ability;
            }
        }

        return null;
    }

}
