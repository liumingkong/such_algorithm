### 符号表

* 目的：将一个键和一个值联系起来。
* 典型的符号表应用：字典，图书索引，文件共享，账户管理，网络搜索，编译器。

### 符号表的实现

<table>
<tr><td>数据结构</td><td>实现</td><td>优点</td><td>缺点</td></tr>
<tr><td>链表（顺序查找）</td><td>SeqSearchST</td>
	<td>适用于小型问题</td>
	<td>对于大型符号表速度很慢</td></tr>
<tr><td>有序数组（二分查找）</td><td>BinarySearchST</td>
	<td>最优的查找效率和空间需求，能够进行有序性相关的操作</td>
	<td>插入操作很慢</td></tr>
<tr><td>二叉查找树</td><td>BST</td>
	<td>实现简单，能够进行有序性相关的操作</td>
	<td>没有性能的上届的保证，链接需要额外的空间</td></tr>
<tr><td>平衡二叉查找树</td><td>RedBlackBST</td>
	<td>最优的查找和插入效率，能够进行有序性相关的操作</td>
	<td>链接需要额外的空间</td></tr>
<tr><td>散列表</td><td>HashST</td>
	<td>快速查找和删除</td>
	<td>需要计算散列值以及额外的存储空间</td></tr>
</table>


### 平衡查找树

<pre>
理想情况下，希望能够保持二分查找树的平衡性，在一棵含有N个结点，我们希望树高为lgN，这样就能够保证所有的查找都能在lgN次比较内结束。
但是动态插入中保持树的平衡的代价太高了
</pre>
 
#### 2-3查找树

<pre>
一颗标准的二叉树的结点称为2-结点（含有一个键和两条链接）
引入3-结点，它含有两个键和三条链接。
</pre>

* 定义，一棵2-3查找树或为一棵空树，或由以下结点组成：
* 2-结点，含有一个键（及其对应的值）和两条链接，左链接指向的2-3树中的键都小于该结点，右链接指向的2-3树中的键都大于该结点
* 3-结点，含有两个键（及其对应的值）和三条链接，左链接指向的2-3树中的键都小于该结点，中链接指向的2-3树种的键都位于该结点的两个键之间，右链接指向的2-3树种的键都大于该结点。


<pre>
一棵完美平衡的2-3查找树中的所有空链接到根结点的距离都应该是相同的。
</pre>

##### 2-3树的查找算法
<pre>
递归地向下查找
</pre>
##### 向2-结点中插入新键
<pre>
1.在二叉查找树中进行一次未命中的查找，再把新结点挂在树的底部，这样无法保持平衡
2.如果未命中的查找结束于一个2-结点，把这个结点替换为一个3-结点，将要插入的键保存其中即可
3.如果未命中的查找结束于一个3-结点，要再细分处理
</pre>
##### 向一棵只含有一个3-结点的树中插入新键
<pre>
1.一棵只含有一个3-结点的树中插入一个新键。这棵树中有两个键，所以在它唯一的结点中已经没有可插入新键的空间了。为了将新键插入，先临时将新键存入该结点，使之成为一个4-结点。
2.创建一个4-结点很方便，因为很容易将它转换为一棵由3个2-结点组成的2-3树，其中一个结点含有中键（根结点），一个结点含有3个键中的最小者（和根结点的左链接相连），一个结点含有3个键中的最大者（和根结点的右链接相连）。
3.这棵树既是一棵含有3个结点的二叉查找树，同时也是一棵完美平衡的2-3树，因为其中所有的空链接到根结点的距离都相等。
4.插入前树的高度为0，插入后树的高度为1
</pre>
##### 向一个父结点为2-结点的3-结点中插入新键
<pre>

</pre>









