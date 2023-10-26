package cinema

data class SeatOutOfBoundException(
    val error: String = "The number of a row or a column is out of bounds!"
) : RuntimeException(error)

data class TicketAlreadyPurchasedException(
    val error: String = "The ticket has been already purchased!"
): RuntimeException(error)

data class InvalidTokenException(
    val error: String = "Wrong token!"
): RuntimeException(error)

data class InvalidPasswordException(
    val error: String = "The password is wrong!"
): RuntimeException(error)
