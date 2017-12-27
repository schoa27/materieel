Feature: Nadat Materieel overzicht is gestart wordt de taal gewijzigd in het Nederlands

  Scenario: De browser is gestart en staat in de setup pagina
    Given De browser is gestart
    Given De setup pagina is geopend
    When Selecteer de Nederlandse taal in Dropdown overzicht Change the language
    Then De Setup pagina wordt getoond in het nederlands getoond
