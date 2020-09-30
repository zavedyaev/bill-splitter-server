package ru.zavedyaev.billsplitterserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BillSplitterServerApplication

fun main(args: Array<String>) {
    runApplication<BillSplitterServerApplication>(*args)
}
