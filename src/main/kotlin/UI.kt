class UI {

    fun mainMenu(){
        println("Выберите что вы хотите сделать:" +
                "\n 1) Создать обьект" +
                "\n 2) Найти обьект" +
                "\n 3) Вывести все обьекты" +
                "\n 4) Удалить обьект" +
                "\n 5) Завершить работу")

        var variant = ExaminationInt()

        when (variant){
            1-> {
                CreateNewObject()
                mainMenu()
            }
            2-> {
                FindObject()
                mainMenu()
            }
            3-> {
                Monument.Print()
                mainMenu()
            }
            4-> {
                println("Введите название памятника")
                var name = ExaminationString()
                Monument.DeleteObject(name)
                mainMenu()
            }
            5->{
                println("Завершение работ")
            }
            else -> {
                println("Введено неверное значение")
                mainMenu()
            }
        }
    }

    fun CreateNewObject(){
        println("Введите название памятника")
        var name = ExaminationString()

        println("Введите местоположение памятника")
        var location = ExaminationString()

        println("Введите тип памятника")
        var type = ExaminationString()

        println("Введите архитектора памятника")
        var architector = ExaminationString()

        println("Введите год постройки памятника")
        var year = ExaminationInt()

        var monument: Monument = Monument(name,location,type,architector,year)
            Monument.AddToList(monument)

        println("Вы успешно создали обьект")
    }

    fun ExaminationString():String{
        var flag = true
        var newCount = ""
        while (flag){
            newCount = readLine()!!
            if (newCount is String) {
                flag=false
            }
            else{
                println("Введено неправильное значение")

            }
        }
        return newCount
    }

    fun ExaminationInt():Int{
        var flag = true
        var newCount = 0
        while (flag){
            val newCountInt= readLine()
            val number= newCountInt?.toIntOrNull()
            if (number != null){
                flag =false
                newCount=number
            }
            else{
                println("Введено неправильное значение")
                println("Введите число")
            }
        }
        return newCount
    }

    fun FindObject(){
        println("Выберите что вы хотите сделать:" +
                "\n 1) Поиск по названию" +
                "\n 2) Поиск по архитектору" +
                "\n 3) Поиск по веку" +
                "\n 4) Вернуться в главное меню")

        var variant = readLine()!!.toInt()
        println("Введите значение")

        when (variant){
            1->{
                var searchName = ExaminationString()
                Monument.SearchByName(searchName)
            }
            2->{
                var searchArchitector = ExaminationString()
                Monument.SearchByArchitector(searchArchitector)
            }
            3->{
                var age = ExaminationInt()
                Monument.OutputMonumentByAge(age)
            }
            4->{

            }
            else -> {
                println("Введено неверное значение")
                FindObject()
            }
        }
    }


}