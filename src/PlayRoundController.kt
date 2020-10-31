import kotlin.random.Random

class PlayRoundController(private val listener: Callback) {
    private var player: Player? = null
    private var computer: Player? = null
    private var weakness = mapOf("scissor" to "rock", "paper" to "scissor", "rock" to "paper")

    fun setPlayer(player: Player) {
        this.player = player
    }

    fun setComputer() {
        val idx = Random.nextInt(weakness.size)
        this.computer = Player(weakness.entries.elementAt(idx).value)
    }

    fun getComputer(): Player? {
        return this.computer;
    }

    fun playRound() {
        var result = when (player!!.bet) {
            computer!!.bet -> "tie"
            weakness[computer!!.bet] -> "win"
            else -> "lose"
        }
        result =  when (result) {
            "tie" -> "Tie! Nobody win nobody lose"
            else -> {
                "You ${result.capitalize()}! ${player!!.bet.capitalize()} ${
                    if (result == "lose") {
                        "beaten by"
                    } else {
                        "beats"
                    }
                } ${computer!!.bet.capitalize()}"
            }
        }
        listener.result(result)
    }
}