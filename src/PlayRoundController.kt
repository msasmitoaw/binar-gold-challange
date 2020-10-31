import kotlin.random.Random

class PlayRoundController(private val listener: Callback) {
    private var player: Player? = null
    private var playerTwo: Player? = null
    private var weakness = mapOf("gunting" to "batu", "kertas" to "gunting", "batu" to "kertas")

    fun setPlayer(player: Player) {
        this.player = player
    }

    fun setPlayerTwo(playerTwo: Player) {
        this.playerTwo = playerTwo
    }

    fun setPlayerTwo() {
        val idx = Random.nextInt(weakness.size)
        this.playerTwo = Player(weakness.entries.elementAt(idx).value)
    }

    fun getPlayerTwo(): Player? {
        return this.playerTwo
    }

    fun playRound(mode: String) {
        listener.result(
            when (player!!.bet) {
                playerTwo!!.bet -> "DRAW!"
                weakness[playerTwo!!.bet] -> "Pemain 1 MENANG!"
                else -> "Pemain 2 MENANG!"
            }
        )
        listener.prompt(mode)
    }
}