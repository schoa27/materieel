Feature: Starten van Materieel overzicht

  Scenario: De browser wordt gestart met adres van Materieel Overzicht
    Given De browser wordt gestart
    When Het adres van Materieel Overzicht wordt in gevuld in dres balk
    Then Setup pagina van Materieel Overzicht wordt getoond

  Scenario: De browser is gestart en staat in de setup pagina
    Given De browser is gestart
    Given De setup pagina is geopend
    When Selecteer de Nederlandse taal in Dropdown overzicht Change the language
    Then De Setup pagina wordt getoond in het nederlands getoond
