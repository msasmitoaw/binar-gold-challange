class Main {
    companion object : Callback {
        @JvmStatic
        fun main(args: Array<String>) {
            menu()
        }

        override fun menu() {
            menuLoop@ do {
                println("==========================================")
                println("SELAMAT DATANG di GAME SUIT VERSI TERMINAL")
                println("==========================================")
                println("1. Mulai bermain dengan komputer")
                println("2. Mulai bermain dengan pemain lain")
                println("3. Keluar")
                println("==========================================")
                print("Masukkan pilihan: ")
                when (readLine()) {
                    "1" -> game("pvc")
                    "2" -> game("pvp")
                    "3" -> {
                        println("Bye")
                        break@menuLoop
                    }
                    else -> println("Masukkan tidak dikenali")
                }
            } while (true)
        }


        override fun game(mode: String) {
            println("==========================================")
            println("GAME SUIT VERSI TERMINAL")
            println("BERMAIN MELAWAN ${if (mode == "pvc") "KOMPUTER" else "PEMAIN LAIN"}")
            println("==========================================")
            val playRoundController = PlayRoundController(this)
            print("1. Masukkan pemain 1: ")
            val player = Player(readLine()!!)
            playRoundController.setPlayer(player)
            print("2. Masukkan pemain 2: ")
            when (mode) {
                "pvc" -> {
                    playRoundController.setPlayerTwo()
                    println(playRoundController.getPlayerTwo()!!.bet)
                }
                else -> {
                    val playerTwo = Player(readLine()!!)
                    playRoundController.setPlayerTwo(playerTwo)
                }
            }
            playRoundController.playRound(mode)
        }

        override fun result(result: String) {
            println("\nHasil: ")
            println("\b$result")
        }

        override fun prompt(mode: String) {
            println("==========================================")
            println("Ingin bermain lagi? (y/n)")
            do {
                when (readLine()!!.toLowerCase()) {
                    "y" -> {
                        game(mode); break
                    }
                    "n" -> break
                    else -> {
                        println("Masukkan tidak sesuai!")
                        println("==========================================")
                        println("Ingin bermain lagi? (y/n)")
                        continue
                    }
                }
            } while (true)
        }

    }
}