package ru.netology

fun main() {

    val numberOfSeconds = 60 //количество пройденого времени в секундах
    declination(numberOfSeconds)
}

fun declination(numberOfSeconds: Int) {
    val stringnumberOfSeconds = numberOfSeconds.toString()
    if (numberOfSeconds <= 60) {
        print("был(а) только что")
    } else if (numberOfSeconds >= 61 && numberOfSeconds < 60*60){
        print("был(а) ${numberOfSeconds/60} ${declinationMinutes(numberOfSeconds)} назад")
    } else if (numberOfSeconds >= 60*60 && numberOfSeconds < 24*60*60){
        print("был(а) ${numberOfSeconds/(60*60)} ${declinationHours(numberOfSeconds)} назад")
    } else if (numberOfSeconds >= 24*60*60){
        print("был(а) ${declinationDay(numberOfSeconds)}")
    }

}

fun declinationMinutes(numberOfSeconds: Int) :String {
    val strMinutes = (numberOfSeconds/60).toInt().toString()
    var str: String = ""
    when (strMinutes.substring(strMinutes.lastIndex)){
        "0","5","6","7","8","9" -> str = "минут"
        "1" -> str = "минута"
        "2", "3", "4" -> str = "минуты"
    }
    return str
}

fun declinationHours(numberOfSeconds: Int) :String {
    val strHours = (numberOfSeconds/(60*60)).toInt().toString()
    var str: String = ""
    when (strHours.substring(strHours.lastIndex)){
        "0","5","6","7","8","9" -> str = "часов"
        "1" -> str = "час"
        "2", "3", "4" -> str = "часа"
    }
    return str
}

fun declinationDay(numberOfSeconds: Int) :String {
    var str: String = ""
    if(numberOfSeconds >= 24*60*60 && numberOfSeconds < 2*24*60*60 ){
        str = "сегодня"
    } else  if (numberOfSeconds >= 2*24*60*60 && numberOfSeconds < 3*24*60*60){
        str = "вчера"
    } else {
        str = "давно"
    }
    return str
}