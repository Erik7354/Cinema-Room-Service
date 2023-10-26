package cinema

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MovieTheaterController(
    private val service: MovieTheaterService
) {
    @GetMapping("/stats")
    fun getStats(@RequestParam password: String?): RoomStatDTO =
        service.stats(password)

    @GetMapping("/seats")
    fun getAvailableSeats(): RoomDTO =
        service.availableSeats()

    @PostMapping("/purchase")
    fun bookSeat(@RequestBody seat: SeatDTO): PurchasedTicketDTO =
        service.purchaseSeat(seat)

    @PostMapping("/return")
    fun bookSeat(@RequestBody token: TokenDTO): ReturnedTicketDTO =
        service.returnTicket(token)
}