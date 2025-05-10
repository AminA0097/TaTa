package com.userservice.tata.More;

public class Remote {
    public static <T> T makeRemote(Class<T> clazz) throws Exception{
        String className = clazz.getSimpleName();
        String entiyName = className.replace("InterFace","Service");
        String fullClassName = "com.userservice.tata" + entiyName;
        Class<?> implClass = Class.forName(fullClassName);
        Object instance = implClass.getDeclaredConstructor().newInstance();
        return clazz.cast(instance);
    }
    public static <T>String getRepoNameFromRemote(Class<T> entityClass){
        String fullClassName = entityClass.getSimpleName();
        if (fullClassName.endsWith("Entity")) {
            String repoName = fullClassName.replace("Entity", "Repo");
            repoName = Character.toLowerCase(repoName.charAt(0)) + repoName.substring(1);
            System.out.println(repoName);
            return repoName;
        }
        return null;
    }
}
