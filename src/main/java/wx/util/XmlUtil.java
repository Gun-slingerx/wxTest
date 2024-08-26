package wx.util;

import java.lang.reflect.Method;

public class XmlUtil {

    // 将对象转化为xml字符串。 rootName 为根节点名称
    public static String obj2Xml(Object obj, String rootName) throws Exception {
        // 拿到class 并获取其所有的方法
        Class<?> aClass = obj.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        // 建立xml。
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<").append(rootName).append(">");
        // 遍历方法提取值。
        for (Method m : declaredMethods) {
            m.setAccessible(true);
            // 要获取值，只需要获取 get 开头的方法。
            String methodName = m.getName();
            if (methodName.startsWith("get")) {
                // 获取到值。
                Object value = m.invoke(obj);
                // 拿到key
                String key = methodName.replace("get", "").trim();
                // 拼接值
                xmlBuilder
                        .append("<").append(key).append("><![CDATA[")
                        .append(value)
                        .append("]]></").append(key).append(">");
            }
        }
        // 尾节点
        xmlBuilder.append("</").append(rootName).append(">");
        return xmlBuilder.toString();
    }
}
