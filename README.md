# Дипломный проект по тестированию мобильного приложения Wikipedia для Android
### <a target="_blank" href="https://https://ru.wikipedia.org">Wikipedia</a>

### <a target="_blank" href="https://https://github.com/wikimedia/apps-android-wikipedia">Wikipedia mobile app</a>

[//]: # (## <img src="images/logos/Android Logo.svg" width="50" height="50"  alt="Jenkins"/></a>Содержание)
## :robot: Содержание

- [Технологии и инструменты](#rocket-технологии-и-инструменты)
- [Тест кейсы](#scroll-тест-кейсы)
- [Параметры запуска тестов](#computer-параметры-запуска-тестов)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Allure отчет](#отчет-в-allure-report)
- [Интеграция с Allure TestOps](#интеграция-с-allure-testops)
- [Отчет в Telegram](#уведомление-в-telegram-при-помощи-бота)
- [Примеры видео о прохождении тестов](#примеры-видео-о-прохождении-тестов)

## :rocket: Технологии и инструменты

<p align="center">
<a href="https://www.java.com/"><img src="images/logos/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://www.jetbrains.com/idea/"><img src="images/logos/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://github.com/"><img src="images/logos/Github.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logos/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logos/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logos/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logos/Allure_Report.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.browserstack.com/"><img src="images/logos/Browserstack.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://appium.io/"><img src="images/logos/Appium.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://developer.android.com/studio"><img src="images/logos/Android-studio.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://www.jenkins.io/"><img src="images/logos/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://qameta.io/"><img src="images/logos/Allure_EE.svg" width="50" height="50"  alt="Allure TestOps"/></a>

[//]: # (<a href="https://aerokube.com/selenoid/"><img src="images/logos/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>)
[//]: # (<a href="https://www.docker.com/"><img src="images/logos/Docker.svg" width="50" height="50"  alt="Docker"/></a>)
</p>

## :scroll: Тест кейсы

- ✓ Тест страниц приветствия.
- ✓ Тест поиска.
- ✓ Тест перехода в меню настройки ленты.
- ✓ Тест настройки ленты, отключение всех опций.
- ✓ Тест добавления русского языка.
- ✓ Тест пунктов основного меню.


[К содержанию](#Содержание)

## :computer: Параметры запуска тестов

### Локальный запуск:
Паттерн запуска из терминала выглядит следующим образом: \
```gradle clean task -DdeviceHost=deviceHost``` \
task в данном случае один - mobile_tests \
ключ deviceHost определяет на какой площадке будут запущены тесты
- ```browserstack``` - тесты будут запущены на платформе <a target="_blank" href="hhttps://www.browserstack.com/">BrowserStack</a>
- ```emulator``` - тесты будут запущены на локально развернутом эмуляторе <a target="_blank" href="https://developer.android.com/studio">Android Studio</a>
- ```real``` - тесты будут запущены на реальном девайсе

Промер:
```bash
Gradle clean mobile_tests -DdeviceHost=browserstack
```

Запуск сборки в Jenkins производится со следующими параметрами:
```bash
clean
${TASK}
-DdeviceHost=${DEVICEHOST}
```

### Параметры сборки в Jenkins:

- ```DEVICEHOST``` - Выбор платформы запуска (по умолчанию ```browserstack```)
- ```BRANCH``` - выбор ветки репозитория GitHub (по умолчанию ```main```)
- ```TASK``` - выбор задачи (настройка build.gradle, по умолчанию ```mobile_tests```)


[К содержанию](#Содержание)

## <img src="images/logos/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a>Сборка в Jenkins
### <a target="_blank" href="https://jenkins.autotests.cloud/job/berezkindv_diploma_mobile_tests_project/">Jenkins</a>

Инструкция по запуску сборки в Jenkins:
<p align="center">
<a><img src="images/screenshots/jenkins_job_parameters.png" alt="Jenkins"/></a>
</p>

По завершении сборки можно посмотреть Allure отчет или перейти к Allure TestOps:
<p align="center">
<a><img src="images/screenshots/jenkins_job_notifications.png" alt="Jenkins"/></a>
</p>

[К содержанию](#Содержание)

## <img src="images/logos/Allure_Report.svg" width="25" height="25"  alt="Allure"/></a>Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/berezkindv_diploma_ui_tests_project/10/allure/">Allure report</a>

### Основное окно

<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/allure_report_dashboard.png">
</p>

### Тесты

<p align="center">
<img title="Allure Tests" src="images/screenshots/allure_report_tests.png">
</p>

### Графики

<p align="center">
<img title="Allure Graphics" src="images/screenshots/allure_report_graphs.png">
</p>

[К содержанию](#Содержание)

## <img src="images/logos/Allure_EE.svg" width="25" height="25"  alt="Allure"/></a>Интеграция с <a target="_blank" href="https://allure.autotests.cloud/launch/12018">Allure TestOps</a>

### Дашборд

<p align="center">
<img title="Allure TestOps Dashboard" src="images/screenshots/testops_dashboard.png">
</p>

### Тест-кейсы

<p align="center">
<img title="Allure TestOps Tests" src="images/screenshots/testops_tests.png">
</p>

[К содержанию](#Содержание)

## <img src="images/logos/Telegram.svg" width="25" height="25"  alt="Allure"/></a>Уведомление в Telegram при помощи бота
По завершении всех операций телеграм бот отправит отчет со статистикой:
<p align="center">
<img title="Allure Overview Dashboard" src="images/screenshots/telegram_bot.png">
</p>

[К содержанию](#Содержание)



### <img src="images/logos/Browserstack.svg" width="25" height="25"  alt="Allure"/></a>Примеры видео о прохождении тестов

<p align="center">
<img title="BrowserStack Video" src="images/screenshots/video_onboarding.gif" width="250" height="250"  alt="video">
<img title="BrowserStack Video" src="images/screenshots/video_add_language.gif" width="250" height="250"  alt="video">
<img title="BrowserStack Video" src="images/screenshots/video_starch.gif" width="250" height="250"  alt="video">
</p>

[К содержанию](#Содержание)