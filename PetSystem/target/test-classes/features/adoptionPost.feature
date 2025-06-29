Feature: Публикуване и одобряване на обява за осиновяване

  Scenario: Собственик създава нова обява
    Given Собственикът е автентикиран
    When попълни форма със заглавие "Коте за осиновяване" и описание "Много мило"
    Then системата запазва обявата със статус "в изчакване"

  Scenario: Администратор одобрява обявата
    Given Администраторът вижда нова обява със статус "в изчакване"
    When я одобри
    Then обявата се публикува със статус "одобрена"

  Scenario: Администратор отхвърля обявата
    Given Администраторът вижда нова обява със статус "в изчакване"
    When я отхвърли
    Then обявата се отбелязва със статус "отхвърлена"

  Scenario: Създаване на обява без заглавие – грешка
    Given Собственикът е влязъл в системата
    When попълни форма със заглавие "" и описание "Куче, търсещо дом"
    Then системата показва съобщение за грешка: "Заглавието е задължително поле"
