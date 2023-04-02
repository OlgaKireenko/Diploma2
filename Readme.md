# Git. README.md

# Тестирование формы покупки туристического тура

Тестирование формы покупки туристического тура. Два основных варианта покупки по карте и в кредит по номеру карты.
5 полей для ввода информации, которые необходимо протестировать: Номер карты, месяц, год, владелец и cvv.
Каждое поле необходимо проверить на валидацию и по граничным значениям. Так же необходимо проверить запись успешно ли был совершён платёж и каким способом.

## Начало работы

1. на локальной машине выполнить команду git clone https://github.com/OlgaKireenko/Diploma2
2. открыть проект в IntelliJIdea 
3. стартануть контейнер, для этого в IIDEA открыть файл docker-compose.yml и нажать два зелёных квадратика (docker-compose up)
4. зайти в терминал, встать в папку проекта и выполнить команду java -jar aqa-shop.jar (приложение откроется на порту http://localhost:8080)

### Prerequisites
На локальной машине должны быть установлены:
1. Chrome браузер
2. IntelliJIdea или любой другой tool для работы с java кодом
3. Docker Desktop версии 4.11 и выше
4. Git
