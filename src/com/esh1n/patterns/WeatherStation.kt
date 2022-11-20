package com.esh1n.patterns

object WeatherStation {
    @JvmStatic
    fun main(args: Array<String>) {

        val house = WeatherHouse()
        val sergei = UserPhoneObserver("Sergei")
        val ivan = UserPhoneObserver("Ivan")
        house.updateWeather { copy(temperature = 10) }
        house.registerObserver(sergei)
        house.updateWeather { copy(temperature = 15) }
        house.registerObserver(ivan)
        house.updateWeather { copy(temperature = 20) }
        house.removeObserver(sergei)
        house.updateWeather { copy(temperature = 25) }

    }
}

data class WeatherInfo(val pressure: Int, val temperature: Int)

fun interface Observer {
    fun update(weatherInfo: WeatherInfo)
}

class UserPhoneObserver(val name: String) : Observer {
    override fun update(weatherInfo: WeatherInfo) {
        println("New Weather for $name pressure: ${weatherInfo.pressure} temp: ${weatherInfo.temperature}")
    }
}

interface Observable {
    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun removeAllObservers()

    fun emitDataToObservers()
}

class WeatherHouse : Observable {

    private var subcribers = mutableListOf<Observer>()

    private var weatherInfo = WeatherInfo(0, 0)

    fun updateWeather(updateFunction: WeatherInfo.() -> WeatherInfo) {
        weatherInfo = weatherInfo.updateFunction()
        println("WeatherHouse updateWeather for ${weatherInfo.pressure} temp: ${weatherInfo.temperature}")
        emitDataToObservers()
    }

    override fun registerObserver(observer: Observer) {
        subcribers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        subcribers.remove(observer)
    }

    override fun removeAllObservers() {
        subcribers.removeAll { true }
    }

    override fun emitDataToObservers() {
        subcribers.forEach { it.update(weatherInfo) }
    }


}