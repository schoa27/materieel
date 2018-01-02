Feature: Het instellen van de taal en de bestands paden voor de applicatie

  Scenario: De browser is gestart en staat in de setup pagina en er wordt gekozen voor de Nederlandse taal
    Given De browser is gestart
    Given De setup pagina is geopend
    When Selecteer de Nederlandse taal in Dropdown overzicht Change the language
    Then De Setup pagina wordt getoond in het nederlands getoond
    And De browser wordt gesloten

  Scenario: De browser is gestart en staat in de setup pagina bestands paden worden gevuld
    Given De browser is gestart
    Given De setup pagina is geopend
    When Selecteer de Nederlandse taal in Dropdown overzicht Change the language
    And Pad voor het XML bestand wordt in gevuld
    And  Pad voor de afbeedling wordt in gevuld
    And  Wordt op de Doorgaan knop gedrukt
    Then Overzicht pagina wordt getoond met alle instellingen
    And De browser wordt gesloten