package com.seniorglez.server.infra.amqp;

import com.seniorglez.server.domain.port.WorkerService;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl implements WorkerService {

    private RabbitOut rabbitOut;

    public WorkerServiceImpl(RabbitOut rabbitOut) {
        this.rabbitOut = rabbitOut;
    }

    @Override
    public void sendTask(String msg) {
        rabbitOut.send(msg);
    }

}
