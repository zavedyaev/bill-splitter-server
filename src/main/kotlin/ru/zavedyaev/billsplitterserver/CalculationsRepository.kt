package ru.zavedyaev.billsplitterserver

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.ResultSet


@Repository
class CalculationsRepository {
    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    fun findById(id: String): Calculation? {
        return jdbcTemplate.queryForObject(
                "SELECT id, data FROM calculation where id = ?", arrayOf(id)
        ) { rs: ResultSet, _: Int ->
            Calculation(rs.getString("id"), rs.getString("data"))
        }
    }

    fun create(calculation: Calculation) {
        jdbcTemplate.update("INSERT INTO calculation(id, data) VALUES (?,?)",
                calculation.id, calculation.getDataJson())
    }
}