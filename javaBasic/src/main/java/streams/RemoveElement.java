package streams;

import com.alibaba.druid.support.json.JSONUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 集合删除元素
 *
 * @author lijie
 * @date 2021/6/5 23:05
 */
@Slf4j
public class RemoveElement {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Ana");
        names.add("Mary");
        names.add("Anthony");
        names.add("Mark");

        Iterator<String> i = names.iterator();
        while(i.hasNext()) {
            String e = i.next();
            if (e.startsWith("A")) {
                i.remove();
            }
        }
        log.info("names删除后: {}", JSONUtils.toJSONString(names));

        List<String> list = new ArrayList<>();
        list.add("John");
        list.add("Ana");
        list.add("Mary");
        list.add("Anthony");
        list.add("Mark");
        list.removeIf(e -> e.startsWith("A"));

        log.info("list删除后: {}", JSONUtils.toJSONString(list));
    }
}
