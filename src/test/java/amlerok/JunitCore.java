package amlerok;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JunitCore {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class clazz = HomeWork1.class;
        for (Method method : clazz.getDeclaredMethods()) {
            Test methodAnnotation = method.getAnnotation(Test.class);
            if (methodAnnotation != null) {

                method.invoke(clazz.getConstructor().newInstance());
            }
        }




        //run all methods with @Test

        //print results вывести результат
    }
}
