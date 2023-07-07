class Monument (
    val name: String,
    val location: String,
    val type: String,
    val architect: String,
    val yearBuilt: Int,
)
{
    companion object{
        var monumentList = mutableListOf<Monument>()

        fun SearchByName(searchName: String) {
            monumentList.filter { it.name == searchName }
                .forEach { PrintAllField(it) }
        }

        fun SearchByArchitector(searchArchitector:String){
            monumentList.filter { it.name == searchArchitector }
                .forEach { PrintAllField(it) }
        }

        fun OutputMonumentByAge(age: Int) {
            val monumentsByAge = monumentList.filter { div(it.yearBuilt) == age }

            if (monumentsByAge.isNotEmpty()) {
                monumentsByAge.forEach { PrintAllField(it) }
            } else {
                println("Памятников, построенных в $age веке, нет")
            }
        }

        fun Print() {
            if (monumentList.isNotEmpty()) {
                monumentList.forEach { PrintAllField(it) }
            } else {
                println("Список пуст")
            }
        }

        fun AddToList(monument: Monument){
            monumentList.add(monument)
        }

        fun DeleteObject(name: String) {
            val removed = monumentList.removeIf { it.name == name }

            if (removed) {
                println("Объект с именем $name удален")
            } else {
                println("Объект с именем $name не найден")
            }
        }


        fun PrintAllField(monument: Monument){
            println("название ${monument.name}\n" +
                    "местоположение ${monument.location}\n" +
                    "тип ${monument.type}\n" +
                    "архитектор ${monument.architect}\n" +
                    "год постройки ${monument.yearBuilt}\n")
        }

        operator fun div (yearBuilt: Int):Int{
            return yearBuilt/100+1
        }
    }
}