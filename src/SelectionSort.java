
/**
 * 选择排序
 * @author Mengjun Wen
 * @date 2018/6/2
 */
public class SelectionSort {

    private Item item = new Item();

    /**
     * 选择Paiute
     * @param tArr 需要排序的数组
     *
     * @return 排序之后的数组
     */
    public static int[] selectionSort(int[] tArr){
        for (int i = 0; i < tArr.length; i++) {
            // 最小元素索引
//            int minIndex = i;
            for (int j = i+1; j < tArr.length; j++) {
                // 通过交换，在i位置上就是最小的元素
                if(tArr[i] > tArr[j]){
                    int temp = tArr[i];
                    tArr[i]=tArr[j];
                    tArr[j]=temp;
                }
            }
        }
        return tArr;
    }

    private class inner{
        private Item as = item;

        public void reverse(){
            as.name="yf";
            System.out.println(as.name);
            System.out.println(item.name);
        }
    }

}
