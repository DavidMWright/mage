package org.mage.test.cards.single.m21;

import mage.constants.PhaseStep;
import mage.constants.Zone;
import org.junit.Ignore;
import org.junit.Test;
import org.mage.test.serverside.base.CardTestPlayerBase;

public class DemonicEmbraceTest extends CardTestPlayerBase {

    @Test
    @Ignore
    public void playFromGraveyard() {
        // Enchanted creature gets +3/+1, has flying, and is a Demon in addition to its other types.
        // You may cast Demonic Embrace from your graveyard by paying 3 life and discarding a card in addition to paying its other costs.
        addCard(Zone.GRAVEYARD, playerA, "Demonic Embrace");
        addCard(Zone.BATTLEFIELD, playerA, "Swamp", 3);
        addCard(Zone.HAND, playerA, "Mountain");
        addCard(Zone.BATTLEFIELD, playerA, "Grizzly Bears");

        castSpell(1, PhaseStep.PRECOMBAT_MAIN, playerA, "Demonic Embrace", "Grizzly Bears");
        //addTarget(playerA, );
        addTarget(playerA, "Mountain");
        setStrictChooseMode(true);
        setStopAt(1, PhaseStep.POSTCOMBAT_MAIN);
        execute();
        assertAllCommandsUsed();
    }
}
