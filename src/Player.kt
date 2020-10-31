data class Player(var bet: String) {
    private val choice = arrayOf("gunting", "batu", "kertas")

    init {
        do {
            when (bet) {
                in choice -> {
                    this.bet = bet.toLowerCase(); break
                }
                else -> {
                    println("Masukkan tidak sesuai, pilihan harus di antara gunting, batu atau kertas!")
                    print("Masukkan pilihan: ")
                    this.bet = readLine()!!.toLowerCase()
                }
            }
        } while (true)
    }
}