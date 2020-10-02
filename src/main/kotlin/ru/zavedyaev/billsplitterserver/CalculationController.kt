package ru.zavedyaev.billsplitterserver

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*


@CrossOrigin(origins = ["http://zavedyaev.ru:80", "http://zavedyaev.ru"])
@RestController
@RequestMapping("/calculation")
class CalculationController {

    @Autowired
    private lateinit var calculationsRepository: CalculationsRepository

    @GetMapping("/{id}")
    fun load(@PathVariable id: String): String {
        return calculationsRepository.findById(id)?.getDataJson()
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "There is not such calculation")
    }

    @PostMapping("")
    fun create(@RequestBody calculationData: CalculationData): String {
        val id = UUID.randomUUID().toString()
        val calculation = Calculation(id, calculationData)
        calculationsRepository.create(calculation)
        return id
    }
}