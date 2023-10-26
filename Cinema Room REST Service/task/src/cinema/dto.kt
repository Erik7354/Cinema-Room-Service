package cinema

import com.fasterxml.jackson.annotation.JsonProperty

data class RoomStatDTO (
    @JsonProperty("current_income")
    val currentIncome: Int,
    @JsonProperty("number_of_available_seats")
    val numberOfAvailableSeats: Int,
    @JsonProperty("number_of_purchased_tickets")
    val numberOfPurchasedTickets: Int,
)

data class ReturnedTicketDTO (
    @JsonProperty("returned_ticket")
    val returnedTicket: SeatDTO
)

data class PurchasedTicketDTO (
    val token: String,
    val ticket: SeatDTO,
)

data class ErrorResponseDTO (
    val error: String?
)

data class TokenDTO (
    val token: String
)

data class SeatDTO (
    val row: Int,
    val column: Int,
    val price: Int = if (row <= 4) 10 else 8
)

data class RoomDTO (
    @JsonProperty("total_rows")
    val totalRows: Int,
    @JsonProperty("total_columns")
    val totalColumns: Int,
    @JsonProperty("available_seats")
    val availableSeats: MutableList<SeatDTO> = mutableListOf<SeatDTO>().apply {
        for (i in 1..totalRows) {
            for (j in 1..totalColumns) {
                add(SeatDTO(i,j))
            }
        }
    }
)