Oppg1: Svar1:

Det ser ut som til at Shopifly har en rekke utfordringer knyttet til utviklingsprosessen sin.
De mangler automatisering og har ingen flyt i utviklingsprosessen deres. De har også manuelle godkjenningsprosesser som fører til unødvendig arbeid, utgifter og ineffektivitet som er waste.

Innføring av DevOps kan bidra til å løse disse utfordringene ved å fokusere på automatisering, samarbeid og kontinuerlig levering av endringer.
DevOps prinsippene som blir brut er flyt, feedback, kontinuerlig forbedring.


Oppg1: Svar2

Ut fra DevOps perspektiv så er dette fortsatt ikke den optimale og langvarig løsning. DevOps vil helst at prosessen blir automatisert.

Det beste løsning er slå sammen utviklere med driftspersonell og øke fokuset på samarbeid. Dette kan bidra til mer leveranser og mindre feil.


Oppg1: Svar3

En av utfordringene med å overlevere kode til en annen avdeling er at det kan være vanskelig å sikre at den. Fra DevOps perspektiv så er det dårlig samarbeid og kommunikasjon mellom de to avdelingene. Dette kan igjen føre til at systemer blir lansert uten å være klar for produksjon, noe som kan føre til mer feil og forsinkelser.

En av fordelene ved å ha ansvar for både drift og utvikling er at teamet vil ha en bredere forståelse av produktet de utvikler. Dette bidrar til å økt samarbeidet mellom utvikling og drift som i praksis betyr mindre feil og nedetid.


En utfordring med at et utviklingsteam overleverer kode til en annen avdeling som har ansvar for drift er at det kan føre til dårlig samarbeid og kommunikasjon mellom de to avdelingene. Dette kan igjen føre til at systemer blir lansert uten å være tilstrekkelig testet eller klare for produksjon, noe som kan føre til problemer og forsinkelser.

Ved å ha et team med ansvar for både drift og utvikling kan man få gevinster som bedre samarbeid og kommunikasjon mellom de to avdelingene, raskere gjennomføringstid for endringer, og økt automatisering. Dette kan bidra til å redusere risikoen for feil og forsinkelser, og kan også gjøre at virksomheten kan utnytte ny teknologi og reagere raskt på endringer i markedet.

Oppg1: svar4

For å redusere eller fjerne denne risikoen kan man bruke DevOps prinsipper som continuous delivery, continuous feedback.

Del 3 - Docker
Oppave 3 - 2


Prosessen kan deles i to deler. Først lager vi sikkerhet nøkler i IAM management og så konfigurere de i Repository secrets og docker.yml filen slik at den kan koble og push mot ECR.

Del to er det en multi stage Dockerfile, som først lager en container som har alle verktøy til å bygge applikasjonen, maven osv. Spring boot applikasjonen blir kompilert og bygget i denne containeren. Deretter bruker den resultatet fra byggeprosessen, JAR filen til å lage en runtime container for applikasjonen. Og en docker.yml fil som kjører Dockerfile og autentiserer og pusher seg mot ECR.

1.	Lag et AWS ECR repository for din container
2.	Gå til IAM management og lag Access keys.
3.	Gå til Repositorien din lag repository secrets
4.	Lag en Multistage Dockerfile. For å kjøre mvn packageog lage en runtime container.
5.	Lag en docker.yml file som kjører din Dockerfile og pusher filen til ECR.
6.	Husk å konfiguerer din hemmelig nøkler i docker.yml filen.



Del 5 - Terraform og CloudWatch Dashboards

Oppgave 5 – 1
