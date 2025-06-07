# Idea构建运行Gradle项目的一些建议


* 使用idea运行gradle，本地不需要安装gradle
  
* Tip2: Use the Gradle panel to run tasks 
  * 使用Gradle的面板来运行任务
  <img src="./pic/01_使用gradle面板来运行gradle的tasks.png">

* Tip3: Customise your Gradle task executions 

* Tip4: Automatically import changes to build.gradle
  * 根据build.gradle 来自动更新变更内容
  Tip5: Use idea to search for build dependencies 
  * 使用idea的搜索功能来提那件构建时的依赖信息
  * 定位到build.gradle 文件 右键，选择Generate
  <img src="./pic/02_借助idea新增依赖或者插件.png" >
  * 之后就可以搜索相关的依赖了。 
  * 







## 遇到的问题

* 报错
  * <img src="./pic/901_Err_on_such_key.png">

* idea 识别不了gradle 构建的项目
  * 解决方案；配置idea 的gradle
  * <img src="./pic/idea运行gradle构建的项目_V20250524.png">
  * <img src="./pic/003_gradle版本要求.png"/>
