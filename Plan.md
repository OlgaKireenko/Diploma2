# Diploma

Дипломная работа по курсу AQA_33

## Перечень автоматизируемых сценариев :

Предусловия для всех кейсов:
----Необходимо запустить приложение на контейнере

### 1. Покупка тура по дебетовой карте, карта активная

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
   3.заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц любым значением от 1 до 12 (Например, 12)
5. заполнить поле год любым значением из будущего (Например, 23)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР:  Сообщение "Успешно. Операция одобрена банком" is visible

### 2. Покупка тура с помощью неактивной дебетовой карты

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением недействительной карты - "4444 4444 4444 4442"
4. заполнить поле месяц любым значением от 1 до 12 (Например, 12)
5. заполнить поле год любым значением из будущего (Например, 23)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Сообщение "Ошибка. Банк отказал в проведении операции" is visible

### 3. Покупка тура по дебетовой карте, номер карты невалидный (короткий)

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением - "444"
4. заполнить поле месяц любым значением от 1 до 12 (Например, 12)
5. заполнить поле год любым значением из будущего (Например, 23)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Сообщение "Неверный формат"

### 4. Покупка тура по дебетовой карте, поле номер карты пустое

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением - "444"
4. заполнить поле месяц любым значением от 1 до 12 (Например, 12)
5. заполнить поле год любым значением из будущего (Например, 23)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Сообщение "Неверный формат"

### 5. Покупка тура по дебетовой карте, номер карты невалидный (длинный)

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением - "44444444444444444444"

ОР: Невозможно ввести в поле номер карты больше 19 ти значений

### 6. Покупка тура по дебетовой карте, номер карты невалидный (буквы)

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
   3.заполнить поле номер карты значением - "ФФФ"

ОР: Невозможно ввести в поле номер карты буквы

### 7. Покупка тура по дебетовой карте, номер карты невалидный (спец символы)

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
   3.заполнить поле номер карты значением - "4444!!!"

ОР: Невозможно ввести в поле номер карты спец символы

### 8. Покупка тура по дебетовой карте, карта активная, в  поле месяц число больше 12

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц любым значением больше "12"  (Например, 24)
5. заполнить поле год любым значением из будущего (Например, 23)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Подстрочное сообщение в поле месяц "Неверно указан срок действия карты"

### 9. Покупка тура по дебетовой карте, карта активная, в  поле месяц трёзначное число

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц любым трёхзначным числом (Например, 555)

ОР: Невозможно ввести в поле месяц трёхзначное число

### 10. Покупка тура по дебетовой карте, карта активная, в  поле месяц однозначное число

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
   3.заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц любым значением от 1 до 9  (Например, 5)
5. заполнить поле год любым значением из будущего (Например, 23)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Подстрочное сообщение в поле месяц "Неверный формат"

### 11. Покупка тура по дебетовой карте, карта активная, поле месяц оставить пустым

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. не заполнять поле месяц, оставить пустым
5. заполнить поле год любым значением из будущего (Например, 23)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Подстрочное сообщение в поле месяц "Неверный формат"

### 12. Покупка тура по дебетовой карте, карта активная, в  поле месяц ввести спец символы

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц спецсимволами (Например, !!!)

ОР: Невозможно ввести в поле месяц спецсимволы

### 13. Покупка тура по дебетовой карте, карта активная, в  поле месяц ввести буквы

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц буквами (Например, ффф)

ОР: Невозможно ввести в поле месяц буквы

### 14. Покупка тура по дебетовой карте, карта активная, выбрать текущий год и предыдущий месяц

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением "sysdate-1"   (Например, 11)
5. заполнить поле год текущим значением (Например, 22)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Подстрочное сообщение в поле месяц "Неверно указан срок действия карты"

### 15. Покупка тура по дебетовой карте, карта активная, выбрать год плюс 10 лет к текущему

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением до 12  (Например, 11)
5. заполнить поле год sysdate +10yy (Например, 32)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Подстрочное сообщение в поле месяц "Неверно указан срок действия карты"

