# TextWrapView

这是一个图文混排的库，支持html标记语言的图文混排。

#### 使用方法
* 第一步： Add the JitPack repository to your build file 
 ```xml
 	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
 ```
* 第二步：Add the dependency  
```xml
 	dependencies {
	        compile 'com.github.loonggg:TextWrapView:v1.1'
	}
 ```
* 第三步：在xml布局文件中使用
 ```xml
     <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">


        <com.loonggg.textwrapviewlib.view.TextWrapView
            android:id="@+id/twv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="@dimen/activity_vertical_margin"
            android:layout_marginTop="@dimen/activity_horizontal_margin" />
    </ScrollView>
 ```
* 第四步：在java中使用，可以修改字体大小和字体颜色，方法如下：
```java
TextWrapView twv = (TextWrapView) findViewById(R.id.twv);
//Color.BLACK是字体颜色，14是字号大小
twv.setText("html格式的内容", Color.BLACK, 14);
```
