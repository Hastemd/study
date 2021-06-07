package streams;

/**
 * java8 基本类型和对象的转换
 *
 * @author lijie
 * @date 2021/6/5 22:35
 */
public class ConvertPrimitiveToObject {

    public static void main(String[] args) {
        //However, this will result in a compilation error because of inconvertible types.
        // That's because autoboxing only applies to individual elements and not to arrays or collections.
        //Integer[] integers = (Integer[])(new int[]{0,1,2,3,4});

        // 1. for循环转换
        int[] input = new int[] { 0, 1, 2, 3, 4 };
        Integer[] expected = new Integer[] { 0, 1, 2, 3, 4 };

        Integer[] output = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = input[i];
        }

        // 2. java stream 转换
        


    }
}
