# WebEngineering Module, Graded Exercise

## Commit Proposal

Matriculation Number: 17-549-973
Email               : severin.peyer@students.fhnw.ch

Project idea short description: 

###Umfrage-Tool "Swipinion"
- Das Umfrage-Tool "Swipinion" ist ein Tool, um einfache "Ja/Nein"- oder "Gefällt mir/Gefällt mir nicht"-Fragen zu stellen.
- Die Idee wurde in Requirements Engineering geboren und in bwlC wird momentan ein Businessplan dazu erstellt. 
- Ein Administrator kann Fragen erfassen und auswählen, ob es eine "Ja/Nein"- oder eine "Gefällt mir/Gefällt mir nicht"-Frage ist.
- Administratoren und Users sehen eine Übersicht dieser Fragen und können diese beantworten.

####Mögliche Erweiterungen
- Eine Frage durch ein Bild erweitern
- Kategorien von Fragen erstellen
- Kategorien können von Usern abonniert werden
- Fragen können mit Swipen beantwortet werden (daher der Name Swipinion bestehnd aus Swipe und Opinion)
- Rollenerweiterung durch einen Moderator, welcher Fragen von normalen Usern freigeben kann
- Administrator kann neue Benutzer erfassen


## Project confirmation

I assume that admins must login and regular users must also login to avoid answering multiple times.

With this assumption: confirmed.

D. König


## Project delivery <to be filled by student>

How to start the project: (if other than `grailsw run-app`)

How to test the project:  (if other than `grailsw test-app`)

Hand-written, static HTML 
project description:      (if other than `index.html` in project root directory)

External contributions: see `index.html`

Other comments: see `index.html`

I'm particular proud of: see `index.html`


## Project grading 

index.html given and fully valid 
plus: good document structure, use of semantic elements, nice styling!
The use of SVG for the logo has some interesting effects.

The application runs smoothly.
(minor: typo "Ich lehene ab") ;-)

Features:
- customized login
- data prefill in bootstrap (great example questions!)
- navigation, role-based security, form-based interaction, 
- 2 domain classes (plus security) and two many-to-one relations
- comprehensive custom view for the summary
- role-based security and feature set (use in the controllers)
- declarative validation

Engineering:
- comprehensive commit log over many days, a bit tail-heavy towards the end
- tests are all commented out
- comments are mostly implementation specific line-comments but they help
- The html has some validity issues, e.g. duplicated id attributes in the question overview page for
"question", "answer", and "user_id".

You made very good use of the framework features, particularly scaffolding and security, in combination with
custom actions and view. Holding onto the Services from within the view is possible but not fully in the spirit
of WebMVC, where the controller should call the service and pass all data to the view that the view needs.

The application is focused on a clear purpose and achieves it with the benefits of simplicity.

I award two extra points for the particular effort as visible in the commit log. 

Congratulations!
You created a fully functional, distributed, security-enabled, database-backed, web application
from scratch on your own in a rather tight time frame.

Grade: 5.4


