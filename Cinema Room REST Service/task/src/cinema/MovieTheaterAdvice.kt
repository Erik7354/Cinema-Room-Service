package cinema

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class MovieTheaterAdvice {

    @ExceptionHandler()
    fun handleInvalidPasswordException(e: InvalidPasswordException): ResponseEntity<ErrorResponseDTO> =
        ResponseEntity(ErrorResponseDTO(e.error), HttpStatus.UNAUTHORIZED)

    @ExceptionHandler
    fun handleTicketAlreadyPurchasedException(e: TicketAlreadyPurchasedException): ResponseEntity<ErrorResponseDTO> =
        ResponseEntity(ErrorResponseDTO(e.error), HttpStatus.BAD_REQUEST)

    @ExceptionHandler
    fun handleSeatOutOfBoundsException(e: SeatOutOfBoundException): ResponseEntity<ErrorResponseDTO> =
        ResponseEntity(ErrorResponseDTO(e.error), HttpStatus.BAD_REQUEST)

    @ExceptionHandler
    fun handleInvalidTokenException(e: InvalidTokenException): ResponseEntity<ErrorResponseDTO> =
        ResponseEntity(ErrorResponseDTO(e.error), HttpStatus.BAD_REQUEST)

}
