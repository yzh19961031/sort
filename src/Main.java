import java.util.Arrays;

/**
 * 常用排序算法整理
 * @author Y
 * @date 2020/5/27
 */
public class Main {

    private static int[] array = {44,55,2,31,9,1,7,25,32,27,15};

    // 冒泡排序  时间复杂度o(n2)
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        // 控制循环次数 需要循环 n-1 次
        for (int i = 0; i < n - 1; i++) {
            // 两两比较 将较大的沉底
            // 这边注意要减一  防止数组越界
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            // 这边每次循环结束打印数组结果 可以看得更清晰
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    // 冒泡排序优化  可以减少循环的次数
    public static int[] bubbleSort1(int[] arr) {
        int n = arr.length;
        // 控制循环次数 需要循环 n-1 次
        for (int i = 0; i < n - 1; i++) {
            // 定义一个标识 只有在发生元素交换的时候才改变改标识
            // 如果标识没有改变 说明之后的元素已经是排好序的 可以直接退出循环
            boolean flag = true;
            // 两两比较 将较大的沉底
            // 这边注意要减一  防止数组越界
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    flag = false;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            // 这边每次循环结束打印数组结果 可以看得更清晰
            System.out.println(Arrays.toString(arr));
            if (flag) {
                break;
            }
        }
        return arr;
    }

    // 选择排序  时间复杂度o(n2)
    public static int[] selectSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 这边记录下后面未排序第一个元素的索引位置
            int min = i;
            for (int j = i + 1; j < n; j++) {
                // 比较后面的元素 记录下比最小值小的下标索引
                if (arr[j] < arr[min])
                    min = j;
            }
            // 将取到的最小的值放到前面
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
            // 每次循环结束打印结果
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    // 插入排序  时间复杂度o(n2)
    public static int[] insertSort(int[] arr) {
        int n = arr.length;
        // 控制循环次数
        for (int i = 0; i < n - 1; i++) {
            // 默认第一个是排序好的 之后依次取未排序元素插入到之前排序好的数组中
            // 这边取之后的元素与之前排序好的元素依次比较 进行插入操作
            for (int j = i + 1; j > 0 ; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
            // 每次循环结束打印结果
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] ints = bubbleSort(array);
        //int[] ints = selectSort(array);
        //int[] ints = insertSort(array);
        System.out.println(Arrays.toString(ints));
    }
}
