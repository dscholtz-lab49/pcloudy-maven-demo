package listener;

import io.cucumber.messages.types.TestStepStarted;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.Result;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestStepFinished;
import org.apache.commons.lang3.StringUtils;

public class CustomEventListener implements ConcurrentEventListener {


    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepStarted.class, this::testStepStarted);

        publisher.registerHandlerFor(TestStepFinished.class, this::testStepFinished);
    }

    private void testStepStarted(TestStepStarted event) {
        System.err.println("Test started: " + event.getTestStepId());
    }

    private void testStepFinished(TestStepFinished event) {
        Result result = event.getResult();
        if (!Status.PASSED.equals(result.getStatus())) {
            String message = "Test did not pass (" + result.getStatus() + "): " + event.getTestCase().getName();
            System.err.println(message);
        }
    }

}