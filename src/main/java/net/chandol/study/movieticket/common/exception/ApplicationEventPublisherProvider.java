package net.chandol.study.movieticket.common.exception;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventPublisherProvider implements ApplicationEventPublisherAware {
    private static ApplicationEventPublisher publisher;

    public static ApplicationEventPublisher getEventPublisher() {
        return publisher;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
        ApplicationEventPublisherProvider.publisher = eventPublisher;
    }
}