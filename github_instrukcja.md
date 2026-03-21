# 🚀 Instrukcja dla studentów: Laboratoria 2026

W tym semestrze będziemy pracować z wykorzystaniem **GitHub Classroom**. Każdy z Was będzie miał własne prywatne repozytorium, do którego ja będę co tydzień wrzucał nowe zadania (foldery `lab1`, `lab2` itd.).

---

## Krok 1: Akceptacja zadania i klonowanie
1. Kliknij w link do GitHub Classroom otrzymany od prowadzącego.
2. Znajdź swoje imię i nazwisko na liście (lub dołącz do klasy, jeśli listy jeszcze nie ma).
3. GitHub automatycznie utworzy Twoje prywatne repozytorium o nazwie `laboratoria-2026-TwojLogin`.
4. Na maila dodatkowo dostaniesz zaproszenie do organizacji - zaakceptuj je.
5. Sklonuj swoje nowe repozytorium na dysk komputera:
   ```bash
   git clone https://github.com/NASZA-ORGANIZACJA/laboratoria-2026-TwojLogin.git
   cd laboratoria-2026-TwojLogin
   ```

---

## Krok 2: Konfiguracja synchronizacji (UPSTREAM) – TYLKO RAZ
Abyś mógł pobierać nowe zadania, które będę wrzucał do mojego repozytorium, musisz dodać je jako tzw. **upstream** (źródło). Wykonaj tę komendę wewnątrz folderu z projektem:

```bash
git remote add upstream https://github.com/TWOJ-PROFIL/TWOJE-REPO-ZRODLOWE.git
```

*Teraz Twoje repozytorium ma dwa połączenia:*
* `origin` – Twoje prywatne repozytorium (tutaj wrzucasz rozwiązania).
* `upstream` – Moje repozytorium (stąd pobierasz nowe zadania).

---

## Krok 3: Cotygodniowa aktualizacja (Pobieranie zadań)
Gdy ogłoszę, że nowe laboratorium (np. `lab2`) jest dostępne, wykonaj poniższe komendy, aby pobrać je do siebie:

```bash
# 1. Pobierz zmiany ze źródła
git pull upstream main

# 2. Wyślij aktualizację do swojego prywatnego repo na GitHubie
git push origin main
```
*Twoje dotychczasowe rozwiązania w folderze `lab1` nie zostaną nadpisane – Git automatycznie "doklei" nowy folder `lab2`.*

---

## Krok 4: Praca nad zadaniem i oddawanie (Pull Request)
Pracujemy na tzw. **branchach** (gałęziach). To profesjonalny sposób na rozwijanie kodu.

1. **Stwórz nową gałąź dla danego laboratorium:**
   ```bash
   git checkout -b rozwiazanie-lab2
   ```
2. **Rozwiąż zadania w folderze `lab2`.**
3. **Zapisz zmiany (Commit):**
   ```bash
   git add .
   git commit -m "Ukończono zadania z Lab 2"
   ```
4. **Wyślij gałąź na GitHub:**
   ```bash
   git push origin rozwiazanie-lab2
   ```
5. **Otwórz Pull Request (PR):**
   Wejdź na stronę swojego repozytorium na GitHubie. Zobaczysz żółty pasek z przyciskiem **"Compare & pull request"**. Kliknij go i stwórz PR. 

**To właśnie w tym Pull Requestcie będę sprawdzał Twój kod i zostawiał uwagi.**

---

## Krótka ściąga komend:
* `git status` – sprawdź, co zmieniłeś.
* `git pull upstream main` – pobierz nowe laby od prowadzącego.
* `git push origin main` – wyślij wszystko do swojego repo.
* `git branch` – sprawdź, na której gałęzi jesteś.

Powodzenia!