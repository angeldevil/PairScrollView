PairScrollView
==============

类似今日头条详情页，可以有两个Child View，并且这两个Child View都可以垂直滚动，比如 `WebView+ListView`。

但是也不要求必须是`WebView`、`ListView`或`ScrollView`，可以是任意View。

`PairScrollView`主要使用`canScrollVertically`来判断Child View是否滚动到边缘，所以对于需要滚动的View如`ListView`等不是必须是`PairScrollView`的Direct Child View，只要这个可滚动的View的ParentView（`PairScrollView`的直接子View）正确实现了`canScrollVertically`就可以，可以参考[CustomLinearLayout.java][1]。也正因为如此，才允许Child View是任意View，因为`canScrollVertically`是`android.view.View`中定义的方法。

一定要是两个Child View吗？只有一个当然也可以，那三个或更多呢？想实现也行，不过由于没用到就没做处理了。

其实对于`WebView+ListView`的情况把`WebView`当作`ListView`的HeaderView也可以，只是`ListView`就无法正确计算滚动条高度了，如果不需要滚动条显示，这种方式也可以。

Examples
========

如下图，上面是一个`WebView`，下面是一个`LinearLayout`，`LinearLayout`中竖直排列一个`LinearLayout`和一个`ListView`，通过`layout_weight`使滚动到ListView时上面的Toolbar一直显示在屏幕顶部。

![][2]
![][3]

Licence
=======

[Apache Version 2.0][2]



 [1]:./src/me/angeldevil/pairscrollview/CustomLinearLayout.java
 [2]:./art/img1.png
 [3]:./art/img2.png
 [4]:http://www.apache.org/licenses/LICENSE-2.0.html
