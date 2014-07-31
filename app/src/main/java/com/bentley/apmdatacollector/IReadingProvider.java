package com.bentley.apmdatacollector;

import java.util.Map;

public interface IReadingProvider {
    Map<String, String> GetIndicatorReading(int sequence);
}
