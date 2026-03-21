# 🚀 Instrukcja dla studentów: Laboratoria 2026

W tym semestrze będziemy pracować z wykorzystaniem **GitHub Classroom**. Każdy z Was będzie miał własne prywatne repozytorium, do którego ja będę co tydzień wrzucał nowe zadania (foldery `lab1`, `lab2` itd.).

---

## Krok 1: Akceptacja zadania i klonowanie
1. Kliknij w link do GitHub Classroom otrzymany od prowadzącego.
2. Znajdź swoje imię i nazwisko na liście (lub dołącz do klasy, jeśli listy jeszcze nie ma).
3. GitHub automatycznie utworzy Twoje prywatne repozytorium o nazwie `repo-matka-TwojLogin`. Prawdodpobonie na końcu pojawi się info o błędzie - zignoruj
4. Na githubie po wejściu `profil` -> `organizacje` powinna ci się wyświetlić organizacja **repo-matka-nick** - kliknij i zaakceptuj
4. Sklonuj swoje nowe repozytorium na dysk komputera:
   ```bash
   git clone https://github.com/NASZA-ORGANIZACJA/repo-matka-TwojLogin.git
   cd repo-matka-TwojLogin
   ```

---

Tutaj potencjalnie mogą pojawić się problamy z autentykacją - bo repo jest prywatne i microsoft podobno tak fantastycznie poczarował że nie da się po prostu clona zrobić.

Tu macie poradnik jak sobie z tym poradzić  - https://docs.github.com/en/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account

## Krok 2: Konfiguracja synchronizacji (UPSTREAM) – TYLKO RAZ

Tu chodzi o to żebyście sobie pobierali zmiany/nowe laby z mojego repo.

Są dwie opcje

### Przez github
Na swoim repo klikacie przycisk "Sync fork" - reszta dzieje się sama


### Przez terminal

Tutaj trzeba pare kroczków
1. Skopiuj link do repa matki (SSH lub Http jak chcecie)
2. Ustaw to repo jako **upstream**

```bash
git remote add upstream https://github.com/AGH-Projektowanie-Obiektowe/klasaaaaa_2026-repo_matka-projektowanie-obiektowe.git
```

*Teraz Twoje repozytorium ma dwa połączenia:*
* `origin` – Twoje prywatne repozytorium (tutaj wrzucasz rozwiązania).
* `upstream` – Moje repozytorium (stąd pobierasz nowe zadania).

---

## Krok 3: Cotygodniowa aktualizacja (Pobieranie zadań)
Żeby na swoim prywatnym repo miec zmiany z repa matki (czyli nowego laba) to trzeba spullowac zmiany z repa matki.

```bash
# 1. Pobierz zmiany ze źródła
git pull upstream main

# 2. Wyślij aktualizację do swojego prywatnego repo na GitHubie
git push origin main
```
*Twoje dotychczasowe rozwiązania w folderze `lab1` nie zostaną nadpisane – Git automatycznie "doklei" nowy folder `lab2`. (a przynajmniej taka mam nadzieje xd)*

---

## Krok 4: Praca nad zadaniem i oddawanie (Pull Request)
Zmiany mają byc robione na oddzielnym branchu - tak żeby można było łatwo utworzyc Pull Requesta do waszego maina.

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

**Na tym Pull Requescie odbędzie się tzw. Code Review - czyli będę pisał komentarze do kodu itp.**

---

## Krótka ściąga komend:
Jak ktoś używa jakiegoś GUI do gita to go to totalnie nie interesuje, ale jak ktoś lubi z terminala:
* `git status` – sprawdź, co zmieniłeś.
* `git pull upstream main` – pobierz nowe laby od prowadzącego.
* `git push origin main` – wyślij wszystko do swojego repo.
* `git branch` – sprawdź, na której gałęzi jesteś.

Powodzenia!