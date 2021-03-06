Feature: Ophalen van lijs met locomotieven, waggons, stammen

  Scenario: Ophalen van lijst met locomotievem
    Given De browser is gestart
    Given De setup pagina is geopend
    When Selecteer de Nederlandse taal in Dropdown overzicht Change the language
    And Pad voor het XML bestand wordt in gevuld
    And Pad voor kleine de afbeedlingen wordt in gevuld
    And Pad voor grote de afbeedlingen wordt in gevuld
    And Wordt op de Doorgaan knop gedrukt
    And Bij volgende pagina wordt op de knop "Locomotief" Overzicht gedrukt
    Then wordt een lijst met "locomotieven" getoond
    And De browser wordt gesloten


  Scenario: Ophalen van lijst met Waggons
    Given De browser is gestart
    Given De setup pagina is geopend
    When Selecteer de Nederlandse taal in Dropdown overzicht Change the language
    And Pad voor het XML bestand wordt in gevuld
    And Pad voor kleine de afbeedlingen wordt in gevuld
    And Pad voor grote de afbeedlingen wordt in gevuld
    And Wordt op de Doorgaan knop gedrukt
    And Bij volgende pagina wordt op de knop "Wagen" Overzicht gedrukt
    Then wordt een lijst met "waggons" getoond
    And De browser wordt gesloten

  Scenario: Ophalen van lijst met Trein-stammen
    Given De browser is gestart
    Given De setup pagina is geopend
    When Selecteer de Nederlandse taal in Dropdown overzicht Change the language
    And Pad voor het XML bestand wordt in gevuld
    And Pad voor kleine de afbeedlingen wordt in gevuld
    And Pad voor grote de afbeedlingen wordt in gevuld
    And Wordt op de Doorgaan knop gedrukt
    And Bij volgende pagina wordt op de knop "Stam" Overzicht gedrukt
    Then wordt een lijst met "stam-gegevens" getoond
    And De browser wordt gesloten