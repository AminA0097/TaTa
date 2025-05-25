package com.userservice.tata.Util;

public class Remote {
    public static <T> T makeRemote(Class<T> clazz) throws Exception {
        String className = clazz.getSimpleName();
        String entiyName = className.replace("InterFace", "Service");
        String fullClassName = "com.userservice.tata" + entiyName;
        Class<?> implClass = Class.forName(fullClassName);
        Object instance = implClass.getDeclaredConstructor().newInstance();
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

    public static Class<?> getEntityClassFromRemote() {
        try {
            StackTraceElement[] stack = Thread.currentThread().getStackTrace();
            if (stack.length > 3) {
                String callerClassName = stack[3].getClassName();
                String simpleCaller = callerClassName.substring(callerClassName.lastIndexOf('.') + 1);
                String entityName;
                String entityNameS = "";
                if (simpleCaller.endsWith("Service")) {
                    entityName = simpleCaller.replace("Service", "Entity");
                } else if (simpleCaller.endsWith("Controller")) {
                    entityName = simpleCaller.replace("Controller", "Entity");
                } else {
                    return null;
                }
                if (entityName.endsWith("Entity")) {
                    entityNameS = entityName.replace("Entity", "");
                }
                String entityPackage = "com.userservice.tata";
                String fullEntityClassName = entityPackage + "." + entityNameS + "." + entityName;

                return Class.forName(fullEntityClassName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class<?> getDtoNameFromRemote() {
        try {
            StackTraceElement[] stack = Thread.currentThread().getStackTrace();
            if (stack.length > 3) {
                String callerClassName = stack[3].getClassName();
                String simpleCaller = callerClassName.substring(callerClassName.lastIndexOf('.') + 1);
                String entityName;
                String entityNameS = "";
                if (simpleCaller.endsWith("Service")) {
                    entityName = simpleCaller.replace("Service", "Dto");
                } else if (simpleCaller.endsWith("Controller")) {
                    entityName = simpleCaller.replace("Controller", "Dto");
                } else {
                    return null;
                }
                if (entityName.endsWith("Dto")) {
                    entityNameS = entityName.replace("Dto", "");
                }
                String entityPackage = "com.userservice.tata";
                String fullEntityClassName = entityPackage + "." + entityNameS + "." + entityName;

                return Class.forName(fullEntityClassName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
