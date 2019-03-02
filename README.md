# AddTryCatchPlugin


insert try catch code when gradle transform class

自动在字节码中增加try catch的gradle 插件

usage

用法

add this code to build.gradle in app moudle

在app moudle级别的build.gradle中插入如下代码即可


```build.gradle
apply plugin: 'add-trycatch'

addTryCatch {
    hookPoint = ["com.addtrycatchplugin.TestCrash" : ["crashMethod1", "crashMethod2"],
                 "com.addtrycatchplugin.TestCrash1": ["crashMethod1", "crashMethod2"]]
    exceptionHandler = ["com.addtrycatchplugin.ExceptionUtils": "uploadCatchedException"]
}
```
