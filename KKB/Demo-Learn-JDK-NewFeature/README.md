### Construction 🚧

## 介绍

这是我自己在学习各版本JDK中新特性的代码存档  
同时分享我整理在Notion上的笔记  
[JDK8](https://seasidetown.notion.site/JDK8-ce3b068baeac460ea54162483826bf6b)  
[JDK9](https://seasidetown.notion.site/JDK9-e39ce52b2c1b41198c302f95a543f822)  
[JDK10](https://seasidetown.notion.site/JDK10-1f7b4cbca315423b8bdcce7101324f94)  
[JDK11](https://seasidetown.notion.site/JDK11-f66d855061534e3584c2384feb5dee0f)  
[JDK12](https://seasidetown.notion.site/JDK12-9ae7ccedafd748ce8195fd882cf1c4aa)  
[JDK13](https://seasidetown.notion.site/JDK13-2d1e8320cc384d0abd2ed578cd31b3de)  
[JDK14](https://seasidetown.notion.site/JDK14-3efc1cd6234b44b395385eb76e517397)  
[JDK15](https://seasidetown.notion.site/JDK15-fa67237dbd104173b59109d57c27be36)

## tips

+ 推荐使用IDEA,你需要在项目结构中为每一个模块单独地设定依赖与语言级别为不同的JDK版本
+ IDEA可能将JDK9的那些模块辨别为Kotlin模块导致编译异常。解决方法是重新构建项目，参考于[这里](https://stackoverflow.com/questions/53497454/intellij-idea-ultimate-2018-3-thinks-my-java-9-project-is-a-kotlin-project)
+ 有些新特性是预览版本(preview)的，而JDK预览版本的特性是默认关闭的，所以一些相关代码无法通过编译。
+ 如果你使用的是IDEA自己的构建系统IntelliJ，那么直接修改项目/模块的语言级别为带有(preview)
  前缀的就可以开启JDK预览特性了  
  ***但是IDEA仅提供了部分带preview的JDK选项***。(在2022.2中是JDK17、18、19、20)
+ 我本人出于习惯，在本项目中(的大部分模块)使用了Maven，但目前好像通过修改pom的方式开启Java预览特性还比较麻烦，可以尝试后面的提到的pom配置代码，
  如果不行的话，个人不建议继续折腾，而是直接参考最后的[通用解决方案](#最后我的解决方案)
+ 最后，即使你开启了预览版本的特性，但在IDEA中编辑时仍可能会有红色的问题提示(例如JDK14模块中使用`record`类的那一个示例)，
  但实际上是可以正常运行的，无视IDEA的Warning直接运行即可。

------------------------------------------------------

### 如果你要开启JDK的预览特性,可以避免以下我走过的一些弯路

本项目(中部分模块)的构建系统是Maven，所以我希望可以通过修改pom.xml文件来解决这个问题。但是相继查找了很多篇文章，思路基本上都是添加
`<compilerArgs>
<arg>--enable-preview</arg>
</compilerArgs>`
到maven的编译器插件配置里，但进行了多次尝试，最后没有还有能成功开启JDK预览特性的。  
这里仅分享一篇还算有用的[StackOverflow帖子](https://stackoverflow.com/questions/52232681/compile-and-execute-a-jdk-preview-feature-with-maven)，
在最新的一个回答中，新版本的Maven编译器插件应该只需要一行配置代码就可以开启JDK的预览特性了，但试了一下还是没有用。也许在以后的更新后，将这个参数添加到Maven的编译器插件中就可以了，但目前(2022-8月)在IDEA中使用还是存在问题。
```xml

<plugin>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>3.10.1</version> <!-- 最低要这个版本才支持 -->
  <configuration>
    <enablePreview>true</enablePreview>
  </configuration>
</plugin>
```

### 最后我的解决方案

我放弃通过maven的插件方法来解决这个问题，而是通过修改IDEA配置中java编译器和vm参数的方式来开启预览特性的方法。[参考文章链接🔗](https://foojay.io/today/how-to-run-project-loom-from-intellij-idea/)
这个操作本质上就是添加--enable-preview这个参数到javac和java后。

***tips:***  
(IDEA2022.2) 在**运行/调试配置** 页面左下角点击编辑配置模版，   
在模板页面中添加JVM参数：-enable-preview。这样就不用单独地为每一个配置文件添加参数了
