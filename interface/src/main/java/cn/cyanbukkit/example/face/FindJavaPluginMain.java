package cn.cyanbukkit.example.face;

import java.lang.reflect.Field;

public class FindJavaPluginMain {


    public static Object findMain() {
        try {
            // 获取当前类所在的包路径
            String currentPackage = FindJavaPluginMain.class.getPackage().getName();
            // 构建可能的Launcher类全限定名
            String launcherClassName = currentPackage.replace(".face", ".launcher.CyanPluginLauncher");
            
            Class<?> clazz = Class.forName(launcherClassName);
            Field field = clazz.getDeclaredField("cyanPlugin");
            field.setAccessible(true);
            return field.get(null); // 直接获取静态实例
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
