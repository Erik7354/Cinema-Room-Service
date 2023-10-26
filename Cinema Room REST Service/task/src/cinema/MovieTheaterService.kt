package cinema

import org.springframework.stereotype.Service
import java.util.*

@Service
class MovieTheaterService {
    private val totalRows = 9
    private val totalColumns = 9
    private val room = RoomDTO(totalRows, totalColumns)
    private val purchasedTickets = mutableListOf<PurchasedTicketDTO>()
    private val password = "super_secret"

    fun availableSeats(): RoomDTO = room

    fun stats(password: String?): RoomStatDTO {
        println("password: ${password}")
        if (password != this.password) {
            throw InvalidPasswordException()
        }

        return RoomStatDTO(
            purchasedTickets.sumOf { it.ticket.price },
            room.availableSeats.size,
            purchasedTickets.size
        )
    }

    fun purchaseSeat(seat: SeatDTO): PurchasedTicketDTO {
        if (seat.row < 1 || seat.row > totalRows || seat.column < 1 || seat.column > totalColumns) {
            throw SeatOutOfBoundException()
        }

        if (!room.availableSeats.contains(seat)) {
            throw TicketAlreadyPurchasedException()
        }

        room.availableSeats.remove(seat)
        val ticket = PurchasedTicketDTO(
            token = UUID.randomUUID().toString(),
            ticket = seat
        )
        purchasedTickets.add(ticket)

        return ticket
    }

    fun returnTicket(token: TokenDTO): ReturnedTicketDTO {
        val ticket = purchasedTickets.find { it.token == token.token } ?: throw InvalidTokenException()

        purchasedTickets.remove(ticket)
        room.availableSeats.add(ticket.ticket)

        return ReturnedTicketDTO(ticket.ticket)
    }
}