### 16. Покупка тура по дебетовой карте, карта активная, выбрать год из прошлого

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением до 12  (Например, 11)
5. заполнить поле год значением "sysdate-1yy"   (Например, 21)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Подстрочное сообщение в поле месяц "Истёк срок действия карты"

### 17. Покупка тура по дебетовой карте, карта активная, ввести в поле год трёхзначное число

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением до 12  (Например, 11)
5. заполнить поле год трёхзначным числом (Например, 022)

ОР: Невозможно ввести в поле год трёхзначное число

### 18. Покупка тура по дебетовой карте, карта активная, ввести в поле год однозначное число

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением до 12  (Например, 11)
5. заполнить поле год однозначным числом (Например, 2)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Подстрочное сообщение в поле год "Неверный формат"

### 19. Покупка тура по дебетовой карте, карта активная, ввести в поле год буквы

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением до 12  (Например, 11)
5. заполнить поле год буквами (Например, AA)

ОР: Невозможно ввести в поле год буквы

### 20. Покупка тура по дебетовой карте, карта активная, ввести в поле год  спецсимволы

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением до 12  (Например, 11)
5. заполнить поле год спецсимволами (Например, !!)

ОР: Невозможно ввести в поле год спецсимволы

### 21. Покупка тура по дебетовой карте, карта активная, поле год оставить пустым

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением до 12  (Например, 11)
5. поле год оставить пустым
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Подстрочное сообщение в поле год "Неверный формат"

### 22. Покупка тура по дебетовой карте, карта активная, поле владелец оставить пустым

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением "sysdate-1"   (Например, 11)
5. заполнить поле год значением из будущего "sysdate +1"YY (Например, 23)
6. поле владелец не заполняем
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР:  Подстрочное сообщение в поле владелец "Поле обязательно для заполнения"

### 23. Покупка тура по дебетовой карте, карта активная, в поле владелец ввести больше 100 символов

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением "sysdate-1"   MM (Например, 11)
5. заполнить поле год значением "sysdate +1" YY (Например, 23)
6. заполнить поле владелец латинскими символами в количестве больше 100
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Невозможно ввести в поле владелец больше 100 символов

### 24. Покупка тура по дебетовой карте, карта активная, в поле владелец ввести Кириллицу

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением "sysdate-1"   (Например, 11)
5. заполнить поле год значением из будущего "sysdate +1"YY (Например, 23)
6. заполнить поле владелец кириллицей, верхний регистр, Имя и Фамилия (Например, ИВАН ИВАНОВ)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Подстрочное сообщение в поле владелец "Неверный формат"

### 25. Покупка тура по дебетовой карте, карта активная, в поле владелец ввести цифры и спецсимволы

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением "sysdate-1"   (Например, 11)
5. заполнить поле год значением из будущего "sysdate +1"YY (Например, 23)
6. заполнить поле владелец спецсимволами и цифрами, например "11 !!"
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Подстрочное сообщение в поле владелец "Неверный формат"

### 26. Покупка тура по дебетовой карте, карта активная, в поле владелец ввести два символа Латинницей с пробелом

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением "sysdate-1"   (Например, 11)
5. заполнить поле год значением из будущего "sysdate +1"YY (Например, 23)
6. заполнить поле владелец двумя символами, например "w a"
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Подстрочное сообщение в поле владелец "Неверный формат"

### 27. Покупка тура по дебетовой карте, карта активная, в поле владелец ввести два символа Латинницей

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением "sysdate-1"   (Например, 11)
5. заполнить поле год значением из будущего "sysdate +1"YY (Например, 23)
6. заполнить поле владелец двумя символами, например "wa"
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Подстрочное сообщение в поле владелец "Неверный формат"

### 28. Покупка тура по дебетовой карте, карта активная, поле CVC/CVV оставить пустым

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением "sysdate-1"   (Например, 11)
5. заполнить поле год значением из будущего "sysdate +1"YY (Например, 23)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. поле CVV не заполнять
8. нажать кнопку <Продолжить>

ОР: Подстрочное сообщение в поле cvv "Неверный формат"

