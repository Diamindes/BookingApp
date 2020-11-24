package bookingApp.services.utils

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

data class FilterDTO(var property: String, var value: String)
data class SortDTO(var property: String, var direction: String)

class PageRequestHolder(sortJson: String?, page: Int, size: Int, filtersJson: String?) {
    var pageRequest: PageRequest
    var filters: List<FilterDTO> = emptyList()

    init {
        val sort: SortDTO = parseSort(sortJson)

        pageRequest = PageRequest.of(
                page,
                size,
                Sort.by(Sort.Direction.fromString(sort.direction), sort.property)
        )

        parseFilters(filtersJson)
    }

    private fun parseSort(sortJson: String?): SortDTO {
        return if (sortJson != null) {
            jacksonObjectMapper().readValue(sortJson)
        } else {
            SortDTO("name", "ASC")
        }
    }

    private fun parseFilters(filtersJson: String?) {
        if (filtersJson != null) {
            filters = jacksonObjectMapper().readValue(filtersJson)
        }
    }
}