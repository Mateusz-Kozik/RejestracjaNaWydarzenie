# Rejestracja na wydarzenie – aplikacja Android

## Opis projektu

Aplikacja Android napisana w języku Java, która umożliwia rejestrację na wydarzenie.

Projekt pokazuje umiejętność:

- Przekazywania danych między aktywnościami przy użyciu Intent extras
- Odbierania wyniku z drugiej aktywności
- Walidacji danych formularza
- Obsługi RESULT_OK i RESULT_CANCELED

---

## Funkcjonalności aplikacji

### Formularz rejestracji (MainActivity)

Użytkownik może podać:

- Imię
- Email
- Typ biletu (Spinner)
- Akceptować regulamin (CheckBox)

Dane są walidowane przed przejściem dalej.

---

### Podsumowanie rejestracji (SummaryActivity)

Po poprawnej walidacji dane są przekazywane do drugiej aktywności.

Użytkownik może:

- Potwierdzić rejestrację
- Anulować rejestrację

Aplikacja zwraca wynik do ekranu głównego.

---

## Technologie

- Java  
- Android SDK  
- Activity Result API  
- Intent Extras  

---

## Struktura projektu

- MainActivity – formularz rejestracji  
- SummaryActivity – podsumowanie danych  

---

## Autor

Mateusz Kozik
Klasa 4R

---

## 📅 Data

2026