### 29. Покупка тура по дебетовой карте, карта активная, в поле CVC/CVV ввести больше трёх символов

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением "sysdate-1"   (Например, 11)
5. заполнить поле год значением из будущего "sysdate +1"YY (Например, 23)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым четырёхзначным числом (Например, 2055)

ОР: Подстрочное сообщение в поле cvv "Неверный формат"

### 30. Покупка тура по дебетовой карте, карта активная, в поле CVC/CVV ввести меньше трёх символов

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц значением "sysdate-1"   (Например, 11)
5. заполнить поле год значением из будущего "sysdate +1"YY (Например, 23)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым двухзначным числом (Например, 25)
8. нажать кнопку <Продолжить>

ОР: Подстрочное сообщение в поле cvv "Неверный формат"

### 31. Покупка тура в кредит по дебетовой карте, карта активная

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить в кредит>
3. заполнить поле номер карты значением одобренной карты - "4444 4444 4444 4441"
4. заполнить поле месяц любым значением от 1 до 12 (Например, 12)
5. заполнить поле год любым значением из будущего (Например, 23)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Сообщение "Успешно. Операция одобрена банком"

### 32. Покупка тура в кредит по дебетовой карте, карта недействительная

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить в кредит>
3. заполнить поле номер карты значением недействительной карты - "4444 4444 4444 4442"
4. заполнить поле месяц любым значением от 1 до 12 (Например, 12)
5. заполнить поле год любым значением из будущего (Например, 23)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Сообщение "Ошибка. Банк отказал в проведении операции"

### 33. Покупка тура в кредит по дебетовой карте, номер карты невалидный (трёхзначны номер)

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить в кредит>
3. заполнить поле номер карты значением - "444"
4. заполнить поле месяц любым значением от 1 до 12 (Например, 12)
5. заполнить поле год любым значением из будущего (Например, 23)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Сообщение "Неверный формат"

### 34. Покупка тура в кредит по дебетовой карте, номер карты невалидный (20-ти значный)

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить в кредит>
3. заполнить поле номер карты значением - "4444 4444 4444 444114444"

ОР: Невозможно ввести в поле номер карты больше 19 ти значений

### 35. Покупка тура в кредит по дебетовой карте, номер карты невалидный (буквы)

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением - "ФФФ"

ОР: Невозможно ввести в поле номер карты буквы

### 36. Покупка тура в кредит по дебетовой карте, номер карты невалидный (спецсимволы)

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить>
3. заполнить поле номер карты значением - "4444!!!"

ОР: Невозможно ввести в поле номер карты спецсимволы

### 37. Покупка тура в кредит по дебетовой карте, номер карты невалидный (пустое поле)

1. открыть порт http://localhost:8080
2. нажать кнопку <Купить в кредит>
3. оставить поле номер карты пустым
4. заполнить поле месяц любым значением от 1 до 12 (Например, 12)
5. заполнить поле год любым значением из будущего (Например, 23)
6. заполнить поле владелец латынью, верхний регистр, Имя и Фамилия (Например, IVAN IVANOV)
7. заполнить поле CVV любым трёхзначным числом (Например, 205)
8. нажать кнопку <Продолжить>

ОР: Сообщение "Неверный формат"

## Проверки БД

1. Выполнить в БД следующиий запрос:

select * from table

ОР: Есть информация об успешной покупке тура по дебетовой карте

2. Выполнить в БД следующиий запрос:

select * from table

ОР: Есть информация об успешной покупке тура в кредит по дебетовой карте

3. Выполнить в БД следующиий запрос:

select * from table

ОР: Есть информация об отказе при покупке тура по дебетовой карте

4. Выполнить в БД следующиий запрос:

select * from table

ОР: Есть информация об отказе при покупке тура в кредит по дебетовой карте

## Перечень используемых инструментов с обоснованием выбора

1. Gradle
2. Selenide
3. что-то для работы с бд, пока не определилась
4. Docker
5. JUnit

## Перечень и описание возможных рисков при автоматизации

1. пока будем автоматизировать разработчики что-то поменяют
2.

## Интервальная оценка с учётом рисков в часах

5-10 рабочих дней
