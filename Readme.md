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

