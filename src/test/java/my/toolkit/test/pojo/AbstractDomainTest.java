package my.toolkit.test.pojo;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

import java.lang.reflect.Array;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

// Voir la couverture de code avec et sans :
//@Ignore
@RunWith(JUnitParamsRunner.class)
public abstract class AbstractDomainTest {
    
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	public abstract JunitParamsVO[] getParams() ;

	@Test
    @Parameters(method="getParams")
    public void testAllPojo(JunitParamsVO junitParamsVO ) throws ClassNotFoundException {
        // given
        final Class<?> classUnderTest = junitParamsVO.getClassUnderTest();
        Object[] constructorParameters = junitParamsVO.getConstructorParameters();
        final Class<?>[] constructorParameterTypes = junitParamsVO.getConstructorParameterTypes();
        Class<?> builderClassUnderTest = getBuilderClass(classUnderTest);
        
        //when
        
        // then
        if (builderClassUnderTest != null) {
            assertPojoMethodsFor(builderClassUnderTest )
                .testing(junitParamsVO.getTestingMethodsForBuilder())
                .areWellImplemented();
        }
        // and
        assertPojoMethodsFor(classUnderTest).create(classUnderTest, constructorParameters, constructorParameterTypes)
                .testing(junitParamsVO.getTestingMethods())
                .areWellImplemented();

    }

    private Class<?> getBuilderClass(Class<?> classUnderTest) {
        String name = classUnderTest.getSimpleName();
        Class<?> builderClassUnderTest = null;
        Class<?>[] classes = classUnderTest.getClasses();
        for (Class<?> clazz : classes) {
            if(clazz.getSimpleName().endsWith(name+"Builder")){
                builderClassUnderTest = clazz;
                break;
            }
        }
        return builderClassUnderTest;
    }

    protected JunitParamsVO[] toArray(List<JunitParamsVO> list) {
        int size = list.size();
        Object[] array = (Object[]) Array.newInstance(JunitParamsVO.class, size);
        JunitParamsVO[] paramVOs = (JunitParamsVO[]) list.toArray(array);
        return paramVOs;
    }
}
