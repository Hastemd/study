package streams;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 字符串分割
 *
 * @author lijie
 * @date 2021/6/5 23:25
 */
@Slf4j
public class StringSplit {

    public static void main(String[] args) {
        String str = "1,2,3,4,5";
        String collect = Stream.of(str.split(",")).collect(Collectors.joining("-"));
        log.info("collect : {}", collect);
        String collect2 = Stream.of(str.split(",")).collect(Collectors.joining("-","[","]"));
        log.info("collect2 : {}", collect2);

        List<Integer> listWithDuplicates = Lists.newArrayList(11, 5, 0, 3, 1, 2, 3, 0, 0);
        HashSet<Integer> hashSet = new HashSet<>(listWithDuplicates);
        log.info("hashSet : {}", JSONUtils.toJSONString(hashSet));
        List<Integer> listWithoutDuplicates = new ArrayList<>(hashSet);
        log.info("listWithDuplicates : {}", JSONUtils.toJSONString(listWithDuplicates));
        log.info("listWithoutDuplicates : {}", JSONUtils.toJSONString(listWithoutDuplicates));
    }
}
