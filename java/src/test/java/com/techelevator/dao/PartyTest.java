package com.techelevator.dao;

import com.techelevator.model.Party;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PartyTest {

    @Test
    public void sort_characters_by_id() {
        Party party = new Party();
        party.setCharacterOne(3);
        party.setCharacterTwo(4);
        party.setCharacterThree(2);
        party.setCharacterFour(1);

        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        expectedList.add(4);


        Assert.assertArrayEquals(expectedList.toArray(), party.retrieveCharacterIdOrdered().toArray());

    }

}
