package my.toolkit.test.pojo;

import lombok.Builder;
import lombok.Data;
import pl.pojo.tester.api.assertion.Method;

@Data
@Builder
public class JunitParamsVO {
    private Class<?> classUnderTest;
    private Object[] constructorParameters;
    private final Class<?>[] constructorParameterTypes;
    private final Method[] testingMethods;
    private final Method[] testingMethodsForBuilder;
}