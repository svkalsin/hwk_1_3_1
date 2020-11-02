package ru.netology

fun main() {

    val numberOfSeconds = 60*60*11 //количество пройденого времени в секундах
    declination(numberOfSeconds)
}

fun declination(numberOfSeconds: Int) {
    val stringnumberOfSeconds = numberOfSeconds.toString()
    if (numberOfSeconds <= 60) {
        print("был(а) только что")
    } else if (numberOfSeconds >= 61 && numberOfSeconds < 60*60){
        print("был(а) ${numberOfSeconds/60} ${declinationMinutesHours(numberOfSeconds, true)} назад")
    } else if (numberOfSeconds >= 60*60 && numberOfSeconds < 24*60*60){
        print("был(а) ${numberOfSeconds/(60*60)} ${declinationMinutesHours(numberOfSeconds, false)} назад")
    } else if (numberOfSeconds >= 24*60*60){
        print("был(а) ${declinationDay(numberOfSeconds)}")
    }

}

fun declinationMinutesHours(numberOfSeconds: Int, showMinutes: Boolean = true) :String {
    val strMinutes = (numberOfSeconds/60).toInt().toString()
    var str: String = ""
    when (strMinutes.substring(strMinutes.lastIndex)){
        "0","5","6","7","8","9" -> str = if (showMinutes) "минут" else "часов"
        "1" -> str = if (showMinutes) "минута" else "час"
        "2", "3", "4" -> str = if (showMinutes) "минуты" else "часа"
    }
    when (strMinutes.substring(strMinutes.lastIndex-1)){
        "11","13","14","15","16","17","18","19" -> str = if (showMinutes) "минут" else "часов"
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