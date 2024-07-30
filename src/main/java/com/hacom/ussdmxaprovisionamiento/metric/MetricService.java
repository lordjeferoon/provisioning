package com.hacom.ussdmxaprovisionamiento.metric;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;
import io.micrometer.core.instrument.Counter;

import java.util.HashMap;
import java.util.Map;

@Service
public class MetricService {

    public final static String METRICS_PREFIX = "hacom.pws.pws.gw";

    private final Counter receivedMetric;
    private final Map<String, Counter> metrics = new HashMap<>();
    private final MeterRegistry meterRegistry;

    public MetricService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        receivedMetric = Counter.builder(METRICS_PREFIX + ".capReceivedOkay")
                .description("Messages received Okay Authentication.")
                .register(meterRegistry);
    }

    public void setReceivedMetric(){
        receivedMetric.increment();
    }
    
    public void setMetric(String id, String description){
        String metricKey = METRICS_PREFIX + "." + id;
        if(metrics.containsKey(metricKey)){
            metrics.get(metricKey).increment();
        } else {
            Counter newCounter = Counter.builder(metricKey)
                    .description(description)
                    .register(meterRegistry);
            newCounter.increment();
            metrics.put(metricKey, newCounter);
        }
    }
    
}
