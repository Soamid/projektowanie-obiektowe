## Lab 2: Dzwoni kuzyn

Celem laba jest zapoznanie studentów z zasadami SOLID jak i innymi podstawowymi regułami którymi należy się kierować w trakcie implementacji systemu.

Zadaniem będzie refactor istniejącego kodu - coś z czym w swojej ścieżce zawodowej zapewne spotkacie się nieraz.

Starałem się go napisać tak źle i brzydko jak się tylko da - samo zrozumienie co się właściwie dzieje może być już wyzwaniem.

Ogółem rzecz biorąc ten kod jest:
 - Niezrozumiały
 - Ciężko rozszerzalny (bardzo często trzeba mocno ingerować w istniejący już kod)
 - Nieodporny na błędy użytkownika - sygnatury metod pozwalają bardzo łatwo
Do tego nawet nie wiem czy działa - ale tym się nie przejmujemy narazie, testy będą później w toku kursu.

### Zadanie 1

Zapoznaj się z dostarczonym kodem i poczyń odpowiedni refactor, tak aby kod spełniał zasady SOLID i nie łamał innych dobrych praktyk programowania.

**Bardzo ważne: Notuj sobie gdzieś zmiany i powód tych zmian - przykładowo: Wprowadziłem dodatkową klasę X, ponieważ klasa Y miałą więcej niż jedną odpowiedzialność.**
Istnieje spora szansa że będę z tego pytał przy oddawaniu laba

*Jak dużo trzeba zrobić?*

Refactorować kod można bez końca tak aby był ✨perfekcyjny✨, jednak gdzieś trzeba postawić granicę.
Każda zasada z SOLIDa jest złamana przynajmniej raz - wystarczy naprawić każdą z nich przynajmniej raz.
Niemniej oczywiście, jeśli zauważysz złamianie zasady w innym miejscu, gorąco zachęcam aby tą część kodu również poprawić.

### Zadanie 2
Jest taka metoda co zapisuje zdjęcia do chmury - dodaj nowego clouda do którego możnaby zapisać zdjęcia. Złamianie której zasady uniemożliwiło łatwe dodanie nowego clouda?

Dodatkowo zaproponuj jakieś rozszerzenie istniejącego systemu. Zwróć uwagę na to, aby sposób jego realizacji był zgodny z którąś zasada z SOLID.

Może być to przykładowo dodanie nowej funkcjonalności do telefonu (ale dłuższej niż 5 linii), wzbogacenie telefonu o interakcję z innym urządzeniem/klasą (np. nadajnik GPS), lub wprowadzenie nowego telefonu.

Chciałbym aby przy oddawaniu laba, odpowiedź z tego zadanie wyglądała jakoś tak: "Wprowadziłem/am nową funkcjonalność X, została zreazlizowana z dodaniem tej i tej klasy, w celu zachowania zasady Y".

### Materiały

 - [Prezentacja z zajęć](https://www.canva.com/design/DAHDXA-8S_o/8jr39VzRfcMIRkV0TwWMPA/view?utm_content=DAHDXA-8S_o&utm_campaign=designshare&utm_medium=link2&utm_source=uniquelinks&utlId=hbabf327b6a)
 - [Prezentacja z Programowania Obiektowego](https://www.canva.com/design/DAGbt85OPV0/RjGm17Fnxssa2XNvDme4yA/view?utm_content=DAGbt85OPV0&utm_campaign=designshare&utm_medium=link2&utm_source=uniquelinks&utlId=he2f1c89ef7)

Powodzenia!