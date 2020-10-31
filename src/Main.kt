class Main {
    companion object : Callback {
        @JvmStatic
        fun main(args: Array<String>){
            menu()
        }

        override fun menu() {
            println("=============================")
            println("GAME SUIT VERSI TERMINAL")
            println("=============================")
            val playRoundController = PlayRoundController(this)
            print("1. Masukkan pemain 1: ")
            val bet = readLine()!!
            val player = Player(bet)
            playRoundController.setPlayer(player)
            print("2. Masukkan pemain 2: ")
            playRoundController.setComputer()
            println(playRoundController.getComputer()!!.bet)
            playRoundController.playRound()
        }

        override fun result(result: String) {
            println("\nHasil: ")
            println(ConsoleColors.WHITE_BOLD + result + ConsoleColors.RESET)
        }
    }
}