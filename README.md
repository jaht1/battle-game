# Code Challenge 1-3 Battle Game

## TL;DR
- Klona denna repo lokalt, gör uppgiften nedan, committa och pusha.

## Förberedelser

- Se till att du har Git installerat på din dator (https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
- Generera ett SSH-nyckelpar om du inte har det från tidigare, och lägg till i dina inställningar på GitHub (https://git-scm.com/book/en/v2/Git-on-the-Server-Generating-Your-SSH-Public-Key)
- Klicka på den gröna Code-knappen ovan, välj SSH och kopiera adressen till din clipboard.
- Öppna Git Bash (Windows) eller ett terminalfönster (Linux/Mac) 
- Skriv följande, men ersätt adressen med den du just kopierat för att klona denna repo lokalt

  `git clone [kopierad-repo].git` (svara "yes" om det kommer en varning första gången)

- Du kan använda IntelliJ eller VSCode (som docker-devcontainer) för det här projektet (eller någonting annat, men då är du "on your own" om du stöter på problem med din utvecklingsmiljö).

### IntelliJ

- Öppna IntelliJ och välj Open, och navigera till den katalog du just skapade med Git
- Om Run-knappen uppe till höger i IntelliJ inte är aktiverad, klicka på Edit configurations, _Add configuration (+)_ och välj _Application_ från listan.
  Du måste antagligen också söka upp Main-klassen, välja _Java 11_ som JRE samt välja _Classpath of module_ (ta den med _.main_ på slutet).
  Spara konfigurationen, nu borde programmet kompilera (sätt in en "Hello"-utskrift i main-metoden för att testa).

### Visual Studio Code
- Se till att du har Docker installerat på din dator, installera också VSCode-tillägget Remote Containers
- Öppna projektkatalogen och välj "Reopen in Container" när den föreslår det (eller klicka på gröna ikonen nere i vänstra hörnet och välj samma kommando)
- Det tar en stund att bygga containern första gången, efter det borde programmet kompilera (sätt in en "Hello"-utskrift i main-metoden för att testa).

## Uppgiften

- Alla kodfiler skrivs i katalogen `src/main/java/`. Gör inga ändringar i någon annan katalog än denna.
- Projektet innehåller en Main-fil och en main-metod.


## Inlämning

- Uppgiften inlämnas genom att helt enkelt öppna terminalen i IntelliJ (eller Git Bash i rätt katalog) och köra:  
  `git add . ` (lägg till alla ändringar och nya filer)  
  `git commit -m "INLÄMNING del 1"` (eller dylikt beskrivande meddelande)  
  `git push` (Skicka upp koden till GitHub)

- Du kan också använda IntelliJ:s Git-integration om du vill och vet vad du gör.
- Om pushen misslyckas pga rättighetsproblem måste du kolla att du har din publika SSH-nyckel sparad på GitHub.
- Det är fritt fram att pusha nya ändringar ändra fram till uppgiftens deadline! 