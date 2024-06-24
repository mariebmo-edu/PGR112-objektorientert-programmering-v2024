# Eksamen våren 2024, Objektorienter Programmering v/Kristiania.

Dette er løsningsforslag, men vær obs på at denne ikke går gjennom sensur og at jeg ikke har noe med Kristiania å gjøre, så det kan hende sensor(er) er ute etter en annen løsning.

Jeg lager to versjoner, en litt mer komplisert, og en som er litt enklere (men kanskje ikke like "pen")

## Løsningsforslag 1
[Link til løsningsforslag 1 (ferdig)](https://github.com/mariebmo-edu/PGR112-objektorientert-programmering-v2024/tree/main/losningsforlag_v1)
- Her benyttes en env-fil som leses av. I "ekte" kode ville ikke denne være sjekket inn på github, og kun ligge lokalt. Jeg har tatt den med for å vise hvordan det ser ut.
- Her benyttes en god del abstrakt kode (AbstractRepo, AbstractService)
- Her benyttes flere "lag" for å dele opp koden litt mer. Service har i oppgave å snakke med repo, slik at man ikke jobber direkte mot repo-koden hver gang. Dette er et steg man ikke må ha med, men som er greit å vite om i kodesammenheng
- Her benyttes ekstra-klasser for å formattere koden til/fra SQL-spørringer automatisk (AbstractRepo.InsertMapper, AbstractRepo.UpdateMapper, AbstractRepo.ResultMapper)

---

# Docker
Dere finner også en docker-compose.yml-fil i repoet. Docker er et program som lar deg installere og kjøre programmer i en slags VM. I dette prosjektet bruker jeg docker-compose til å starte en MySQL-database i Docker, slik at jeg slipper å ha det lastet ned på maskina. Siden jeg bruker docker-compose, kan jeg også kjøre fila på andre maskiner, og få satt opp databasen likt hver gang. Anbefaler å lese litt om Docker, det er mye brukt i bransjen! :-)
