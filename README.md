## ToDo REST Service

![Java CI](https://github.com/AidanKlark/BSC_Trainee/actions/workflows/maven.yml/badge.svg)

### **Функционал**

**_Добавление пользователя:_**

```
{
    "username" : "user"
    "password" : "user"
    "role" : "USER"
}
```

**_Добавление задачи:_**

```
{
    "taskDescription" : "Добавление задачи #1"
}
```

**_Вывод списка задач_**

Выводит на печать список задач. По-умолчанию, выводятся только невыполненные задачи.

Печатаются следующие поля: идентификатор, статус задачи (true - выполнена, false - не выполнена), описание задачи.

В случае если команда выполняется с аргументом all - печатаются все задачи.
В случае если команда выполняется с аргументом substring и искомой подстрокой - печатаются задачи, что содержат эту подстроку.

Пример вывода:
```
{
    "1": {
        "taskDescription": "Задача №1",
        "status": false
    },
    "2": {
        "taskDescription": "Задача №2",
        "status": true
    }
}
```

**_Изменение статуса задачи_**

Переключает состояние задачи (с "выполнена" на "не выполнена" и наоборот) по идентификатору.

**_Удаление задачи из списка_**

Вводится идентификатор задачи, которую нужно удалить.

**_Редактирование задачи_**

Вводится идентификатор задачи, и новое описание задачи. 

Статус задачи меняется на false, если был иным.
