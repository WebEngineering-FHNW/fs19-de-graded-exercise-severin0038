<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Swipinion Home</title>
</head>
<body>
    <main>
        <p>Das ist meine Startseite</p>

        <sec:ifLoggedIn>
            <sec:ifAllGranted roles="ROLE_ADMIN">
                <ul>
                    <li><a href="/question">Liste aller Fragen</a></li>
                    <li><a href="/question/openQuestions">offene Fragen</a></li>
                    <li><a href="/question/answeredQuestions">beantwortete Fragen</a></li>
                    <li><a href="/question/create">Neue Frage erstellen</a></li>
                    <li><a href="/question/evaluation">Auswertung</a></li>
                </ul>
            </sec:ifAllGranted>
        </sec:ifLoggedIn>

        <sec:ifLoggedIn>
            <sec:ifAllGranted roles="ROLE_NORMAL">
                <ul>
                    <li><a href="/question/openQuestions">offene Fragen</a></li>
                    <li><a href="/question/answeredQuestions">beantwortete Fragen</a></li>
                <ul>
            </sec:ifAllGranted>
        </sec:ifLoggedIn>

    </main>
</body>
</html>