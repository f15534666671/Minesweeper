class Vehicle {
    // add name
    var name: String = ""
    // create constructor
    constructor(name: String) {
        this.name = name
    }

    inner class Engine {
        // add horsePower
        var horsePower: Int = 0

        // create constructor
        constructor(horsePower: Int) {
            this.horsePower = horsePower
        }

        fun start() {
            println("RRRrrrrrrr....")
        }

        // create function printHorsePower()
        fun printHorsePower() {
            println("The $name vehicle has $horsePower horsepower.")
        }
    }
}