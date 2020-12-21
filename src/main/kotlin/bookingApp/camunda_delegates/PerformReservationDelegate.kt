package bookingApp.camunda_delegates

import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class PerformReservationDelegate : JavaDelegate {
    @Throws(Exception::class)
    override fun execute(execution: DelegateExecution) {
        println(execution.getVariable("user_id"))
    }
}