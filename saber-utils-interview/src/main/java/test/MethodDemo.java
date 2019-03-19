package test;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Method;

/**
 * @author Aria
 * @time on 2019-03-14.
 */
public class MethodDemo {

    public static void main(String[] args) {
        Method[] methods = SampleClass.class.getMethods();
        Class declaringClass = methods[0].getDeclaringClass();
        System.out.println(JSON.toJSONString(declaringClass));
    }
}

class SampleClass {
    private String sampleField;

    public String getSampleField() {
        return sampleField;
    }

    public void setSampleField(String sampleField) {
        this.sampleField = sampleField;
    }
}