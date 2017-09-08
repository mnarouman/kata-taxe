package my.toolkit.test.katataxe.domain;

import static pl.pojo.tester.api.assertion.Method.CONSTRUCTOR;
import static pl.pojo.tester.api.assertion.Method.EQUALS;
import static pl.pojo.tester.api.assertion.Method.GETTER;
import static pl.pojo.tester.api.assertion.Method.HASH_CODE;
import static pl.pojo.tester.api.assertion.Method.SETTER;
import static pl.pojo.tester.api.assertion.Method.TO_STRING;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import my.toolkit.test.katataxe.domain.command.Command;
import my.toolkit.test.katataxe.domain.facture.Facture;
import my.toolkit.test.katataxe.domain.product.DefaultProduct;
import my.toolkit.test.katataxe.domain.product.Livre;
import my.toolkit.test.katataxe.domain.product.Medicament;
import my.toolkit.test.katataxe.domain.product.Nourriture;
import my.toolkit.test.katataxe.domain.product.factory.ProductConfig;
import my.toolkit.test.pojo.AbstractDomainTest;
import my.toolkit.test.pojo.JunitParamsVO;
import pl.pojo.tester.api.assertion.Method;

// Voir la couverture de code avec et sans :
//@Ignore
@RunWith(JUnitParamsRunner.class)
public class KataTaxeDomainTest extends AbstractDomainTest {

    public JunitParamsVO[] getParams() {
        List<JunitParamsVO> list = new ArrayList<>();
        Command command = Command.builder().build();
        list.add(factureParams(command));
        list.add(defaultProductParams());
        list.add(livreParams());
        list.add(medicamentParams());
        list.add(nouritureParams());

        //TODO A finir...
        list.add(productConfigParams());

        JunitParamsVO[] paramVOs = toArray(list);

        return paramVOs;
    }

    private JunitParamsVO productConfigParams() {
        return JunitParamsVO.builder()
                .classUnderTest(ProductConfig.class)
                .constructorParameters(new Object[] { Nourriture.class, "Legume", 1d, false })
                .constructorParameterTypes(new Class<?>[] { Class.class, String.class, double.class, boolean.class })
                .testingMethodsForBuilder(new Method[] { CONSTRUCTOR, TO_STRING })
                .testingMethods(new Method[] { GETTER, TO_STRING, EQUALS, HASH_CODE, CONSTRUCTOR })
                .build();
    }

    private JunitParamsVO nouritureParams() {
        return JunitParamsVO.builder()
                .classUnderTest(Nourriture.class)
                .constructorParameters(new Object[] { "Un Nom", 1d, false })
                .constructorParameterTypes(new Class<?>[] { String.class, double.class, boolean.class })
                .testingMethodsForBuilder(new Method[] { CONSTRUCTOR, TO_STRING })
                .testingMethods(new Method[] { GETTER, SETTER, CONSTRUCTOR })
                .build();
    }

    private JunitParamsVO medicamentParams() {
        return JunitParamsVO.builder()
                .classUnderTest(Medicament.class)
                .constructorParameters(new Object[] { "Un Nom", 1d, false })
                .constructorParameterTypes(new Class<?>[] { String.class, double.class, boolean.class })
                .testingMethodsForBuilder(new Method[] { CONSTRUCTOR, TO_STRING })
                .testingMethods(new Method[] { GETTER, SETTER, CONSTRUCTOR })
                .build();
    }

    private JunitParamsVO livreParams() {
        return JunitParamsVO.builder()
                .classUnderTest(Livre.class)
                .constructorParameters(new Object[] { "Un Nom", 1d, false })
                .constructorParameterTypes(new Class<?>[] { String.class, double.class, boolean.class })
                .testingMethodsForBuilder(new Method[] { CONSTRUCTOR, TO_STRING })
                .testingMethods(new Method[] { GETTER, SETTER, CONSTRUCTOR })
                .build();
    }

    private JunitParamsVO defaultProductParams() {
        return JunitParamsVO.builder()
                .classUnderTest(DefaultProduct.class)
                .constructorParameters(new Object[] { "Un Nom", 1d, false })
                .constructorParameterTypes(new Class<?>[] { String.class, double.class, boolean.class })
                .testingMethodsForBuilder(new Method[] { CONSTRUCTOR, TO_STRING })
                .testingMethods(new Method[] { GETTER, SETTER, CONSTRUCTOR })
                .build();
    }

    private JunitParamsVO factureParams(Command command) {
        return JunitParamsVO.builder()
                .classUnderTest(Facture.class)
                .constructorParameters(new Object[] { command, 1d, 1d })
                .constructorParameterTypes(new Class<?>[] { Command.class, double.class, double.class })
                .testingMethodsForBuilder(new Method[] { CONSTRUCTOR, TO_STRING })
                .testingMethods(new Method[] { GETTER, CONSTRUCTOR, TO_STRING, EQUALS, HASH_CODE })
                .build();
    }
}
