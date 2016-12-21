import java.util.Iterator;

/**
 * Created by XianSheng on 2016/12/20.
 * 下压栈（能够动态调整数组大小的实现），实现了任意集合类数据类型的最佳性能
 * 每项操作的用时都与集合大小无关
 * 空间需求总是不超过集合大小乘以一个常数
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];//栈元素
    private int N = 0;//元素数量

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        //将栈移动到一个新的大小为max的数组中
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item) {
        //将元素添加进如栈
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop() {
        //从栈顶删除元素
        Item item = a[--N];
        a[N] = null;//避免对象游离
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterrator();
    }

    private class ReverseArrayIterrator implements Iterator<Item> {
        //支持后进先出的迭代
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }
}
