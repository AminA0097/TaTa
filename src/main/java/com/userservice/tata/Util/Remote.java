package com.userservice.tata.Util;

public class Remote {
    public static <T> T makeRemote(Class<T> clazz) throws Exception {
        String className = clazz.getSimpleName();
        String simpleName = className.replace("InterFace", "");
        String serviceName = simpleName + "Service";
        String fullClassName = "com.userservice.tata." + simpleName + "." + serviceName;

        Class<?> implClass = Class.forName(fullClassName);


        Object instance = SpringContextHelper.getContext().getBean(implClass);
        return clazz.cast(instance);
    }



    public static <T> String getRepoNameFromRemote(Class<T> entityClass) {
        String fullClassName = entityClass.getSimpleName();
        if (fullClassName.endsWith("Entity")) {
            String repoName = fullClassName.replace("Entity", "Repo");
            repoName = Character.toLowerCase(repoName.charAt(0)) + repoName.substring(1);
            System.out.println(repoName);
            return repoName;
        }
        return null;
    }

    public static String getRepoNameFromRemote() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length > 3) {
            String callerClassName = stackTraceElements[3].getClassName();
            String simpleCaller = callerClassName.substring(callerClassName.lastIndexOf('.') + 1);
            if (simpleCaller.endsWith("Service")) {
                simpleCaller = simpleCaller.replace("Service", "Repo");
            } else if (simpleCaller.endsWith("Controller")) {
                simpleCaller = simpleCaller.replace("Controller", "Repo");
            }

            return Character.toLowerCase(simpleCaller.charAt(0)) + simpleCaller.substring(1);
        }
        return null;
    }

    public static Class<?> getEntityClassFromRemote(Class<?> clazz) {
        try {
            if (clazz != null) {
                String simpleClassName = clazz.getSimpleName();
                String entityName;
                String entityNameWithoutSuffix = "";

                if (simpleClassName.endsWith("Service")) {
                    entityName = simpleClassName.replace("Service", "Entity");
                    entityNameWithoutSuffix = simpleClassName.replace("Service", "");
                } else if (simpleClassName.endsWith("Controller")) {
                    entityName = simpleClassName.replace("Controller", "Entity");
                    entityNameWithoutSuffix = simpleClassName.replace("Controller", "");
                } else {
                    return null;
                }
                String basePackage = clazz.getPackageName();
                String fullEntityClassName = basePackage + "." + entityName;

                return Class.forName(fullEntityClassName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public static Class<?> getDtoNameFromRemote(Class<?> clazz) {
        try {
            if (clazz != null) {
                String simpleClassName = clazz.getSimpleName();
                String dtoName;
                if (simpleClassName.endsWith("Service")) {
                    dtoName = simpleClassName.replace("Service", "Dto");
                    String basePackage = clazz.getPackageName();
                    String fullEntityClassName = basePackage + "." + dtoName;
                    return Class.forName(fullEntityClassName);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
