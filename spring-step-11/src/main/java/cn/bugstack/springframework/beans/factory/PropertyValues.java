package cn.bugstack.springframework.beans.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xusheng
 * @Date 2022/11/22 14:25
 * @Desc
 */
public class PropertyValues {

    private List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValues.add(propertyValue);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : propertyValues) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }
}
