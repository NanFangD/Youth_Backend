@[TOC](SpringBoot+Vue实现前后端完全分离—简介)
### 前言 

这是自己在寒假时期完成的小项目，因为该准备考研了就没有继续下去，在这里感谢老哥的教程[Evan-Nightly](https://blog.csdn.net/Neuf_Soleil/article/details/88925013)，自已跟着一步一步学会个整个框架的基本结构也在此基础上进行了自己的修改。
### 项目的介绍
技术的使用：
前端：Vue+ElementUi+Axios
后端：Spring+Mybatis+Mysql
在开发的过程中遇到了很多关于性能的问题，在这里只实现了前端的性能优化：上传图片压缩，前端代码gzip压缩，ElementUI 按需使用，Vue模块按需加载，CDN引用文件加速。
后端还有很多需要去优化。
>作者主要想实现，一个二手书的网站，个人可以在个人中心处添加或删除自己的图书，添加的图书可以在图书馆中显示，而想买书的人可以去图书馆查看自己想要的书籍
也就是说这是一个C2C的平台，完全不需要作者介入管理，目前没有精力继续下去，就放着了。

**有兴趣的同学可以去我的网址测试
[Youth Onpiece](http://www.ujsnanfang.xyz/#/login)
账号：666666，密码：666666**
**账号：55555，密码：55555**
(因为有人改我的密码了┭┮﹏┭┮，为了方便我又做了一个后台管理，有人想要我就传到github里面吧，不过后台很简单，只能添加删除个账号。我也懒得弄）

这里附上我的**GitHup**下载地址
(不要忘了给我个 **star**  O(∩_∩)O~)
**后端下载地址:[Youth Backend](https://github.com/nanfangguiren/Youth_Backend)**
**前端下载地址:[Youth Front](https://github.com/nanfangguiren/Youth_Front)**
和**CSDN**下载地址 **[nanfang](https://download.csdn.net/download/qq_39740279/12522622)**
**其他内容下有时间再写写O(∩_∩)O~**
#### 界面展示
__1、登录界面__
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200329111913453.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NzQwMjc5,size_16,color_FFFFFF,t_70)
__2、主界面__
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200329112024454.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NzQwMjc5,size_16,color_FFFFFF,t_70)
__3、图书馆__
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200329112111610.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NzQwMjc5,size_16,color_FFFFFF,t_70)
__4、个人中心__
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200329112143836.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NzQwMjc5,size_16,color_FFFFFF,t_70)
__4.1、添加图书__
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200329112220644.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NzQwMjc5,size_16,color_FFFFFF,t_70)
__4.2修改密码__（各位可不要把测试密码改了O(∩_∩)O~）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200329112315811.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NzQwMjc5,size_16,color_FFFFFF,t_70)
__4.3后台管理__
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200430232150626.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM5NzQwMjc5,size_16,color_FFFFFF,t_70)
（为什么起名Youth，因为我女朋友的名字叫青春，手动滑稽   __O(∩_∩)O哈哈~__）
