#学习youtube

视频链接https://www.youtube.com/watch?v=jS0buQyfJfs&list=PL0dzCUj1L5JGfHj1lwxOq67zAJV3e1S9S&index=1

#01介绍RecyclerView



##bug:unsolve

    import kotlinx.android.synthetic.main.activity_main.*

[参考链接](https://stackoverflow.com/questions/34169562/unresolved-reference-kotlinx)



1. 在项目工程的 build.gradle中


        buildscript {
        dependencies {
            classpath "org.jetbrains.kotlin:kotlin-android-extensions:$kotlin_version"
        }
        }

2. 在模块级别的build.gralde中

        apply plugin: 'kotlin-android-extensions'

**注**window不存在，ubuntu存在这个错误


实现功能：使用RecyclerViews实现下拉列表的功能

#02 okhttp&Gson

将id,name,position均动态更改为url上的条目数

#03  picasso&circleimageview

    implementation 'com.squareup.picasso:picasso:2.5.2'
    compile 'de.hdodenhof:circleimageview:2.2.0'

获取image，channel图像，channel  name,分割线，字体加粗，布局间隔

#04 add activity

通过点击事件，将原本的“linux 教程”,进入到linux 具体哪几集
使用`android.support.constraint.ConstraintLayout`布局

#05 Pass Data Between Activity through Intent
#06 WebView